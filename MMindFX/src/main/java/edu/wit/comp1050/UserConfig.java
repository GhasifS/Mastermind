package edu.wit.comp1050;

import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.*;

public class UserConfig {

    private static UserConfig instance;
    private FileBasedConfiguration configuration;

    private UserConfig() {
        Parameters params = new Parameters();
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                        .configure(params.properties()
                                .setFileName("src/main/resources/config.properties"));
        try {
            configuration = builder.getConfiguration();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static synchronized UserConfig getInstance() {
        if (instance == null) {
            instance = new UserConfig();
        }
        return instance;
    }

    public String getProperty(String key) {
        UserConfig uc = new UserConfig();
        return (String) uc.configuration.getProperty(key);
    }

    public static void modifyLine(String config, String value) {
        try {
            BufferedReader file = new BufferedReader(new FileReader("src/main/resources/config.properties"));
            StringBuilder inputBuffer = new StringBuilder();
            String line;
            while ((line = file.readLine()) != null) {
                if (line.contains(config)) {
                    inputBuffer.append(config).append(" = ").append(value);
                    inputBuffer.append('\n');
                } else {
                    inputBuffer.append(line);
                    inputBuffer.append('\n');
                }
            }
            file.close();
            FileOutputStream fileOut = new FileOutputStream("src/main/resources/config.properties");
            fileOut.write(inputBuffer.toString().getBytes());
            fileOut.close();
        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }
    }

    public static void resetDefault() {
        try {
            FileOutputStream fileOut = new FileOutputStream("src/main/resources/config.properties");
            String inputBuffer = "# Mastermind Properties File (mmind.properties)\n" +
                    "codeSize = 4\n" +
                    "codePegRows = 10\n" +
                    "dupesAllowedInCode = true\n" +
                    "blanksAllowedInCode = false\n" +
                    "maxTime = 0\n" +
                    "playSounds = true\n";
            fileOut.write(inputBuffer.getBytes());
            fileOut.close();
        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }
    }
}