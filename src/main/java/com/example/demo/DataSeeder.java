package com.example.demo;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.entity.Stock;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataSeeder implements ApplicationRunner {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StockRepository stockRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Category rootCategory = addCategory(null, "root");
		Category category = addCategory(rootCategory, "category1");

		Product product = addProduct(category);

		Stock stock = addStock(product);
	}

	private Category addCategory(Category parent, String name) {
		Category category = new Category();
		category.setName(name);
		category.setParent(parent);
		return categoryRepository.save(category);
	}

	private Stock addStock(Product product) {
		Stock stock = new Stock();
		stock.setProduct(product);
		stock.setQty(100L);
		return stockRepository.save(stock);
	}

	private Product addProduct(Category category) {
		Product product = new Product();
		product.setBrand("brand1");
		product.setName("name1");
		product.setPrice(BigDecimal.valueOf(130));
		product.setCategory(category);
		return productRepository.save(product);
	}
}
