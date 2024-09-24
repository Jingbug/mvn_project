package www.aaa;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// login logic
		HttpSession session = req.getSession();
		User sUser = (User) session.getAttribute("user");
		
		if(sUser == null) {
			String id = req.getParameter("id");
			String role = req.getParameter("role");
			
			User user = new User();
			user.setId(id);
			user.setRole(role);
			session.setAttribute("user", user);
			
			resp.getWriter().println("login Successful");
		} else {
			resp.getWriter().println(sUser.getId() + "! please log out first");
		}
	}
}
