// Copyright 2017 Information & Computational Sciences, JHI. All rights
// reserved. Use is subject to the accompanying licence terms.

package jhi.gobii.ui.xml;

import javax.xml.bind.annotation.*;

public class App
{
	private String name;
	private String url;
	private String logo;
	private String description;
	private String category;

	public App()
	{
	}

	public App(String name, String url, String logo, String description, String category)
	{
		this.name = name;
		this.url = url;
		this.logo = logo;
		this.description = description;
		this.category = category;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public String getLogo() {
		return logo;
	}

	@XmlElement
	public void setLogo(String logo)
		{ this.logo = logo; }

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	@XmlElement
	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory()
		{ return category; }

	@XmlElement
	public void setCategory(String category)
		{ this.category = category; }
}