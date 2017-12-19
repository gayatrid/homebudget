<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
    <script type="text/javascript">
      $(function() {
          $('#idDateField').datepicker();
      });
  </script>
    </head>
    <body bgcolor="#F4F7FC"><div align="center"><br><br>
    <h2>Spending Management Screen</h2>
    <form:form method="post" action="addSpending" commandName="spending">
        <table>
        <tr>
            <td>
            <fmt:formatDate value="${spending.payDate}" pattern="MM-dd-yyyy" var="payDatevar"/><!-- this is for date format -->
            <form:label path="payDate"><spring:message code="label.payDate"/></form:label></td>
            <td><form:input id="idDateField" type="date" value="${payDatevar}" path="payDate" /></td>
        </tr>
        <tr>
            <td><form:label path="description"><spring:message code="label.description"/></form:label></td>
            <td><form:input path="description" /></td>
        </tr>
        <tr>
            <td><form:label path="price"><spring:message code="label.price"/></form:label></td>
            <td><form:input path="price" /></td>
        </tr>
        <tr>
            <td><form:label path="bankName"><spring:message code="label.bankname"/></form:label></td>
            <td><form:input path="bankName" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message code="label.addButton"/>"/>
            </td>
        </tr>
    </table> 
    </form:form>
    <h3>Spending</h3>
    <c:if  test="${!empty spendingList}">
    <table class="data" border="1">
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Price</th>
        <th>Bank Name</th>
        <th></th>
    </tr>
    <c:forEach items="${spendingList}" var="spend">
        <tr>
            <td>${spend.payDate} </td>
            <td>${spend.description}</td>
            <td>${spend.price}</td>
            <td>${spend.bankName}</td>
           <th> <a href="./delete/${spend.id}">Delete</a>
           <%-- <a href="./edit/${spend.id}">Edit</a> --%>
           
           </th>
            
        </tr>
    </c:forEach>
    </table>
    </c:if></div>
    </body>
</html>