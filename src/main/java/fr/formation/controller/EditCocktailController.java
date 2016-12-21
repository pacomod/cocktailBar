package fr.formation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.entity.Cocktail;
import fr.formation.entity.CocktailIngredient;
import fr.formation.service.CocktailService;
import fr.formation.service.IngredientService;

@Controller
@RequestMapping("/cocktail")
public class EditCocktailController {

	@Autowired
	private CocktailService cocktailService;

	@Autowired
	private IngredientService ingredientService;

	private boolean error;
	List<CocktailIngredient> cocktailIngredients;

	private Integer cocktailId;

	@PostConstruct
	public void _init() {
		this.cocktailIngredients = new ArrayList<>();
	}

	@RequestMapping("/addIngredient")
	public String addIngredient(@RequestParam final Integer ingredientId) {
		final CocktailIngredient cocktailIngredients = new CocktailIngredient();
		cocktailIngredients.setCocktail(this.cocktailService.get(this.cocktailId));
		cocktailIngredients.setIngredient(this.ingredientService.get(ingredientId));
		this.cocktailIngredients.add(cocktailIngredients);
		return this.getForward();
	}

	@RequestMapping("/removeIngredient")
	public String removeIngredient(@RequestParam final Integer ingredientId) {
		final CocktailIngredient cocktailIngredients = new CocktailIngredient();
		cocktailIngredients.setCocktail(this.cocktailService.get(this.cocktailId));
		cocktailIngredients.setIngredient(this.ingredientService.get(ingredientId));
		this.cocktailIngredients.remove(cocktailIngredients);
		return this.getForward();
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable final Integer id) {
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("editCocktail");
		if (this.error) {
			this.error = false;
		} else {
			final Cocktail cocktail = this.cocktailService.get(id);
			mav.addObject("cocktail", cocktail);
			this.cocktailId = cocktail.getId();
		}
		if (this.cocktailIngredients.isEmpty()) {
			this.cocktailService.getCocktailIngredients(this.cocktailId);
		}
		mav.addObject("cocktailIngredients", this.cocktailIngredients);
		mav.addObject("ingredients",
				this.ingredientService.getAllByCocktail(this.cocktailIngredients));
		return mav;
	}

	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute @Valid final Cocktail cocktail,
			final BindingResult result) {
		if (result.hasErrors()) {
			this.error = true;
		} else {
			this.cocktailService.update(cocktail);
		}
		return getForward();
	}

	private String getForward() {
		return "forward:/cocktail/edit/" + this.cocktailId + ".html";
	}
}
