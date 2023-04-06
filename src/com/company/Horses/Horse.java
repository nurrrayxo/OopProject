package com.company.Horses;

class Horse {
    private String name; // Имя лошади
    private double odds; // Коэффициент выплаты
    private double minBet; // Минимальная сумма ставки


    public Horse(String name, double odds, double minBet) {
        this.name = name;
        this.odds = odds;
        this.minBet = minBet;
    }

    public String getName() {
        return name;
    }

    public double getOdds() {
        return odds;
    }

    public double getMinBet() {
        return minBet;
    }
}
