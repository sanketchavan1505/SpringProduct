package com.service;

import java.util.List;

import com.bean.Product;

public interface ProductService {
	
	public List<Product> getAllProduct();
	
	public Product getById(int pid);
	
	public Product createProduct(Product p);
	
	public void editProduct(int pid,Product p);
	
	public void deleteByid(int pid);
	
	public Product getByPidandPrice(int pid,double price);
	
	public List<Product> findByPriceIsNotNull();
	
	public Product getProduct(String name);



}
