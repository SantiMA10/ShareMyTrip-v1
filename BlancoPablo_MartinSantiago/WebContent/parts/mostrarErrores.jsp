<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${errores != null}">
	<c:forEach var="error" items="${errores}" varStatus="i">
		<ul>
			<li>${ error }</li>
		</ul>
	</c:forEach>
	<c:remove var="errores"/>
</c:if>
