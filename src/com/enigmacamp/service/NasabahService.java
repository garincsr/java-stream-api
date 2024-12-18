package com.enigmacamp.service;

import com.enigmacamp.model.Nasabah;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NasabahService {
    List<Nasabah> nasabah = new ArrayList<>();

    public void addNasabah(){
        this.nasabah.add(new Nasabah("Garin Caesar", 22, 1000000.0, "Baik", 10));
        this.nasabah.add(new Nasabah("Prabowo Subiyono", 73, 500000.0, "Netral", 32));
        this.nasabah.add(new Nasabah("Lione Messi", 33, 1000000.0, "Buruk", 2));
    }

    public void readAllNasabah(){
        this.nasabah.stream().toList().forEach(System.out::println);
    }

    public void allNasabahAverageBalance(){
        System.out.println("=============================== All Nasabah's Average Balance ===============================");
        double averageBalance = this.nasabah.stream()
                .mapToDouble(nasabah -> nasabah.getBalance())
                .average()
                .orElse(0.0); //terminate operation, i didnt want to make list
        System.out.println("Average Balance from All Nasabah: Rp. " + String.format("%,.2f", averageBalance));

    }
}
