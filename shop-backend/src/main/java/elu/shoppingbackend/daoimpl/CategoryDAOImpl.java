package elu.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import elu.shoppingbackend.dao.CategoryDAO;
import elu.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {

		Category category = new Category();

		// adding categories 1
		category.setId(1);
		category.setName("Television");
		category.setDescription("The description os the television category");
		category.setImageURL("TV_category.png");

		categories.add(category);

		// adding categories 2
		Category category1 = new Category();
		category1.setId(2);
		category1.setName("Telephone");
		category1.setDescription("The description os the telephone category");
		category1.setImageURL("TL_category.png");

		categories.add(category1);

		// adding categories 3
		Category category2 = new Category();
		category2.setId(3);
		category2.setName("Laptop");
		category2.setDescription("The description os the Laptop category");
		category2.setImageURL("LPT_category.png");

		categories.add(category2);

	}

	@Override
	public List<Category> list() {

		return categories;
	}

	@Override
	public Category get(int id) {
		// enhanced for loop
		for(Category category : categories) {
			if (category.getId()== id) return category;
		}
		return null;
	}

}
