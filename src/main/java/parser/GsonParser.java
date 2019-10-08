package parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Product;

public class GsonParser {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        Product product = new Product();
        product.setManufacturer("Dext");
        product.setModel("br001");
        product.setDateOfManufacture("26-04-2027");
        product.setColor("Grey");
        product.setPrice((float) 17.99);
        product.setAmount(8);

        String json = GSON.toJson(product);
        System.out.println(json);

    }
}
