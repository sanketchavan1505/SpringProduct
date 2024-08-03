package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bean.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
	
	public Product getByPidAndPrice(int pid,double price);
	
	public List<Product> findByPriceIsNotNull();
	
	@Query("select u from Product u where pname like ?1")
	public Product getProduct(String name);

}
