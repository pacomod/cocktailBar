package fr.formation.entity;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Cocktail implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotNull
	@Pattern(regexp=("[^/:;+=@&*\\\\]+"))
	private String name;
	@NotNull
	@Min(0)
	private Double price;
	private boolean alcoholic;
//	List<CocktailIngredient> CocktailIngredient;


	public Cocktail() {
		super();
	}

	public Cocktail(Integer id, String name, Double price, boolean alcoholic) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.alcoholic = alcoholic;
	}

	@Override
	public String toString() {
		return "Cocktail [id=" + id + ", name=" + name + ", price=" + price + ", alcoholic=" + alcoholic + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isAlcoholic() {
		return alcoholic;
	}

	public void setAlcoholic(boolean alcoholic) {
		this.alcoholic = alcoholic;
	}


//	public List<CocktailIngredient> getCocktailIngredient() {
//		return CocktailIngredient;
//	}
//
//	public void setCocktailIngredient(List<CocktailIngredient> cocktailIngredient) {
//		CocktailIngredient = cocktailIngredient;
//	}

}
