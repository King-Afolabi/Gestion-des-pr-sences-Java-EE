<%-- 
    Document   : add_user
    Created on : 4 juin 2024, 09:38:20
    Author     : kingafolabi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="../header.jsp" %>
<%@include file="navbar_user.jsp" %>

<div class="container">

    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-4">
            ${msg} 
            <div class="mt-5 card shadow-sm">

                <div class="card-body">
                    <h3 class="text-center txt-blue">Inscription</h3>

                    <form action="user", method="post">
                        
                        <input type="hidden" name="add" value="utilisateur">

                        <div data-mdb-input-init  class="form-outline mb-4 mt-5">
                            <input required type="text" id="nom" name="nom_user" class="form-control">
                            <label for="nom" class="form-label">Nom</label>
                        </div>
                        <div data-mdb-input-init class="form-outline mb-4">
                            <input required type="text" id="prenom" name="prenom_user" class="form-control">
                            <label for="prenom" class="form-label">Prénom</label>
                        </div>
                        <div data-mdb-input-init class="form-outline mb-4">
                            <input required type="text" id="login_user" name="login_user" class="form-control">
                            <label for="login_user" class="form-label">Login</label>
                        </div>
                        <div data-mdb-input-init  class="form-outline mb-4 mt-5">
                            <input required type="text" id="password_user" name="password_user" class="form-control">
                            <label for="password_user" class="form-label">Password</label>
                        </div>
                        <div class="form-outline mb-4">
                            <label class="form-label" for="selectRole">Sélectionnez un statut</label>
                            <select class="form-select" id="selectRole" name="role_user">
                                <option value="1">Apprenant</option>
                                <option value="2">Formateur</option>
                                <option value="3">Administrateur</option>
                            </select>
                        </div>

                        <button type="submit" class="btn btn-primary btn-block">Ajouter</button>

                    </form>

                    <p class="text-center text-danger"> ${msg1} </p>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../footer.jsp" %>
