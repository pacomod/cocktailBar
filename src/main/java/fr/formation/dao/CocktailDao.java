package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.entity.Cocktail;

@Repository
public interface CocktailDao extends JpaRepository<Cocktail, Integer> {

	List<Cocktail> findAllByNameContains(final String search);
}
