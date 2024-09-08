<%-- 
    Document   : list_presence
    Created on : 10 juin 2024, 16:56:26
    Author     : kingafolabi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.jsp" %>
<%@include file="navbar_formateur.jsp" %>

<div class="container mt-5">
    <h2 class="text-center mb-4">Créer une liste de présence</h2>

    <form action="formateur" method="post">
        <input type="hidden" name="added" value="create">
        <!-- Formulaire de sélection de date et heure -->
        <div class="row mb-2">
            <!-- Select box pour la liste des classes -->
            <div class="form-group mb-4 col">
                <label for="class">Classe</label>
                <select id="class" name="id_class" class="form-select" required>

                    <c:forEach items="${classes}" var="c">
                        <option value="${c.idClasse}">${c.nomClasse}</option>
                    </c:forEach>
                </select>
            </div>

            <!-- Select box pour la liste des cours -->
            <div class="form-group mb-4 col">
                <label for="course">Cours</label>
                <select id="course" name="id_cours" class="form-select" required>

                    <c:forEach items="${cours}" var="cr">
                        <option value="${cr.id_cours}">${cr.nom_cours}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col">
                <label for="date">Date</label>
                <input type="date" id="date" name="date_list" class="form-control" required>
            </div>
            <div class="col">
                <label for="time">Heure</label>
                <input type="time" id="time" name="time_list" class="form-control" required>
            </div>
        </div>
        <!-- <input type="hidden" name="action" value="list_presence">
    Bouton submit pour afficher la liste de présence -->
        <div class="text-center">
            <button type="submit" class="btn btn-primary mb-6">Afficher la Liste de Présence</button>
        </div>


    </form>
</div>


<%@include file="../footer.jsp" %>