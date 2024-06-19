
<%@ page import="org.javarush.module3.Question" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gardening Quiz</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script type="text/javascript" src="scrypt.js"></script>
</head>
<body>
<div class="container">
    <div class="quiz-header">
        <h1>Gardening Quiz</h1>
    </div>

    <form id="quiz-form" action="/quiz" method="post">
        <div class="quiz-question">
        <% Question currentQuestion = (Question) session.getAttribute("currentQuestion");
            String questionText = currentQuestion.getQuestion();
            List<String> answers = currentQuestion.getAnswers();

            if(!questionText.equals("")){
        %>
            <div class="question-container">
                <p class="question-text"><%=questionText%></p>
            </div>
        <%
            }
        %>

        <div class="quiz-info"><p>Question ${sessionScope.currentQuestionIndex +1} out of ${sessionScope.totalQuestions}</p></div>
        </div>
        <div class="quiz-options">
            <% for(int i=0; i<answers.size(); i++){
            %>
                <div class="form-check">
                   <input class="form-check-input" type="radio" name="userAnswer" value=<%=i%> id="<%="option"+ i%>">
                   <label class="form-check-label" for="<%="option"+ i%>"><%=answers.get(i)%></label><br>
                </div>
            <%
            }
            %>
        </div>
        <div class="quiz-submit">
            <input type="submit" class="btn" id="submit-button" value="SubmitAnswer" onclick="return validateAnswer();"/>
        </div>
        <div>
            <div class="hidden-element" id="answer-alert">
                ${message}
            </div>
        </div>
    </form>

    <div class="quiz-restart">
        <button class="btn" onclick="restartGame();">Restart</button>
    </div>
</div>

</body>
</html>
