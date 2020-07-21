<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
		<link rel="stylesheet" type="text/css" href="Stylesheet.css">
<title>Music Locator Homepage</title>
</head>
<body>
	<form action="getmusicdetails">
		Choose Music File : <br><br>
		<input type="file" id="musicfile" name="musicfile" value="Browse">
		<input type="submit" name="stop" value="Stop Music" onclick="form.action='stopmusic';"><br><br>
		<input type="submit" name="findmusic" value="Display Details"><br><br>
	
	
	
		<table style="text-align: center;
	border-radius: 20px;
	padding: 10px;
	margin-left: 95px;">
				<tr>
					<th>Artist</th>
					<th>Title</th>
					<th>Album</th>
					<th>Released-Date</th>
					<th>Music-Label</th>
				</tr>
				
				<tr>
					<td>${Music.artist}</td>
					<td>${Music.title}</td>
					<td>${Music.album}</td>
					<td>${Music.release_date}</td>
					<td>${Music.label}</td>
				</tr>
				
		</table>
	
	</form>

</body>
</html>