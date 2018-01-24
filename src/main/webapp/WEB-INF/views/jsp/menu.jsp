<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en" ng-app="myapp">
<head>
<title>Release Details</title>
<script src="https://code.angularjs.org/1.3.0-beta.5/angular.js"></script>
<script src="<%=request.getContextPath() %>/resources/core/js/menu.js"></script>
</head>
<body>
<div ng-app="sideBar" ng-controller="MainCtrl">
    
<nav class="navbar navbar-default NOnavbar-fixed-top" style="border-color:black; background-color: black;margin-left: -2px;height: 70px;" >
  <div class="container-fluid">
    <div class="navbar-header">

      <button type="button" class="navbar-toggle collapsed menu-toggle" id="menu-toggle" href="#menu">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="NOnavbar-brand" href="#/home">
        <p class="logo">Sistema</p>
      </a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

      <span class="glyphicon glyphicon-share hidden-xs pull-right share-link" aria-hidden="true" ng-click="sair()"></span>
    </div>
  </div>
</nav>

<div id="wrapper">
  <div id="sidebar-wrapper" >
    <ul class="sidebar-nav">
      <div class="user-panel">
        <div class="pull-left image">
          <img ng-src="http://icons.iconarchive.com/icons/double-j-design/origami-colored-pencil/256/blue-user-icon.png" class="img-arredondadaSide" alt="User Image"></img>
        </div>
        <div class="pull-left info">
        </br>
        <p style="color: rgb(105, 183, 105)">Bem Vindo, Diego</p>
        <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
      </div>
    </div>
    <hr class="colorgraph">
    <li>
      <a href="#/home">
        <i class="fa fa-home"></i> <span>Inicio</span>
      </a>
    </li>
    <li>
      <a href="#/cadastroCliente">
        <i class="fa fa-medkit"></i> <span>Cadastro Cliente</span>
      </a>
    </li>

    <li>
      <a href="#/chat">
        <i class="fa fa-commenting"></i><span>Chat</span>
      </a>
    </li>
    <li class"dropdown">
      <a class="dropdown-toggle" data-toggle="collapse" data-target="#configuracoes" role="button"
      aria-haspopup="true" aria-expanded="false"><i class="fa fa-cog"></i> Configura��es <span class="caret">
      </span></a>
      <ul id="configuracoes" class="collapse">
        <li>
          <a href="#/home/usuarios"><i class="fa fa-users"></i>
            Usu�rios</a>
          </li>
        </ul>
      </li>
    </ul>
  </div>
  <!-- /#sidebar-wrapper -->
  <!-- Page Content -->
  <div id="page-content-wrapper">
    <div class="container-fluid">
      <div class="row">
        <div class="col-lg-12">
          <div id="wrapper">
              <!-- Carrega todas as p�ginas-->
            <div ui-view="main"></div>

          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- /#page-content-wrapper -->
</div>
     <script type="text/javascript">
  $(document).ready ( function () {
    $(document).on("click", "#menu-toggle", function (e) {
      e.preventDefault();
      $("#wrapper").toggleClass("toggled");
    });
  });
  </script>
</div>
</body>
</html>