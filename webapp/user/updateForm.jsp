<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>KUIT</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/styles.css" rel="stylesheet">
  </head>
  <body>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark" aria-label="Fourth navbar example">
      <div class="container-fluid">
        <a class="navbar-brand" href="/"> KUIT </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsExample04">
          <ul class="navbar-nav me-auto mb-2 mb-md-0">
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-bs-toggle="dropdown" aria-expanded="false">Home</a>
              <ul class="dropdown-menu" aria-labelledby="dropdown04">
                <li><a class="dropdown-item" href="#">Profile</a></li>
                <li><a class="dropdown-item" href="#">Settings</a></li>
              </ul>
            </li>
          </ul>
          <form>
            <input class="form-control" type="text" placeholder="Search" aria-label="Search">
          </form>
        </div>
      </div>
    </nav>
    <div class="navbar-default">
      <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
        </a>

        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
          <li><a href="/index.html" class="nav-link px-2 link-secondary">Q&A</a></li>
          <li><a href="#" class="nav-link px-2 link-dark">FAQs</a></li>
          <li><a href="/user/userList" class="nav-link px-2 link-dark">User List</a></li>
          <li><a href="#" class="nav-link px-2 link-dark">About</a></li>
        </ul>

        <div class="col-md-3 text-end">
          <a href="/user/login.html" type="button" class="btn btn-outline-primary me-2">Login</a>
          <a href="/user/form.jsp" type="button" class="btn btn-primary">Sign-up</a>
        </div>
      </header>
    </div>

    <div class="container" id="main">

        <main class="form-update">
        <% String userId = request.getParameter("userId"); %>

          <form name="Update" method="post" action="/user/update">
            <div class="form-floating">
              <input type="text" class="form-control" id="userId" name="userId" placeholder="Id" readonly value="<%= userId %>">
              <label for="userId">User Id</label>
              <small class="text-muted">ID cannot be modified.</small>
            </div>
            <div class="form-floating">
              <input type="password" class="form-control" id="password" name="password" placeholder="Password">
              <label for="password">Password</label>
            </div>
            <div class="form-floating">
              <input type="text" class="form-control" id="name" name="name" placeholder="name">
              <label for="name">Name</label>
            </div>
            <div class="form-floating">
              <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com">
              <label for="email">Email address</label>
            </div>
            <div style="height:10px;">
            </div>
            <button class="w-100 btn btn-lg btn-primary" type="submit">Update</button>
          </form>
        </main>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../js/scripts.js"></script>
  </body>
</html>