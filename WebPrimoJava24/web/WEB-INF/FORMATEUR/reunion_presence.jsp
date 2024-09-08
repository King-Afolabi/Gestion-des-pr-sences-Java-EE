<%-- 
    Document   : reunion_presence
    Created on : 11 juin 2024, 05:46:28
    Author     : kingafolabi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.jsp" %>
<%@include file="navbar_formateur.jsp" %>

<!-- Tableau de présence -->

<div class="container mt-5">
    <h2 class="text-center mb-4">Liste de présence</h2>
    <form action="formateur" method="post">
        <input type="hidden" name="added" value="reunion">
        <div id="attendanceTable">
            <%-- TODO: Remplir dynamiquement avec les données des utilisateurs --%>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Login</th>
                        <th>Statut</th>
                        <th>Présence</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${users}" var="u">
                        <%-- Exemple de données statiques, remplacer par les données dynamiques --%>
                        <tr>
                            <th scope="row" name="id_user" value="${u.id}">${u.id}</th>
                            <td name="nom_user" value="${u.nom_user}">
                                ${u.nom_user}
                            </td>
                            <td name="prenom_user" value="${u.prenom_user}">
                                ${u.prenom_user}
                            </td>
                            <td name="login_user" value="${u.login_user}">
                                ${u.login_user}
                            </td>
                            <td name="role_user" value="${u.role.id}">
                                ${u.role.libelleRole}
                            </td>
                            <td>
                                <select class="form-select" name="new_role_user">
                                    <option value="1" selected >Présent</option>
                                    <option value="2" >Absent</option>
                                </select>
                            </td>

                        </tr>
                    </c:forEach>



                </tbody>
            </table>
            <form action="formateur" method="post">


                <!-- Bouton pour enregistrer la liste -->
                <div class="text-center">
                    <button type="button" class="btn btn-success mt-4">Enregistrer la Liste</button>
                </div>
        </div>
    </form>
</div>
<%@include file="../footer.jsp" %>