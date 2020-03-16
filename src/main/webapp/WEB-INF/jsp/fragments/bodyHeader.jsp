<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<nav class="navbar fixed-top navbar-expand navbar-dark transparent-dark py-0">
    <div class="container">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <sec:authorize access="isAuthenticated()">
                        <form:form class="form-inline my-2" action="logout" method="post">
                            <div class="navbar-text">
                                <spring:message code="app.credentials"/>:
                                <sec:authentication property="principal.userTo.login"/>&nbsp;&nbsp;
                            </div>
                            <button class="btn btn-primary my-1" type="submit">
                                Выйти
                            </button>
                        </form:form>
                    </sec:authorize>
                </li>
                <li class="nav-item dropdown">
                    <a class="dropdown-toggle nav-link my-1 ml-2" data-toggle="dropdown">${pageContext.response.locale}</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${requestScope['javax.servlet.forward.request_uri']}?lang=en">English</a>
                        <a class="dropdown-item" href="${requestScope['javax.servlet.forward.request_uri']}?lang=ru">Русский</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>
<script type="text/javascript">
    var localeCode = "${pageContext.response.locale}";
</script>
