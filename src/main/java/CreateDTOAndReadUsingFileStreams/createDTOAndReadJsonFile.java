package CreateDTOAndReadUsingFileStreams;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class createDTOAndReadJsonFile {
    public static void main(String[] args) throws IOException {
        Model dto = (Model) readModel(new Model(), "/model.json");
        System.out.println(dto.toString());
    }

    private static Object readModel(Object dtoType, String filename) throws IOException {
        Object dto = dtoType.getClass();
        try {
            InputStream inJson = null;
            ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            inJson = dtoType.getClass().getResourceAsStream(filename);
            dto = objectMapper.readValue(inJson, dtoType.getClass());
            //Read using buffered reader
            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inJson, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dto;
    }
}
