package utility;

import org.apache.logging.log4j.*;
import java.io.*;
import java.util.*;

public class PropertyManager {


    private static final Logger logger = LogManager.getLogger( PropertyManager.class.getSimpleName() );
    private static final Properties properties = new Properties();

    public PropertyManager(String testDataFileName) {
        loadProperties( System.getProperty( "test.data.folder" ) + testDataFileName );
    }

    public static String getProperty(String propertyName) {
        return properties.getProperty( propertyName );
    }

    private void loadProperties(String filePath) {
        logger.info( "Trying to access property file: " + filePath );
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream( filePath )) {
            properties.load( inputStream );
        } catch (Exception e) {
            logger.error( "Property file with path: " + filePath + " cannot be opened" );
            LogUtil.logStackTrace( e , logger );
        }
    }
}
