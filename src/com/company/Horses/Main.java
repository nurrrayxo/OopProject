package com.company.Horses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
// Создаем список лошадей
            List<Horse> horses = new ArrayList<>();
            horses.add(new Horse("Horse 1", 1.5, 50));
            horses.add(new Horse("Horse 2",2.0,50));
            List<User> users = new ArrayList<>();
            users.add(new User("Player 1"));
            users.add(new User("Player 2"));


            // Показываем список лошадей и их характеристики
            System.out.println("List of horses:");
            for (Horse horse : horses) {
                System.out.println(horse.getName() + " (coefficient " + horse.getOdds() + ", minimal bet" + horse.getMinBet() + ")");
            }

            // Проходим по каждому игроку и позволяем ему сделать ставки
            for (User user : users) {
                System.out.println("Player " + user.getName() + ", your balance: " + user.getBalance());
                Scanner scanner = new Scanner(System.in);
                for (Horse horse : horses) {
                    System.out.println("Enter amount of bet " + horse.getName() + " (minimal bet " + horse.getMinBet() + "):");
                    double amount = scanner.nextDouble();
                    if (amount >= horse.getMinBet() && amount <= user.getBalance()) {
                        user.placeBet(new Bet(horse, amount));
                    } else {
                        System.out.println("Bet is not correct. Try again");
                    }
                }
            }

            // Запускаем заезд
            Race race = new Race(horses);
            race.start();

            // Показываем результаты заезда
            System.out.println("The winner is " + race.getWinner().getName() + "!");

            // Рассчитываем и показываем выигрыши
            for (User user : users) {
                double totalWin = 0;
                for (Bet bet : user.getBets()) {
                    if (bet.getHorse() == race.getWinner()) {
                        double win = bet.getAmount() * bet.getHorse().getOdds();
                        totalWin += win;
                        user.addBalance(win);
                        System.out.println("Player " + user.getName() + ", your horse " + bet.getHorse().getName() + " is winner! You get " + win + ".");
                    }
                }
                if (totalWin == 0) {
                    System.out.println("Player " + user.getName() + ", you lost.");
                } else {
                    System.out.println("Player " + user.getName() + ", your win: " + totalWin + ".Your new balance: " + user.getBalance());
                }
            }
        }
}

