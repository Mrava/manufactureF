package test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLBuilder
{
	private Document document = null;
	private Element root = null;

	public Document getDocument()
	{
		return document;
	}

	public Element getRoot()
	{
		return root;
	}

	public XMLBuilder() throws ParserConfigurationException
	{
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		document = builder.newDocument();
		document.setXmlVersion("1.0");
		
		root = document.createElement("root");
		
		document.appendChild(root).setTextContent("bridge");
		
		//root.appendChild(document.createTextNode("bridge"));
		
	}
	
	
	
}
