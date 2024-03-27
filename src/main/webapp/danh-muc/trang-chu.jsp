<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 08/03/2024
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>  <%--import thư viện vào jsp --%>
<html>
<head>
    <title>Danh muc</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="container">

<form action="/danh-muc/add" method="post">
    <div class="mb-3">
        <label class="form-label">Ma danh muc</label>
        <input type="text" class="form-control" name="maDanhMuc">
    </div>
    <div class="mb-3">
        <label class="form-label">Ten danh muc</label>
        <input type="text" class="form-control" name="tenDanhMuc">
    </div>

    <div class="row">
        <p class="col-4"> Trang thai
        </p>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Active" name="trangThai">
            <label class="form-check-label">
                Active
            </label>
        </div>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Inactive" name="trangThai">
            <label class="form-check-label">
                Inactive
            </label>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<h1>Danh sach danh muc</h1>
<table class="table">
    <thead>
    <tr>
        <td>ID</td>
        <td>Ma Danh Muc</td>
        <td>Ten Danh Muc</td>
        <td>Trang Thai</td>
        <td>Ngay Tao</td>
        <td>Ngay Sua</td>
        <td>Chuc nang</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="s" items="${list}" varStatus="i">
        <tr>
            <td>${s.id}</td>
            <td>${s.maDanhMuc}</td>
            <td>${s.tenDanhMuc}</td>
            <td>${s.trangThai}</td>
            <td>${s.ngayTao}</td>
            <td>${s.ngaySua}</td>
            <td>
                <a href="#" class="btn btn-primary">Chi tiet</a>
                <a href="#" class="btn btn-primary">Xoa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
