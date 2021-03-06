package com.ela.csvtopojo;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.pojoxml.core.PojoXml;
import org.pojoxml.core.PojoXmlFactory;

import com.opencsv.CSVReader;

public class CsvToXML {
	
	public String csvtoxml() throws IOException
	{
		
		 PojoXml pojoxml = PojoXmlFactory.createPojoXml();
		 CSVReader reader = new CSVReader(new FileReader("E:\\SharedFolder\\Rajesh\\13_F_Data.csv"));
		 
		 InformationTableList informationTableList = new InformationTableList();
		 List infoList = new ArrayList();
		 InformationTable informationTable;
		 Voting voting = new Voting();
		 String[] nextLine;
		 
		 nextLine=reader.readNext();                      //to skip the first line
		 
		  while ((nextLine = reader.readNext()) != null) {
			  informationTable = new InformationTable();
			  for(int i=0;i<nextLine.length;i++)
	      {
	    	  
				     informationTable.setNameOfIssuer(nextLine[0]);
				     informationTable.setTitleOfClass(nextLine[1]);
				     informationTable.setCusip(nextLine[2]);
				     informationTable.setValue(Integer.parseInt(nextLine[3]));
				     informationTable.setSshPrnamt(Integer.parseInt(nextLine[4]));
				     informationTable.setSshPrnamtType(nextLine[5]);
				     informationTable.setPutCall(nextLine[6]);
				     informationTable.setInvestmentDiscretion(nextLine[7]);
				     informationTable.setOtherManager(Integer.parseInt(nextLine[8]));
				     
				     
				     voting.setSole(Integer.parseInt(nextLine[9]));
				     voting.setShared(Integer.parseInt(nextLine[10]));
				     voting.setNone(Integer.parseInt(nextLine[11]));
				     
				     informationTable.setVoting(voting);
				  
				 // System.out.println(nextLine[i]);
	    	  
	      }
		  infoList.add(informationTable);
			  
			  
		  }
		  informationTableList.setInformationTableList(infoList);
		  String xml = pojoxml.getXml(informationTableList);
		     System.out.println(xml);
		//  System.out.println("List of information table ##################################"+informationTableList);
		     
		     System.out.println("List of xml"+xml);
		     return xml;
	}
	
	


	public void writeFile(String yourXML) throws IOException{
	    BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\elavarasan.natarajan\\Desktop\\output.xml"));
	    try { 
	        out.write(yourXML);
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        out.close();
	    }
	}
	
	public static void main(String[] args) throws IOException
	{
		CsvToXML csvToXML = new CsvToXML();
		csvToXML.writeFile(csvToXML.csvtoxml());
	}

}
