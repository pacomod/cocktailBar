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
			<%-- passer la liste des ingrédients en hidden! --%>
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
	<%-- Lister, modifier, supprimer les ingrédients --%>
	<div class="container">
		<div class="well col-md-8">
			<%--CocktailIngredients pseudo table header --%>
			<div class="row">
				<div class="col-md-6">
					<strong>Ingrédient</strong>
				</div>
				<div class="col-md-5">
					<strong>Quantité</strong>
				</div>
				<div class="col-md-1">
					<%-- action --%>
				</div>
			</div>
			<%--CocktailIngredients pseudo table body --%>
			<c:forEach items="${cocktailIngredients}" var="cocktailIngredient">
				<form id="${cocktailIngredient.ingredient.id}"
					action="<c:url value='/cocktail/removeIngredient.html'/>" class="ckin">
					<fieldset>
						<div class="form-inline">
							<input type="hidden" name="ingredientId"
								value="${cocktailIngredient.ingredient.id}" />
							<input
								class="form-group col-md-5" type="text" disabled
								value="${cocktailIngredient.ingredient.name}" />
							<div class="form-group col-md-1"></div>
							<input class="form-group col-md-1" name="ingredientQuantityNum"
								type="number" min="1" value="${cocktailIngredient.quantityNum}" />
							<input class="form-group col-md-1 text-center" disabled value="/"/>
							<input class="form-group col-md-1" name="ingredientQuantityDen"
								type="number" min="1" value="${cocktailIngredient.quantityDen}" />
							<div class="form-group col-md-1"></div>
							<button id="btn${cocktailIngredient.ingredient.id}"
								class="form-group btn-warning col-md-2">Supprimer</button>
						</div>
					</fieldset>
				</form>
			</c:forEach>
			<hr>
			<%-- Ajouter un ingrédient --%>
			<form action="<c:url value='/cocktail/addIngredient.html'/>">
				<fieldset>
					<div class="form-inline">
						<select id="ckadd" class="form-group col-md-5" name="ingredientId">
							<option value="" selected disabled>Choisir</option>
							<c:forEach items="${ingredients}" var="ingredient">
								<option value="${ingredient.id}">${ingredient.name}</option>
							</c:forEach>
						</select>
						<div class="form-group col-md-1"></div>
						<input class="form-group col-md-1" name="ingredientQuantityNum"
							type="number" min="1" value="1" />
						<input class="form-group col-md-1 text-center" disabled value="/"/>
						<input class="form-group col-md-1" name="ingredientQuantityDen"
							type="number" min="1" value="1" />
						<div class="form-group col-md-1"></div>
						<button id="btnadd" class="form-group col-md-2" disabled>Ajouter</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</div>
<%--<div id="log"></div> --%>
<%-- <div class="back"> --%>
<%-- 	<a href="<c:url value='/cocktails.html'/>">Retour</a> --%>
<%-- </div> --%>
<%-- $('#coctailIngredientsTable').DataTable();--%>
<%--		$('#log').prepend('<p>log:' + $('#' +$(this.form).attr('id')).attr('action') + '</p>') --%>
<script type="text/javascript">
	$('form.ckin :input').change(function() {
		$('#btn' + $(this.form).attr('id')).html('Modifier');
		$('#btn' + $(this.form).attr('id')).removeClass('btn-warning').addClass('btn-success');
		$('#' + $(this.form).attr('id')).attr('action',
				'<c:url value="/cocktail/modifyIngredient.html"/>')
	});
	$('#ckadd').change(function() {
		$('#btnadd').removeAttr('disabled');
	});
</script>
<jsp:include page="/inc/footer.jsp" />
