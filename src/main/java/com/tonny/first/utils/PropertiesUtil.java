package com.tonny.first.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class PropertiesUtil {
    private ResourceBundle resourceBundle;
    private final  String filename;
    public PropertiesUtil(String filename)
    {
        this.filename=filename;
        Locale locale=new Locale("zh","cn");
        this.resourceBundle=ResourceBundle.getBundle(filename);

    }
    public String getValue(String key)
    {
        String Message =this.resourceBundle.getString(key);
        return Message;
    }

}
