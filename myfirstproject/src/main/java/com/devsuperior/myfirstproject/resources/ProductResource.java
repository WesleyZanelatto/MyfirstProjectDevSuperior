package com.devsuperior.myfirstproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.myfirstproject.entities.Product;
import com.devsuperior.myfirstproject.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired//Injeção de Dependencia já cria uma instancia/objeto de ProductRepository em ProductResource
	private ProductRepository productRepository;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {//findAll: Encontrar todos
		List<Product> list = productRepository.findAll();//Nesse momento vai ser quem acessa os dados ou memoria, buscando e retornando para nós
		return ResponseEntity.ok().body(list);
		
		
		
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {//@PathVariable: Vai reconhecer o /1 ou 2. que são os id
		Product obj = productRepository.findById(id).get();
		return ResponseEntity.ok().body(obj);
	}
	
	
}


