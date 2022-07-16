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

            <p class="text-danger">This is going to permanently delete the record from our database, and cannot be undone!</p>
            <p>If you're sure, then type "PERMANENTLY DELETE" in the text box provided below.</p>
            <form method="POST">
                <input type="hidden" name="id" value="${contact.id}">
                <div class="form-group row">
                    <input type="text" class="col-md-4" name="confirm">
                    <button class="btn btn-danger col-md-3">Delete!</button>
                </div>
                <h5 class="text-danger">${errMessage}</h5>
            </form>
        </div>
    </div>
</c:if>

<%@include file="footer.jspf"%>
