<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkout</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h3>Checkout</h3>
    </div>
</div>

<div id="container">
    <form:form action="checkout" method="get" modelAttribute="customer">



        <table>
            <tbody>
            <tr>
                <td><label>Box number</label></td>
                <td><form:input path="boxNumber" /></td>
                <td><form:errors path="boxNumber"/> </td>
                <td><form:errors id="boxIsEmpty"/> </td>
            </tr>

            <tr>
                <td><label>Confirm changes</label></td>
                <td>
                    <input type="submit" value="Checkout" class="save"/>
                    <input type="button" value="Cancel" class="save"
                       onclick="window.location.href='list'; return false;"/>
                </td>
            </tr>
            </tbody>
        </table>
    </form:form>
</div>
</body>
</html>
