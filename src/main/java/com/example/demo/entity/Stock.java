package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Stock {

	@Id
	@GeneratedValue
	private Long id;
	@OneToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Product product;
	private Long qty;
}
