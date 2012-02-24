<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
  <title>Hello World</title>
</head>
<body>
  <h1>helloWorld from Controller</h1>
  
  <p>
  	${messageFromHelloWorld}
  </p>
</body>
</html>