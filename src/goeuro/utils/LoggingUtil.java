package goeuro.utils;

import goeuro.search.sort.GoEuroConstants;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;


// TODO: Auto-generated Javadoc
/**
 * The Class LoggingUtil.
 */
public class LoggingUtil {
		
	 /**
 	 * Creates a java.util.logging.LOGGER
 	 *
 	 * @param classname class defining the LOGGER
 	 * @param filename  log file
 	 * @param append the append
 	 * @return new LOGGER instance
 	 */
    public final static java.util.logging.Logger createLogger(Class classname, String filename,
                                                              boolean append) {

        SimpleDateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
        String date = date_format.format(new Date());
        filename = filename + "." + date;
        String path = GoEuroConstants.user_dir + GoEuroConstants.separator + "logs";
        File file = new File(path);
        if (!file.exists())
            file.mkdirs();

        java.util.logging.Logger LOGGER = null;
        try {
            LOGGER = java.util.logging.Logger.getLogger(classname.getName());

            LOGGER.setLevel(Level.ALL);
            FileHandler handler = new FileHandler(path + GoEuroConstants.separator + filename
                    + ".txt", append);

            handler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(handler);
            LOGGER.setUseParentHandlers(false);
        } catch (SecurityException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

        return LOGGER;
    }


}
