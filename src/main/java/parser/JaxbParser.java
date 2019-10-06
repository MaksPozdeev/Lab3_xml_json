package main.java.parser;

import main.java.entity.Products;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JaxbParser {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Products.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            String xmlFilePath = "F:\\develop\\Lab3_xml_json\\resources\\products.xml";
            FileReader reader = new FileReader(xmlFilePath);
            Products products = (Products) unmarshaller.unmarshal(reader);
            System.out.println(products);
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
