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
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-10">
            <c:if test="${not empty bonusList}">
                <table class="table table-hover table-dark">
                    <thead class="thread-dark">
                    <tr>
                        <th>Id</th>
                        <th>Date</th>
                        <th>Amount</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="bonus" items="${bonusList}" varStatus="index">
                        <tr>
                            <td>${bonus.bonusId}</td>
                            <td>${bonus.bonusDate}</td>
                            <td>${bonus.bonusAmount}</td>
                            <td>
                                <button class="btn btn-sm btn-primary"
                                        onclick="location.href='update/${bonus.bonusId}'">Edit
                                </button>
                                <button class="btn btn-sm btn-danger"
                                        onclick="location.href='delete/${bonus.bonusId}'">Delete
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${bonusList.size() == 0}">
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
