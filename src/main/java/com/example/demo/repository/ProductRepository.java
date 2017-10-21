package com.example.demo.repository;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("select p.id as id, p.name as name, p.brand as brand, p.price * s.qty as value from Product p join p.stock s")
	List<ProductValue> calculateValueOfProducts();

	@Override
	@Query("select p from Product p " +
		"join fetch p.category c " +
		"join fetch p.stock " +
		"join fetch c.parent")
	List<Product> findAll();
}
