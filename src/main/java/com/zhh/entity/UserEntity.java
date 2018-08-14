package com.zhh.entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
* @ClassName: UserEntity
* @Description: 用户信息实体类
* @author zhh
* @date 2016-8-12 上午9:16:13
* 
*/
@Getter
@Setter
@ToString
public class UserEntity {
    /**
    * @Fields id : 主键id
    */
    private String id;
    //登录账号
    private String loginNo;
    //用户账号
    private String userName;
    //用户年龄
    private int userAge;
    //用户性别
    private int userSex;
    /**
     * @Fields salt : 加密用的盐
     */
    private String salt;

    /**
    * @Fields password : 密码
    */
    private String password;

    /**
    * @Fields mobile : 手机号
    */
    private String mobile;

    /**
    * @Fields email : 邮箱
    */
    private String email;
    
    /**
    * @Fields active : 用户状态
    */
    private String active;

    /**
    * @Fields insertDate : 新建时间
    */
    private Date insertDate;

    /**
    * @Fields updateDate : 修改时间
    */
    private Date updateDate;

}