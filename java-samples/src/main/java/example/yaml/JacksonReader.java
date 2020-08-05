package example.yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by xuelu
 * 2020-07-24.
 */
public class JacksonReader {

    public static void main(String[] args) throws IOException {

        File file = new File("/Users/xuelu/git/apps/java-samples/src/main/resources/my-yaml.yaml");
        final ObjectMapper mapper = new ObjectMapper(new YAMLFactory()); // jackson databind

        MyYamlFile myYamlFile = mapper.readValue(file, MyYamlFile.class);
        System.out.println(myYamlFile);

    }
}
