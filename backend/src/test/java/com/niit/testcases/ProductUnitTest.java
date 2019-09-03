package com.niit.testcases;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDao;
import com.niit.model.Product;

public class ProductUnitTest
{
@Autowired
	static ProductDao productDao;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    
	    context.scan("com.niit");
	    context.refresh();
	    
	    productDao=(ProductDao) context.getBean("productDao");
	}
	@Ignore
	@Test
	public void addProductTest()
	{
		Product  product=new Product();
		 product.setCategoryID(12);
		 product.setProDesc("toy");
		 product.setProId(123);
		 product.setProName("fasttrack");
		 product.setProprice(2500);
		 product.setStock(20);
		 product.setSupplierId(25);
		
		assertTrue("Problem in adding the  product", productDao.addProduct( product));
	}
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product  product= productDao.getProduct(65);
		
		assertTrue("Problem in deleting  product", productDao.deleteProduct( product));
	}
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product  product= productDao.getProduct(66);
		 product.setProDesc("Western Wear");
		
		assertTrue("Problem in updating  product", productDao.updateProduct( product));
	}

}

