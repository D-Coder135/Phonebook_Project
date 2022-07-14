<%--
     Created by IntelliJ IDEA.
    Author: Devansh Shukla (D-Coder135)
    Date: 14-07-2022/07/2022
    Time: 09:30 PM
    File: show-contact.jsp
--%>
<%@ include file="header.jspf" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>Contact details for id ${param.id}</h3>
<hr>

<c:choose>
    <c:when test="${requestScope.contact == null}">
        <h5 class="text-danger">Sorry, we didn't find any contact with id ${param.id}</h5>
    </c:when>

    <c:otherwise>
        <div class="row">
            <div class="col-md-5">
                <img class="img-thumbnail" src="${contact.avatar}" >
            </div>

            <div class="col-md-7">
                <table class="table">

                </table>
            </div>
        </div>
    </c:otherwise>

</c:choose>

<%@ include file="footer.jspf" %>