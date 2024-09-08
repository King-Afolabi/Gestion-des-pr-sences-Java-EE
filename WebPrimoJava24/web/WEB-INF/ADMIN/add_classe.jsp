<%-- 
    Document   : add_classe
    Created on : 5 juin 2024, 16:35:09
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
                    <h3 class="text-center txt-blue">Créer une classe</h3>

                    <form action="user", method="post">

                        <input type="hidden" name="add" value="classe">

                        <div data-mdb-input-init  class="form-outline mb-4 mt-5">
                            <input required type="text" id="nom" name="nom_class" class="form-control">
                            <label for="nom" class="form-label">Nom classe</label>
                        </div>
                        <div data-mdb-input-init  class="form-outline mb-4 mt-5">
                            <input required type="text" id="niveau" name="niveau_class" class="form-control">
                            <label for="niveau" class="form-label">Niveau classe</label>
                        </div>
                        <div data-mdb-input-init class="form-outline mb-4">
                            <input required type="number" id="nombre" name="nbre_apprenant" class="form-control">
                            <label for="nombre" class="form-label">Nombre apprenant</label>
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