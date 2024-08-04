package CreateDTOAndReadUsingFileStreams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model {
    private int id;
    private String fruitName;
    private String fruitSerialNumber;
}
