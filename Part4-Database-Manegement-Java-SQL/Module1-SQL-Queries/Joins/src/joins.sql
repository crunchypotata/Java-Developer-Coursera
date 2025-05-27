SELECT *
FROM Artist;

SELECT Album.Title AS AlbumsTitle, Artist.Name AS ArtistsName
FROM Album
INNER JOIN Artist ON Album.ArtistId = Artist.ArtistId;

SELECT Artist.Name AS ArtistsName, Album.Title AS AlbumsTitle
FROM Artist
LEFT JOIN Album ON Artist.ArtistId = Album.ArtistId;

SELECT Album.Title AS AlbumsTitle, Artist.Name AS ArtistsName
FROM Artist
RIGHT JOIN Album ON Artist.ArtistId = Album.ArtistId;