<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>

	<h1>Add New Student</h1>
	<form action="SaveServlet" method="post">
		<table>

			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><select name="country" style="width: 150px">
						<option>Bangladesh</option>
						<option>India</option>
						<option>UK</option>
						<option>Other</option>
				</select></td>
			</tr>

			<tr>
				<td><input type="submit" value="Save Student" /></td>
			</tr>

		</table>
	</form>

	<br />
	<a href="ViewServlet">view employees</a>

</body>
</html>