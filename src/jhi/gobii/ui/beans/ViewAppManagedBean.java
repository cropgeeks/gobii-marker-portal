package jhi.gobii.ui.beans;

import java.io.*;
import java.util.*;
import javax.annotation.*;
import javax.enterprise.inject.*;
import javax.faces.context.*;
import javax.xml.bind.*;

import jhi.gobii.ui.xml.*;

@Model
public class ViewAppManagedBean implements Serializable
{
	private List<App> launchers = new ArrayList<>();

	public ViewAppManagedBean()
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
			launchers = launcherList.getList();
		}
		catch (Exception e) { e.printStackTrace(); }
	}

	public List<App> getLaunchers()
	{
		return launchers;
	}

	public void setLaunchers(List<App> launchers)
		{  this.launchers = launchers; }
}
