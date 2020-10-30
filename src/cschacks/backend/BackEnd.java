package cschacks.backend;

public class BackEnd
{
    private Scoreboard scoreboard;
    private boolean areTies;
    private int numInnings;
    private boolean userIsAway;
    private boolean userIsHome;

    private int gameStatus;

    public BackEnd()
    {
        scoreboard = new Scoreboard();
        areTies = true;
        numInnings = 9;
	      userIsHome = true;
        userIsHome = false;
        gameStatus = 0;
    }

    public BackEnd(boolean areTies, int numInnings, boolean userIsAway, boolean userIsHome)
    {
	     this.areTies = areTies;
	     this.numInnings = numInnings;
	     this.userIsAway = userIsAway;
       this.userIsHome = userIsHome;
       gameStatus = 0;
    }

    public Scoreboard getScoreboard()
    {
	     return scoreboard;
    }

    public boolean ties()
    {
	     return areTies;
    }

    public void setTiesToTrue()
    {
	     areTies = true;
    }

    public void setTiesToFalse()
    {
	     areTies = false;
    }

    public int getInnings()
    {
	     return numInnings;
    }

    public void changeInnings(int i)
    {
	     if (i < 3 || i > 9)
       {
	        System.out.println("Invalid innings");
	      }
       else
       {
	        numInnings = i;
	      }
    }

    public boolean userIsAway()
    {
	     return userIsAway;
    }

    public boolean userIsHome()
    {
	     return userIsHome;
    }

    public void setUserToHome()
    {
	     userIsHome = true;
    }

    public void setUserToAway()
    {
	     userIsAway = true;
    }

    public void removeUserFromHome()
    {
	     userIsHome = false;
    }

    public void removeUserFromAway()
    {
	     userIsAway = false;
    }

    public int getStatus() {
        return gameStatus;
    }

    public void modifyStatus(int s) {
      gameStatus = s;
    }
}
