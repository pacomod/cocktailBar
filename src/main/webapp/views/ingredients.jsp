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
				<h1>Liste des ingrédients</h1>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="well bs-component">
			<table id="ingredientsTable" class="table table-hover table-striped">
				<thead>
					<tr>
						<th>Nom</th>
						<th>État</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ingredients}" var="ingredient">
						<tr>
							<td>${ingredient.name}</td>
							<td>${ingredient.state}</td>
							<td class="col-md-2"><a
								href="<c:url value="/ingredients/mod.html">
							  <c:param name="id" value="${ingredient.id}"/>
							</c:url>"
								class="btn btn-success btn-xs">Modif</a> <a
								href="<c:url value="/ingredients/del.html">
							  <c:param name="id" value="${ingredient.id}"/>
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
	$('#ingredientsTable').DataTable({
		pageLength : 5,
		lengthMenu : [ 5, 10, 15 ],
		colReorder : true
	});
</script>
<jsp:include page="/inc/footerWithTables.jsp" />
