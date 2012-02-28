<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Simple PFM</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css" media="screen, projection" />
<style>
body {
	padding-top: 60px;
}
</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" type="text/css" media="screen, projection" />
</head>

<body>

    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="${pageContext.request.contextPath}/">Simple PFM</a>
          <div class="nav-collapse">
            <ul class="nav">
              <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
              <!--   <li><a href="#">Accounts</a></li>-->
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
	<div class="container">	
	