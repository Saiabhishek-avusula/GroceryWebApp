package com.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.grocery.dao.CategoryDao;
import com.grocery.dao.ProductDao;
import com.grocery.model.Category;
import com.grocery.model.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDao pd;
	@Autowired
	private CategoryDao cd;
	
	
	//getting the list of products and categories present in the database
	public void getAllProd(Model m) {
		// TODO Auto-generated method stub
		Iterable<Category> cat = cd.findAll();
		Iterable<Product> prod = pd.findAll();
		m.addAttribute("category",cat);
		m.addAttribute("product",prod); 
		
	}

    // to get specific catergory wise products
	public void getSpecificProd(String cat, Model m) {
		// TODO Auto-generated method stub
		Iterable<Category> cate = cd.findAll();
		List<Product> list=null;
		if(cat.equals("all")) {
			list=pd.findAll();
			m.addAttribute("product",list); 
			m.addAttribute("category",cate);
		}else {
			int num=0;
			int len=cat.length();
			for(int i=0;i<len;i++) {
				num=num * 10 + ((int)cat.charAt(i) -48);
			}
			System.out.println(num);
			list=pd.findAllById(num);
			if(list==null) {
				m.addAttribute("category",cate);
				m.addAttribute("message","Oops!!,No item Found under this Category");
			}
			m.addAttribute("product",list); 
			m.addAttribute("category",cate);
		}
		  
	}

    //to view all the products available in database
	public void viewallProduct(Model m) {
		// TODO Auto-generated method stub
		Iterable<Product> prod = pd.findAll();
		m.addAttribute("product",prod); 
	}
	
    //updating product details
	public Product updateProduct(Product p) {
		// TODO Auto-generated method stub
		return pd.save(p);
		
	}
	
	

	

}
