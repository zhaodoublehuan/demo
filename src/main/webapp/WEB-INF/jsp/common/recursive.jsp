<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="basePath"
       value="${pageContext.request.scheme}${'://'}${pageContext.request.serverName}${':'}${pageContext.request.serverPort}${pageContext.request.contextPath}"/>

<c:if test="${not empty menuList}">
    <c:forEach items="${menuList}" var="item">
        <c:if test="${item.childrenMenus==null || fn:length(item.childrenMenus) == 0}">
            <li><a href="${basePath}${item.menuUrl}"><i class="fa fa-fw ${item.iconClass}"></i> <span>${item.menuName}</span></a>
            </li>
        </c:if>
        <c:if test="${item.childrenMenus!=null && fn:length(item.childrenMenus) > 0}">
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-laptop"></i>
                    <span>${item.menuName}</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                   <c:set var="menuList" value="${item.childrenMenus}" scope="request"/>
                    <jsp:include page="../common/recursive.jsp"/>
                </ul>
            </li>
        </c:if>
    </c:forEach>

</c:if>
