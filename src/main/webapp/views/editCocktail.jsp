<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/inc/header.jsp" />
<c:set var="nav" value="cocktails"></c:set>
<%@ include file="/inc/navbar.jsp"%>
<c:url value="/cocktail/save.html" var="saveUrl">
</c:url>
<div class="container">
	<div class="page-header" id="banner">
		<div class="row">
			<div class="col-lg-8 col-md-7 col-sm-6">
				<h2>Modifier le cocktail</h2>
			</div>
		</div>
	</div>

	<div class="cocktail-details col-md-4">
		<form:form modelAttribute="cocktail" action="${saveUrl}">
			<form:hidden path="id" />
			<div class="form-group">
				<form:label path="name">Nom</form:label>
				<form:input path="name" class="form-control" />
				<form:errors path="name" cssClass="alert alert-danger"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="price">Prix</form:label>
				<form:input path="price" type="number" min="0" step="0.01"
					class="form-control" />
				<form:errors path="price" cssClass="alert alert-danger"></form:errors>
			</div>
			<div class="checknox">
				<form:label path="alcoholic" for="alcoholic">Alcoolisé</form:label>
				<form:checkbox path="alcoholic" id="alcoholic" />
			</div>
			<button>Valider</button>
		</form:form>
	</div>
	<div class="cocktail-ingredients col-md-8">
		<table id="cocktailIngredientsTable">
			<thead>
				<tr>
					<th>Ingrédient</th>
					<th colspan="2">Quantité</th>
					<th></th>
					<%-- action --%>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cocktailIngredients}" var="cocktailIngredient">
					<c:url value="/cocktail/removeIngredient.html" var="removeUrl">
						<c:param name="ingredientId"
							value="${cocktailIngredient.ingredient.id}">
						</c:param>
					</c:url>
					<tr>
<%-- 						<form action=""> --%>
							<td>${cocktailIngredient.ingredient.name}</td>
							<td><input name="" type="number" min="1"
								value="${cocktailIngredient.quantityNum}" /></td>
							<td><input type="number" min="1"
								value="${cocktailIngredient.quantityDen}" /></td>
							<td><a href="${removeUrl}" class="btn">Supprimer</a></td>
<%-- 						</form> --%>
					</tr>
				</c:forEach>
				<tr>
					<form action="<c:url value='/cocktail/addIngredient.html'/>">
						<td><select name="ingredientId">
								<c:forEach items="${ingredients}" var="ingredient">
									<option value="${ingredient.id}">${ingredient.name}</option>
								</c:forEach>
						</select></td>
						<td><input name="ingredientQuantityNum" type="number" min="1" value="1" /></td>
						<td><input name="ingredientQuantityDen" type="number" min="1" value="1" /></td>
						<td><button>Ajouter</button></td>
					</form>
				</tr>

			</tbody>
		</table>
	</div>
</div>
<div class="back">
	<a href="<c:url value='/cocktails.html'/>">Retour</a>
</div>
<script type="text/javascript">
	$('#coctailIngredientsTable').DataTable();
</script>
<jsp:include page="/inc/footer.jsp" />
