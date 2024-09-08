<%-- 
    Document   : list_classe
    Created on : 5 juin 2024, 16:49:28
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
                <th scope="col">Nom classe</th>
                <th scope="col">Niveau classe</th>
                <th scope="col">Nombre apprenants</th>

                <th scope="col">Modifier</th>
                <th scope="col">Supprimer</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${classes}" var="c">

                <tr>
                    <th scope="row">${c.idClasse}</th>
                    <td>
                        <form action="user" method="post">
                            <input type="hidden" name="add" value="modify_class">
                            <input type="hidden" name="old_nom_class" value="${c.nomClasse}">
                            <input type="text" name="new_nom_class" value="${c.nomClasse}">
                            </td>
                            <td>
                                <input type="text" name="new_niveau_class" value="${c.niveauClasse}">
                            </td>
                            <td>
                                <input type="number" name="new_nbre_apprenant" value="${c.nbreApprenant}">
                            </td>
                            <td>
                                <button type="submit" class="btn btn-primary">Modifier</button>
                        </form>
                    </td>
                    <td>
                        <form action="user" method="post">
                            <input type="hidden" name="add" value="drop_classe">
                            <input type="hidden" name="nom_class" value="${c.nomClasse}">
                            <input type="hidden" name="niveau_class" value="${c.niveauClasse}">
                            <button type="submit" class="btn btn-danger">Supprimer</button>
                        </form>
                    </td>
                </tr>

            </c:forEach>
        </tbody>
    </table>
</div>


<%@include file="../footer.jsp" %>