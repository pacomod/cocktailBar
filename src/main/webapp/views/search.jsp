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
				<h1>Résultats de recherche</h1>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="well bs-component">
			<table id="resultsTable" class="table table-hover table-striped">
				<thead>
					<tr>
						<th class="hide">Id</th>
						<th>Nom</th>
						<th>Type</th>
						<th />
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cocktailResults}" var="cocktail">
						<tr>
							<td class="hide">${cocktail.id}</td>
							<td>${cocktail.name}</td>
							<td>Cocktail</td>
							<td><a
								href="<c:url value='/cocktail/edit/${cocktail.id}.html'/>">Modifier</a></td>
						</tr>
					</c:forEach>
					<c:forEach items="${ingredientResults}" var="ingredient">
						<tr>
							<td class="hide">${ingredient.id}</td>
							<td>${ingredient.name}</td>
							<td>Ingrédient</td>
							<td><a
								href="<c:url value='/ingredient/edit/${ingredient.id}.html'/>">Modifier</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</div>
	<script type="text/javascript">
	$.noConflict();
  var table = jQuery('#resultsTable').DataTable({
		pageLength : 5,
		lengthMenu : [ 5, 10, 15 ],
		colReorder : true
	});
</script>
	<jsp:include page="/inc/footerWithTables.jsp" />