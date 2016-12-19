package fr.formation.trash;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import fr.formation.entity.Ingredient;

@Component
public class IngredientDaoOld {

	public List<Ingredient> readAll() {
		return Arrays.asList(
				new Ingredient(null,"Rhum", 0),
				new Ingredient(null,"Tequila", 0),
				new Ingredient(null,"Whiskey", 0),
				new Ingredient(null,"Cane sugar syrup", 0),
				new Ingredient(null,"Lime juice", 0),
				new Ingredient(null,"Sparkling water", 0),
				new Ingredient(null,"Ice cubes", 1),
				new Ingredient(null,"Mint", 1),
				new Ingredient(null,"Sugar", 1),
				new Ingredient(null,"CO2", 2));
	}
}
