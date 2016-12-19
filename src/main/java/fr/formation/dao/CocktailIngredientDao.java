package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.entity.CocktailIngredient;

@Repository
public interface CocktailIngredientDao  extends JpaRepository<CocktailIngredient, Integer> {

}
