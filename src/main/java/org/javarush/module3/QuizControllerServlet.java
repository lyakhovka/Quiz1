package org.javarush.module3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value="/quiz")
public class QuizControllerServlet extends HttpServlet {
int correctAnswersAmount;
int incorrectAnswersAmount;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        List<Question> questions = QuestionsBase.getInstance().getQuestions();
        correctAnswersAmount = 0;
        incorrectAnswersAmount = 0;
        if(!questions.isEmpty()){
            session.setAttribute("currentQuestion", questions.get(0));
            session.setAttribute("currentQuestionIndex", 0);
            session.setAttribute("totalQuestions", questions.size());
            session.setAttribute("message", "");
            session.setAttribute("correctAnswersAmount",correctAnswersAmount);
            session.setAttribute("incorrectAnswersAmount",incorrectAnswersAmount);
            getServletContext().getRequestDispatcher("/quiz.jsp").forward(req, resp);
        }
        else{
            resp.getWriter().println("No questions found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        Question currentQuestion = (Question) session.getAttribute("currentQuestion");
        String userAnswerStr = req.getParameter("userAnswer");

        if(userAnswerStr != null && !userAnswerStr.isEmpty()){
            try{
                int userAnswer = Integer.parseInt(userAnswerStr);

                if (userAnswer == currentQuestion.getCorrectAnswer()){
                    session.setAttribute("message", "CORRECT!");
                    correctAnswersAmount = correctAnswersAmount+1;
                }
                else {
                    session.setAttribute("message", "INCORRECT.");
                    incorrectAnswersAmount = incorrectAnswersAmount+1;
                }
            }catch (NumberFormatException e){
                session.setAttribute("message", "Error parsing user answer");
            }
        }

        List<Question> questions = QuestionsBase.getInstance().getQuestions();
        int currentQuestionIndex = (Integer) session.getAttribute("currentQuestionIndex");

        if("true".equals(req.getParameter("restartButton"))) {
            restartQuiz(session);
            resp.sendRedirect("quiz.jsp");
            return;
        }
        session.setAttribute("currentQuestionIndex", currentQuestionIndex);
        session.setAttribute("totalQuestions", questions.size());

        if(currentQuestionIndex < questions.size()-1){
            Question nextQuestion = questions.get(currentQuestionIndex+1);
            session.setAttribute("currentQuestion", nextQuestion);
            session.setAttribute("currentQuestionIndex", currentQuestionIndex+1);
            session.setAttribute("correctAnswersAmount", correctAnswersAmount);
            session.setAttribute("incorrectAnswersAmount", incorrectAnswersAmount);
            resp.sendRedirect("quiz.jsp");
        }
        else{
            session.setAttribute("correctAnswersAmount", correctAnswersAmount);
            session.setAttribute("incorrectAnswersAmount", incorrectAnswersAmount);
            resp.sendRedirect("quizResult.jsp");
        }
    }

    private void restartQuiz(HttpSession session){
        session.removeAttribute("currentQuestion");
        session.removeAttribute("currentQuestionIndex");
        session.removeAttribute("message");
        session.removeAttribute("correctAnswersAmount");
        session.removeAttribute("incorrectAnswersAmount");

        List<Question> questions = QuestionsBase.getInstance().getQuestions();
        Question firstQuestion = questions.get(0);
        session.setAttribute("currentQuestion", firstQuestion);
        session.setAttribute("currentQuestionIndex", 0);
        correctAnswersAmount = 0;
        incorrectAnswersAmount = 0;
        session.setAttribute("correctAnswersAmount", correctAnswersAmount);
        session.setAttribute("incorrectAnswersAmount", incorrectAnswersAmount);

    }
}
