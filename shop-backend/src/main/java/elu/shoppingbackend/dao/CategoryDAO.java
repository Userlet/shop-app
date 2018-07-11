package elu.shoppingbackend.dao;

import java.util.List;

import elu.shoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	
	Category get(int id);
}
