package fr.formation.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.model.Menu;

@Controller
public class MainController {

	@Autowired
	private MessageSource messages;

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

	private String getMessage(final String key) {
		return this.messages.getMessage(key, null, null);
	}

}
