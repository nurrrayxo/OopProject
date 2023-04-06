package com.company.Voting;

import java.util.Objects;

class Voter {
    private String name;
    private int age;
    private String address;
    private Candidate votedFor;

    public Voter(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void vote(Candidate candidate) {
        votedFor = candidate;
    }

    public boolean hasVoted() {
        return votedFor != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voter)) return false;
        Voter voter = (Voter) o;
        return name.equals(voter.name) && address.equals(voter.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
}