<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Gardening Quiz</title>
  <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class ="start-container">
<div class="statistics" id="correctness-amount">
  <h2>Your result is:</h2>
  <p class = "quiz-description">Correct answers: <%=session.getAttribute("correctAnswersAmount")%>. Incorrect answers: <%=session.getAttribute("incorrectAnswersAmount")%>
  </p>
</div>
<% Integer correctAnswersAmount = (Integer) session.getAttribute("correctAnswersAmount");
   Integer incorrectAnswersAmount = (Integer) session.getAttribute("incorrectAnswersAmount");

  if(correctAnswersAmount > incorrectAnswersAmount){
%>
<div class="card">
  <h2>Congratulations! You've got a green thumb!</h2>
</div>
<%
  } else {
%>
<div class="card">
  <h2>Pure your plants.</h2>
</div>
<%}%>
<div>
  <a class="button" href="index.jsp">Start page</a>
</div>
</div>
</body>
</html>