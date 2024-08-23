package JSONFileReading;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class JSONFileReading {
    public static void main(String[] args) throws FileNotFoundException,IOException {
        System.out.println("Opening File");
        getFile();
    }
    public static void getFile() throws IOException {
        FileReader fileReader=new FileReader("/C:\\Users\\chait\\Downloads\\JsonAndXMLReading\\JsonAndXMLReading\\src\\main\\resources\\EntityModel.json");
        System.out.println(fileReader);

        InputStream inputStream=null;
        inputStream=EntityModel.class.getResourceAsStream("/EntityModel.json");

        //EntityModel entityModel=new EntityModel();
        ObjectMapper objectMapper=new ObjectMapper();
        EntityModel entityModel1 = objectMapper.readValue(inputStream, new TypeReference<EntityModel>() {
        });

        if(entityModel1.getId()!=0 && !entityModel1.getName().isEmpty()){
            System.out.println("Deserialized ID: "+entityModel1.getId());
            System.out.println("Deserialized Name: "+entityModel1.getName());
        }
    }
}
