<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<tiles:insertAttribute name="header"/>
<body>
<tiles:insertAttribute name="bodyHeader"/>
<div class="container">
    <div class="d-flex justify-content-center h-100">
        <div class="card">
            <div class="card-header">
                <h3><spring:message code="app.signIn"/></h3>
            </div>
            <div class="card-body">
                <form:form id="login_form" action="spring_security_check" method="post">
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user"></i></span>
                        </div>
                        <input type="text" name="username" class="form-control" placeholder="<spring:message code="user.login"/>">

                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-key"></i></span>
                        </div>
                        <input type="password" name="password"  class="form-control" placeholder="<spring:message code="user.password"/>">
                    </div>
                    <div class="row align-items-center remember">
                        <input type="checkbox"><spring:message code="app.rememberMe"/>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn float-right yellow_btn"><spring:message code="app.login"/></button>
                    </div>
                </form:form>
            </div>
            <br>
            <div class="card-footer">
                <div class="d-flex justify-content-center links">
                    <spring:message code="app.notProfileQuestion"/>
                </div>
                <div class="d-flex form-group justify-content-center">
                    <a class="btn yellow_btn" href="profile/register"><spring:message code="app.register"/> &raquo;</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<tiles:insertAttribute name="footer"/>
<script type="text/javascript">
    <c:if test="${not empty param.username}">
        $('input[name="username"]').val("${param.username}");
    </c:if>
    <c:if test="${not empty param.error}">
        $(document).ready(function () {
            errorNoty('app.badCredentials');
        });
    </c:if>
    <c:if test="${not empty param.message}">
    $(document).ready(function () {
        successNoty("${param.message}");
    });
    </c:if>
</script>
</html>