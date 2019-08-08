<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkout result</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h3>Receipt</h3>
    </div>
</div>

<div id="container">
    <div id="content">
        <c:url var="finishLink" value="/poolCustomer/list"/>

        <table>
            <tr>
                <th>Box number</th>
                <th>Ticket type</th>
                <th>Start time</th>
                <th>End time</th>
                <th>Charge</th>
                <th>Finish</th>
            </tr>

            <tr>
                <td>${customer.boxNumber}</td>
                <td>${customer.ticket}</td>
                <td>${dateFormat.format(customer.start)}</td>
                <td>${currentDate.toString()}</td>
                <td>${charge}</td>
                <td>
                    <a href="${finishLink}" class="button">Confirm</a>
                </td>
            </tr>

        </table>
    </div>
</div>
</body>
</html>
