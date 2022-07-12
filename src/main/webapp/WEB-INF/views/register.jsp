<%--
     Created by IntelliJ IDEA.
    Author: Devansh Shukla (D-Coder135)
    Date: 12-07-2022/07/2022
    Time: 10:34 PM
    File: register
--%>
<%@ include file="./header.jspf" %>

<h3>New User Registration Form</h3>
<hr>

<form method="POST">

    <div class="form-group row">
        <label for="name" class="col-md-4">Name</label>
        <div class="col-md-8">
            <input type="text" class="form-control" name="name" id="name">
        </div>
    </div>
</form>

<%@ include file="footer.jspf" %>
