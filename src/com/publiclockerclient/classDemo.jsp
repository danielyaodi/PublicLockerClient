<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.publiclockerclient.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>client Demo</title>
<h2 align="center">Client Demo Page</h2>
</head>
<body>

	<form action="clientDemo.jsp" method="post">
		<table align="center" height="200">

			<tr>
				<td>This is simulate Locker Address Request:</td>
			</tr>


			<tr>
				<td>API Key:</td>
				<td><input type="text" name="apiKey" id="apiKey"
					style="width: 200px; height: 20px; font-size: 15px"></td>

			</tr>
			<tr>
				<td>Order Number:</td>
				<td><input type="text" name="orderNumber" id="orderNumber"
					style="width: 200px; height: 20px; font-size: 15px"></td>
				<td><input type="hidden" name="action" id="action"
					value="request"></td>
			</tr>
			<tr>
				<td>Package Length:</td>
				<td><input type="text" name="packageLength" id="packageLength"
					style="width: 200px; height: 20px; font-size: 15px"></td>

			</tr>


			<tr>
				<td>Package Width:</td>
				<td><input type="text" name="packageWidth" id="pakcageWideo"
					style="width: 200px; height: 20px; font-size: 15px"></td>

			</tr>

			<tr>
				<td>Package Height:</td>
				<td><input type="text" name="packageHeight" id="pockageHeightq"
					style="width: 200px; height: 20px; font-size: 15px"></td>

			</tr>
			<tr>
				<td>API Key:</td>
				<td><input type="text" name="apiKey" id="apiKey"
					style="width: 200px; height: 20px; font-size: 15px"></td>

			</tr>
			<tr>
				<td>API Key:</td>
				<td><input type="text" name="apiKey" id="apiKey"
					style="width: 200px; height: 20px; font-size: 15px"></td>

			</tr>
			<tr>
				<td><input type="reset" name="reset" id="reset"
					style="width: 100px; height: 40px; font-size: 18px"></td>

				<td align="right"><input type="submit" name="submit"
					value="request" id="submit"
					style="width: 100px; height: 40px; font-size: 18px"></td>

			</tr>
			<tr>
				<td><a
					href="http://127.0.0.1:8080/PublicLockerServer/clientReg.jsp">Not
						an user? Register here!</a></td>
			</tr>


		</table>


	</form>








	<%
		LockerAddressRequest(apiKey, orderNumber, packageLength, packageWidth, packageHeight, packageQty, zipcode);
	%>

</body>
</html>