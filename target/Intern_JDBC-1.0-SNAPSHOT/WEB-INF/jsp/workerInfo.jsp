<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<jsp:include page="header.jsp"/>
<body>
<div class="container" style="margin-top: 60px;">
    <div class="col-md-4">
        <form:form action="${action}" method="${method}" modelAttribute="worker">
            <fieldset class="scheduler-border">
                <legend class="scheduler-border"><c:out value="${msg}"/></legend>
                <c:if test="${type.equals('update')}">
                    <div class="form-group">
                        <label class="control-label">ID</label>
                        <form:input path="workerId" type="text" class="form-control" id="id" placeholder="ID"
                                    disabled="true"/>
                        <form:hidden path="workerId"/>
                        <form:hidden path="titleEntity.workerRefId"/>
                    </div>
                </c:if>
                <div class="form-group">
                    <label class="control-label">First Name (*)</label>
                    <form:input path="fName" type="text" class="form-control" placeholder="First Name" required="true"/>
                </div>
                <div class="form-group">
                    <label class="control-label">Last Name (*)</label>
                    <form:input path="lName" type="text" class="form-control" placeholder="Last Name" required="true"/>
                </div>
                <div class="form-group">
                    <label class="control-label">Salary (*)</label>
                    <form:input path="salary" type="number" step="any" class="form-control" placeholder="Salary"
                                required="true" min="1"/>
                </div>
                <div class="form-group">
                    <label class="control-label">Joining Date (*)</label>
                    <form:input path="joiningDate" type="date" class="form-control" placeholder="Publish Date"
                                required="true"/>
                </div>
                <div class="form-group">
                    <label class="control-label">Department (*)</label>
                    <form:input path="department" type="text" class="form-control" placeholder="Department"
                                required="true"/>
                </div>
                <div class="form-group">
                    <label class="control-label">Title </label>
                    <form:input path="titleEntity.workerTitle" type="text" class="form-control" placeholder="Title "
                                required="true"/>
                </div>
                <div class="form-group">
                    <label class="control-label">Affected From Date</label>
                    <form:input path="titleEntity.affectFrom" type="date" class="form-control"
                                placeholder="Affect From Date" required="true"/>
                </div>
                <br>
                <button type="submit" class="btn btn-info">Save</button>
            </fieldset>
        </form:form>
    </div>
</div>
</body>
</html>

