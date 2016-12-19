package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.dao.CocktailDao;
import fr.formation.dao.CocktailIngredientDao;
import fr.formation.dao.IngredientDao;
import fr.formation.entity.Cocktail;
import fr.formation.entity.CocktailIngredient;

@Service
public class CocktailService {

	@Autowired
	private CocktailDao dao;

	@Autowired
	private CocktailIngredientDao cocktailIngredientsDao;
	
	@Autowired
	private IngredientDao ingredientsDao;
	
	@Transactional
	public void addCocktailIngredient(final Integer cocktailId,
			final Integer ingredientId, final Integer quantityNum,
			final Integer quantityDen) {
		final CocktailIngredient cocktailIngredient = new CocktailIngredient();
		cocktailIngredient.setCocktail(this.dao.findOne(cocktailId));
		cocktailIngredient.setIngredient(this.ingredientsDao.findOne(ingredientId));
		cocktailIngredient.setQuantityNum(quantityNum);
		cocktailIngredient.setQuantityDen(quantityDen);

		this.cocktailIngredientsDao.save(cocktailIngredient);
	}
	
	public List<Cocktail> getAll() {
		return this.dao.findAll();
	}

	@Transactional
	public void create(final Cocktail cocktail) {
		this.dao.save(cocktail);
	}

	@Transactional
	public void update(final Cocktail cocktail) {
		this.dao.save(cocktail);
	}

	@Transactional
	public void delete(final Cocktail cocktail) {
		this.dao.delete(cocktail);
	}
	
	public List<CocktailIngredient> getCocktailIngredients() {
		return this.cocktailIngredientsDao.findAll();
	}
}
