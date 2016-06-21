package bo;

import java.util.ArrayList;

import bean.Products;
import dao.ProductsDAO;

public class NewsBO {
	
	ProductsDAO newsDAO = new ProductsDAO();
	public ArrayList<Products> getListNews() {
		return newsDAO.getListNews();
	}
	public boolean addNews(Products news) {
		return newsDAO.addNews(news);
	}
	public Products getDetail(int idNews) {
		return newsDAO.getDetail(idNews);
	}
	public boolean editNews(Products product) {
		return newsDAO.edit(product);
	}
	public boolean delNews(int idNews) {
		return newsDAO.delNews(idNews);
	}
	public ArrayList<Products> getListNewsByIDCat(int idCat) {
		return newsDAO.getListByIDCat(idCat);
	}
	public ArrayList<Products> getListNewsLienQuanByIDCat(int idCat, int idNews) {
		return newsDAO.getListLienQuanByIDCat(idCat, idNews);
	}
	public ArrayList<Products> getListNewsPerPage(int offset, int numberNewsPerPage) {
		return newsDAO.getListPerPage(offset, numberNewsPerPage);
	}
	public static int countAllNews() {
		return ProductsDAO.countAll();
	}
	public ArrayList<Products> getListNewsByIDCatPerPage(int idCat, int offset, int numberNewsPerPage) {
		return ProductsDAO.getListByIDCatPerPage(idCat, offset, numberNewsPerPage);
	}
	public static int countAllNewsByIDCat(int idCat) {
		return ProductsDAO.countAllByIDCat(idCat);
	}

}
