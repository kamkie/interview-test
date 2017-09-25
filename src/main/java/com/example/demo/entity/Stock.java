package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class Stock {

	@Id
	@GeneratedValue
	private Long id;
	@OneToOne
	@JsonBackReference
	private Product product;
	private Long qty;
}
