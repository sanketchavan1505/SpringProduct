package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Product;
import com.service.ProductService;

@RestController
@RequestMapping("/Products")
public class HelloController {

	@Autowired
	ProductService ps;

	public HelloController() {
		// TODO Auto-generated constructor stub
		System.out.println("Controller is called....");
	}

	@RequestMapping("/")
	public String getIndex() {
		return "index";
	}

	@PostMapping("/addProduct")
	public Product addProduct(@ModelAttribute Product p) {

		return ps.createProduct(p);

	}
	
	@GetMapping("/getById/{pid}")
	public Product getProduct(@PathVariable int pid) {
		return ps.getById(pid);
	}
	
	@GetMapping("/getAll")
	public List<Product> getAllProduct(){
		return ps.getAllProduct();
	}
	
	@PutMapping("/editProduct/{pid}")
	public String updateProduct(@PathVariable int pid,@ModelAttribute Product p) {
		ps.editProduct(pid, p);
		
		return "Product Updated successfully.....";
	}
	
	@DeleteMapping("/deleteById/{pid}")
	public String deleteProdut(@PathVariable int pid) {
		ps.deleteByid(pid);
		
		return "Delete by id ....";
	}
	
	@GetMapping("/get/{pid}/{price}")
	public Product getProductBypidandprice(@PathVariable int pid, @PathVariable double price) {
		return ps.getByPidandPrice(pid, price);
	}

	@GetMapping("/getProduct")
	public List<Product> getProductByNotNull() {
		return ps.findByPriceIsNotNull();
	} 
	
	@GetMapping("/getProducts/{pname}")
	public Product getProductLike(@PathVariable String pname) {
		return ps.getProduct(pname);
	} 
	
	
}
