package main.java.parser;

import main.java.entity.Category;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StaxJaxbParser {
    public static void main(String[] args) throws Exception {

        JAXBContext jc = JAXBContext.newInstance(Category.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        XMLInputFactory xmlFactory = XMLInputFactory.newInstance();
        String xmlFilePath = "resources/products.xml";
        XMLStreamReader reader = xmlFactory.createXMLStreamReader(new FileReader(xmlFilePath));
        List<Category> categoryList = new ArrayList<>();
        while (reader.hasNext() && (!reader.isStartElement() || !reader.getLocalName().equals("category"))) {
            reader.next();
        }

        while (reader.getEventType() == XMLStreamConstants.START_ELEMENT) {
            JAXBElement<Category> boolElement = unmarshaller.unmarshal(reader, Category.class);
            Category category = boolElement.getValue();
            categoryList.add(category);

            if (category.getNameCategory() != null) { 
                System.out.println("Category name: " + category.getNameCategory());
            }

            if (reader.getEventType() == XMLStreamConstants.CHARACTERS) {
                reader.next();
            }
        }
        reader.close();

        categoryList.forEach(System.out::println);
    }
}
