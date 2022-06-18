<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <jsp:include page="header.jsp"/>
    <fmt:setLocale value="${sessionScope.language}"/>
    <fmt:setBundle basename="language.language" var="rs"/>
    <title><fmt:message bundle="${rs}" key="language.StartPage"/></title>
    <%--    <link rel="stylesheet" href="background.css">--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="bg-image"
     style="background-image: url('https://oir.mobi/uploads/posts/2021-03/1616439667_13-p-krasivii-fon-nebo-13.jpg');
            height: 90vh" >
<section class="py-5 text-center container">
    <div class="row py-lg-5">
        <div class="col-lg-6 col-md-8 mx-auto">
            <h1 class="fw-light"><fmt:message bundle="${rs}" key="language.Welcome"/></h1>
            <p class="lead text-muted"><fmt:message bundle="${rs}" key="language.StartInfo"/><p>
            <a href="/aircost/start?command=login_page" class="btn btn-primary my-2"><fmt:message bundle="${rs}" key="language.LogIn"/></a>
            <a href="/aircost/start?command=register_page" class="btn btn-secondary my-2"><fmt:message bundle="${rs}" key="language.Register"/></a>
        </p>
            <a class="btn btn-success my-2" href="/aircost/start?command=home_page"><fmt:message bundle="${rs}" key="language.Start"/></a>
        </div>
    </div>
</section>
<%--    <div class="container py-20 d-flex flex-column min-vh-100 foreground">--%>
<%--        <div class="pricing-header p-3 pb-md-4 mx-auto text-center">--%>
<%--            <h1 class="display-4 fw-normal text-white"><fmt:message bundle="${rs}" key="language.Welcome"/></h1>--%>
<%--            <p class="fs-5 text-muted"><fmt:message bundle="${rs}" key="language.StartInfo"/></p>--%>
<%--            <a class="me-3 py-2 text-decoration-none btn btn-outline-light" href="/aircost/start?command=home_page"><fmt:message bundle="${rs}" key="language.Start"/></a>--%>
<%--          <p class="fs-10 text-white"><fmt:message bundle="${rs}" key="language.Auth"/></p>--%>
<%--            <a class="me-1 py-2 text-decoration-none btn btn-outline-light" href="/aircost/start?command=login_page"><fmt:message bundle="${rs}" key="language.LogIn"/></a>--%>
<%--            <a class="me-1 py-2 text-decoration-none btn btn-outline-light" href="/aircost/start?command=register_page"><fmt:message bundle="${rs}" key="language.Register"/></a>--%>

<%--        </div>--%>
    </div>
<jsp:include page="footer.jsp"/>
<%--</div>--%>
</body>
</html>
