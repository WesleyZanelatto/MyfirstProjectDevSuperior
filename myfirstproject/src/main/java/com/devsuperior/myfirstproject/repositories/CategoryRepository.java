package com.devsuperior.myfirstproject.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.devsuperior.myfirstproject.entities.Category;

@Component /*Esta anotação faz com que o bean registrado no Spring possa ser utilizado em qualquer bean, seja ele um serviço, um DAO, 
			 um controller, etc. No noso caso vai ser possivel fazer uma Injeção de dependencia dessa classe em qualquer outro lugar,
			 como esta feito na Classe CategoryResource*/
public class CategoryRepository {

	private Map<Long, Category> map = new HashMap<>();
	
	public void save(Category obj) {//Salva uma categoria
		map.put(obj.getId(), obj);
	}

	public Category findById(Long id) {//Retorna a Categoria do id correspondente/inserido/informado
		return map.get(id);
	}
	
	public List<Category> findAll() {//Retorna todas as categorias do BD
		return new ArrayList<Category> (map.values());
	}
}