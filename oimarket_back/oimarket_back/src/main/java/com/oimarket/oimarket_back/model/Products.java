package com.oimarket.oimarket_back.model;


import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "products")
public class Products {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	private String mem_id;
	private int count;
	private String category;
	private int status;
	private String product_img;
	private String local;
	private String detail;
	private Date created_at;
	private Date updated_at;
	public Products(){
		
	}
	public Products(long id, String title, String mem_id, int count, String category, int status, String product_img,
			String local, String detail, Date created_at, Date updated_at) {
		super();
		this.id = id;
		this.title = title;
		this.mem_id = mem_id;
		this.count = count;
		this.category = category;
		this.status = status;
		this.product_img = product_img;
		this.local = local;
		this.detail = detail;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	

	
	
}
