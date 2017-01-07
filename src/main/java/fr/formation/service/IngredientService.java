package fr.formation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import fr.formation.dao.IngredientDao;
import fr.formation.entity.CocktailIngredient;
import fr.formation.entity.Ingredient;

@Service
public class IngredientService {
	@Autowired
	private IngredientDao dao;

	public List<Ingredient> getAll() {
		return this.dao.findAll();
	}

	@Transactional
	public void create(final Ingredient ingredient) {
		this.dao.save(ingredient);
	}

	@Transactional
	public void update(final Ingredient ingredient) {
		this.dao.save(ingredient);
	}

	@Transactional
	public void delete(final Ingredient ingredient) {
		this.dao.delete(ingredient);
	}

	public Ingredient get(final Integer ingredientId) {
		return this.dao.findOne(ingredientId);
	}

	public List<Ingredient> getAllIngredientsLeft(
			final List<CocktailIngredient> cocktailIngredients) {
		List<Ingredient> results = null;
		if (CollectionUtils.isEmpty(cocktailIngredients)) {
			results = this.getAll();
		} else {
			final List<Integer> ingredientIds = cocktailIngredients.stream()
					.map(
							(final CocktailIngredient cocktailIngredient) -> cocktailIngredient
									.getIngredient().getId())
					.collect(Collectors.toList());
			results = this.dao.findAllByIdNotIn(ingredientIds);
		}
		return results;
	}

	public List<Ingredient> searchByName(final String search) {
		return this.dao.findAllByNameContains(search);
	}
}
