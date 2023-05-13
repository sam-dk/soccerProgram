import java.util.*;
import java.io.*;

/**
    soccerProgram class that will take a list of soccer teams and display the rankings of the soccer teams
*/
public class soccerProgram
{
    /**
        Returns an array of SoccerTeam objects that were listed in a file
        @param filename The name of the file containing the soccer teams
    */
    public static SoccerTeam[] createArray(String filename)
    {
        int numOfTeams = 0; //number of teams
        int n = 0; //loop variable
        String line = ""; 
        String team = "";
        int wins, losses, draws;
        wins = 0; losses = 0; draws = 0;
        SoccerTeam[] array = new SoccerTeam[1]; //intializes array with an array of 1 SoccerTeam object

        try
        {
            File file = new File(filename);
            Scanner infile = new Scanner(file);

            numOfTeams = Integer.parseInt(infile.next()); //grabs number of teams from file
            array = new SoccerTeam[numOfTeams]; //array references an array of SoccerTeam objects with size of numOfTeams
            infile.nextLine();
            
            while(infile.hasNextLine()) //while not end of file, keeps reading nextLine from file
            {
                line = infile.nextLine();
                Scanner inline = new Scanner(line); //creates a new Scanner from the line that was grabbed from file
                inline.useDelimiter(", "); //used a new delimiter for next() calls

                //takes the information of the line and splits it up into team, wins, draws, and losses
                team = inline.next();
                wins = Integer.parseInt(inline.next());
                draws = Integer.parseInt(inline.next());
                losses = Integer.parseInt(inline.next());

                if(n != numOfTeams) //while n != numOfTeams will add a new SoccerTeam object to the array
                {    
                    array[n] = new SoccerTeam(team, wins, draws, losses);
                    n++;
                } 
            }
            
            infile.close(); //closes file
        }
        catch(Exception e) //catch any exception and displays an error message
        {
            System.out.println("ERROR HAS OCCURRED");
        }
        return array; //returns the array
    }

    /**
        Returns the partition index of the array. This method is used by the quicksort method.
        @param l The lowest index of array
        @param h The highest index of array
        @param array The array that is being partitioned
        @return The partition index of the array
    */
    public static int partition(int l, int h, SoccerTeam[] array)
    {
        SoccerTeam pivotItem = array[l]; //pivotItem equals SoccerTeam obj at lowest index
        int j = l; //j equals the lowest index
        SoccerTeam hold = new SoccerTeam(); //initializes hold to be used when swapping SoccerTeam objects

        for(int i = l+1; i <= h; i++)
        {
            if(array[i].compareTo(pivotItem) == 1) //compares two SoccerTeam objects
            {
                //if SoccerTeam at i has more total points, than SoccerTeam at pivotItem
                j++; //increase j --> which will increase pivotPoint (partition index), see code after for loop

                //swaps the SoccerTeam objects at indices i and j
                hold = array[j]; 
                array[j] = array[i];
                array[i] = hold;
            }
        }

        int pivotPoint = j; //pivotPoint (partition index) equals j

        //swaps the SoccerTeam objects at indices l(lowest index) and pivotPoint
        hold = array[pivotPoint];
        array[pivotPoint] = array[l];
        array[l] = hold;

        return pivotPoint; //returns pivotPoint (partition index)
    }

    /**
        Sorts the array of SoccerTeam objects listed as an argument using the quicksort algorithm
        @param l The lowest index of array
        @param h The highest index of array
        @param array The array of SoccerTeam objects that is to be sorted
    */
    public static void quickSort(int l, int h, SoccerTeam[] array)
    {
        int pivotPoint = 0; //initializes pivotPoint equal to 0

        if(h > l) //if the highest index is greater than the lowest index
        {
            pivotPoint = partition(l, h, array); //pivotPoint equals the partition index of array
            quickSort(l, pivotPoint-1, array); //calls quickSort with indices to the left of pivotPoint
            quickSort(pivotPoint+1, h, array); //calls quickSort with indices to the right of pivotPoint
        }        

    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String filename = in.next(); //user inputs filename
        
        SoccerTeam[] array = createArray(filename); //creates array of SoccerTeam objects from user file

        quickSort(0, array.length-1, array); //calls quickSort(lowest index, highest index, array)
        
        //displays the rankings of the soccer teams listed in the user file
        for(int i = 0; i < array.length; i++)
            System.out.println(array[i]);
    }
}