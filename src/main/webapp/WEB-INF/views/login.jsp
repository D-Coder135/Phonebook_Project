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
            <input type="text" class="form-control" name="email" id="email" value= "${param.email}">
            <div class="text-danger">${errors.email}</div>
        </div>
    </div>
    <br>
    <div class="form-group row">
        <label for="password" class="col-md-4">Password</label>
        <div class="col-md-8">
            <input type="password" class="form-control" name="password" id="password">
            <div class="text-danger">${errors.password}</div>
        </div>
    </div>
    <br>
    <div class="form-group row">
        <label class="col-md-4"></label>
        <div class="col-md-8">
            <button class="btn btn-primary">Login</button>

            <input type="reset" class="btn btn-link" value="Reset">
        </div>
    </div>
</form>

<%@include file="footer.jspf" %>
