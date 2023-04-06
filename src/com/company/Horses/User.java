package com.company.Horses;

import java.util.ArrayList;
import java.util.List;

class User {
    public static final double STARTING_BALANCE = 1000; // Начальный баланс игрока


    private String name;        // Имя игрока
    private double balance;     // Баланс игрока
    private List<Bet> bets;     // Список ставок игрока

    public User(String name) {
        this.name = name;
        this.balance = STARTING_BALANCE;
        this.bets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    public void placeBet(Bet bet) {
        bets.add(bet);
        balance -= bet.getAmount();
    }

    public List<Bet> getBets() {
        return bets;
    }
}
