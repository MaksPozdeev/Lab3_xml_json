package parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Products;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;


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
            String jsonString = objToJson(products);
            System.out.println(jsonString);
            int q = saveJsonInFile(jsonString, "NewJsonFile");
            System.out.println("q = " + q);
        }

    }

    private static Integer saveJsonInFile(String jsonString, String nameJson) {
        int result = -1;
        if (jsonString == null) {
            return -1;
        }
        String newJsonFileName;
        if (nameJson.isEmpty()) {
            newJsonFileName = "NewJsonFile.json";
        } else {
            newJsonFileName = nameJson + ".json";
        }
        try (FileWriter writer = new FileWriter(newJsonFileName, false)) {
            writer.write(jsonString);
            writer.flush();
            result = 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
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

        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}
