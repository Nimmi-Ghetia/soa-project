<%-- 
    Document   : Update
    Created on : 1 Apr, 2017, 12:22:15 PM
    Author     : ngghe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="index.html" align="right">Back</a><br/>
        <form method="POST"  action="UpdateMovie?flag=1">
           Enter the movie name:<input type="text"  name="name"/><br/>
           <input type="submit" name="getdetails"  value="Enter"/>
           <br/>
           <br/>
          
        </form>
        <form method="post" action="UpdateMovie?flag=2&&mov_id=${requestScope.mov_id}">
              
               movie id:${requestScope.mov_id}<br/>
               
            category id:<input type="text"  name="cat_id" value="${requestScope.cat_id}"/><br/>
            cinema id:<input type="text"  name="cin_id" value="${requestScope.cin_id}"/><br/>
            name:<input type="text"  name="name" value="${requestScope.name}"/><br/>
            price:<input type="text"  name="price" value="${requestScope.price}"/><br/>
            rating:<input type="text"  name="rating" value="${requestScope.rating}"/><br/>
            release date:<input type="text"  name="release_date" value="${requestScope.release_date}" disabled="true"/><br/>
            <input type="submit" value='Update' name='update' />    
       
           </form>
           
            ${requestScope.msg}
    </body>
</html>
