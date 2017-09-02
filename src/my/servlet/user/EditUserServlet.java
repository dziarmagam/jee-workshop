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

@WebServlet("/users/*")
public class EditUserServlet extends HttpServlet {

	private final UserDao userDao;
	

	public EditUserServlet() {
		this.userDao = DbUtil.getUserDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		int userId = getUserIdFromPath(pathInfo);
		User user = userDao.findById(userId);
		req.setAttribute("user", user);
		getServletContext().getRequestDispatcher("/jsp/user/editUser.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username =  req.getParameter("username");
		String password =  req.getParameter("password");
		String email =  req.getParameter("email");
		String groupIdString = req.getParameter("group_id");
		int id = Integer.parseInt(req.getParameter("id")); 
		int groupId = Integer.parseInt(groupIdString);
		
		User user = 
				new User(id, username, password, email,
						new UserGroup(groupId, null, null));
		userDao.updateUser(user);
		resp.sendRedirect("/jee-workshop/users");
	}
	
	private int getUserIdFromPath(String path) {
		String[] split = path.split("/");
		return Integer.parseInt(split[split.length -1]);
	}

}
