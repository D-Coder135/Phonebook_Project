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
                <img class="img-thumbnail" src="${contact.avatar == '' ? './assets/images/default-profile.jpeg' : contact.avatar}" >
            </div>

            <div class="col-md-7">
                <table class="table">

                    <tr>
                        <td>Firstname</td>
                        <td>${contact.firstname}</td>
                    </tr>

                    <tr>
                        <td>Lastname</td>
                        <td>${contact.lastname}</td>
                    </tr>

                    <tr>
                        <td>Email address</td>
                        <td>${contact.email}</td>
                    </tr>

                    <tr>
                        <td>Phone number</td>
                        <td>${contact.phone}</td>
                    </tr>

                    <tr>
                        <td>Street address</td>
                        <td>${contact.address}</td>
                    </tr>

                    <tr>
                        <td>City</td>
                        <td>${contact.city}</td>
                    </tr>

                    <tr>
                        <td>State/region/province</td>
                        <td>${contact.state}</td>
                    </tr>

                    <tr>
                        <td>Pin-Code</td>
                        <td>${contact.pincode}</td>
                    </tr>

                    <tr>
                        <td>Country</td>
                        <td>${contact.country}</td>
                    </tr>

                </table>
                <a href="./edit-and-update-contact?id=${contact.id}" class="btn btn-primary">Edit details</a>
                <a href="./delete-contact?id=${contact.id}" class="btn btn-outline-danger">Delete Contact</a>
            </div>
        </div>
    </c:otherwise>

</c:choose>

<%@ include file="footer.jspf" %>