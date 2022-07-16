<%--
     Created by IntelliJ IDEA.
    Author: Devansh Shukla (D-Coder135)
    Date: 16-07-2022/07/2022
    Time: 09:33 PM
    File: confirm-delete-contact.jsp
--%>
<%@include file="header.jspf"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3 class="text-danger">Confirm Deletion</h3>
<hr>

<c:if test="${contact == null}">
    <h5>The id supplied is either invalid or the contact does not belong to your phonebook!</h5>
</c:if>

<c:if test="${contact != null}">

</c:if>

<%@include file="footer.jspf"%>
