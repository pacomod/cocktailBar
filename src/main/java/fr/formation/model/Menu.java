package fr.formation.model;

import java.util.List;

public class Menu {
	final private String title;
	final private String url;
	final List<Menu> subMenus;

	public Menu(final String title, final String url, final List<Menu> subMenus) {
		super();
		this.title = title;
		this.url = url;
		this.subMenus = subMenus;
	}

	public boolean hasSubMenus() {
		return !(this.subMenus == null || this.subMenus.isEmpty());
	}

	@Override
	public String toString() {
		return "Menu [title=" + title + ", url=" + url + ((this.hasSubMenus())?", subMenus=" + subMenus + "]":"]");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subMenus == null) ? 0 : subMenus.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (subMenus == null) {
			if (other.subMenus != null)
				return false;
		} else if (!subMenus.equals(other.subMenus))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public List<Menu> getSubMenus() {
		return subMenus;
	}

}
