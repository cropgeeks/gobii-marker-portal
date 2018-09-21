package jhi.gobii.ui.beans;

import jhi.gobii.ui.xml.*;
import org.primefaces.model.*;

import javax.enterprise.context.*;
import javax.faces.context.*;
import javax.faces.view.*;
import javax.inject.*;
import javax.xml.bind.*;
import java.io.*;
import java.nio.file.*;

@Named
@ViewScoped
public class RegisterAppManagedBean implements Serializable
{
	private App app = new App();
	private UploadedFile uploadedFile;

	public RegisterAppManagedBean()
	{
	}

	public App getApp()
		{ return app; }

	public void setApp(App app)
		{ this.app = app; }

	public UploadedFile getUploadedFile()
	{
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile)
	{
		this.uploadedFile = uploadedFile;
	}

	public String register()
		throws Exception
	{
		String folderPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/assets/img/instances/");
		System.out.println(folderPath);
		Path path = new File(folderPath, uploadedFile.getFileName()).toPath();
		try (InputStream input = uploadedFile.getInputstream())
		{
			Files.copy(input, path, StandardCopyOption.REPLACE_EXISTING);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		app.setLogo(uploadedFile.getFileName());

		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(AppList.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			//TODO: configure this properly rather than harcoding to a path
			File xml = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/config/launchers.xml"));

			AppList launcherList = (AppList) jaxbUnmarshaller.unmarshal(xml);
			launcherList.getList().add(app);

			for (App a : launcherList.getList())
				System.out.println(a);

			Marshaller marhseller = jaxbContext.createMarshaller();
			marhseller.marshal(launcherList, xml);
		}
		catch (Exception e) { e.printStackTrace(); }

		return "index";
	}
}