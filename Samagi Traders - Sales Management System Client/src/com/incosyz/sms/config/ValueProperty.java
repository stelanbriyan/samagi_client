/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.config;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Date : Nov 20, 2015 Time : 4:19:38 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class ValueProperty {

    private final Properties properties;

    public ValueProperty() throws IOException {
        this.properties = new Properties();
        properties.load(new FileReader("./src/com/incosyz/sms/config/value.properties"));
    }

    public void setProperty(String name, String property) throws IOException {
        properties.setProperty(name, property);
        properties.store(new FileWriter("./src/com/incosyz/sms/config/value.properties"), "");
    }

    public String getProperty(String name) {
        return properties.getProperty(name);
    }

}
