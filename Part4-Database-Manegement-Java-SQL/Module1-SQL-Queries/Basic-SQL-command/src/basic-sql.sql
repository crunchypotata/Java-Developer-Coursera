SELECT *
FROM Sales;

SELECT SaleDate, TotalSaleAmount
FROM Sales;

UPDATE Sales
SET QuantitySold = 2
WHERE TransactionID = 10;

SELECT *
FROM Sales
WHERE SaleDate > '2023-08-03';