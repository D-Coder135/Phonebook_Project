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

    </c:forEach>
</div>

<%@include file="footer.jspf"%>
