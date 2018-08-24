package com.zhh.realm;

import com.alibaba.fastjson.JSON;
import com.zhh.entity.base.Permission;
import com.zhh.entity.base.Role;
import com.zhh.entity.base.UserEntity;
import com.zhh.service.base.RoleService;
import com.zhh.service.base.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("restriction")
public class UserRealm extends AuthorizingRealm {
	/**
	* @Fields LOGGER : 记录日志
	*/
	private static final Logger LOGGER = Logger.getLogger(UserRealm.class);
	/**
	* @Fields userService : 注入用户service
	*/
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		LOGGER.info("权限验证开始========");
		/*获取到登录用户名*/
		String loginNo = (String) principals.getPrimaryPrincipal();
		LOGGER.info("登录用户名========"+loginNo);
	    /*获取用户的角色集合*/
	    List<Role> roleList =  roleService.selectRolesByLoginNo(loginNo);
	    LOGGER.info("登录用户角色集合========"+JSON.toJSONString(roleList));
	    //角色名的集合
	    Set<String> roles = new HashSet<String>();
	    //权限名的集合
	    Set<String> permissions = new HashSet<String>();
	    if(roleList!=null){
	    	/*循环角色集合*/
		    for(Role role:roleList){
		    	/*角色集合名称拼接字符串*/
			      roles.add(role.getCode());
			      LOGGER.info("角色拥有的权限信息====="+role.getCode()+"===="+JSON.toJSONString(role.getPermissionSet()));
			      /*循环权限信息*/
			      for(Permission per:role.getPermissionSet()){
			    	/*权限集合字符串拼接权限名称*/
			        permissions.add(per.getName());
			      }
		    }
	    }
	    /*新建权限认证信息*/
	    SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
	    /*角色设置*/
	    authorizationInfo.addRoles(roles);
	    /*权限信息设置*/
	    authorizationInfo.addStringPermissions(permissions);
	    LOGGER.info("未登录用户设置权限角色信息到shiro========结束");
	    return authorizationInfo;
	}
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		LOGGER.info("登录认证开始========");
		/*获取用户账户*/
		String loginNo = (String) token.getPrincipal();
		LOGGER.info("登录用户的名称======="+loginNo);
		/*根据账户查询用户*/
	    UserEntity user = userService.findUserByLoginNo(loginNo);
	    LOGGER.info("数据库中是否存在该用户======="+JSON.toJSONString(user));
	    /*如果用户不存在*/
	    if(user==null){
	       LOGGER.warn("用户不存在");
	       throw new UnknownAccountException("没有找到该账号");
	    }
	    
	    /**
	     * 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以在此判断或自定义实现  
	     */
	    SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getLoginNo(), user.getPassword(),getName());
	    info.setCredentialsSalt(ByteSource.Util.bytes(user.getSalt()));
	    LOGGER.info("由shiro验证用户信息的结果======="+JSON.toJSONString(info));
	    return info;
	  }
	  
	  @Override
	  public String getName() {
	    return getClass().getName();
	  }

}
