package fr.formation.entity;

import java.io.Serializable;

public class Cocktail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private double price;
	private boolean alcoholic;
	//	List<IngredientProportion> ingredientProportions;


	public Cocktail() {
		super();
	}

	public Cocktail(Integer id, String name, double price, boolean alcoholic) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.alcoholic = alcoholic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (alcoholic ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Cocktail other = (Cocktail) obj;
		if (alcoholic != other.alcoholic)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cocktail [id=" + id + ", name=" + name + ", price=" + price + ", alcoholic=" + alcoholic + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAlcoholic() {
		return alcoholic;
	}

	public void setAlcoholic(boolean alcoholic) {
		this.alcoholic = alcoholic;
	}

	//	public List<IngredientProportion> getIngredientProportions() {
	//		return ingredientProportions;
	//	}
	//
	//	public void setIngredientProportions(List<IngredientProportion> ingredientProportions) {
	//		this.ingredientProportions = ingredientProportions;
	//	}
}
