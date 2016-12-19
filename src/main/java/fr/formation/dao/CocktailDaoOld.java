package fr.formation.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import fr.formation.entity.Cocktail;

@Component
public class CocktailDaoOld {

	public List<Cocktail> readAll() {
		return Arrays.asList(
				new Cocktail(null,
						"Ti-Punch'", 4.5, true),
//						Arrays.asList(
//								new IngredientProportion(new Ingredient("Rhum", 0),
//										2,3),
//								new IngredientProportion(new Ingredient("Cane sugar syrup", 0),
//										1, 6),
//								new IngredientProportion(new Ingredient("Lime juice", 0),
//										1, 6))),
				new Cocktail(null,
						"Mojito'", 4.5, true));
//						Arrays.asList(
//								new IngredientProportion(new Ingredient("Rhum", 0),
//										1,3),
//								new IngredientProportion(new Ingredient("Sparkling water", 0),
//										1,3),
//								new IngredientProportion(new Ingredient("Mint", 1),
//										1, 12),
//								new IngredientProportion(new Ingredient("Cane sugar syrup", 0),
//										1, 12),
//								new IngredientProportion(new Ingredient("Lime juice", 0),
//										1, 6))));
	}
}
