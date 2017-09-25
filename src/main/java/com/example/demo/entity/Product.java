package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	private String name;
	private String brand;
	private BigDecimal price;
	@JsonManagedReference
	@OneToOne(mappedBy = "product")
	private Stock stock;
}
