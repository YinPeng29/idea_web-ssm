<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/19
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
    <c:if test="${!empty userList}">
        <c:forEach var="user" items="${userList}">
            姓名:${user.userName}
            手机号:${user.userPhone}
            email:${user.userEmail}
        </c:forEach>
    </c:if>
</body>
</html>
