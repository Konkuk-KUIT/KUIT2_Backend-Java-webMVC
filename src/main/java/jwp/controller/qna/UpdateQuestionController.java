package jwp.controller.qna;

import core.db.MemoryQuestionRepository;
import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.ModelAndView;
import core.mvc.view.View;
import jwp.model.Question;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Objects;

public class UpdateQuestionController extends AbstractController {
    private final MemoryQuestionRepository questionRepository = MemoryQuestionRepository.getInstance();
    HttpSession session;

    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        if (!UserSessionUtils.isLogined(session)) {
            return jspView("redirect:/users/loginForm");
        }

        String questionId = params.get("questionId");
        Question question = questionRepository.findByQuestionId(questionId);

        if (!question.isSameUser(Objects.requireNonNull(UserSessionUtils.getUserFromSession(session)))) {
            throw new IllegalArgumentException();
        }

        question.updateTitleAndContents(params.get("title"),params.get("contents"));
        questionRepository.update(question);

        return jspView("redirect:/");
    }

    @Override
    public void setSession(HttpSession session) {
        this.session = session;
    }
}
