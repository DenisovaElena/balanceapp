<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<tiles:insertAttribute name="header"/>
<body>
<script type="text/javascript" src="resources/js/profile.js" defer></script>
<tiles:insertAttribute name="bodyHeader"/>
<div class="container">
    <div class="d-flex justify-content-center h-100">
        <%--@elvariable id="userTo" type="ru.example.balanceapp.to.UserTo"--%>
        <div class="card">
            <div class="card-header">
                <h3><spring:message code="${register ? 'app.register' : 'app.profile'}"/> ${userTo.login}</h3>
            </div>
            <div class="card-body">
                <c:if test="${not empty register}">
                <form:form id="profile_form" action="profile/register" method="post">
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user"></i></span>
                        </div>
                        <input type="text" id="login" name="login" class="form-control" placeholder="<spring:message code="user.login"/>">
                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-key"></i></span>
                        </div>
                        <input type="password" id="password" name="password"  class="form-control" placeholder="<spring:message code="user.password"/>">
                    </div>
                </form:form>
                <div class="form-group">
                    <button type="button" onclick="registerUser()" class="btn float-right yellow_btn"><spring:message code="${register ? 'app.register' : 'user.save'}"/></button>
                </div>
                </c:if>
                <c:if test="${empty register}">
                    <div class="row justify-content-center">
                        <h4 class="col-md-5"><spring:message code="user.balance"/>:</h4>
                        <h3 class="col-md-5" id="balance"></h3>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    <c:if test="${empty register}">
        $(document).ready(function () {
            getAuthUserProfileData();
        });
    </c:if>
</script>
</body>
<tiles:insertAttribute name="footer"/>
</html>