package jhi.gobii.ui.beans;

import jhi.gobii.ui.xml.*;

import javax.annotation.*;
import javax.enterprise.inject.*;
import javax.faces.context.*;
import javax.xml.bind.*;
import java.io.*;
import java.util.*;
import java.util.stream.*;

@Model
public class DesktopAppsManagedBean implements Serializable
{
	private List<App> launchers = new ArrayList<>();
	private List<Documentation> documentation = new ArrayList<>();

	public DesktopAppsManagedBean()
	{
	}

	@PostConstruct
	public void init()
	{
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(AppList.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			//TODO: configure this properly rather than harcoding to a path
			File xml = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/config/launchers.xml"));

			AppList launcherList = (AppList) jaxbUnmarshaller.unmarshal(xml);

			documentation = launcherList.getList().stream()
				.flatMap(l -> l.getDocumentationList().stream())
				.collect(Collectors.toCollection(ArrayList::new));

			launchers = launcherList.getList().stream()
				.filter(l -> l.getType().equalsIgnoreCase("Desktop Apps"))
				.collect(Collectors.toCollection(ArrayList::new));
		}
		catch (Exception e) { e.printStackTrace(); }
	}

	public List<App> getLaunchers()
	{
		return launchers;
	}

	public void setLaunchers(List<App> launchers)
		{  this.launchers = launchers; }

	public List<Documentation> getDocumentation()
		{ return documentation; }

	public void setDocumentation(List<Documentation> documentation)
		{ this.documentation = documentation; }
}
