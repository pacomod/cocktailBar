package fr.formation.controller;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.entity.Ingredient;
import fr.formation.entity.State;
import fr.formation.service.IngredientService;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {

	@Autowired
	private IngredientService service;

	@RequestMapping
	public ModelAndView listAll() {
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("ingredients");
		mav.addObject("ingredients", this.service.getAll());
		return mav;
	}

	@RequestMapping("/add")
	public ModelAndView add() {
		final ModelAndView mav = new ModelAndView();
		mav.addObject("states", State.all);
		mav.addObject("action", "Ajouter");
		mav.setViewName("actionIngredient");
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String newIngredient(@RequestParam final String name,
			@RequestParam final Integer state) {
		this.service.create(new Ingredient(null, name, state));
		return "redirect:/ingredients/add.html";
	}

	@RequestMapping("/mod")
	public ModelAndView mod(@Param(value = "id") final int id) {
		final ModelAndView mav = new ModelAndView();
		final Iterator<Ingredient> ingrdientsIter = this.service.getAll()
				.iterator();
		Ingredient ingredient = null;
		boolean found = false;
		while (!found && ingrdientsIter.hasNext()) {
			ingredient = ingrdientsIter.next();
			found = ingredient.getId() == id;
		}
		mav.addObject("ingredient", ingredient);
		mav.addObject("states", State.all);
		mav.addObject("action", "Modifier");
		mav.setViewName("actionIngredient");
		return mav;
	}

	@RequestMapping(value = "/mod", method = RequestMethod.POST)
	public String modIngredient(@RequestParam final int id,
			@RequestParam final String name, @RequestParam final Integer state) {
		this.service.update(new Ingredient(id, name, state));
		return "redirect:/ingredients.html";
	}

	@RequestMapping("/del")
	public ModelAndView del(@Param(value = "id") final int id) {
		final ModelAndView mav = new ModelAndView();
		final Iterator<Ingredient> ingrdientsIter = this.service.getAll()
				.iterator();
		Ingredient ingredient = null;
		boolean found = false;
		while (!found && ingrdientsIter.hasNext()) {
			ingredient = ingrdientsIter.next();
			found = ingredient.getId() == id;
		}
		mav.addObject("ingredient", ingredient);
		mav.addObject("states", State.all);
		mav.addObject("action", "Effacer");
		mav.setViewName("actionIngredient");
		return mav;
	}

	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public String delIngredient(@RequestParam final int id,
			@RequestParam final String name, @RequestParam final State state) {
		this.service.delete(new Ingredient(id, name, state.value()));
		return "redirect:/ingredients.html";
	}

	@RequestMapping(value = "/add_relou", method = RequestMethod.POST)
	public String newIngredient_relou(final HttpServletRequest request) {
		final String name = request.getParameter("name");
		final Integer state = Integer.parseInt(request.getParameter("state"));
		this.service.create(new Ingredient(null, name, state));
		return "redirect:/ingredients/add.html";
	}
}
