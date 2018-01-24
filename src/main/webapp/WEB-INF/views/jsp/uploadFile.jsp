<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link rel="stylesheet"	href="<%=request.getContextPath()%>/resources/core/css/table.css">
<link rel="stylesheet"	href="<%=request.getContextPath()%>/resources/core/css/layout.css">
<script type="text/javascript">
	$(function() {
		$('#idDateField').datepicker();
	});
</script>
</head>
<body bgcolor="#F4F7FC" >
<form:form method="post" action="addRecord"	commandName="spendingForm" enctype="multipart/form-data">
<div id="upleft" >
					
					 <table>
        <tr>
            <td><form:label path="file">Select a file to upload</form:label></td>
            <td><input type="file" name="file" /></td>
        </tr>
        <tr>
            <td><input type="submit" name="uploadFile"  value="Upload" /></td>
        </tr>
    </table>
    </div>
    </form:form>

</body>
</html>