-- INNER JOIN – List tracks and their corresponding albums
SELECT Track.Name AS TrackName,
       Album.Title AS AlbumTitle
FROM Track
INNER JOIN Album
    ON Track.AlbumId = Album.AlbumId;

-- LEFT JOIN - Display all artists and their albums
SELECT Artist.Name AS ArtistName,
       Album.Title AS AlbumTitle
FROM Artist
LEFT JOIN Album
    ON Artist.ArtistId = Album.ArtistId;

-- RIGHT JOIN – List all albums and their artists
SELECT Album.Title AS AlbumTitle,
       Artist.Name AS ArtistName
FROM Album
RIGHT JOIN Artist
    ON Album.ArtistId = Artist.ArtistId;

-- UNION - Combine major and minor genre lists
SELECT Genre.Name AS GenreName
FROM Genre;

-- Categorize customers based on purchase amounts
SELECT Customer.FirstName, Customer.LastName,
       SUM(Invoice.Total) AS TotalSpent,
       CASE
           WHEN SUM(Invoice.Total) < 50 THEN 'Low'
           WHEN SUM(Invoice.Total) BETWEEN 50 AND 100 THEN 'Medium'
           WHEN SUM(Invoice.Total) > 100 THEN 'High'
           ELSE 'Undefined'
       END AS SpendingCategory
FROM Customer
JOIN Invoice
    ON Customer.CustomerId = Invoice.CustomerId
GROUP BY Customer.CustomerId;

