<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.language}"/>
    <fmt:setBundle basename="language.language" var="rs"/>
    <%--    <link rel="stylesheet" href="background.css">--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css">
</head>
<header>
    <div class="d-flex flex-column flex-md-row align-items-center border-bottom bg-dark">
        <a href="/aircost/" class="d-flex align-items-center text-light text-decoration-none">
            <span class="fs-3" style="text-indent: 30px">AirCOST</span>
        </a>
        <nav class="d-inline-flex mt-2 mt-md-0 ms-md-auto">
            <form action="/aircost/start" method="get">
                <input type="hidden" name="command" value="language">
                <button class="btn btn-light" type="submit" name="language" value="en_US">EN</button>
                <button class="btn btn-light" type="submit" name="language" value="ru_RU">RU</button>
                <a class="btn btn-success" href="/aircost/start?command=profile_page"><fmt:message bundle="${rs}"
                                                                                              key="language.Profile"/></a>
            </form>

        </nav>


    </div>


    <%--    <div class="container">--%>
    <%--        <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">--%>
    <%--            <a href="/aircost/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">--%>
    <%--                <span class="fs-3" style="text-indent: 30px">AirCOST</span>--%>
    <%--            </a>--%>

    <%--            <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">--%>
    <%--                <button class="nav-link px-2 btn btn-dark" type="submit" name="language" value="en_US">EN</button>--%>
    <%--                <button class="nav-link px-2 btn btn-dark" type="submit" name="language" value="ru_RU">RU</button>--%>
    <%--            </ul>--%>

    <%--            <div class="col-md-3 text-end">--%>
    <%--                <a class="btn btn-primary" href="/aircost/start?command=profile_page"><fmt:message bundle="${rs}"--%>
    <%--                                                                                                  key="language.Profile"/></a>--%>
    <%--            </div>--%>
    <%--        </header>--%>
    <%--    </div>--%>
</header>

</html>
