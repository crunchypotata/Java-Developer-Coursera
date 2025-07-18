<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- TODO 12: set the title of the page to "Product List" and close the head tag-->
        <meta charset="UTF-8">
        <link rel="stylesheet" href="/css/product-styles.css">
        <title>Product List</title>
    </head>
    <!-- TODO 13: add the body tag and a heading tag with the text "Available Products" -->
    <body>
        <!-- Add heading here -->
        <h1>Available Products</h1>
        <table border = "1">
            <tread>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                </tr>
            </tread>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.description}</td>
                        <td>$${product.price}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
