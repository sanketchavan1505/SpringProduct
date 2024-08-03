package com.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Product;
import com.dao.ProductDao;
import com.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
 @Autowired
 ProductDao pd;
 
	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return pd.findAll();
	}

	@Override
	public Product getById(int pid) {
		// TODO Auto-generated method stub
		return pd.findById(pid).orElse(null);
	}

	@Override
	public Product createProduct(Product p) {
		// TODO Auto-generated method stub
		return pd.save(p);
	}

	@Override
	public void editProduct(int pid, Product p) {
		// TODO Auto-generated method stub
		Optional<Product> p1=pd.findById(pid);
		
		if(p1.isPresent()) {
			Product p2=p1.get();
			
			p2.setPname(p.getPname());
			p2.setPrice(p.getPrice());
			
			pd.save(p2);
			
		}
		
	}

	@Override
	public void deleteByid(int pid) {
		// TODO Auto-generated method stub
		pd.deleteById(pid);
	}
	
	@Override
		public Product getByPidandPrice(int pid, double price) {
			// TODO Auto-generated method stub
		
		return pd.getByPidAndPrice(pid, price);
			
		}
	
	@Override
		public List<Product> findByPriceIsNotNull() {
			// TODO Auto-generated method stub
			return pd.findByPriceIsNotNull();
		}
	
	@Override
		public Product getProduct(String name) {
			// TODO Auto-generated method stub
			return pd.getProduct(name);
		}
}
