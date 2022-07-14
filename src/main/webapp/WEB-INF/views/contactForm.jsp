<%--
     Created by IntelliJ IDEA.
    Author: Devansh Shukla (D-Coder135)
    Date: 14-07-2022/07/2022
    Time: 02:26 PM
    File: contactForm.jsp
--%>
<%@ include file="header.jspf" %>
<h3>Add new contact details</h3>
<hr>

<form method="POST">

    <div class="form-group row">
        <label for="firstname" class="col-md-4">Firstname</label>
        <div class="col-md-8">
            <input type="text" class="form-control" name="firstname" id="firstname">
            <div class="text-danger">${errors.name}</div>
        </div>
    </div>
    <br>

</form>

<%@ include file="footer.jspf" %>
