package serializationWithJava;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SerializationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private static int staticVariable;
    private int instanceVariable;
}
