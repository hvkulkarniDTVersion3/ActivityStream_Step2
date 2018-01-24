<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page session="false" isELIgnored="false"%>
<html>
<head>
<title>Activity Stream</title>


</head>
<body>

	<!-- create a form which will have textboxes for Sender Name and Message content along with a Send 
Submit button. Handle errors like empty fields -->

	<form action="sendMessage" method="post">
		SenderName<input type="text" name="sender" required /> <br />
		 Message<input
			type="text" name="message" required /> <input type="submit"
			value="submit">


		<!-- display all existing messages in a tabular structure with Sender Name, Posted Date and Message -->
		<table>
			<thead>
				<tr>
					<th>MessageId</th>
					<th>SenderName</th>
					<th>postedDate</th>
					<th>Message</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${messages}" var="msg">
					<tr>

						<td>${msg.messageId}</td>
						<td>${msg.senderName}</td>
						<td>${msg.postedDate}</td>
						<td>${msg.message}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>