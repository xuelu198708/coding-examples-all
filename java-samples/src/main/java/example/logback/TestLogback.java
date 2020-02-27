package example.logback;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xuelu
 * 2019-07-08.
 */
public class TestLogback {

    private static Logger logger = LoggerFactory.getLogger(TestLogback.class);

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("xxx");
        person.setAddress("aaaa");
        logger.info("person: {}", person);
        logger.info("xxx: {}", "xxx");
    }

    @Data
    private static class Person{
        private String name;
        private String address;
    }
}
