<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 08/03/2024
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="container">

<form action="/sinh-vien/add" method="post">
    <div class="mb-3">
        <label class="form-label">Ma sinh vien</label>
        <input type="text" class="form-control" name="maSinhVien">
    </div>
    <div class="mb-3">
        <label class="form-label">Ten sinh vien</label>
        <input type="text" class="form-control" name="tenSinhVien">
    </div>
    <div class="mb-3">
        <label class="form-label">Tuoi</label>
        <input type="text" class="form-control" name="tuoi">
    </div>
    <div class="mb-3">
        <label class="form-label">Dia Chi</label>
        <input type="text" class="form-control" name="diaChi">
    </div>
    <div class="mb-3">
        <label for="disabledSelect" class="form-label">Ten lop</label>
        <select id="disabledSelect" class="form-select">
            <option>SD123</option>
            <option>SD124</option>
            <option>SD125</option>
        </select>
    </div>
    <div class="row">
        <p class="col-4">Gioi tinh
        </p>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Nam" name="gioiTinh">
            <label class="form-check-label">
                Nam
            </label>
        </div>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Nu" name="gioiTinh">
            <label class="form-check-label">
                Nu
            </label>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<table class="table">
    <thead>
    <tr>
        <td>
            STT
        </td>
        <td>Ten sinh vien</td>
        <td>Ma sinh vien</td>
        <td>Dia chi</td>
        <td>Tuoi</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listSinhVien}" var="s" varStatus="i">
        <tr>
            <td>${i.index +1}</td>
            <td>${s.tenSv}</td>
            <td>${s.maSv}</td>
            <td>${s.diaChi}</td>
            <td>${s.tuoi}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
