<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <jsp:include page="header.jsp"/>
    <fmt:setLocale value="${sessionScope.language}"/>
    <fmt:setBundle basename="language.language" var="rs"/>
    <title><fmt:message bundle="${rs}" key="language.RegisterPage"/></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="bg-image"
     style="background-image: url('https://kartinkin.net/uploads/posts/2021-07/thumbs/1626140558_62-kartinkin-com-p-nezhno-goluboi-fon-odnotonnii-krasivo-63.jpg');
            height: 90vh">
    <section class="py-5 text-center container">
        <div class="row py-lg-5">
            <div class="col-lg-6 col-md-8 mx-auto">
                <form name="RegisterForm" action="/aircost/start" method="post">
                    <div class="container">
                        <%--                        <img class="logo" src="http://pngimg.com/uploads/padlock/padlock_PNG103184.png">--%>
                        <h1 class="display-4 fw-normal text-white"><fmt:message bundle="${rs}"
                                                                                key="language.RegisterForm"/></h1>
                        <p class="fs-5 text-muted"><fmt:message bundle="${rs}" key="language.FormInfo"/></p>
                        <div class="form-outline mb-2">

                            <input type="text" class="form-control"
                                   placeholder="<fmt:message bundle="${rs}" key="language.Name"/>" name="name">
                        </div>
                        <div class="form-outline mb-2">
                            <input type="text" class="form-control"
                                   placeholder="<fmt:message bundle="${rs}" key="language.Surname"/>" name="surname">
                        </div>
                        <div class="form-outline mb-2">
                            <input type="text" class="form-control"
                                   placeholder="<fmt:message bundle="${rs}" key="language.Passport"/>" name="passport">
                        </div>
                        <div class="form-outline mb-2">
                            <input type="text" class="form-control"
                                   placeholder="<fmt:message bundle="${rs}" key="language.Email"/>"
                                   pattern="^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$"
                                   name="email">
                        </div>
                        <div class="form-outline mb-2">
                            <input type="password" class="form-control"
                                   placeholder="<fmt:message bundle="${rs}" key="language.Password"/>" name="password">
                        </div>
                        <button class="btn btn-primary btn-block mb-4"  type="submit"><fmt:message bundle="${rs}" key="language.Register"/></button>
                    </div>
                    <div class="container signin">
                        <p><fmt:message bundle="${rs}" key="language.AlreadyHaveAccount"/> <a
                                href="/aircost/start?command=login_page"><fmt:message bundle="${rs}"
                                                                                      key="language.SignIn"/></a></p>
                    </div>
                    <c:if test="${error == 1}">
                        <p id="errorText" class="fw-normal text-red" style="color:red;"><fmt:message bundle="${rs}"
                                                                                                          key="language.EmailAlreadyTakenError"/></p>
                    </c:if>
                    <c:if test="${error == 2}">
                        <p id="errorText" class="fw-normal text-red" style="color:red;"><fmt:message bundle="${rs}"
                                                                                                          key="language.EmptyFieldsError"/></p>
                    </c:if>
                    <input type="hidden" name="command" value="register">
                </form>
                <div class="pricing-header p-2 pb-md-2 mx-auto text-center">
                    <a class="me-1 py-2 text-decoration-none btn btn-outline-light"
                       href="<c:url value='/index.jsp'/>"><fmt:message bundle="${rs}" key="language.Back"/></a>
                </div>
            </div>
        </div>
    </section>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
