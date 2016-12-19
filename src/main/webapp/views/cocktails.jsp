<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/inc/headerWithTables.jsp" />
<c:set var="nav" value="ingredients"></c:set>
<%@ include file="/inc/navbar.jsp"%>
<div class="container">
	<div class="page-header" id="banner">
		<div class="row">
			<div class="col-lg-8 col-md-7 col-sm-6">
				<h1>Liste des cocktails</h1>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="well bs-component">
			<table id="cocktailsTable" class="table table-hover table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nom</th>
						<th>Prix</th>
						<th>Alcoolisé</th>
						<th>Ingrédients</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cocktails}" var="cocktail">
						<tr>
							<td class="col-md-2">${cocktail.id}</td>
							<td>${cocktail.name}</td>
							<td>${cocktail.price}</td>
							<td>${cocktail.alcoholic}</td>
							<td>…</td>
							<td class="col-md-2"><a
								href="<c:url value="/cocktails/mod.html">
							  <c:param name="id" value="${cocktail.id}"/>
							  </c:url>"
								class="btn btn-success btn-xs">Modif</a> <a
								href="<c:url value="/cocktails/del.html">
							  <c:param name="id" value="${cocktail.id}"/>
							  </c:url>"
								class="btn btn-warning btn-xs">Suppr</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script type="text/javascript">
	$.noConflict();
  var table = jQuery('#cocktailsTable').DataTable({
		pageLength : 5,
		lengthMenu : [ 5, 10, 15 ],
		colReorder : true
	});

	jQuery('#cocktailsTable tbody').on('click', 'tr', function() {
		var data = table.row(this).data();
		alert('You clicked on ' + data[0] + '\'s row');
	});
</script>
<jsp:include page="/inc/footerWithTables.jsp" />
