// Copyright 2017 Information & Computational Sciences, JHI. All rights
// reserved. Use is subject to the accompanying licence terms.

package jhi.gobii.ui;

import java.io.*;
import javax.xml.bind.*;

import jhi.gobii.ui.xml.*;

public class Test
{
	public static void main(String[] args)
		throws Exception
	{
		Test test = new Test();
		test.getLaunchers();
	}

	public XmlLauncherList getLaunchers()
		throws Exception
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(XmlLauncherList.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		File xml = new File("launchers.xml");

		XmlLauncherList list = (XmlLauncherList) jaxbUnmarshaller.unmarshal(xml);

		for (XmlLauncher launcher: list.getList())
			System.out.println(launcher.getName() + " - " + launcher.getUrl());

		return list;
	}
}