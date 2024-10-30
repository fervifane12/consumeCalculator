package com.consumecalculator.consumeCalculator.DTO;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

@Component
public class ConsumeMonthDTO{

    public String userId;
    public int idConsumeMonth;
    public double waterCons;
    public double gasCons;
    public double electricityCons;
    public String date;



    public ConsumeMonthDTO() {
    }

    public ConsumeMonthDTO(String userId, int idConsumeMonth, double waterCons, double gasCons, double electricityCons, String date) {
        this.userId = userId;
        this.idConsumeMonth = idConsumeMonth;
        this.waterCons = waterCons;
        this.gasCons = gasCons;
        this.electricityCons = electricityCons;
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getIdConsumeMonth() {
        return idConsumeMonth;
    }

    public void setIdConsumeMonth(int idConsumeMonth) {
        this.idConsumeMonth = idConsumeMonth;
    }

    public double getWaterCons() {
        return waterCons;
    }

    public void setWaterCons(double waterCons) {
        this.waterCons = waterCons;
    }

    public double getGasCons() {
        return gasCons;
    }

    public void setGasCons(double gasCons) {
        this.gasCons = gasCons;
    }

    public double getElectricityCons() {
        return electricityCons;
    }

    public void setElectricityCons(double electricityCons) {
        this.electricityCons = electricityCons;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ConsumeMonthDTO{" +
                "userId='" + userId + '\'' +
                ", idConsumeMonth=" + idConsumeMonth +
                ", waterCons=" + waterCons +
                ", gasCons=" + gasCons +
                ", electricityCons=" + electricityCons +
                ", date='" + date + '\'' +
                '}';
    }
}
