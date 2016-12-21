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
	private CocktailIngredientDao cocktailIngredientDao;

	@Autowired
	private CocktailDao cocktailDao;

	@Autowired
	private IngredientDao ingredientDao;

	@Transactional
	public void addCocktailIngredient(final Integer cocktailId,
			final Integer ingredientId, final Integer quantityNum,
			final Integer quantityDen) {
		final CocktailIngredient cocktailIngredient = new CocktailIngredient();
		cocktailIngredient.setCocktail(this.cocktailDao.findOne(cocktailId));
		cocktailIngredient.setIngredient(this.ingredientDao.findOne(ingredientId));
		cocktailIngredient.setQuantityNum(quantityNum);
		cocktailIngredient.setQuantityDen(quantityDen);

		this.cocktailIngredientDao.save(cocktailIngredient);
	}

	public List<Cocktail> getAll() {
		return this.cocktailDao.findAll();
	}

	@Transactional
	public void create(final Cocktail cocktail) {
		this.cocktailDao.save(cocktail);
	}

	@Transactional
	public void update(final Cocktail cocktail) {
		this.cocktailDao.save(cocktail);
	}

	@Transactional
	public void delete(final Cocktail cocktail) {
		this.cocktailDao.delete(cocktail);
	}

	public Cocktail get(final Integer id) {
		return this.cocktailDao.findOne(id);
	}

	public List<CocktailIngredient> getCocktailIngredients(
			final Integer cocktailId) {
		return this.cocktailIngredientDao.findAllByCocktailId(cocktailId);
	}
}
