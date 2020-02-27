package example.logback.converter;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.alibaba.fastjson.JSON;
import org.slf4j.helpers.MessageFormatter;

import java.util.stream.Stream;

/**
 * Created by xuelu
 * 2019-07-08.
 */
public class JsonFormatConverter extends MessageConverter {

    @Override
    public String convert(ILoggingEvent event) {
        try {
            return MessageFormatter.arrayFormat(event.getMessage(), Stream.of(event.getArgumentArray())
                    .map(argument -> {
                        if(argument instanceof String){
                            if (argument.equals("xxx")) {
                                return "yyy";
                            }
                            return argument;
                        }
                        return JSON.toJSONString(argument);
                    }).toArray()).getMessage();
        } catch (Exception e) {
            return event.getMessage();
        }
    }


}
