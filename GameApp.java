import java.util.Scanner;

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
        game = new Game (seed, timeToPlay);
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

        System.out.println("Welcome to the Job Market!");
        GameApp gameApp = new GameApp (Integer.valueOf(args[0]), Integer.valueOf(args[1]));
        if (Integer.valueOf(args[0]) <= 0 || Integer.valueOf(args[1]) <= 0)
        {
        	//terminate the game
        	gameApp.game.setTimeToPlay(0);
        }
        int timePenalty;
        //TODO: Call the start() method to start playing the game
        
        while (!gameApp.game.isOver())
        {
        	//Step 1 display how much time remains
        	//Step 2 create new jobs
        	gameApp.game.displayActiveJobs();   //Step 3
        	int index = getIntegerInput("Enter the index of the job that you want to work on:");  //Step 4
        	if (!(index == 0))
        	{
        		timePenalty = index;
        		gameApp.game.setTimeToPlay (gameApp.game.getTimeToPlay() - timePenalty);  
        	}
        	int time = getIntegerInput("Enter the time you want to work on this job:");  //Step 5
        	
        }
    }

    /**
     * Add Comments as per implementation
     */
    private void start(){
        //TODO: The interactive game logic goes here
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