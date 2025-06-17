package JSONFileReading;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JSONFileReadingEasyWay {
    public static void main(String[] args) {
        MyClass myObject = new MyClass("example", 123);
        // Convert the object to JSON string
        String jsonString = getAsJsonString(myObject);
        System.out.println("JSON String: " + jsonString);
        // Save JSON string to a file
        String filePath = "src/main/resources/output.json"; // Specify the file path
        saveJsonToFile(jsonString, filePath);
        // Convert JSON string back to Map
        try {
            Map<String, String> jsonMap = getJsonAsMap(jsonString);
            System.out.println("JSON as Map: " + jsonMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Convert JSON string back to MyClass object
        MyClass newObject = readJsonAsObject(jsonString, new MyClass("", 0));
        System.out.println("Deserialized Object: " + newObject);
    }

    //Read JSON Data
    public static <T> String getAsJsonString(final T message) {
        final ObjectMapper map = new ObjectMapper();
        final Gson gson = new Gson();
        map.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        map.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        try {
            return gson.toJson(message);
        } catch (final Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static Map<String, String> getJsonAsMap(String data) throws IOException {
        Map<String, String> map = new HashMap<String, String>();
        ObjectMapper mapper = new ObjectMapper();
        map = mapper.readValue(data, HashMap.class);
        return map;
    }

    public static <T> T readJsonAsObject(final String text, final T t) {
        T response = null;
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);

            response = (T) mapper.readValue(text, t.getClass());
            return response;
        } catch (final JsonProcessingException e) {
            System.out.println(e);
        } catch (final IOException e) {
            System.out.println(e);
        }
        return null;
    }
    // Method to save JSON string to a file
    public static void saveJsonToFile(String jsonString, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(jsonString);
            System.out.println("JSON saved to file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    /*
    Output:
    JSON String: {"name":"example","value":123}
    JSON as Map: {name=example, value=123}
    Deserialized Object: MyClass{name='example', value=123}
     */
}
