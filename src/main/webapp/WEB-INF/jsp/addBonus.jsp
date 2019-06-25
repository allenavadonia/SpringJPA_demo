<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<jsp:include page="header.jsp"/>
<body>
<div class="container" style="margin-top: 60px;">
    <div class="col-md-4">
        <form:form action="${action}" method="${method}" modelAttribute="bonus">
            <fieldset class="scheduler-border">
                <legend class="scheduler-border"><c:out value="${msg}"/></legend>
                <c:if test="${type.equals('update')}">
                    <label class="control-label">ID</label>
                    <form:input path="bonusId" type="text" class="form-control" id="id" placeholder="ID"
                                disabled="true"/>
                    <form:hidden path="bonusId"/>
                    <div class="form-group">
                        <label class="control-label">worker id </label>
                        <form:input path="workerRefId.workerId" type="text" class="form-control" />
                    </div>
                </c:if>
                <c:if test="${!type.equals('update')}">
                    <div class="form-group">
                        <label class="control-label">worker id </label>
                        <form:input path="workerRefId.workerId" type="text" class="form-control"/>
                    </div>
                </c:if>
                <div class="form-group">
                    <label class="control-label">amount (*)</label>
                    <form:input path="bonusAmount" type="number" step="any" class="form-control" placeholder="Salary"
                                required="true" min="1"/>
                </div>
                <div class="form-group">
                    <label class="control-label"> Date (*)</label>
                        <form:input path="bonusDate" type="date" class="form-control" placeholder="Publish Date"
                                    required="true"/>
                    <button type="submit" class="btn btn-info">Save</button>
            </fieldset>
        </form:form>
    </div>
</div>
</body>
</html>