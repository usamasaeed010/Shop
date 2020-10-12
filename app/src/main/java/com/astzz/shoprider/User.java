package com.astzz.shoprider;

import android.content.Context;

public class User {

   private String name1;
    private String address1;
    private String phnNumber1;
    private String machine1;
    private String machanic1;

    public User(String name, String address, String phnNumber, String machine, String machanic) {
        this.name1 = name;
        this.address1 = address;
        this.phnNumber1 = phnNumber;
        this.machine1 = machine;
        this.machanic1 = machanic;
    }

    public User() {

    }


    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getPhnNumber1() {
        return phnNumber1;
    }

    public void setPhnNumber1(String phnNumber1) {
        this.phnNumber1 = phnNumber1;
    }

    public String getMachine1() {
        return machine1;
    }

    public void setMachine1(String machine1) {
        this.machine1 = machine1;
    }

    public String getMachanic1() {
        return machanic1;
    }

    public void setMachanic1(String machanic1) {
        this.machanic1 = machanic1;
    }
}
