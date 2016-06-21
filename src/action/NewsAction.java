package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Category;
import bean.Products;
import bo.CatBO;
import bo.NewsBO;

/**
 * Servlet implementation class NewsAction
 */
public class NewsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final int NUMBER_NEWS_PER_PAGE = 5;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsAction() {
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
		
		//get list cat
		CatBO catBO = new CatBO();
		ArrayList<Category> listCat = catBO.getListCat();
		request.setAttribute("listCat", listCat);
		
		//get list News
		String trang = request.getParameter("trang");
		int p=0;
		int offset; // LIMIT offset, NUMBER_NEWS_PER_PAGE 
		int totalPage = 0;//số trang
		if(trang != null){
			p = Integer.parseInt(trang);
			offset = (p-1) * NUMBER_NEWS_PER_PAGE;
		} else {
			offset = 0;
			p=1;
		}
		int sotin = NewsBO.countAllNews();
		totalPage = (int) Math.ceil((float)sotin/NUMBER_NEWS_PER_PAGE);
		request.setAttribute("totalPage", totalPage);
		
		request.setAttribute("p", p);
		
		NewsBO newsBO = new NewsBO();
		ArrayList<Products> listNews = newsBO.getListNewsPerPage(offset, NUMBER_NEWS_PER_PAGE);
		request.setAttribute("listNews", listNews);
		
		RequestDispatcher rd = request.getRequestDispatcher("listAllNewa.jsp");
		rd.forward(request, response);
	}

}
