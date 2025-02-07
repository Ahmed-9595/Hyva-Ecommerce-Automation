package com.revton.qa.utils;

import java.util.Properties;

public class ConfigUtils {
    private final Properties properties;
    private static ConfigUtils configUtils;
    private ConfigUtils(){
        // Availability to Handle Different Environments
        String environment = System.getProperty("environment","production");
        switch (environment) {
            case "production" ->
                    properties = new PropertiesUtils().propertiesLoad("src/main/java/com/revton/qa/config/hyvaApp.properties");
            default -> throw new RuntimeException("the env doesn't exist");
        }
    }
    public static ConfigUtils getInstance(){
        if (configUtils==null){
            configUtils= new ConfigUtils();
        }
        return configUtils;

    }
    public String getBaseUrl(){
        // Load BaseUrl from Property file
        String property = properties.getProperty("BaseUrl");
        if (property!=null){
            return property;}
        throw new RuntimeException("base Url doesn't exist");
    }

}
