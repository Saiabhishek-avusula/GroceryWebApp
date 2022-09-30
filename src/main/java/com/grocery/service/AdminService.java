package com.grocery.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.grocery.dao.AdminDao;
import com.grocery.dao.CategoryDao;
import com.grocery.dao.ProductDao;
import com.grocery.model.Admin;
import com.grocery.model.Category;
import com.grocery.model.Product;

@Service
public class AdminService {
	@Autowired
	private AdminDao ad;
	@Autowired
	private CategoryDao cd;
	@Autowired
	private ProductDao pd;

	public boolean adminLogin(String user, String pass) {

		Admin admin = ad.findByAdminUsername(user);
		if (user.equals(admin.getAdminUsername()) && pass.equals(admin.getAdminPass())) {
			return true;

		}
		return false;
	}

	public Admin viewAdmin(String user) {
		// TODO Auto-generated method stub
		return ad.findByAdminUsername(user);
	}

	public Admin updateAdmin(Admin a) {
		// TODO Auto-generated method stub
		return ad.save(a);
	}
	

	public boolean adminAddProd(Product product, int categoryId,MultipartFile multipartFile) { 
	   
		
		String fileName=multipartFile.getOriginalFilename();
		String filePath=null;
		System.out.println(fileName);
		if(fileName.contains("..")) 
		{
//					throw new fileNameException()
		}
		else {
			Category category=cd.findById(categoryId).orElse(null);
			
			filePath="http://localhost:8080/images/"+category.getCategoryTitle()+"/"+fileName;
			System.out.println(filePath);
			System.out.println();
			product.setpPhoto(filePath);
			product.setCategory(category);
			pd.save(product);
		
		}
		
		return true;
	

		// pic uploading to server

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
			directoryPath=s+"/src/main/resources/static/images/"+category.getCategoryTitle();
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
}
	
	
	
	
	
	
	
	
	
	/*
	 * public void saveProduct(String name, double basePrice, int category, String
	 * description, double discount, double gst, MultipartFile multipartFile, int
	 * returnPeriod, int stock) { // TODO Auto-generated method stub
	 * product.setpName(name); product.setpPrice(basePrice);
	 * product.setCategory(category); product.setDescription(description);
	 * product.setpDiscount(discount); product.setReturnPeriod(returnPeriod);
	 * product.setStock(stock); product.setUpdatedTime(LocalDateTime.now());
	 * 
	 * String fileName=multipartFile.getOriginalFilename(); String filePath=null;
	 * System.out.println(fileName); if(fileName.contains("..")) { // throw new
	 * fileNameException() } else { Category
	 * categoryObject=categoryDaoObject.findById(category).orElse(null);
	 * RootCategory
	 * rootCategoryObject=rootCategoryDaoObject.findById(categoryObject.
	 * getRootCategoryId()).orElse(null);
	 * 
	 * filePath="../../images/"+rootCategoryObject.getName()+"/"+categoryObject.
	 * getName()+"/"+fileName; System.out.println(filePath); System.out.println();
	 * product.setImage(filePath); productDaoObject.save(product);
	 * 
	 * }
	 * 
	 * 
	 * }
	 * 
	 * public void saveImage(int category, MultipartFile multipartFile) { // TODO
	 * Auto-generated method stub String
	 * fileName=multipartFile.getOriginalFilename(); System.out.println(fileName);
	 * String directoryPath=null; if(fileName.contains("..")) { // throw new
	 * fileNameException() } else { Category
	 * categoryObject=categoryDaoObject.findById(category).orElse(null);
	 * RootCategory
	 * rootCategoryObject=rootCategoryDaoObject.findById(categoryObject.
	 * getRootCategoryId()).orElse(null); Path currentRelativePath = Paths.get("");
	 * Path s = currentRelativePath.toAbsolutePath(); System.out.println(s);
	 * directoryPath=s+"/src/main/resources/static/images/"+rootCategoryObject.
	 * getName()+"/"+categoryObject.getName(); System.out.println(directoryPath);
	 * Path path=Paths.get(directoryPath); File file=new File(directoryPath);
	 * if(!file.exists()) { try { file.createNewFile(); System.out.println(file); }
	 * catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } try(InputStream
	 * inputStream=multipartFile.getInputStream()){ Path
	 * filePath=path.resolve(fileName); System.out.println(filePath);
	 * Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING); }
	 * catch (IOException ioe) { // throw new
	 * IOException("Could not save image file: " + fileName, ioe);
	 * ioe.printStackTrace(); }
	 * 
	 * } }
	 * 
	 * }
	 */
/*
 * p.setpPhoto(); // get Category by ID
 * 
 * 
 * Category category=cd.findById(categoryId).get(); p.setCategory(category);
 */
 

