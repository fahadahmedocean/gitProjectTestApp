<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">

<head>
    <link type="text/css" rel="stylesheet" href="<c:url value="/styles/bootstrap.min.css"/>" />
</head>
<body>
<h1> This is our First spring Boot App</h1>

<h3>${message}</h3>
<a href="/upsertStudent">Create Student</a>
<table class="table">
    <thead>
    <tr>
        <th>Sl#</th>
        <th>Name</th>
        <th>Father's Name</th>
        <th>Mother's Name</th>
        <th>Roll No</th>
        <th>Gender</th>
        <th>Email Address</th>
        <th>Cell No</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${studentList}" var="std" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
            <td>${std.name}</td>
            <td>${std.fatherName}</td>
            <td>${std.motherName}</td>
            <td>${std.rollNo}</td>
            <td>${std.gender}</td>
            <td>${std.email}</td>
            <td>${std.mobile}</td>
            <td>
                <a class="btn btn-warning" href="./upsertStudent?studentId=${std.id}">Edit</a>
            </td>
            <td>
                <a class="btn btn-danger" href="./deleteStudent?studentId=${std.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>


    </tbody>
</table>

</body>

</html>