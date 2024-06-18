
<%@ page import="org.javarush.module3.Question" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
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
        %>
            <c:if test="${not empty questionText}">
                <div class="question-container">
                    <p class="question-text"><%=questionText%></p>
                </div>
            </c:if>
            <div class="quiz-info"><p>org.javarush.module3.Question ${sessionScope.currentQuestionIndex +1} out of ${sessionScope.totalQuestions}</p></div>
        </div>
        <div class="quiz-options">
            <div class="form-check">
                <input class="form-check-input" type="radio" name="userAnswer" value="1" id="option1">
                <label class="form-check-label" for="option1">${currentQuestion.getAnswerOption1()}</label><br>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="userAnswer" value="2" id="option2">
                <label class="form-check-label" for="option2">${currentQuestion.getAnswerOption2()}</label><br>
            </div>
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
