package my.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.DbUtil;
import my.dao.user.UserDao;
import my.entity.User;

@WebServlet("/users")
public class UserListServlet extends HttpServlet {
	
	private final UserDao userDao;
	
	public UserListServlet() {
		this.userDao = DbUtil.getUserDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = userDao.loadAll();
		req.setAttribute("users", users);
		getServletContext().getRequestDispatcher("/jsp/user/users.jsp")
		.forward(req, resp);
	}

}
