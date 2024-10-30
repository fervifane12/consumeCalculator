package com.consumecalculator.consumeCalculator.Entities;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"user", "date"})})
public class ConsumeMonth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremental
    public int idConsumeMonth;

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "userId")
    private User user;

    @Column(nullable = false)
    private double waterCons;

    @Column(nullable = false)
    private double gasCons;

    @Column(nullable = false)
    private double electricityCons;

    @Column(nullable = false)
    private String date;

    public ConsumeMonth() {
    }

    public ConsumeMonth(User user, double waterCons, double gasCons, double electricityCons, String date) {
        this.user = user;
        this.waterCons = waterCons;
        this.gasCons = gasCons;
        this.electricityCons = electricityCons;
        this.date = date;
    }


    public int getIdConsumeMonth() {
        return idConsumeMonth;
    }

    public void setIdConsumeMonth(int idConsumeMonth) {
        this.idConsumeMonth = idConsumeMonth;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) throws Exception {
        this.user = user;
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
        return "ConsumeMonth{" +
                "idConsumeMonth=" + idConsumeMonth +
                ", user=" + user +
                ", waterCons=" + waterCons +
                ", gasCons=" + gasCons +
                ", electricityCons=" + electricityCons +
                ", date=" + date +
                '}';
    }
}
