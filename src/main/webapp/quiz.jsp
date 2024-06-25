
<%@ page import="org.javarush.module3.Question" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gardening Quiz</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script type="text/javascript" src="script.js"></script>
</head>
<body>
<div class="container">
    <div class="quiz-header">
        <h2 class="quiz-header">Gardening Quiz</h2>
    </div>

    <form id="quiz-form" action="/quiz" method="post">
        <div class="quiz-description">
            <p class="quiz-description">Question <%=(Integer)session.getAttribute("currentQuestionIndex") +1 %> out of <%=session.getAttribute("totalQuestions")%>
            </p>
        </div>
        <div class="answer-alert-class" id="answer-alert">
            <%=session.getAttribute("message")%>
        </div>
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

        <div class="quiz-options-container">
            <% for(int i=0; i<answers.size(); i++){
            %>
                <div class="quiz-options">
                   <input class="form-check-input" type="radio" name="userAnswer" value=<%=i%> id="<%="option"+ i%>">
                   <label class="form-check-label" for="<%="option"+ i%>"><%=answers.get(i)%></label><br>
                </div>
            <%
            }
            %>
        </div>
        <div class="submit-button">
            <input type="submit" class="btn" id="submit-button" value="SUBMIT ANSWER" onclick="return validateAnswer()"/>
        </div>
        <div class="statistics">
            <div id="correctness-amount">
                <p>Correct answers: <%=session.getAttribute("correctAnswersAmount")%>. Incorrect answers: <%=session.getAttribute("incorrectAnswersAmount")%>
                </p>
            </div>
        </div>
    </form>

    <div class="quiz-restart">
        <button class="btn" onclick="restartGame();">RESTART</button>
    </div>
</div>

</body>
</html>
