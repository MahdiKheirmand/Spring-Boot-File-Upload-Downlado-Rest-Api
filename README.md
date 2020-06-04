# Spring-Boot-File-Upload-Downlado-Rest-Api
A Library where each book has a cover(File) which can be downloaded
<br>
<br>
<br>

### Set up
1. Set application.properties
<br>    Open src/main/java/resourcers/application.properties
<br>    Create a MySQL database called  **_spring_boot_file_** 
<br><br>    spring.datasource.username= YOUR MYSQL USERNAME
<br>        spring.datasource.password= YOUR MYSQL PASSWORD
<br><br><br>

2. run the app

### Links

1. http://localhost:8080/books/register
   <br> Use this Link to create a new book
   <br>
2. http://localhost:8080/books/getall
   <br> Use this Link to get all books stored
   <br>
3. http://localhost:8080/books/delete/book_id
   <br> Use this Link to delete book 
   <br>
4. http://localhost:8080/books/get/book_id
   <br> Use this Link to get book with given book_id
   <br>
5. http://localhost:8080/books/file/book_id
   <br> Use this Link to download file(cover) book
   <br><br>


### How To Register with postman
![Screenshot](Screenshot.png)

