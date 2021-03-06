package fr.formation.controller;

import java.util.Iterator;

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
	private CocktailService cocktailService;

	@RequestMapping
	public ModelAndView listAll() {
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("cocktails");
		mav.addObject("cocktails", this.cocktailService.getAll());
		return mav;
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
		this.cocktailService.create(new Cocktail(null, name, price, alcoholic));
		return "redirect:/cocktails.html";
	}

	@RequestMapping("/mod")
	public ModelAndView mod(@Param(value = "id") final int id) {
		final ModelAndView mav = new ModelAndView();
		final Iterator<Cocktail> cocktailIter = this.cocktailService.getAll()
				.iterator();
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
			@RequestParam final String name, @RequestParam final double price,
			@RequestParam final boolean alcoholic) {
		this.cocktailService.update(new Cocktail(id, name, price, alcoholic));
		return "redirect:/cocktails.html";
	}

	@RequestMapping("/del")
	public ModelAndView del(@Param(value = "id") final int id) {
		final ModelAndView mav = new ModelAndView();
		final Iterator<Cocktail> ingrdientsIter = this.cocktailService.getAll()
				.iterator();
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
	public String delCocktail(@RequestParam final Integer id,
			@RequestParam final String name, @RequestParam final double price,
			@RequestParam final boolean alcoholic) {
		this.cocktailService.purgeCocktailIngredients(id);
		this.cocktailService.delete(new Cocktail(id, name, price, alcoholic));
		return "redirect:/cocktails.html";
	}

}
