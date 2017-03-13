/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.mixmodel;

import com.incosyz.sms.model.BatchModel;
import com.incosyz.sms.model.BikeModel;
import com.incosyz.sms.model.Model;
import java.io.Serializable;

/**
 * Date : Nov 13, 2015 Time : 4:32:34 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class GETStock implements Serializable {

    private StockModel stockModel;
    private BikeModel bikeModel;
    private Model model;
    private BatchModel batchModel;

    /**
     * @return the stockModel
     */
    public StockModel getStockModel() {
        return stockModel;
    }

    /**
     * @param stockModel the stockModel to set
     */
    public GETStock setStockModel(StockModel stockModel) {
        this.stockModel = stockModel;
        return this;
    }

    /**
     * @return the bikeModel
     */
    public BikeModel getBikeModel() {
        return bikeModel;
    }

    /**
     * @param bikeModel the bikeModel to set
     */
    public GETStock setBikeModel(BikeModel bikeModel) {
        this.bikeModel = bikeModel;
        return this;
    }

    /**
     * @return the model
     */
    public Model getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public GETStock setModel(Model model) {
        this.model = model;
        return this;
    }

    /**
     * @return the batchModel
     */
    public BatchModel getBatchModel() {
        return batchModel;
    }

    /**
     * @param batchModel the batchModel to set
     */
    public GETStock setBatchModel(BatchModel batchModel) {
        this.batchModel = batchModel;
        return this;
    }
}
