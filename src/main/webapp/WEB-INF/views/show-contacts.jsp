<%--
     Created by IntelliJ IDEA.
    Author: Devansh Shukla (D-Coder135)
    Date: 15-07-2022/07/2022
    Time: 12:48 PM
    File: show-contacts.jsp
--%>
<%@include file="header.jspf"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>List of all your contacts</h3>
<hr>

<div class="row">
    <c:forEach items="${requestScope.contacts}" var="c">
        <div class="card col-md-4">
            <img src="${c.avatar==''?'./assets/images/default-profile.jpeg': c.avatar}" class="card-img-top" alt="${c.firstname} ${c.lastname}">
            <div class="card-body">
                <h5 class="card-title">${c.firstname} ${c.lastname}</h5>
                <p class="card-text">${c.email} ${c.phone}</p>
                <a href="./view-contact-details?id=${c.id}" class="btn btn-primary">View details</a>
            </div>
        </div>
    </c:forEach>
</div>

<%@include file="footer.jspf"%>
