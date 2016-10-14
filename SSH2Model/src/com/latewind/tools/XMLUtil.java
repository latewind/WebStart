/**
 * 
 */
package com.latewind.tools;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author Administrator
 *
 */
public class XMLUtil {

	/**
	 * @param args
	 */
	public static Document parse(URL url) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
    }
	
	 public void bar(Document document) throws DocumentException {

	        Element root = document.getRootElement();

	        // iterate through child elements of root
	        for ( Iterator i = root.elementIterator(); i.hasNext(); ) {
	            Element element = (Element) i.next();
	            System.out.println(element.getName()+" "+element.attributeValue("name"));     
	            // do something
	        }

	        // iterate through child elements of root with element name "foo"
	        for ( Iterator i = root.elementIterator( "foo" ); i.hasNext(); ) {
	            Element foo = (Element) i.next();
	            System.out.println(foo.getText());
	            // do something
	        }

	        // iterate through attributes of root 
	        for ( Iterator i = root.attributeIterator(); i.hasNext(); ) {
	            Attribute attribute = (Attribute) i.next();
	            
	            System.out.println(attribute.getText());
	            // do something
	        }
	     }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileUtil.getWEBINFPath();
		String path="E:\\privilege.xml";
		URL url=null;
		try {
			File file=new File(path);
			url=file.toURL();
			XMLUtil xmlUtil=new XMLUtil();
			Document d=xmlUtil.parse(url);
			xmlUtil.bar(d);
			
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}

	}

}
