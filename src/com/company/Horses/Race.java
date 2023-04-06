package com.company.Horses;

import java.util.*;

class Race {
    private List<Horse> horses; // Список лошадей в заезде
    private Horse winner; // Победитель заезда


    public Race(List<Horse> horses) {
        this.horses = horses;
    }

    public void start() {
        // Генерируем случайное число от 0 до 1 для каждой лошади
        Random random = new Random();
        Map<Horse, Double> distances = new HashMap<>();
        for (Horse horse : horses) {
            double distance = random.nextDouble();
            distances.put(horse, distance);
        }

        // Выбираем лошадь с наибольшим расстоянием
        winner = Collections.max(distances.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public Horse getWinner() {
        return winner;
    }
}