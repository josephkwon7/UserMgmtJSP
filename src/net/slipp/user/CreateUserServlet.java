package net.slipp.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import net.slipp.support.MyValidatorFactory;

@WebServlet("/users/create")
public class CreateUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 4자 이상, 12자 이하, 영문자/숫자만 허용
		String userId = request.getParameter("userId");
		if (userId == null || userId.equals("")) {
		    // 에러 처리
		}
		
		int lengthOfUserId = userId.length();
		if (lengthOfUserId < 4 && lengthOfUserId > 12) {
		    // 에러처리 
		}
		
		String regexp = "[A-Za-z0-9](4, 12)";
		
		String password = request.getParameter("password");
		// 2자 이상, 10자 이하.
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		User user = new User(userId, password, name, email);
		Validator validator = MyValidatorFactory.createValidator();
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
        if (constraintViolations.size() > 0) {
            request.setAttribute("user", user);
            String errorMessage = constraintViolations.iterator().next().getMessage();
            forwardJSP(request, response, errorMessage);
            return;
        }
		
		UserDAO userDAO = new UserDAO();
		try {
            userDAO.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

		response.sendRedirect("/");
	}
	
    private void forwardJSP(HttpServletRequest request, HttpServletResponse response, String errorMesssage)
            throws ServletException, IOException {
        request.setAttribute("errorMessage", errorMesssage);
        RequestDispatcher rd = request.getRequestDispatcher("/form.jsp");
        rd.forward(request, response);
    }
}
