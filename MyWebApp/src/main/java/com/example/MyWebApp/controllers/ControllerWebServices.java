package com.example.MyWebApp.controllers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


@Controller
@RequestMapping("/webServicesInterface")
public class ControllerWebServices {
	
	
	
	 public static String convertDocumentToString(Document doc) {
	        TransformerFactory tf = TransformerFactory.newInstance();
	        Transformer transformer;
	        try {
	            transformer = tf.newTransformer();
	           
	            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	            StringWriter writer = new StringWriter();
	            
	            System.out.println("convertDocumentToString\n");
	            
	            transformer.transform(new DOMSource(doc), new StreamResult(writer));
	            String output = writer.getBuffer().toString();
	            
	            return output;
	        } catch (TransformerException e) {
	            e.printStackTrace();
	        }
	        
	        return null;
	    }
	
	 public static Document convertStringToDocument(String xmlStr) {
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
	        DocumentBuilder builder;  
	        System.out.println("convertStringToDocument\n");
	        try  
	        {  
	            builder = factory.newDocumentBuilder();  
	            Document doc = builder.parse( new InputSource( new StringReader( xmlStr ) ) ); 
	           
	            return doc;
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } 
	        return null;
	    }
	 
	 
	
	
	
	
	
	
	
	
	
	@GetMapping("")
	public String PresentWebServicesInterface() {
		 System.out.println("PresentWebServicesInterface\n");
		
		return "webServicesInterface";
	}

	
	
	@PostMapping(value = {""})
	public String requestExecution(@RequestParam("request")String request,Model m) {
		
		
		
		
		 ClientConfig Config = new DefaultClientConfig();
		 Client c = Client.create(Config);
		 WebResource Resource = c.resource(UriBuilder.fromUri("http://localhost:8080").build());
		
		
		 
		 boolean flag = request.contains("employeeById");
		 boolean flag2 = request.contains("SearchEmployee");
		 if(flag == true) {
			 String str1 = "\\?";
			 String [] arrOfStr = request.split(str1);
			
			 String str = arrOfStr[1];
			 String [] arrOfStr2 = str.split("\\=");
			
			
			 
			 String xmlInString=Resource.path("restapi").path(arrOfStr[0]).queryParam(arrOfStr2[0], arrOfStr2[1]).accept(MediaType.APPLICATION_XML).get(String.class);
			 Document xmlInDoc = convertStringToDocument(xmlInString);
			 String newXmlInString = convertDocumentToString(xmlInDoc);
			 
			 String newformattedXML="\n"+newXmlInString;
			 System.out.println(newformattedXML);
			 m.addAttribute("Xml", newformattedXML);
			 
		 }
		 else if(flag2 == true) {
			 
			 String str1 = "\\?";
			 String [] arrOfStr = request.split(str1);
			 
			 String str = arrOfStr[1];
			 String [] arrOfStr2 = str.split("\\&");
			 String [] arrOfStr3 = arrOfStr2[0].split("\\=");
			 String [] arrOfStr4 = arrOfStr2[1].split("\\=");
			 
			 
			 String xmlInString=Resource.path("restapi").path(arrOfStr[0]).queryParam(arrOfStr3[0], arrOfStr3[1]).queryParam(arrOfStr4[0], arrOfStr4[1]).accept(MediaType.APPLICATION_XML).get(String.class);
			 Document xmlInDoc = convertStringToDocument(xmlInString);
			 String newXmlInString = convertDocumentToString(xmlInDoc);
			 
			 String newformattedXML="\n"+newXmlInString;
			 System.out.println(newformattedXML);
			 m.addAttribute("Xml", newformattedXML);
			 
		 }
		 else {
			 
			 String xmlInString=Resource.path("restapi").path(request).accept(MediaType.APPLICATION_XML).get(String.class);
			 Document xmlInDoc = convertStringToDocument(xmlInString);
			 String newXmlInString = convertDocumentToString(xmlInDoc);
			 
			 String newformattedXML="\n"+newXmlInString;
			 System.out.println(newformattedXML);
			 m.addAttribute("Xml", newformattedXML);
		 }
		 
		
		
		 
		 
		 
		 
		return "webServicesInterface";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
