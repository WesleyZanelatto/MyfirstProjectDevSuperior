package com.devsuperior.myfirstproject.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.devsuperior.myfirstproject.entities.Product;

@Component /*Esta anotação faz com que o bean registrado no Spring possa ser utilizado em qualquer bean, seja ele um serviço, um DAO, 
			 um controller, etc. No noso caso vai ser possivel fazer uma Injeção de dependencia dessa classe em qualquer outro lugar,
			 como esta feito na Classe ProductResource*/
public class ProductRepository {

	private Map<Long, Product> map = new HashMap<>();
	
	public void save(Product obj) {//Salva uma categoria
		map.put(obj.getId(), obj);
	}

	public Product findById(Long id) {//Retorna a Categoria do id correspondente/inserido/informado
		return map.get(id);
	}
	
	public List<Product> findAll() {//Retorna todas as categorias do BD
		return new ArrayList<Product> (map.values());
	}
}