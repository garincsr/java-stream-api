package com.enigmacamp.service;

import com.enigmacamp.model.Nasabah;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NasabahService {
    List<Nasabah> nasabah = new ArrayList<>();

    public void addNasabah(){
        this.nasabah.add(new Nasabah("Garin Caesar", 22, 2300000.0, "Baik", 10));
        this.nasabah.add(new Nasabah("Prabowo Subiyono", 73, 500000.0, "Netral", 32));
        this.nasabah.add(new Nasabah("Lione Messi", 33, 1000000.0, "Buruk", 2));
        this.nasabah.add(new Nasabah("Michael De'Santa", 50, 50000.0, "Baik", 43));
        this.nasabah.add(new Nasabah("Kurt Cobaan", 32, 10000.0, "Buruk", 5));
        this.nasabah.add(new Nasabah("Kevin Love", 40, 2300000.0, "Netral", 1));
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

    public void creditStat(){
        System.out.println("=============================== Credit Status ===============================");
        this.nasabah.stream()
                .filter(nasabah -> nasabah.getKreditStat().contains("Baik"))
                .forEach(s -> System.out.println(s));
        this.nasabah.stream()
                .filter(nasabah -> nasabah.getKreditStat().contains("Netral"))
                .forEach(s -> System.out.println(s));
        this.nasabah.stream()
                .filter(nasabah -> nasabah.getKreditStat().contains("Buruk"))
                .forEach(s -> System.out.println(s));
    }

    public void findTopBalance(){
        System.out.println("=============================== Top Balance ===============================");
        double maxBalance = this.nasabah.stream()
                .mapToDouble(Nasabah::getBalance)
                .max()
                .orElse(0.0);

        Predicate<Nasabah> checkMax = balance -> {
            if (balance.getBalance() == maxBalance){
                return true;
            } else {
                return false;
            }
        };

        this.nasabah.stream()
                .sorted(Comparator.comparing(Nasabah::getBalance).reversed())
                .filter(checkMax)
                .forEach(item -> System.out.println("Pemilik saldo tertinggi adalah " + item.getName() + " " +
                        "dengan saldo sebesar Rp. " + String.format("%,.2f", item.getBalance())));

//        System.out.println("Saldo tertinggi adalah Rp." + String.format("%,.2f", topBalance));

//        List<Nasabah> maxNasabahList = this.nasabah.stream()
//                .filter(nasabah -> nasabah.getBalance() == topBalance)
//                .collect(Collectors.toList());
//        System.out.println(maxNasabahList);

//        if (!maxNasabahList.isEmpty()) {
//            System.out.println("Nasabah dengan saldo maksimum: ");
//            maxNasabahList.forEach(nasabah -> {
//                System.out.println("Nama: " + nasabah.getName());
//                System.out.println("Saldo: Rp " + String.format("%,.2f", nasabah.getBalance()));
//                System.out.println("-------------");
//            });
//        } else {
//            System.out.println("Tidak ada nasabah.");
//        }
    }

    public void findLowBalance(){
        System.out.println("=============================== Low Balance ===============================");
        this.nasabah.stream()
                .sorted(Comparator.comparing(Nasabah::getBalance))
                .limit(1)
                .forEach(item -> System.out.println("Pemilik saldo terendah adalah " + item.getName() + " " +
                        "dengan saldo sebesar Rp. " + String.format("%,.2f", item.getBalance())));

    }

    public void findTheOldest(){
        System.out.println("=============================== The Oldest ===============================");
        this.nasabah.stream()
                .sorted(Comparator.comparing(Nasabah::getAge).reversed())
                .limit(1)
                .forEach(item -> System.out.println("Nasabah tertua adalah " + item.getName() + " " +
                        "dengan usia " + item.getAge()));

    }

    public void findTheYoungest(){
        System.out.println("=============================== The Youngest ===============================");
        this.nasabah.stream()
                .sorted(Comparator.comparing(Nasabah::getAge))
                .limit(1)
                .forEach(item -> System.out.println("Nasabah termuda adalah " + item.getName() + " " +
                        "dengan usia " + item.getAge()));
    }

    public void findTheMostLoyal(){
        System.out.println("=============================== The Loyal ===============================");
        this.nasabah.stream()
                .sorted(Comparator.comparing(Nasabah::getHowLong).reversed())
                .limit(1)
                .forEach(item -> System.out.println("Nasabah paling loyal adalah" + item.getName() + "" +
                        ", sudah menjadi customer selama " + item.getHowLong() + " tahun"));
    }

    public void categoryByBalance(){
        System.out.println("=============================== Category ===============================");
        this.nasabah.stream()
                .filter(nasabah -> nasabah.getBalance() < 1000000.0)
                .forEach($ -> System.out.println("Nasabah dengan saldo dibawah 1 juta: " + $));
        this.nasabah.stream()
                .filter(nasabah -> nasabah.getBalance() >= 1000000.0 || nasabah.getBalance() == 10000000.0)
                .forEach($ -> System.out.println("Nasabah dengan saldo diantara 1 juta sampai 10 juta: " + $));
        this.nasabah.stream()
                .filter(nasabah -> nasabah.getBalance() > 10000000.0)
                .forEach($ -> System.out.println("Nasabah dengan saldo diatas 10 juta: " + $));
    }
}
