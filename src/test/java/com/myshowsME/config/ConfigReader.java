package com.myshowsME.config;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties props = new Properties();

    static {
        var input = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.properties");

        if (input == null) {
            throw new IllegalStateException("config.properties не найден в src/test/resources!");
        }

        try (input) {
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения config.properties", e);
        }
    }

    public static String getUrl() {
        return props.getProperty("base.url");
    }

    public static String getRealLogin() {return props.getProperty("real.login");}
    public static String getRealEmail() {return props.getProperty("real.email");}

    public static String getRealPassword() {return props.getProperty("real.passsword");}


    public static String getRealTrackCode(){
        return props.getProperty("real.trackCode");
    }

    public static String buildUrl(String endpoint){
        var baseUrl = getUrl();
        if(endpoint.startsWith("/")){
            return baseUrl + endpoint;
        } else{
            return baseUrl + "/" + endpoint;
        }
    }
}
