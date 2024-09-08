<%-- 
    Document   : index
    Created on : 29 mai 2024, 14:04:31
    Author     : kingafolabi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <title>Notre application de gestion de présence</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <!-- Font Awesome -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet" />
  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet" />
  <!-- MDB -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.0/mdb.min.css" rel="stylesheet" />

  <link rel="stylesheet" href="CSS/style.css" />

</head>

<body style="background-color: #f8f9fa;">
  <h1 class="text-center txt-red mt-5">Projet PRIMO JAVA</h1>

  <div class="container">
   
    <div class="row justify-content-center">

      <div class="col-md-6 col-lg-4 ">

        <div class="mt-5 card shadow-sm">

          <div class="card-body">
            <h3 class="text-center txt-blue">Connexion</h3>

            <form action="login", method="post">
                
              <div data-mdb-input-init  class="form-outline mb-4 mt-5">
                  <input required type="text" id="login" name="login" class="form-control">
                <label for="login" class="form-label">Login</label>
              </div>
              <div data-mdb-input-init class="form-outline mb-4">
                <input required type="password" id="password" name="password" class="form-control">
                <label for="password" class="form-label">Password</label>
              </div>
              <button type="submit" class="btn btn-primary btn-block">connexion</button>
            
            </form>
            <p class="text-center text-danger"> ${msg} </p>
          </div>
        </div>
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
