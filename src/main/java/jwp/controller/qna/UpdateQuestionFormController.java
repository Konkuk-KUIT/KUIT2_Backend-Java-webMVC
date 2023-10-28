package jwp.controller.qna;

import core.db.MemoryQuestionRepository;
import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.View;
import jwp.model.Question;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class UpdateQuestionFormController implements Controller {
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();

    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        if (!UserSessionUtils.isLogined(session)) {
            return new JspView("redirect:/users/loginForm") ;
        }

        String questionId = req.getParameter("questionId");
        Question question = questionRepository.findByQuestionId(questionId);

        if (!question.isSameUser(Objects.requireNonNull(UserSessionUtils.getUserFromSession(session)))) {
            return new JspView("/qna/show?questionId=" + questionId);
        }
        req.setAttribute("question", question);
        return new JspView("/qna/updateForm.jsp");
    }
}
