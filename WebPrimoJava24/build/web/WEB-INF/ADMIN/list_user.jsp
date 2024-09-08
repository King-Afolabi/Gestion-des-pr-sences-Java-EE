<%-- 
    Document   : list_user
    Created on : 5 juin 2024, 11:44:45
    Author     : kingafolabi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>
<%@include file="navbar_user.jsp" %>

<div class="container mt-5">

    <form action="user" method="get">
        <div class="row mb-3">
            <label for="statutSelect" class="col-sm-2 col-form-label">Filtrer par statut :</label>
            <div class="col-sm-4">
                <input type="hidden" name="action" value="type">
                <select class="form-select" id="statutSelect" name="statut">
                    <option value="tous">Tous</option>
                    <option value="admin" <% if ("admin".equals(request.getParameter("statut"))) { %> selected <% } %>> <!-- maintient la séléction sur Admin -->Admin</option>
                    <option value="formateur" <% if ("formateur".equals(request.getParameter("statut"))) { %> selected <% } %>><!-- maintient la séléction sur Formateur -->Formateur</option>
                    <option value="apprenant" <% if ("apprenant".equals(request.getParameter("statut"))) { %> selected <% } %>><!-- maintient la séléction sur Apprenant -->Apprenant</option>
                </select>
            </div>
            <div class="col-sm-2">
                <button type="submit" class="btn btn-primary">Filtrer</button>
            </div>
        </div>
    </form> 

    ${msg}

    <table class="table table-hover">
        <thead>
            <tr class="table-primary">
                <th scope="col">ID</th>
                <th scope="col">Nom</th>
                <th scope="col">Prénom</th>
                <th scope="col">Login</th>
                <th scope="col">Statut</th>
                <th scope="col">Modifier</th>
                <th scope="col">Supprimer</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="u">

                <tr>
                    <th scope="row">${u.id}</th>
                    <td>
                        <form action="user" method="post">
                            <input type="hidden" name="add" value="modify_user">
                            <input type="hidden" name="old_login_user" value="${u.login_user}">
                            <input type="text" name="new_nom_user" value="${u.nom_user}">
                            </td>
                            <td>
                                <input type="text" name="new_prenom_user" value="${u.prenom_user}">
                            </td>
                            <td>
                                <input type="text" name="new_login_user" value="${u.login_user}">
                            </td>
                            <td>
                                <select name="new_role_user">
                                    <option value="" selected >${u.role.libelleRole}</option>
                                    <option value="1" >Apprenant</option>
                                    <option value="2" >Formateur</option>
                                    <option value="3" >Admin</option>
                                </select>
                            </td>

                            <td>
                                <button type="submit" class="btn btn-primary">Modifier</button>
                        </form>
                    </td>
                    <td>
                        <form action="user" method="post">
                            <input type="hidden" name="add" value="drop_user">
                            <input type="hidden" name="nom_user" value="${u.nom_user}">
                            <input type="hidden" name="prenom_user" value="${u.prenom_user}">
                            <input type="hidden" name="login_user" value="${u.login_user}">
                            <button type="submit" class="btn btn-danger">Supprimer</button>
                        </form>
                    </td>
                </tr>


            </c:forEach>
        </tbody>
    </table>
</div>


<%@include file="../footer.jsp" %>