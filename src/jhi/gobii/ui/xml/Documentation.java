package jhi.gobii.ui.xml;

import javax.xml.bind.annotation.*;

public class Documentation
{
	private String displayName;
	private String url;

	public Documentation()
	{
	}

	public Documentation(String displayName, String url)
	{
		this.displayName = displayName;
		this.url = url;
	}

	public String getDisplayName()
		{ return displayName; }

	@XmlElement
	public void setDisplayName(String displayName)
		{ this.displayName = displayName; }

	public String getUrl()
		{ return url; }

	@XmlElement
	public void setUrl(String url)
		{ this.url = url; }
}
