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
import bean.IsProduct;
import bean.Products;
import bo.CatBO;
import bo.IsProductBO;
import bo.ProductBO;

/**
 * Servlet implementation class viewListByID
 */
public class viewListByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewListByID() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		CatBO catBO = new CatBO();
		ProductBO productBO = new ProductBO();
		IsProductBO isProductBO = new IsProductBO();
		ArrayList<Category> listCat = catBO.getListCat();
		ArrayList<IsProduct> listIsProduct = isProductBO.getListIsProduct();
		
		String idCat = request.getParameter("cat");
		ArrayList<Products> listProduct = productBO.getListNewsById(idCat);		
		request.setAttribute("listCat", listCat);
		request.setAttribute("listProduct", listProduct);
		request.setAttribute("listIsProduct", listIsProduct);
		RequestDispatcher rd = request.getRequestDispatcher("view_list_product_by_id.jsp");
		rd.forward(request, response);
	}

}
