<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<jsp:include page="header.jsp"/>
<body>
<div class="container" style="margin-top: 60px;">

    <button class="btn btn-sm btn-primary" onclick="location.href='bonus/add/'">ADD NEW BONUS</button>
    <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-6">
            <form:form action="search" method="get">
                <div class="input-group">
                    <input name="searchInput" type="text" class="form-control" placeholder="Search by firstname or lastname..."/>
                    <span class="input-group-btn">
                            <button class="btn btn-primary" type="submit">Search</button>
                        </span>
                </div>
            </form:form>
        </div>

        <div class="col-xs-12 col-sm-12 col-md-10">
            <c:if test="${not empty workerList}">
                <table class="table table-hover table-dark">
                    <thead class="thread-dark">
                    <tr>
                        <th>Id</th>
                        <th>FirstName</th>
                        <th>LastName</th>
                        <th>salary</th>
                        <th>joining date</th>
                        <th>department</th>
                        <th>title</th>
                        <th>affectFrom</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="worker" items="${workerList}" varStatus="index">
                        <tr>
                            <td>${worker.workerId}</td>
                            <td>${worker.fName}</td>
                            <td>${worker.lName}</td>
                            <td>${worker.salary}</td>
                            <td>${worker.joiningDate}</td>
                            <td>${worker.department}</td>
                            <td>${worker.titleEntity.workerTitle}</td>
                            <td>${worker.titleEntity.affectFrom}</td>
                            <td>
                                <button
                                        class="btn btn-sm btn-primary"
                                        onclick="location.href='update/${worker.workerId}'">Edit
                                </button>
                            </td>
<%--                                <button--%>
<%--                                        class="btn btn-sm btn-danger"--%>
<%--                                        onclick="location.href='delete/${worker.workerId}'">Delete--%>
<%--                                </button>--%>
                            <td>
                                <form:form method="post" action="/delete?id=${worker.workerId}" >
                                    <button class="btn btn-danger" type="submit">delete</button>
                                </form:form>
                            </td>
                            <td>
                                <button class="btn btn-sm btn-success"
                                        onclick="location.href='bonus/${worker.workerId}'">View Bonus
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${workerList.size() == 0}">
                <br>
                <div class="alert alert-warning">
                    There is no data
                </div>
            </c:if>
        </div>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
