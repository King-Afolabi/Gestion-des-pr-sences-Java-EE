<%-- 
    Document   : essai
    Created on : 30 mai 2024, 12:41:12
    Author     : kingafolabi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="../header.jsp" %>
<%@include file="navbar_formateur.jsp" %>



        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h1 class="text-info">Hello ${user.prenom_user} ${user.nom_user}</h1>
                </div>
            </div>
        </div>

<%@include file="../footer.jsp" %>

