package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.entity.Ingredient;

@Repository
public interface IngredientDao extends JpaRepository<Ingredient, Integer> {

	List<Ingredient> findAllByIdNotIn(final List<Integer> ids);

}
