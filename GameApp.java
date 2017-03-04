/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2016 
// PROJECT:          Program2
// FILE:             GameApp.java
//
// TEAM:    (Team 17, MAVSYR)
// Author1: (Michael Osmian,Osmian@wisc.edu,osmian,001)
// Author2: (Yuqi Wei)
//
// ---------------- OTHER ASSISTANCE CREDITS 
// Persons: N/A
// 
// Online sources:N/A
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.Scanner;

/**
 *This is the main class that starts the program execution and starts 
 *the main program loop. It takes two command line arguments, a seed for the random number generator and a 
 *positive integer indicating the duration. 
 *If either entry is not a positive integer the program terminates.
 * @author Michael Osmian-From Canvas
 */
public class GameApp{
	private Game game;
    /**
     * Scanner instance for reading input from console
     */
    private static final Scanner STDIN = new Scanner(System.in);

    /**
     * Constructor for instantiating game class
     * @param seed: Seed value as processed in command line
     * @param timeToPlay: Total time to play from command line
     */
    public GameApp(int seed, int timeToPlay){
    	if(seed<=0 || timeToPlay<=0){
    		throw new IllegalArgumentException();
    	}
    	 game = new Game(seed,timeToPlay);
    }

    /**
     * Main function which takes the command line arguments and instantiate the
     * GameApp class.
     * The main function terminates when the game ends.
     * Use the getIntegerInput function to read inputs from console
     *
     * @param args: Command line arguments <seed> <timeToPlay>
     */
    public static void main(String[] args){
    	try{
    	GameApp gameApp = new GameApp(Integer.valueOf(args[0]),Integer.valueOf(args[1]));
      	System.out.println("Welcome to the Job Market!");
    	gameApp.start();
    	System.out.println("Game Over!");
    	System.out.println("Your final score: " + gameApp.game.getTotalScore());
    	}
    	catch(IllegalArgumentException e){
    		System.out.println("Seed and TimeToPlay must be greater than zero!");
    	}

    }

    /**
     * This method is the game loop and is repeatedly called while
     * the game is not over
     */
    private void start(){
    	int jobNum=0;
    	int jobDuration=0;

    	while(!game.isOver()){
    		game.createJobs();
    		game.displayActiveJobs();
    		jobNum = getIntegerInput("Select a job to work on: ");
    		jobDuration = getIntegerInput("For how long would you like to work on this job?: ");
    		Job temp=game.updateJob(jobNum, jobDuration);
    		if(temp.isCompleted()){
    		System.out.println("Total Score: "+game.getTotalScore());
    		game.displayCompletedJobs();
    		}
    		
    		
    	}
    }

    /**
     * Displays the prompt and returns the integer entered by the user
     * to the standard input stream.
     *
     * Does not return until the user enters an integer.
     * Does not check the integer value in any way.
     * @param prompt The user prompt to display before waiting for this integer.
     */
    public static int getIntegerInput(String prompt) {
        System.out.print(prompt);
        while ( ! STDIN.hasNextInt() ) {
            System.out.print(STDIN.next()+" is not an int.  Please enter an integer.");
        }
        return STDIN.nextInt();
    }
}