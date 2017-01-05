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
	private List<CocktailIngredient> cocktailIngredients;

	private Integer cocktailId;

	@PostConstruct
	public void _init() {
		this.cocktailIngredients = new ArrayList<>();
	}

	@RequestMapping("/addIngredient")
	public String addIngredient(@RequestParam final Integer ingredientId,
			@RequestParam final Integer ingredientQuantityNum,
			@RequestParam final Integer ingredientQuantityDen) {
		final CocktailIngredient cocktailIngredient = new CocktailIngredient();
		cocktailIngredient.setCocktail(this.cocktailService.get(this.cocktailId));
		cocktailIngredient.setIngredient(this.ingredientService.get(ingredientId));
		cocktailIngredient.setQuantityNum(ingredientQuantityNum);
		cocktailIngredient.setQuantityDen(ingredientQuantityDen);
		this.cocktailIngredients.add(cocktailIngredient);
		return this.getForward();
	}

	@RequestMapping("/modifyIngredient")
	public String modifyIngredient(@RequestParam final Integer ingredientId,
			@RequestParam final Integer ingredientQuantityNum,
			@RequestParam final Integer ingredientQuantityDen) {
		final CocktailIngredient cocktailIngredient = this.cocktailIngredients
				.get(this.cocktailIngredients.indexOf(
						new CocktailIngredient(this.cocktailService.get(this.cocktailId),
								null, this.ingredientService.get(ingredientId), null, null)));
		cocktailIngredient.setQuantityNum(ingredientQuantityNum);
		cocktailIngredient.setQuantityDen(ingredientQuantityDen);
		return this.getForward();
	}

	@RequestMapping("/removeIngredient")
	public String removeIngredient(@RequestParam final Integer ingredientId) {
		System.out.println("EditCocktailController:removeIngredient");
		final CocktailIngredient cocktailIngredients = new CocktailIngredient();
		cocktailIngredients.setCocktail(this.cocktailService.get(this.cocktailId));
		cocktailIngredients.setIngredient(this.ingredientService.get(ingredientId));
		System.out.println(cocktailIngredients);
		this.cocktailIngredients.remove(cocktailIngredients);
		return this.getForward();
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable final Integer id) {
		if (this.cocktailId != null && !this.cocktailId.equals(id)) {
			this.cocktailId = id;
			this.cocktailIngredients = new ArrayList<>();
			if (this.cocktailIngredients.isEmpty()) {
				this.cocktailIngredients.addAll(
						this.cocktailService.getCocktailIngredients(this.cocktailId));
			}
		}
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("editCocktail");
		if (this.error) {
			this.error = false;
		} else {
			final Cocktail cocktail = this.cocktailService.get(id);
			mav.addObject("cocktail", cocktail);
			this.cocktailId = cocktail.getId();
		}

		mav.addObject("cocktailIngredients", this.cocktailIngredients);
		mav.addObject("ingredients",
				this.ingredientService.getAllIngredientsLeft(this.cocktailIngredients));
		return mav;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute @Valid final Cocktail cocktail,
			final BindingResult result) {
		// first get the ingredients list for this cocktail from storage
		final List<CocktailIngredient> cocktailIngredients = this.cocktailService
				.getCocktailIngredients(this.cocktailId);
		// then update ingredients in the original list and insert new ones
		for (final CocktailIngredient cocktailIngredient : this.cocktailIngredients) {
			if (cocktailIngredients.contains(cocktailIngredient)) {
				this.cocktailService.updateCocktailIngredient(cocktailIngredient);
			} else {
				this.cocktailService.addCocktailIngredient(
						cocktailIngredient.getCocktail().getId(),
						cocktailIngredient.getIngredient().getId(),
						cocktailIngredient.getQuantityNum(),
						cocktailIngredient.getQuantityDen());
			}
		}
		// and remove those that are not in the list anymore
		for (final CocktailIngredient cocktailIngredient : cocktailIngredients) {
			if (!this.cocktailIngredients.contains(cocktailIngredient)) {
				this.cocktailService.removeCocktailIngredient(cocktailIngredient);
			}
		}
		if (result.hasErrors()) {
			this.error = true;
		} else {
			this.cocktailService.update(cocktail);
		}
		// return this.getForward();
		return "redirect:/cocktails.html";
	}

	private String getForward() {
		return "forward:/cocktail/edit/" + this.cocktailId + ".html";
	}
}
