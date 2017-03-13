/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.property;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date : Nov 11, 2015 Time : 9:53:32 AM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class Setting {

    private final Properties properties;

    public Setting() throws IOException {
        properties = new Properties();
        properties.load(new FileReader("./src/com/incosyz/sms/property/sb.properties"));
    }

    public void setProperty(String name, String property) throws IOException {
        properties.setProperty(name, property);
        properties.store(new FileWriter("./src/com/incosyz/sms/property/sb.properties"), "");
    }
    
    public String getProperty(String name) {
        return properties.getProperty(name);
    }
}
