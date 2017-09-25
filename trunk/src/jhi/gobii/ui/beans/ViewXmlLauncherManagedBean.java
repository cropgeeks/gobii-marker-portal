package jhi.gobii.ui.beans;

import java.io.*;
import java.util.*;
import javax.annotation.*;
import javax.enterprise.context.*;
import javax.inject.*;
import javax.xml.bind.*;

import jhi.gobii.ui.xml.*;

@Named
@SessionScoped
public class ViewXmlLauncherManagedBean implements Serializable
{
	private List<XmlLauncher> launchers = new ArrayList<>();

	public ViewXmlLauncherManagedBean()
	{
	}

	@PostConstruct
	public void init()
	{
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(XmlLauncherList.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			//TODO: configure this properly rather than harcoding to a path
			File xml = new File("/home/tomcat/www/webapps/gobii-ui/launchers.xml");

			XmlLauncherList launcherList = (XmlLauncherList) jaxbUnmarshaller.unmarshal(xml);
			launchers = launcherList.getList();
		}
		catch (Exception e) { e.printStackTrace(); }
	}

	public List<XmlLauncher> getLaunchers()
		{ return launchers; }

	public void setLaunchers(List<XmlLauncher> launchers)
		{  this.launchers = launchers; }
}
