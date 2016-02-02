<%-- 
    Document   : emailsend
    Created on : 01/02/2016, 15:45:03
    Author     : edilson.junior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Adicionar planilha</h1>
        <form action="emailcontroller" method="post">




            endereco(use duas \):<input  type="text" name="endereco" value="" />


            <input type="submit"		      value="Salvar">
        </form> 
    </body>
</html>
