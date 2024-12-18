package com.enigmacamp.model;

public class Nasabah {
    private String name;
    private Integer age;
    private Double balance;
    private String creditStat;
    private Integer howLong;

    public Nasabah(String name, Integer age, Double balance, String kreditStat, Integer howLong) {
        this.name = name;
        this.age = age;
        this.balance = balance;
        this.creditStat = kreditStat;
        this.howLong = howLong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getKreditStat() {
        return creditStat;
    }

    public void setKreditStat(String kreditStat) {
        this.creditStat = kreditStat;
    }

    public Integer getHowLong() {
        return howLong;
    }

    public void setHowLong(Integer howLong) {
        this.howLong = howLong;
    }

    @Override
    public String toString() {
        return "Nasabah{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", balance=" + balance +
                ", kreditStat='" + creditStat + '\'' +
                ", howLong=" + howLong +
                '}';
    }
}
