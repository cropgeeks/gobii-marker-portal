// Copyright 2017 Information & Computational Sciences, JHI. All rights
// reserved. Use is subject to the accompanying licence terms.

package jhi.gobii.ui.xml;

import javax.xml.bind.annotation.*;

public class XmlLauncher
{
	private String name;
	private String url, url2;
	private String logo;
	private String description;
	private String color;

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

	public String getUrl2() {
		return url2;
	}

	@XmlElement
	public void setUrl2(String url2) {
		this.url2 = url2;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	public String getColor()
		{ return color; }

	@XmlElement
	public void setColor(String color)
		{ this.color = color; }
}