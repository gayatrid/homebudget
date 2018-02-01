 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>Budget</title>

         <!-- Bootstrap CSS CDN -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- Our Custom CSS -->
        <link rel="stylesheet"  href="<%=request.getContextPath() %>/resources/core/css/style.css">
       <!--  <link rel="stylesheet" href="style.css">-->
    </head>
    <body>



        <div class="wrapper">
            <!-- Sidebar Holder -->
            <nav id="sidebar">
                <div class="sidebar-header">
                    <h5>Its not your salary That makes you reach,Its your spending Habit</h5>
                </div>

                <ul class="list-unstyled components">
                    <p>Activity</p>
					 <li>
                        <a href="./getStarted"" target="contentopen">View/Add</a>
						<!-- <a href="#">Add</a> -->
                    </li>
                    <li class="active">

					 
                        <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false">Upload</a>
                        <ul class="collapse list-unstyled" id="homeSubmenu">
                            <li><a href="./uploadFileData" target="contentopen">Upload File Data</a></li>
                        </ul>
                    </li>
                   <li>
                        <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false">Graphic</a>
                        <ul class="collapse list-unstyled" id="pageSubmenu">
                            <li><a href="./openGraphicsPage" target="contentopen">Income/Expenses</a></li>
                            <!-- <li><a href="./openGraphicsPage" target="contentopen"></a></li>
                            <li><a href="#">Page 3</a></li> -->
                        </ul>
                    </li>
                  
                </ul>

               
            </nav>

            <!-- Page Content Holder -->
            <div id="content">

               <!--  <nav class="navbar navbar-default">
                    <div class="container-fluid">

                        <div class="navbar-header">
                            <button type="button" id="sidebarCollapse" class="btn btn-info navbar-btn">
                                <i class="glyphicon glyphicon-align-left"></i>
                                <span>Toggle Sidebar</span>
                            </button>
                        </div>

                    </div>
                </nav> -->
                
 <div id="contentopen" ><iframe name="contentopen" src="./getStarted"  style="width: 1000px;	height: 550px;"></iframe></div>

             
                
        
            </div>
        </div>





        <!-- jQuery CDN -->
         <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
         <!-- Bootstrap Js CDN -->
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

         <script type="text/javascript">
             $(document).ready(function () {
                 $('#sidebarCollapse').on('click', function () {
                     $('#sidebar').toggleClass('active');
                 });
             });
         </script>
    </body>
</html>



<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
a:link, a:visited {
    background-color: #f44336;
    color: white;
    padding: 14px 25px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    border-radius: 10px;
}


a:hover, a:active {
    background-color:  #1a1aff;
}
</style>
</head>
<body bgcolor="#F4F7FC"> <div align="center">
<img src="<%=request.getContextPath() %>/resources/imges/ssp.jpg"><br>
<a href="./getStarted" style="">Get Started</a>
</div>
</body>
</html --%>>