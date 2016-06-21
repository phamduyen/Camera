package bo;

import java.util.ArrayList;

import bean.Products;
import dao.ProductsDAO;

public class ProductsBO {
	ProductsDAO productsDAO = new ProductsDAO();

	public ArrayList<Products> getListNews() {
		// TODO Auto-generated method stub
		return productsDAO.getListNews();
	}
	
}
