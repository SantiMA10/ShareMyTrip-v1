<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${mensaje != null}">
	<div class="alert alert-success">

		${ mensaje }
		
		<c:remove var="mensaje" />
	</div>
</c:if>
