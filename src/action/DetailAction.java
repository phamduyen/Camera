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
import dao.ProductsDAO;

/**
 * Servlet implementation class DetailAction
 */
public class DetailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailAction() {
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
		
		int id_product = Integer.parseInt(request.getParameter("id_product"));
		//int idCat = Integer.parseInt(request.getParameter("idcat"));
		//get list cat
		CatBO catBO = new CatBO();
		ArrayList<Category> listCat = catBO.getListCat();
		request.setAttribute("listCat", listCat);
		
		NewsBO newsBO = new NewsBO();
		// get list news li�n quan
		//ArrayList<Products> listNewsLienQuan = newsBO.getListNewsLienQuanByIDCat(idCat, id_product);
		//request.setAttribute("listNewsLienQuan", listNewsLienQuan);
		//get News Detail
		Products productDetail = newsBO.getDetail(id_product);
		request.setAttribute("productDetail",productDetail );
		
		RequestDispatcher rd = request.getRequestDispatcher("details.jsp");
		rd.forward(request, response);
	}

}
