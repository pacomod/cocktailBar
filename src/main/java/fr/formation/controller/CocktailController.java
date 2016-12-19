package fr.formation.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.entity.Cocktail;
import fr.formation.entity.State;
import fr.formation.service.CocktailService;

@Controller
@RequestMapping("/cocktails")
public class CocktailController {

	@Autowired
	private CocktailService service;
	
	@RequestMapping
	public ModelAndView listAll() {
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("cocktails");
		mav.addObject("cocktails", service.getAll());
		return mav;
	}
	
	public String addCoctailIngredient(@RequestParam final Integer cocktailId,
			@RequestParam final List<Integer> ingredientIds,
			@RequestParam final Integer qte) {
		return null;
	}
	
		@RequestMapping("/add")
	public ModelAndView add() {
		final ModelAndView mav = new ModelAndView();
		mav.addObject("action", "Ajouter");
		mav.setViewName("actionCocktail");
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String newCocktail(@RequestParam final String name,
			@RequestParam final Double price, @RequestParam final Boolean alcoholic) {
		this.service.create(new Cocktail(null, name, price, alcoholic));
		return "redirect:/cocktails/add.html";
	}

	@RequestMapping("/mod")
	public ModelAndView mod(@Param(value = "id") final int id) {
		final ModelAndView mav = new ModelAndView();
		Iterator<Cocktail> cocktailIter = this.service.getAll().iterator();
		Cocktail cocktail = null;
		boolean found = false;
		while (!found && cocktailIter.hasNext()) {
			cocktail = cocktailIter.next();
			found = cocktail.getId() == id;
		}
		mav.addObject("cocktail", cocktail);
		mav.addObject("states", State.all);
		mav.addObject("action", "Modifier");
		mav.setViewName("actionCocktail");
		return mav;
	}

	@RequestMapping(value = "/mod", method = RequestMethod.POST)
	public String modCocktail(@RequestParam final int id,
			@RequestParam final String name,
			@RequestParam final double price,
			@RequestParam final boolean alcoholic) {
		this.service.update(new Cocktail(id, name, price, alcoholic));
		return "redirect:/cocktails.html";
	}

	@RequestMapping("/del")
	public ModelAndView del(@Param(value = "id") final int id) {
		final ModelAndView mav = new ModelAndView();
		Iterator<Cocktail> ingrdientsIter = this.service.getAll().iterator();
		Cocktail cocktail = null;
		boolean found = false;
		while (!found && ingrdientsIter.hasNext()) {
			cocktail = ingrdientsIter.next();
			found = cocktail.getId() == id;
		}
		mav.addObject("cocktail", cocktail);
		mav.addObject("states", State.all);
		mav.addObject("action", "Effacer");
		mav.setViewName("actionCocktail");
		return mav;
	}

	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public String delCocktail(@RequestParam final int id,
			@RequestParam final String name,
			@RequestParam final double price,
			@RequestParam final boolean alcoholic) {
		this.service.delete(new Cocktail(id, name, price, alcoholic));
		return "redirect:/cocktails.html";
	}

}
