package fr.formation.entity;

import java.io.Serializable;

public class Ingredient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private int state;
	
	public Ingredient() {
		super();
	}

	public Ingredient(Integer id, String name, int state) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", state=" + state + "]";
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
		Ingredient other = (Ingredient) obj;
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

	public State getState() {
		return State.getEnum(this.state);
	}

	public void setState(State state) {
		this.state = state.value();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
