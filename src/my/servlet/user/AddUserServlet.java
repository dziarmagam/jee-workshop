package my.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.DbUtil;
import my.dao.user.UserDao;
import my.entity.User;
import my.entity.UserGroup;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet{

	private final UserDao userDao;
	
	public AddUserServlet() {
		this.userDao = DbUtil.getUserDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/jsp/user/addUser.jsp")
		.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username =  req.getParameter("username");
		String password =  req.getParameter("password");
		String email =  req.getParameter("email");
		String group_id = req.getParameter("group_id");
		int id = Integer.parseInt(group_id);
		
		User user = 
				new User(null, username, password, email,
						new UserGroup(id, null, null));
		userDao.addUser(user);
		resp.sendRedirect("/jee-workshop/users");
	}
}
