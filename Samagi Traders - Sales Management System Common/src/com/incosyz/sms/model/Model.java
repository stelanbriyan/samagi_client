/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.incosyz.sms.model;

import java.io.Serializable;

/**
 * Date : Oct 30, 2015
 * Time : 6:18:29 PM
 * @copyright INCOSYZ
 * @author Stelan
 */
public class Model implements Serializable{
    private String modelId;
    private String modelName;

    /**
     * @return the modelId
     */
    public String getModelId() {
        return modelId;
    }

    /**
     * @param modelId the modelId to set
     */
    public Model setModelId(String modelId) {
        this.modelId = modelId;
        return this;
    }

    /**
     * @return the modelName
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * @param modelName the modelName to set
     */
    public Model setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }
    
}
