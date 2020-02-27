package example.logback.filters;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.spi.FilterReply;
import org.slf4j.Marker;

/**
 * Created by xuelu
 * 2019-07-08.
 */
public class SampleTurboFilter extends TurboFilter {

    @Override
    public FilterReply decide(Marker marker, Logger logger, Level level, String format, Object[] params, Throwable t) {
        if (params != null) {
            params[0] = "xuelu111";
        }
        return FilterReply.NEUTRAL;
    }
}
