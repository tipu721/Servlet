<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Add Student</title>
</head>
<body>

<<form action="/register" method="post">

	Name:<input type="text" name="userName"/><br/><br/>
	Password:<input type="password" name="userPass"/><br/><br/>
	Email Id:<input type="text" name="userEmail"/><br/><br/>
	Country:
	<select name="userCountry">
		<option>India</option>
		<option>Pakistan</option>
		<option>other</option>
	</select>

	<br/><br/>
	<input type="submit" value="register"/>

</form>

</body>
</html>