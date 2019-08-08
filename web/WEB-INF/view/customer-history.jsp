<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
    <link type="text/css"
    rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <div class="sideBySide" >
            <h3>History</h3>
        </div>

        <div class="sideBySide" id="outsideAddDiv">
            <div id="insideAddDiv">
                <input type="button" value="Add customer"
                       onclick="window.location.href='http://localhost:8080/web_war_exploded/poolCustomer/showFormForAdd'; return false;"
                       class="add-button"/>
            </div>

        </div>

        <div class="outsideCheckoutDiv" style="float: left;">
            <div id="insideHistoryDiv" class="insideCheckoutDiv" >
                <input type="button" value="Checkout"
                       onclick="window.location.href='http://localhost:8080/web_war_exploded/poolCustomer/showCheckout'; return false;"
                       class="add-button"/>
            </div>

        </div>

        <div class="outsideCheckoutDiv" id="outsideCheckoutDiv" style="float: left;">
            <div id="insideCheckoutDiv" class="insideCheckoutDiv">
                <input type="button" value="Active list"
                       onclick="window.location.href='http://localhost:8080/web_war_exploded/poolCustomer/list'; return false;"
                       class="add-button"/>
            </div>
        </div>


        <div style="clear: both;"></div>
    </div>
</div>
<div id="container">
    <div id="content">
        <table>
            <tr>
                <th>Box number</th>
                <th>Ticket type</th>
                <th>Start time</th>
                <th>End time</th>
                <th>Charge</th>
            </tr>

            <c:forEach var="customerHistory" items="${customersHistory}">

                <tr>
                    <td>${customerHistory.boxNumber}</td>
                    <td>${customerHistory.ticket}</td>
                    <td>${dateFormat.format(customerHistory.start)}</td>
                    <td>${dateFormat.format(customerHistory.end)}</td>
                    <td>${decimalFormat.format(customerHistory.charge)}</td>
                </tr>

            </c:forEach>


        </table>
    </div>
</div>
</body>
</html>
