package action;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;

import bean.Products;
import bean.User;
import bo.ProductBO;

/**
 * Servlet implementation class DelNewsAdminAction
 */
@WebServlet("/DelNewsAdminAction")
public class DelNewsAdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelNewsAdminAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		//kiểm tra đăng nhập
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		if(userLogin == null){
			response.sendRedirect(request.getContextPath()+"/admin/login");
			return;
		}
		
		ProductBO newsBO = new ProductBO();
		int idNews = Integer.parseInt(request.getParameter("idnews"));
		Products news = new Products();
		news = newsBO.getDetail(idNews);
		if(newsBO.delNews(idNews)){
//			File file = new File(news.getPicture());
//			file.delete();
			// chưa lấy đc đường dẫn của file
			RequestDispatcher rd = request.getRequestDispatcher("list-news");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("list-news?msg=Có lỗi trong quá trình xóa ");
			rd.forward(request, response);
		}
		
	}

}
