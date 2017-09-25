package com.example.demo.controller;

import com.example.demo.entity.ProductValue;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/productValue")
public class ProductValueController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public ResponseEntity<List<ProductValue>> valueOfProducts() {
		return ResponseEntity.ok(productRepository.calculateValueOfProducts());
	}
}
