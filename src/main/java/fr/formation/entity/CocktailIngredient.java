package fr.formation.entity;

import java.io.Serializable;

public class CocktailIngredient implements Serializable {

	private static final long serialVersionUID = 1L;
	private Cocktail cocktail;
	private Integer id;
	private Ingredient ingredient;
	private Integer quantityNum;
	private Integer quantityDen;
	
	public CocktailIngredient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CocktailIngredient(Cocktail cocktail, Integer id, Ingredient ingredient, Integer quantityNum,
			Integer quantityDen) {
		super();
		this.cocktail = cocktail;
		this.id = id;
		this.ingredient = ingredient;
		this.quantityNum = quantityNum;
		this.quantityDen = quantityDen;
	}

	@Override
	public String toString() {
		return "CocktailIngredient [cocktail=" + cocktail + ", id=" + id + ", ingredient=" + ingredient + ", quantityNum="
				+ quantityNum + ", quantityDen=" + quantityDen + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cocktail == null) ? 0 : cocktail.hashCode());
		result = prime * result + ((ingredient == null) ? 0 : ingredient.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CocktailIngredient other = (CocktailIngredient) obj;
		if (cocktail == null) {
			if (other.cocktail != null)
				return false;
		} else if (!cocktail.equals(other.cocktail))
			return false;
		if (ingredient == null) {
			if (other.ingredient != null)
				return false;
		} else if (!ingredient.equals(other.ingredient))
			return false;
		return true;
	}

	public Cocktail getCocktail() {
		return cocktail;
	}

	public void setCocktail(Cocktail cocktail) {
		this.cocktail = cocktail;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Integer getQuantityNum() {
		return quantityNum;
	}

	public void setQuantityNum(Integer quantityNum) {
		this.quantityNum = quantityNum;
	}

	public Integer getQuantityDen() {
		return quantityDen;
	}

	public void setQuantityDen(Integer quantityDen) {
		this.quantityDen = quantityDen;
	}
}
