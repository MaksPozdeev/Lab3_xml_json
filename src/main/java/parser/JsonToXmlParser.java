package parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.JSONObject;
import org.json.XML;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonToXmlParser {

    //    public static String parse(String jsonString) throws IOException {
    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectMapper xmlMapper = new XmlMapper();
        String jsonString = "{\"nameCategory\":\"Audio equipment\",\"subcategoryList\":[{\"nameSubcategory\":\"mp3 players\",\"productList\":[{\"manufacturer\":\"Ritmux\",\"model\":\"mp001\",\"dateOfManufacture\":\"12-01-2018\",\"color\":\"Red\",\"price\":19.99,\"amount\":7},{\"manufacturer\":\"SomY\",\"model\":\"mp002\",\"dateOfManufacture\":\"12-11-2018\",\"color\":\"Blue\",\"price\":29.99,\"amount\":13},{\"manufacturer\":\"Dixp\",\"model\":\"mp003\",\"dateOfManufacture\":\"04-07-2018\",\"color\":\"Black\",\"price\":9.99,\"amount\":15}]},{\"nameSubcategory\":\"headphones\",\"productList\":[{\"manufacturer\":\"A3Teh\",\"model\":\"ph001\",\"dateOfManufacture\":\"22-01-2018\",\"color\":\"White\",\"price\":29.99,\"amount\":7},{\"manufacturer\":\"BurnLine\",\"model\":\"ph002\",\"dateOfManufacture\":\"13-11-2019\",\"color\":\"Red\",\"price\":24.49,\"amount\":8}]},{\"nameSubcategory\":\"hi-fi speakers\",\"productList\":[{\"manufacturer\":\"Somy\",\"model\":\"as001\",\"dateOfManufacture\":\"22-11-2017\",\"color\":\"Brown\",\"price\":59.99,\"amount\":4},{\"manufacturer\":\"Imaha\",\"model\":\"as002\",\"dateOfManufacture\":\"13-09-2019\",\"color\":\"Black\",\"price\":79.99,\"amount\":3}]}]},{\"nameCategory\":\"Video equipment\",\"subcategoryList\":[{\"nameSubcategory\":\"TV set\",\"productList\":[{\"manufacturer\":\"Libis\",\"model\":\"tv001\",\"dateOfManufacture\":\"15-10-2016\",\"color\":\"Black\",\"price\":31.99,\"amount\":3},{\"manufacturer\":\"Lizha\",\"model\":\"tv002\",\"dateOfManufacture\":\"21-11-2017\",\"color\":\"Black\",\"price\":29.99,\"amount\":3}]},{\"nameSubcategory\":\"Projectors\",\"productList\":[{\"manufacturer\":\"BanK\",\"model\":\"pr001\",\"dateOfManufacture\":\"27-07-2018\",\"color\":\"Blue\",\"price\":57.99,\"amount\":4},{\"manufacturer\":\"RickoM\",\"model\":\"pr002\",\"dateOfManufacture\":\"12-03-2017\",\"color\":\"Green\",\"price\":49.99,\"amount\":3}]},{\"nameSubcategory\":\"blu ray\",\"productList\":[{\"manufacturer\":\"Dext\",\"model\":\"br001\",\"dateOfManufacture\":\"26-04-2027\",\"color\":\"Grey\",\"price\":17.99,\"amount\":8}]}]}";
        String jsonFilePath = "D:\\development\\Lab3_xml_json\\category.json";

        //    JsonNode tree = objectMapper.readTree(jsonString);
        JsonParser parser = new JsonParser();
        FileReader reader = new FileReader(jsonFilePath);
        JsonElement jsonTree = parser.parse(reader);
        JsonNode tree = objectMapper.readTree(String.valueOf(jsonTree));
        String jsonAsXml = xmlMapper.writer().withRootName("Categorys").writeValueAsString(tree);
        System.out.println(jsonAsXml);

//        System.out.println(jsonString.trim().charAt(0));
//        JSONObject json = new JSONObject(jsonString);
//        String xml = XML.toString(json);
//        System.out.println(xml);
    }
}
