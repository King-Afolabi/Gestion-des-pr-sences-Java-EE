<%-- 
    Document   : Home
    Created on : 29 mai 2024, 15:22:54
    Author     : kingafolabi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notre application de gestion de présence</title>
        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet" />
        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet" />
        <!-- MDB -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.0/mdb.min.css" rel="stylesheet" />

        <link rel="stylesheet" href="CSS/style.css" />

    </head>
    <body>
        
        
        
        
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h1 class="text-info">Hello ${user.prenom_user} ${user.nom_user}</h1>
                </div>
                <div class="col-md-6 mt-2" >
                    <a href="deco"> 
                        <i class="fas fa-power-off" style="color: tomato; font-size: x-large;"></i>
                    </a>
                </div>

            </div>
        </div>




        <!-- MDB -->
        <script
            type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.0/mdb.umd.min.js"
        ></script>
    </body>
</html>
