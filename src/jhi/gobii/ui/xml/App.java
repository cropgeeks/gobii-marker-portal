// Copyright 2017 Information & Computational Sciences, JHI. All rights
// reserved. Use is subject to the accompanying licence terms.

package jhi.gobii.ui.xml;

import java.util.*;
import javax.faces.context.*;
import javax.xml.bind.annotation.*;

public class App
{
	private String name;
	private String url;
	private String logo;
	private String description;
	private String category;
	private String type;
	private List<Documentation> documentationList;

	public App()
	{
	}

	public App(String name, String url, String logo, String description, String category, List<Documentation> documentationList)
	{
		this.name = name;
		this.url = url;
		this.logo = logo;
		this.description = description;
		this.category = category;
		this.documentationList = documentationList;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public String getLogo() {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/config/img/" + logo;
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

	public String getType()
		{ return type; }

	@XmlElement
	public void setType(String type)
		{ this.type = type; }

	public List<Documentation> getDocumentationList()
		{ return documentationList; }

	@XmlElementWrapper(name = "documentationList")
	@XmlElement(name = "documentation")
	public void setDocumentationList(List<Documentation> documentationList)
		{ this.documentationList = documentationList; }
}