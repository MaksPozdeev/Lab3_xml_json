package parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Products;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class MainParser {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) throws IOException {
        String xmlFilePath = "src/main/resources/products.xml";
        String xmlString = readUsingBufferedReader(xmlFilePath);
//        System.out.println(xmlString);
        Products products = xmlToProducts(xmlFilePath);
        if (products != null) {
            System.out.println(products);
        }

        if (products != null) {
            System.out.println(objToJson(products));
        }

    }

    private static String objToJson(Products products) {
        String json = GSON.toJson(products);
        System.out.println(json);
        return json;
    }

    private static Products xmlToProducts(String xmlFilePath) {
        Products products = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Products.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FileReader reader = new FileReader(xmlFilePath);
            products = (Products) unmarshaller.unmarshal(reader);

        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }

    private static String readUsingBufferedReader(String fileName) {
        BufferedReader reader = null;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = null;
            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            // delete the last ls
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        return stringBuilder.toString();
    }
}
