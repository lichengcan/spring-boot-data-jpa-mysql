package com.bezkoder.spring.datajpa.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private Integer age;


}
