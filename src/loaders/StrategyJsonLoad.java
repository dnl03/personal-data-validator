package loaders;

import java.io.IOException;
import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import data_objects.UserDTO;


public class StrategyJsonLoad implements IStrategyDataLoad {
    /* Implementacja Strategii ładowania z pliku JSON */

    private String filePath = "resources/userData.json";

    private static String findValueByKey(JsonNode node, String key) {
        if (node.has(key)) {
            return node.get(key).asText();
        }
        for (JsonNode child : node) {
            if (child.isObject()) {
                String value = findValueByKey(child, key);
                if (value != null) {
                    return value;
                }
            }
        }
        return null;
    }

    public UserDTO loadUserData() {
        System.out.println("Loading data from JSON: " + this.filePath);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File(this.filePath);

            if (file.length() == 0) {
                System.err.println("Błąd: Plik JSON nie istnieje lub jest pusty.");
                return null;
            }

            JsonNode rootNode = objectMapper.readTree(file);

            String email = findValueByKey(rootNode, "email");
            String phone = findValueByKey(rootNode, "phone");
            String postCode = findValueByKey(rootNode, "post_code");


            return new UserDTO(email, phone, postCode);

        } catch (IOException e) {
            System.err.println("Błąd podczas wczytywania JSON z pliku: " + e.getMessage());
            return null;
        }
    }
}