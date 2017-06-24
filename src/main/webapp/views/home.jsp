<%--
  Created by IntelliJ IDEA.
  User: Yerchik
  Date: 22.05.2017
  Time: 4:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Library</h1>
    <div>
        <p><a href="#" onclick="addShow()">Add book</a></p>
        <div id="add" hidden>
            <label for="author">Author:</label>
            <input name="author" id="author" type="text"> <br>

            <label for="name">Name:</label>
            <input name="name" id="name" type="text"><br>
            <br>
            <div id="errorMessage"></div>
            <button id="addButton" onclick="addBook()">Add!</button>
        </div>
        <p><a href="#" onclick="listShow()">All books</a></p>
        <div id="list" hidden>
            <div id="allbooks">


            </div>
        </div>
        <p><a href="#" onclick="removeBook()">Remove book</a></p>
        <div id="remove" hidden>
            <label for="book">Select book:</label>
            <select name="book" id="book"></select>
            <br>
            <button id="clearButton" onclick="removeBook2()">Remove!</button>
        </div>

        <p><a href="#" onclick="editBook()">Edit book</a></p>
        <div id="edit" hidden>
            <label for="editbook">Select book:</label>
            <select name="editbook" id="editbook"></select>
            <br>
            <label for="newName">New name:</label>
            <input name="newName" id="newName" type="text"><br>
            <button id="editButton" onclick="editBook2()">Edit!</button>
        </div>

    </div>



    <script src="/resources/JS/js/jquery-1.11.1.min.js"></script>
    <script src="/resources/JS/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="/resources/JS/js/bootstrap.min.js"></script>
    <script src="/resources/JS/js/modernizr.min.js"></script>
    <script src="/resources/JS/js/pace.min.js"></script>
    <script src="/resources/JS/js/retina.min.js"></script>
    <script src="/resources/JS/js/jquery.cookies.js"></script>
    <script src="/resources/JS/js/custom.js"></script>
    <script src="/resources/JS/home.js"></script>

</body>
</html>
