package group.ui;

import group.quiz.QuizService;
import group.quiz.VerbForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * Servlet gets on quiz/*
 */
@SuppressWarnings("serial")
public class QuizServlet extends HttpServlet {
    private QuizService quizService;

    private static VerbForm getVerbFormFromParameters(HttpServletRequest request, String parameterName, VerbForm defaultValue) {
        String verbFormString = request.getParameter(parameterName);
        VerbForm verbForm = null;
        if (verbFormString != null) {
            verbForm = VerbForm.valueOf(verbFormString.toUpperCase());
        }
        if (verbForm == null) {
            verbForm = defaultValue;
        }
        return verbForm;
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException {
        VerbForm quizVerbForm = getVerbFormFromParameters(request, "quizVerbForm", VerbForm.FIRST);

        response.getWriter().println(quizService.getVerb(quizVerbForm));

        response.setContentType("text/plain");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException,
            IOException {
        String quizVerb = null;
        if (request.getRequestURI().contains("/quiz/") &&
                request.getRequestURI().lastIndexOf("/quiz/") == 0) {
            quizVerb = request.getRequestURI().substring("/quiz/".length());
        }
        VerbForm quizVerbForm = getVerbFormFromParameters(request, "quizVerbForm", VerbForm.FIRST);
        String answerVerb = request.getParameter("answerVerb");
        VerbForm answerVerbForm = getVerbFormFromParameters(request, "answerVerbForm", VerbForm.SECOND);

        Objects.requireNonNull(quizVerb);
        Objects.requireNonNull(quizVerbForm);
        Objects.requireNonNull(answerVerb);
        Objects.requireNonNull(answerVerbForm);

        boolean check = quizService.checkVerb(quizVerb, quizVerbForm, answerVerb, answerVerbForm);
        response.setContentType("text/plain");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(check ? "YES" : "NO");
    }

    public void setQuizService(QuizService quizService) {
        this.quizService = quizService;
    }
}

