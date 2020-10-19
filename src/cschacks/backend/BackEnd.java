package cschacks.backend;

public class BackEnd {
    private Scoreboard scoreboard;
    private boolean areTies;
    private int numInnings;
    private boolean userIsAway;
    private boolean userIsHome;

    public BackEnd() {
        scoreboard = new Scoreboard();
        areTies = true;
        numInnings = 9;
    }
}
