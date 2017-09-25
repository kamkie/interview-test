package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	private Category parent;
}
