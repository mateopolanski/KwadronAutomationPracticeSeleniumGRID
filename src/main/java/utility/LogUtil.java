package utility;

import org.apache.logging.log4j.*;

import java.io.*;

public class LogUtil {

    public static void logStackTrace(Throwable e, Logger logger){

        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        logger.error(stringWriter.toString());
    }

}