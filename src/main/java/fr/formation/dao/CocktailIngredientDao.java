package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.entity.CocktailIngredient;

//@Repository
public interface CocktailIngredientDao
		extends JpaRepository<CocktailIngredient, Integer> {

	/**
	 * Méthode générée par éclipse: génère automatiquement une requête basée sur
	 * le nom de la méthode!!
	 * 
	 * @param cocktailId
	 * @return
	 */
	List<CocktailIngredient> findAllByCocktailId(Integer cocktailId);

}
