package fr.formation.entity;

import java.io.Serializable;

public class IngredientProportion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Ingredient ingredient;
	int num, den;	// → ratio

	public IngredientProportion(Ingredient ingredient, int num, int den) {
		super();
		this.ingredient = ingredient;
		this.num = num;
		this.den = den;
	}

	@Override
	public String toString() {
		return "IngredientProportion [ingredient=" + ingredient + ", ratio=" + num + "/" + den + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + den;
		result = prime * result + ((ingredient == null) ? 0 : ingredient.hashCode());
		result = prime * result + num;
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
		IngredientProportion other = (IngredientProportion) obj;
		if (den != other.den)
			return false;
		if (ingredient == null) {
			if (other.ingredient != null)
				return false;
		} else if (!ingredient.equals(other.ingredient))
			return false;
		if (num != other.num)
			return false;
		return true;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getDen() {
		return den;
	}

	public void setDen(int den) {
		this.den = den;
	}
}
