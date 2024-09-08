<%-- 
    Document   : user_add_class
    Created on : 6 juin 2024, 18:15:30
    Author     : kingafolabi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>
<%@include file="navbar_user.jsp" %>


<div class="container mt-5">

    ${msg}

    <table class="table table-hover">
        <thead>
            <tr class="table-primary">
                <th scope="col">ID</th>
                <th scope="col">Nom</th>
                <th scope="col">Prénom</th>
                <th scope="col">Login</th>
                <th scope="col">Statut</th>
                <th scope="col">Classe</th>
                
                <th scope="col">Ajouter</th>

            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="u">

                <tr>

            <form action="user" method="POST">
                <input type="hidden" name="add" value="user_add_class">

                <th scope="row"  >
                    <input type="hidden" name="id_user" value="${u.id}">
                    ${u.id}</th>

                <td >
                    <input type="hidden" name="nom_user" value="${u.nom_user}">
                    ${u.nom_user}</td>

                <td >
                    <input type="hidden" name="prenom_user" value="${u.prenom_user}">
                    ${u.prenom_user}</td>

                <td  >
                    <input type="hidden" name="login_user" value="${u.login_user}">
                    ${u.login_user}</td>

                <td >
                    <input type="hidden" name="role_user" value="${u.role.libelleRole}">
                    ${u.role.libelleRole}</td>
               
                <td>
                    <select name="new_user_class">
                        <option value="${u.classe.idClasse}" selected>${u.classe.nomClasse}</option>
                        <c:forEach items="${classes}" var="c">
                            <option value="${c.idClasse}" >${c.nomClasse}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <button type="submit" class="btn btn-primary">Ajouter</button>
            </form>
            </td>

        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="../footer.jsp" %>
