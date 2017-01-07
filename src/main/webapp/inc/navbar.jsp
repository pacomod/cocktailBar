<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/" var="homeUrl"></c:url>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value='/'/>">TP Cocktail-Bar
			</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-2">
			<ul class="nav navbar-nav">
				<c:forEach items="${menub}" var="menu">
					<c:choose>
						<c:when test="${menu.title != 'Rechercher'}">
							<c:choose>
								<c:when test="${!menu.hasSubMenus()}">
									<li><a href="<c:url value='${menu.url}'/>.html">${menu.title}
									</a></li>
								</c:when>
								<c:otherwise>
									<li class="dropdown"><a
										href="<c:url value='${menu.url}.html'/>"
										class="dropdown-toggle" data-toggle="dropdown" role="button"
										aria-expanded="false">${menu.title}<span class="caret">
										</span></a>
										<ul class="dropdown-menu" role="menu">
											<c:forEach items="${menu.subMenus}" var="subMenu">
												<li><a href="<c:url value='${subMenu.url}.html'/>">${subMenu.title}</a></li>
											</c:forEach>
										</ul>
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<li>
								<form class="navbar-form navbar-right" role="search" action="<c:url value='${menu.url}.html'/>">
									<div class="form-group">
										<input class="form-control" placeholder="${menu.title}"
											type="text" name="search">
									</div>
									<button type="submit" class="btn btn-default">${menu.title}</button>
								</form>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
		</div>
	</div>
</nav>

