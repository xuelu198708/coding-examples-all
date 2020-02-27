package example.logback.filters;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * Created by xuelu
 * 2019-07-08.
 */
public class SampleFilter extends Filter<LoggingEvent> {

    @Override
    public FilterReply decide(LoggingEvent event) {
        return FilterReply.ACCEPT;
    }
}
