package com.company.Horses;

class Bet {
    private Horse horse; // Лошадь, на которую сделана ставка
    private double amount; // Сумма ставки


    public Bet(Horse horse, double amount) {
        this.horse = horse;
        this.amount = amount;
    }

    public Horse getHorse() {
        return horse;
    }

    public double getAmount() {
        return amount;
    }
}