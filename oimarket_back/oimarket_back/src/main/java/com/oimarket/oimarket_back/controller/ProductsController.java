package com.oimarket.oimarket_back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oimarket.oimarket_back.exception.ResourceNotFoundException;
import com.oimarket.oimarket_back.model.Products;
import com.oimarket.oimarket_back.repository.ProductsRepository;

@RestController
@RequestMapping("/products")
public class ProductsController {
	@Autowired
	private ProductsRepository productsRepository;

	// 전체 게시물 가져오기
	@GetMapping
	public List<Products> getAllProducts() {
		System.out.println("taerdsfasdf ");
		return productsRepository.findAll();
	}

	// id 를 사용하여 게시글 불러오기
	@GetMapping("/{id}")
	public Products getProductById(@PathVariable(value = "id") long id) {
		return productsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
	}

	// 게시물 생성
	@PostMapping
	public Products createProduct( Products products) {

		System.out.println("게시물 만들기");
		return this.productsRepository.save(products);
	}

	// 게시물 id를 사용하여 정보수정
	@PutMapping("/{id}")
	public Products updateProduct(Products products, @PathVariable("id") long id) {
		Products productid = this.productsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
		productid.setTitle(products.getTitle());
		productid.setMem_id(products.getMem_id());
		productid.setCount(products.getCount());
		productid.setCategory(products.getCategory());
		productid.setStatus(products.getStatus());
		productid.setProduct_img(products.getProduct_img());
		productid.setLocal(products.getLocal());
		productid.setCreated_at(products.getCreated_at());
		productid.setUpdated_at(products.getUpdated_at());
		return this.productsRepository.save(productid);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Products> deleteProduct(@PathVariable("id") long id) {
		Products productid = this.productsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
		this.productsRepository.delete(productid);
		return ResponseEntity.ok().build();
	}

}
