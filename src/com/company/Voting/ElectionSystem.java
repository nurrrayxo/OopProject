package com.company.Voting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ElectionSystem {
    private static ArrayList<Voter> voters = new ArrayList<>();
    private static ArrayList<Candidate> candidates = new ArrayList<>();
    private static HashMap<String, Integer> votes = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Election System!");
        System.out.println("Please select your user type:");
        System.out.println("1. Administrator");
        System.out.println("2. Voter");
        int userType = scanner.nextInt();

        if (userType == 1) {
            // Administrator mode
            System.out.println("Enter the number of candidates:");
            int numCandidates = scanner.nextInt();
            for (int i = 0; i < numCandidates; i++) {
                System.out.println("Enter the name of candidate #" + (i + 1) + ":");
                String name = scanner.next();
                candidates.add(new Candidate(name));
                votes.put(name, 0);
            }

            System.out.println("Candidate list created:");
            for (int i = 0; i < candidates.size(); i++) {
                System.out.println((i + 1) + ". " + candidates.get(i).getName());
            }

            System.out.println("Enter the number of voters:");
            int numVoters = scanner.nextInt();
            for (int i = 0; i < numVoters; i++) {
                System.out.println("Enter the details of voter #" + (i + 1) + ":");
                System.out.print("Name: ");
                String name = scanner.next();
                System.out.print("Age: ");
                int age = scanner.nextInt();
                System.out.print("Address: ");
                String address = scanner.next();
                voters.add(new Voter(name, age, address));
            }

            System.out.println("Voter list created:");
            for (int i = 0; i < voters.size(); i++) {
                System.out.println((i + 1) + ". " + voters.get(i).getName());
            }

            System.out.println("Voting period has started!");
            for (int i = 0; i < voters.size(); i++) {
                System.out.println("Enter the number of the candidate you want to vote for:");
                for (int j = 0; j < candidates.size(); j++) {
                    System.out.println((j + 1) + ". " + candidates.get(j).getName());
                }
                int candidateNum = scanner.nextInt();
                Candidate candidate = candidates.get(candidateNum - 1);
                if (votes.containsKey(candidate.getName())) {
                    votes.put(candidate.getName(), votes.get(candidate.getName()) + 1);
                }
                voters.get(i).vote(candidate);
            }

            System.out.println("Voting period has ended!");
            System.out.println("Vote count:");
            for (int i = 0; i < candidates.size(); i++) {
                Candidate candidate = candidates.get(i);
                System.out.println(candidate.getName() + ": " + votes.get(candidate.getName()) + " votes");
            }
        } else if (userType == 2) {
            // Voter mode
            System.out.println("Please enter your details:");
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            System.out.print("Address: ");
            String address = scanner.next();
            Voter voter = new Voter(name, age, address);

            if (!voters.contains(voter)) {
                System.out.println("You are not registered as a voter. Please contact the administrator.");
            } else if (voter.hasVoted()) {
                System.out.println("You have already voted.");
            } else {
                System.out.println("Voting period has started!");
                System.out.println("Enter the number of the candidate you want to vote for:");
                for (int i = 0; i < candidates.size(); i++) {
                    System.out.println((i + 1) + ". " + candidates.get(i).getName());
                }
                int candidateNum = scanner.nextInt();
                Candidate candidate = candidates.get(candidateNum - 1);
                if (votes.containsKey(candidate.getName())) {
                    votes.put(candidate.getName(), votes.get(candidate.getName()) + 1);
                }
                voter.vote(candidate);
                System.out.println("Thank you for voting!");
            }
        } else {
            System.out.println("Invalid user type selected. Please try again.");
        }
    }
}

