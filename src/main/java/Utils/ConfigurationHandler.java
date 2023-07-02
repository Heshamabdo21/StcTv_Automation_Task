
/*
 * Copyright (c) 2023.
 * Hesham Abd Elhamed Gharib
 */

package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigurationHandler implements Configuration {

    @Override
    public Properties load(String filename) {
        Log.info("Reading configuration from file " + filename);
        Properties props = new Properties();
        try {
            String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + filename;
            props.load(new FileInputStream(path));
        } catch (FileNotFoundException e) {
            Log.debug(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            Log.debug(e.getMessage());
        }

        return props;
    }


}
