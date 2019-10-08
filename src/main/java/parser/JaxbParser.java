package parser;

import entity.Products;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class JaxbParser {
    public static void main(String[] args) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Products.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            File xmlFilePath = new File("src/main/resources/products.xml");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(new FileInputStream(xmlFilePath), StandardCharsets.UTF_8));
            Products products = (Products) unmarshaller.unmarshal(in);
            System.out.println(products);

        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

}
