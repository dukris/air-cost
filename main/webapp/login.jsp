<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <jsp:include page="header.jsp"/>
    <fmt:setLocale value="${sessionScope.language}"/>
    <fmt:setBundle basename="language.language" var="rs"/>
    <title><fmt:message bundle="${rs}" key="language.LogInPage"/></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="bg-image"
     style="background-image: url('https://kartinkin.net/uploads/posts/2021-07/thumbs/1626140558_62-kartinkin-com-p-nezhno-goluboi-fon-odnotonnii-krasivo-63.jpg');
            height: 100vh">
    <section class="py-5 text-center container">
        <div class="row py-lg-5">
            <div class="col-lg-6 col-md-8 mx-auto">
                <form name="LoginForm" action="/aircost/start" method="post">
                    <div class="container">
                        <%--            <img class="logo" src="https://e7.pngegg.com/pngimages/489/362/png-clipart-computer-icons-user-interface-login-button-miscellaneous-text.png">--%>
                        <h1 class="display-4 fw-normal text-white"><fmt:message bundle="${rs}"
                                                                                key="language.LogInForm"/></h1>
                        <p class="fs-5 text-muted"><fmt:message bundle="${rs}" key="language.FormInfo"/></p>
                        <div class="form-outline mb-4">
                            <input type="text" class="form-control"
                                   placeholder="<fmt:message bundle="${rs}" key="language.Email"/>"
                                   pattern="^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$"
                                   name="email">
                        </div>
                        <div class="form-outline mb-4">

                            <input type="password" class="form-control"
                                   placeholder="<fmt:message bundle="${rs}" key="language.Password"/>" name="password">
                        </div>
                        <button class="btn btn-primary btn-block mb-4" type="submit"><fmt:message bundle="${rs}"
                                                                                                  key="language.SignIn"/></button>
                    </div>
                    <div class="container signing">
                        <p class="fs-8 fw-normal text-white"><fmt:message bundle="${rs}" key="language.NoAccount"/> <a
                                href="/aircost/start?command=register_page"><fmt:message bundle="${rs}"
                                                                                         key="language.Register"/></a>
                        </p>
                    </div>
                    <div class="container">
                        <c:if test="${error == 1}">
                            <p id="errorText" class="fw-normal text-red" style="color:red;"><fmt:message
                                    bundle="${rs}"
                                    key="language.InvalidUsernameError"/></p>
                        </c:if>
                        <c:if test="${error == 2}">
                            <p id="errorText" class="fw-normal text-red" style="color:red;"><fmt:message
                                    bundle="${rs}"
                                    key="language.ReserveFlightError"/></p>
                        </c:if>
                        <c:if test="${error == 3}">
                            <p id="errorText" class="fw-normal text-red" style="color:red;"><fmt:message
                                    bundle="${rs}"
                                    key="language.EmptyFieldsError"/></p>
                        </c:if>
                    </div>
                    <input type="hidden" name="command" value="login">
                </form>
                <br/>
                <div class="pricing-header p-3 pb-md-4 mx-auto text-center">
                    <a class="me-1 py-2 text-decoration-none btn btn-outline-light"
                       href="<c:url value='/index.jsp'/>"><fmt:message bundle="${rs}" key="language.Back"/></a>
                </div>
            </div>
        </div>
    </section>
    <jsp:include page="footer.jsp"/>
</body>
</html>