
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer form</title>
    <link type="text/css"
        rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h3>Add customer</h3>
        </div>
    </div>

    <div id="container">
        <form:form action="saveCustomer" method="post" modelAttribute="customer">
            <form:hidden path="id"/>


            <table>
                <tbody>
                <tr>
                    <td><label>Box number</label></td>
                    <td><form:input path="boxNumber"/></td>
                    <td><form:errors path="boxNumber"/> </td>
                    <td><form:errors id="boxNotEmpty"/> </td>
                </tr>

                <tr>
                    <td><label>Ticket type</label></td>
                    <td><form:select path="ticket">
                        <form:option value="Normal"/>
                        <form:option value="Student"/>
                    </form:select></td>
                </tr>

                <tr>
                    <td><label>Confirm changes</label></td>
                    <td><input type="submit" value="Save" class="save"/></td>
                </tr>
                </tbody>
            </table>
        </form:form>
    </div>

</body>
</html>
