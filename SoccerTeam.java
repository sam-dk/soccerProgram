/**
    SoccerTeam class that will keep track of a soccer team's name, number of wins,
    number of draws, and number of losses. The class will also calculate and track
    the teams total number of points.
*/
public class SoccerTeam implements Comparable<SoccerTeam>
{
    //instance variables
    private String teamName; //team name
    private int wins; //number of wins
    private int draws; //number of draws
    private int losses; //number of losses
    private int totalPoints; //total points of team

    /**
        Initializes SoccerTeam
    */
    public SoccerTeam()
    {}

    /**
        Initializes SoccerTeam from argument variables
        @param team The name of the soccer team
        @param w The number of wins
        @param d The number of draws
        @param l The number of losses
    */
    public SoccerTeam(String team, int w, int d, int l)
    {
        teamName = team;
        wins = w;
        draws = d;
        losses = l;
        totalPoints = (w*3) + d; //calculates total points
    }

    /**
        Sets team name of SoccerTeam
        @param team The name of the soccer team
    */
    public void setTeamName(String team)
    {
        teamName = team;
    }

    /**
        Sets the number of wins of SoccerTeam
        @param w The number of wins the soccer team has
    */
    public void setWins(int w)
    {
        wins = w;
    }

    /**
        Sets the number of draws of SoccerTeam
        @param d The number of draws the soccer team has
    */
    public void setDraws(int d)
    {
        draws = d;
    }
    
    /**
        Sets the number of losses of SoccerTeam
        @param l The number of losses the soccer team has
    */
    public void setLosses(int l)
    {
        losses = l;
    }

    /**
        Returns the team name of SoccerTeam
        @return The team name of the soccer team
    */
    public String getTeamName(String team)
    {
        return teamName;
    }

    /**
        Returns the number of wins of SoccerTeam
        @return The number of wins the soccer team has
    */
    public int getWins()
    {
        return wins;
    }

    /**
        Returns the number of draws of SoccerTeam
        @return The number of draws the soccer team has
    */
    public int getDraws()
    {
        return draws;
    }

    /**
        Returns the number of losses of SoccerTeam
        @return The number of losses the soccer team has
    */
    public int getLosses()
    {
        return losses;
    }

    /**
        Returns the total points of SoccerTeam
        @return The total points the soccer team has
    */
    public int getTotalPoints()
    {
        return totalPoints;
    }

    /**
        Returns the string of a SoccerTeam object
        @return The string of a SoccerTeam object
    */
    public String toString()
    {
        String str = String.format("%-15s  %2d  %2d  %2d  %2d", teamName, wins, draws, losses, totalPoints);
        return str;
    }


    /**
        Returns true if argument is a SoccerTeam object, false if not
        @return True if o is a SoccerTeam object, false if not
    */
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof SoccerTeam)
            return true;
        return false;
    }

    /**
        Returns 1 if this SoccerTeam has more total points, returns -1 if not. If
        both SoccerTeam objects have the same total points, will then compare the
        number of wins. Will return 1 if this SoccerTeam has more wins, returns -1 if not.
        @return 1 if this SoccerTeam is greater than other SoccerTeam, returns -1 if not
    */
    @Override
    public int compareTo(SoccerTeam other)
    {
        if(totalPoints > other.totalPoints)
            return 1;
        if(totalPoints < other.totalPoints)
            return -1;
        if(totalPoints == other.totalPoints)
        {
            if(wins > other.wins)
                return 1;
            else
                return -1;
        }
        return 0;
    }


}