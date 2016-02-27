<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${errores != null && errores.size() > 0}">
	<div class="alert alert-danger">

		<c:forEach var="error" items="${errores}" varStatus="i">
			<ul>
				<li>${ error }</li>
			</ul>
		</c:forEach>
		<c:remove var="errores" />
	</div>
</c:if>
