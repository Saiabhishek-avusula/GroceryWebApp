package com.grocery.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

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
	public void getSpecificProd(String cat, ModelMap m) {
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
			if(list.isEmpty()) {
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
	public boolean updateProduct(Product product,int categoryId,MultipartFile multipartFile) {
		// TODO Auto-generated method stub
		String fileName=multipartFile.getOriginalFilename();
		String filePath=null;
		System.out.println(fileName);
		if(fileName.contains("..")) 
		{
//					throw new fileNameException()
		}
		else {
			Category category=cd.findById(categoryId).orElse(null);
			
			filePath = "http://localhost:8080/images/" + fileName; /* +category.getCategoryTitle()+"/" */
			System.out.println(filePath);
			product.setpPhoto(filePath);
			product.setCategory(category);
			pd.save(product);
		}
		return true;
		
		}
		

	
	public void saveImage(int categoryId, MultipartFile multipartFile) {
		// TODO Auto-generated method stub
		String fileName=multipartFile.getOriginalFilename();
		System.out.println(fileName);
		String directoryPath=null;
		if(fileName.contains("..")) 
		{
//					throw new fileNameException()
		}
		else {
			Category category=cd.findById(categoryId).orElse(null);
			Path currentRelativePath = Paths.get("");
			Path s = currentRelativePath.toAbsolutePath();
			System.out.println(s);
			directoryPath = s + "/src/main/resources/static/images/"; /* +category.getCategoryTitle() */
			System.out.println(directoryPath);
			Path path=Paths.get(directoryPath);
			File file=new File(directoryPath);
			System.out.println(file);
			if(!file.exists()) {
				try {
					file.createNewFile();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try(InputStream inputStream=multipartFile.getInputStream()){
				Path filePath=path.resolve(fileName);
				System.out.println(filePath);
				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
			}
			catch (IOException ioe) {        
//	            throw new IOException("Could not save image file: " + fileName, ioe);
				ioe.printStackTrace();
	        } 
		}
	}
	
	public void getByPrice(Model m) { // TODO Auto-generated method stub
		  Iterable<Category> cat = cd.findAll(); 
		  Iterable<Product> prod =pd.findByOrderByPPrice(); 
		  m.addAttribute("category",cat);
		  m.addAttribute("product",prod);
		  
		  
		  }
		 

		public void getByProductName(Model m) {
			Iterable<Category> cat = cd.findAll();
			Iterable<Product> prod = pd.sortedPName();
			m.addAttribute("category",cat);
			m.addAttribute("product",prod); 
			
		}
	
		public Product updateProduct(int id,Product p) {
			// TODO Auto-generated method stub
			Category category=cd.findById(id).get();
			p.setCategory(category);
			return pd.save(p);
			
		}

	

}
