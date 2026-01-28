package restapipractice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) //part of jackson library which springboot uses for serializing and deserializing.
// purpose to ignore unknown proeprties during desrialization. serialization-> java object to json deserialization-> json to java
public class Request {
    private String name;

    private Data data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
