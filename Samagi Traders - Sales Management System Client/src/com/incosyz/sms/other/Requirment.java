/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.other;

import com.incosyz.sms.model.CashModel;
import com.incosyz.sms.model.CheckModel;
import com.incosyz.sms.model.LeasingModel;
import java.util.ArrayList;

/**
 * Date : Nov 19, 2015 Time : 10:30:27 AM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class Requirment {

    double cash = 0;
    double cheque = 0;
    double leasing = 0;

    public Requirment(ArrayList<CashModel> cashModels, ArrayList<CheckModel> checkModels, LeasingModel leasingModel) {
        if (cashModels != null) {
            for (CashModel cashAmount : cashModels) {
                cash += Double.parseDouble(cashAmount.getCashAmount());
            }
        }
        if (checkModels != null) {

            for (CheckModel checkModel : checkModels) {
                cheque += Double.parseDouble(checkModel.getAmount());
            }

        }
        if (leasingModel != null) {
            leasing += Double.parseDouble(leasingModel.getLeasingAmount());
        }
    }

    public double getTotalAmount() {
        return cash + cheque + leasing;
    }

    public double getChequeAmount() {
        return cheque;
    }

    public double getCashAmount() {
        return cash;
    }

    public double getLeasing() {
        return leasing;
    }
}
