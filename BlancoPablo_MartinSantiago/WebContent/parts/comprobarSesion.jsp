<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${user == null}">
	<jsp:forward page="sesionInvalida" />
</c:if>
