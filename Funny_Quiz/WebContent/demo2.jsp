<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

</body>
<!DOCTYPE html>
<html>
<body>

	<p>Looping through arrays inside arrays.</p>

	<p id="demo"></p>
	<%
		String x = "{\"name\":\"John\",\"age\":30,\"cars\": [{ \"name\":\"Ford\", \"models\":[ \"Fiesta\", \"Focus\", \"Mustang\" ] },{ \"name\":\"BMW\", \"models\":[ \"320\", \"X3\", \"X5\" ] },{ \"name\":\"Fiat\", \"models\":[ \"500\", \"Panda\" ] } ]}";
	%>
	<script>
		var myObj, i, j, x = "";
		myObj = <%=x%>

		for (i in myObj.cars) {
			x += "<h2>" + myObj.cars[i].name + "</h2>";
			for (j in myObj.cars[i].models) {
				x += myObj.cars[i].models[j] + "<br>";
			}
		}

		document.getElementById("demo").innerHTML = x;
	</script>

</body>
</html>
</html>