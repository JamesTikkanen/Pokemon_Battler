package model;

public class Stats {
    private String name;
    private int wins;
    private int losses;

    public Stats(){}

    public Stats(String name, int wins, int losses){
        this.name = name;
        this.wins = wins;
        this.losses = losses;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getWins() { return wins; }
    public void setWins(int wins) { this.wins = wins; }
    public int getLosses() { return losses; }
    public void setLosses(int losses) { this.losses = losses; }
}
