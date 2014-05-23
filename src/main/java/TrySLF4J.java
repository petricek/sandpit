/**
 * Created by vaclav.petricek on 5/9/14.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrySLF4J {
    static final Logger logger = LoggerFactory.getLogger(TrySLF4J.class);

    public static void main(String[] args) {

        logger.info("fyi");
        logger.error("problem");
        logger.warn("careful");
        logger.debug("too much info");

    }
}

