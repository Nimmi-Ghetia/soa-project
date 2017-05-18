<%-- 
    Document   : insert
    Created on : 1 May, 2017, 3:07:44 PM
    Author     : ngghe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Enter movie details</h1> <a href="index.html" align="right">Back</a>
        <form method="GET"  action="InsertMovie">
            movie id:<input type="text"  name="mov_id"/><br/>
            category id:<input type="text"  name="cat_id"/><br/>
            cinema id:<input type="text"  name="cin_id"/><br/>
            name:<input type="text"  name="name"/><br/>
            price:<input type="text"  name="price"/><br/>
            rating:<input type="text"  name="rating"/><br/>
            release date:<input type="text"  name="date"/><br/>
          <input type="submit" value='Submit' name='insert' />    
        </form>
        ${msg}
    </body>
</html>
