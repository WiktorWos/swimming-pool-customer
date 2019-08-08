
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customers</title>
    <link type="text/css"
        rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <div class="sideBySide" >
            <h3> Active customers</h3>
        </div>

        <div class="sideBySide" id="outsideAddDiv">
            <div id="insideAddDiv">
                <input type="button" value="Add customer"
                       onclick="window.location.href='showFormForAdd'; return false;"
                       class="add-button"/>
            </div>

        </div>



        <div class="outsideCheckoutDiv" id="outsideCheckoutDiv" style="float: left;">
            <div id="insideCheckoutDiv" class="insideCheckoutDiv">
                <input type="button" value="History"
                       onclick="window.location.href='history/showHistory'; return false;"
                       class="add-button"/>
            </div>
        </div>

        <div class="outsideCheckoutDiv" style="float: left;">
            <div id="insideHistoryDiv" class="insideCheckoutDiv" >
                <input type="button" value="Checkout"
                       onclick="window.location.href='showCheckout'; return false;"
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
                <th>Action</th>
            </tr>

            <c:forEach var="customer" items="${customers}">
                <c:url var="updateLink" value="/poolCustomer/showFormForUpdate">
                    <c:param name="id" value="${customer.id}"/>
                </c:url>
                <c:url var="deleteLink" value="/poolCustomer/deleteCustomer">
                    <c:param name="id" value="${customer.id}"/>
                </c:url>
                <c:url var="checkoutLink" value="/poolCustomer/showCheckoutFromId">
                    <c:param name="id" value="${customer.id}"/>
                </c:url>
                <tr>
                    <td>${customer.boxNumber}</td>
                    <td>${customer.ticket}</td>
                    <td>${dateFormat.format(customer.start)}</td>
                    <td><a href="${updateLink}" class="button">Update</a>
                        <a href="${deleteLink}" class="button"
                           onclick="if(!(confirm('Are you sure you want to delete this customer'))) return false">Delete</a>
                        <a href="${checkoutLink}" class="button">Checkout</a>
                    </td>
                </tr>

            </c:forEach>


        </table>
    </div>
</div>
</body>
</html>
