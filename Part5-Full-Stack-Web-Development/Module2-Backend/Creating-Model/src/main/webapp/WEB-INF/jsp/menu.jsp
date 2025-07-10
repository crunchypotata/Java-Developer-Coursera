<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>
                Coffee Shop Menu
            </title>
        </head>
    <body>
        <h1>
            Welcome to the Coffee Shop!
        </h1>
        <h2>
            Our Menu
        </h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
            </tr>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>$${product.price}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
