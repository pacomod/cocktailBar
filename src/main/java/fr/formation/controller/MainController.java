package fr.formation.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.entity.Cocktail;
import fr.formation.entity.Ingredient;
import fr.formation.model.Menu;
import fr.formation.service.CocktailService;
import fr.formation.service.IngredientService;

@Controller
public class MainController {

	@Autowired
	private MessageSource messages;

	@Autowired
	private CocktailService cocktailService;

	@Autowired
	private IngredientService ingredientService;

	@RequestMapping("/index")
	public ModelAndView index() {
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		final List<String> menuKeys = Arrays
				.asList(this.getMessage("menu.list").split(","));
		final List<Menu> menus = new ArrayList<>();
		for (final String menuKey : menuKeys) {
			final List<Menu> subMenus = new ArrayList<>();
			final String prefix = "menu." + menuKey.trim();
			final String title = this.getMessage(prefix + ".title");
			final String url = this.getMessage(prefix + ".url");
			try {
				final List<String> subMenuKeys = Arrays
						.asList(this.getMessage(prefix + ".sublist").split(","));
				for (final String subMenuKey : subMenuKeys) {
					final String subPrefix = "submenu." + subMenuKey.trim();
					final String subTitle = this.getMessage(subPrefix + ".title");
					final String subUrl = this.getMessage(subPrefix + ".url");
					subMenus.add(new Menu(subTitle, subUrl, null));
				}
			} catch (final NoSuchMessageException e) {
				// no sub-menu…
			}
			menus.add(new Menu(title, url, subMenus));
		}
		mav.getModel().put("menus", menus);
		return mav;
	}

	@RequestMapping("/search")
	public ModelAndView searchResults(@RequestParam final String search) {
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("search");
		final List<Cocktail> searchByName = this.cocktailService
				.searchByName(search);
		System.out.println("MainController:search: " + searchByName);
		mav.addObject("cocktailResults", searchByName);
		final List<Ingredient> searchByName2 = this.ingredientService
				.searchByName(search);
		System.out.println("MainController:search: " + searchByName2);
		mav.addObject("ingredientResults", searchByName2);
		return mav;
	}

	private String getMessage(final String key) {
		return this.messages.getMessage(key, null, null);
	}

}
