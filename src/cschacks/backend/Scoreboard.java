package cschacks.backend;

public class Scoreboard
{
    private int inning;
    private boolean isBottom;
    private int balls;
    private int strikes;
    private int outs;
    private int awayRuns;
    private int awayHits;
    private int awayErrors;
    private int homeRuns;
    private int homeHits;
    private int homeErrors;
    private boolean runnerOnFirst;
    private boolean runnerOnSecond;
    private boolean runnerOnThird;

    public Scoreboard ()
    {
        inning = 9;
        isBottom = true;
        balls = 3;
        strikes = 2;
        outs = 2;
        awayRuns = 0;
        awayHits = 0;
        awayErrors = 0;
        homeRuns = 0;
        homeHits = 0;
        homeErrors = 0;
        runnerOnFirst = true;
        runnerOnSecond = true;
        runnerOnThird = true;
    }

    public void endOfHalfInning()
    {
        outs = 0;
        if (isBottom)
        {
            inning++;
            isBottom = false;
        }
        else
          isBottom = true;
    }

    public void addBall()
    {
        balls++;
        // Walk
        if (balls == 4)
            resetCount();
    }

    public void addStrike()
    {
        strikes++;
        if (strikes == 3)
        {
            addOut();
            resetCount();
        }
    }

    public void addOut() {
        outs++;
        if (outs == 3) {
            resetCount();
            endOfHalfInning();
        }
    }

    public void resetCount()
    {
        balls = 0;
        strikes = 0;
    }

    public int getBalls() {
        return balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getOuts() {
        return outs;
    }

    public void setRunnerOnFirst() {
        runnerOnFirst = true;
    }

    public void setRunnerOnSecond() {
        runnerOnSecond = true;
    }

    public void setRunnerOnThird() {
        runnerOnThird = true;
    }

    public void clearRunnerOnFirst() {
        runnerOnFirst = false;
    }

    public void clearRunnerOnSecond() {
        runnerOnSecond = false;
    }

    public void clearRunnerOnThird() {
        runnerOnThird = false;
    }

    public boolean getRunnerOnFirst() {
        return runnerOnFirst;
    }

    public boolean getRunnerOnSecond() {
        return runnerOnSecond;
    }

    public boolean getRunnerOnThird() {
        return runnerOnThird;
    }

    public void addAwayRun() {
        awayRuns++;
    }

    public void addAwayHit() {
        awayHits++;
    }

    public void addAwayError() {
        awayErrors++;
    }

    public void addHomeRun() {
        homeRuns++;
    }

    public void addHomeHit() {
        homeHits++;
    }

    public void addHomeError() {
        homeErrors++;
    }

    public int getAwayRuns() {
        return awayRuns;
    }

    public int getAwayHits() {
        return awayHits;
    }

    public int getAwayErrors() {
        return awayErrors;
    }
}
