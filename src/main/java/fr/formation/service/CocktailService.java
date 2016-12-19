package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.dao.CocktailDao;
import fr.formation.entity.Cocktail;

@Service
public class CocktailService {

	@Autowired
	private CocktailDao dao;

	public List<Cocktail> getAll() {
		return this.dao.findAll();
	}

	@Transactional
	public void create(final Cocktail cocktail) {
		this.dao.save(cocktail);
	}

	@Transactional
	public void update(final Cocktail cocktail) {
		this.dao.save(cocktail);
	}

	@Transactional
	public void delete(final Cocktail cocktail) {
		this.dao.delete(cocktail);
	}
}
