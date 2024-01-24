<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC SHOP</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>BOOK MANAGEMENT</h1>
		<h2>
			<a href="${pageContext.request.contextPath}/books/add">New Book</a>
		</h2>
		<nav class="navbar navbar-light bg-light">
			<form class="form-inline d-flex"
				action="${pageContext.request.contextPath}/books/search"
				method="get">
				<input class="form-control mx-2" type="search" name="searchText"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form>
		</nav>

		<form:form action="${pageContext.request.contextPath}/books/checkout"
			method="post" modelAttribute="bookOrder">
			<div class="my-3 d-flex col-md-6">
				<form:select path="customerId" cssClass="form-select w-75">
					<form:option value="-" label="Select user would place order..."></form:option>
					<c:forEach items="${customers}" var="customer">
						<form:option value="${customer.id}" label="${customer.name}"></form:option>
					</c:forEach>
				</form:select>
				<input type="submit" value="Check out" class="btn btn-primary mx-3" />
			</div>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>Add to cart</th>
						<th>Title</th>
						<th>Author</th>
						<th>Price</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${books}" var="book">
						<tr>
							<td><form:checkbox path="selectedBooks" value="${book.id}"
									cssClass="form-check"></form:checkbox></td>
							<td>${book.title}</td>
							<td>${book.author}</td>
							<td>${book.price}</td>
							<td><a href="books/edit?id=${book.id}">Edit</a>
								&nbsp;&nbsp;&nbsp; <a href="books/delete?id=${book.id}">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form:form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>