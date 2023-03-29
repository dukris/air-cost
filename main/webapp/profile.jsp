<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <jsp:include page="header.jsp"/>
    <fmt:setLocale value="${sessionScope.language}"/>
    <fmt:setBundle basename="language.language" var="rs"/>
    <title><fmt:message bundle="${rs}" key="language.ProfilePage"/></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="bg-image "
     style="background-image: url('https://mir-oboev.ua/image/cache/catalog/oboi/RONI69869528-1000x1000.jpg');
            height: 150vh">
    <c:if test="${sessionScope.user == null}">
    <div class="container py-20 d-flex flex-column min-vh-100 foreground">
        <div class="pricing-header p-3 pb-md-4 mx-auto text-center">
            <h1 class="display-4 fw-normal text-white"><fmt:message bundle="${rs}" key="language.NotLogged"/></h1>
            <a class="btn btn-primary my-2"
               href="/aircost/start?command=login_page"><fmt:message bundle="${rs}" key="language.LogIn"/></a>
            <a class="btn btn-secondary my-2"
               href="/aircost/start?command=register_page"><fmt:message bundle="${rs}" key="language.Register"/></a>
        </div>
        </c:if>
        <c:if test="${sessionScope.user != null}">
            <c:if test="${sessionScope.users != null}">
                <h3><fmt:message bundle="${rs}" key="language.ActiveUsers"/>:</h3>
                <hr>
                <c:forEach items="${users}" var="user" varStatus="status">
                    <p><fmt:message bundle="${rs}" key="language.Name"/>: ${user.name}</p>
                    <p><fmt:message bundle="${rs}" key="language.Surname"/>: ${user.surname}</p>
                    <p><fmt:message bundle="${rs}" key="language.Email"/>: ${user.email}</p>
                    <hr>
                </c:forEach>
                <c:if test="${sessionScope.flights != null}">
                    <form action="/aircost/start" method="post">
                        <h3><fmt:message bundle="${rs}" key="language.ActiveFlights"/>:</h3>
                        <hr>
                        <c:forEach items="${flights}" var="flight" varStatus="status">
                            <p><fmt:message bundle="${rs}" key="language.From"/>: ${flight.fromCity}</p>
                            <p><fmt:message bundle="${rs}" key="language.To"/>: ${flight.toCity}</p>
                            <p><fmt:message bundle="${rs}" key="language.Date"/>: ${flight.date}</p>
                            <p><fmt:message bundle="${rs}" key="language.Price"/>: ${flight.price}</p>
                            <p><fmt:message bundle="${rs}" key="language.Amount"/>: ${flight.amount}</p>
                            <button type="submit" name="deleteChoice" value="${flight.id}"><fmt:message bundle="${rs}"
                                                                                                        key="language.Delete"/></button>
                            <button type="submit" name="editChoice" value="${flight.id}"><fmt:message bundle="${rs}"
                                                                                                      key="language.Edit"/></button>
                            <hr>
                        </c:forEach>
                        <c:if test="${error == 1}">
                            <p id="errorText" style="color:red;"><fmt:message bundle="${rs}"
                                                                              key="language.DeleteFlightUnableError"/></p>
                        </c:if>
                        <input type="hidden" name="command" value="update_flight">
                    </form>
                    <p><a href="/aircost/start?command=add_page"><fmt:message bundle="${rs}"
                                                                              key="language.AddFlight"/></a></p>
                </c:if>
            </c:if>
            <c:if test="${sessionScope.users == null}">
                <div class="pricing-header p-3 pb-md-4 mx-auto text-center">
                    <h1 class="display-4 fw-normal text-white"><fmt:message bundle="${rs}" key="language.WelcomeProfile"/>${sessionScope.user.name}!</h1>
                <p class="lead text-primary"><fmt:message bundle="${rs}" key="language.Name"/>: ${sessionScope.user.name}</p>
                <p class="lead text-primary"><fmt:message bundle="${rs}" key="language.Surname"/>: ${sessionScope.user.surname}</p>
                <p class="lead text-primary"><fmt:message bundle="${rs}" key="language.Email"/>: ${sessionScope.user.email}</p>
                <p class="lead text-primary"><fmt:message bundle="${rs}" key="language.Passport"/>: ${sessionScope.user.passport}</p>
                <p><a href="/aircost/start?command=update_profile_page"><fmt:message bundle="${rs}"
                                                                                     key="language.EditPassword"/></a>
                </p>
                </div>
                <c:if test="${sessionScope.orders == null}">
                    <p><fmt:message bundle="${rs}" key="language.NoActiveOrders"/></p>
                </c:if>
                <c:if test="${sessionScope.orders != null}">
                    <div class="album py-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-sm">
                                    <h1 class="display-2 fw-normal text-white"><fmt:message bundle="${rs}" key="language.ActiveOrders"/>:</h1>
                                    <div class="card shadow-sm">
                                        <div class="card-body">
                                                <div class="alert  alert-dark mt-2">
                                                    <c:forEach items="${orders}" var="order" varStatus="status">
                                                    <div class="form-check">
                                                        <p class="card-text"><fmt:message bundle="${rs}" key="language.From"/>: ${order.fromCity}</p>
                                                        <p class="card-text"><fmt:message bundle="${rs}" key="language.To"/>: ${order.toCity}</p>
                                                        <p class="card-text"><fmt:message bundle="${rs}" key="language.Date"/>: ${order.date}</p>
                                                        <p class="card-text"><fmt:message bundle="${rs}" key="language.AmountOfTickets"/>: ${order.amount}</p>
                                                        <p class="card-text"><fmt:message bundle="${rs}" key="language.TotalCost"/>: ${order.totalCost}</p>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:if>
            <div class="pricing-header p-2 pb-md-2 mx-auto text-center">
                <a class="me-1 py-2 text-decoration-none btn btn-outline-light"
                   href="/aircost/start?command=logout"><fmt:message bundle="${rs}" key="language.LogOut"/></a>
            </div>
           </c:if>
        <div class="pricing-header p-2 pb-md-2 mx-auto text-center">
            <a class="me-1 py-2 text-decoration-none btn btn-outline-light"
               href="<c:url value='/index.jsp'/>"><fmt:message
                    bundle="${rs}" key="language.Back"/></a>
        </div>
    </div>
</div>
<%--    <jsp:include page="footer.jsp"/>--%>
</body>
</html>
