<%--
     Created by IntelliJ IDEA.
    Author: Devansh Shukla (D-Coder135)
    Date: 13-07-2022/07/2022
    Time: 09:17 PM
    File: login
--%>
<%@include file="header.jspf" %>
<h3>Existing user please login here</h3>
<hr>

<form method="POST">
    <div class="form-group row">
        <label for="email" class="col-md-4">Email address</label>
        <div class="col-md-8">
            <input type="text" class="form-control" name="email" id="email">
            <div class="text-danger">${errors.email}</div>
        </div>
    </div>
</form>

<%@include file="footer.jspf" %>
