/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2016 
// PROJECT:          Program2
// FILE:             Game.java
//
// TEAM:    (Team 17, MAVSYR)
// Author1: (Michael Osmian,Osmian@wisc.edu,osmian,001)
// Author2: (Roberto O'dogherty)
// Author3: (Aleysha Becker, ambecker5@wisc.edu, ambecker5, 001)
//
// ---------------- OTHER ASSISTANCE CREDITS 
// Persons: N/A
// 
// Online sources:N/A
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * This class is in The Game class is responsible for maintaining the active list of 
 * jobs and utilizes the JobSimulator class to create new jobs to be added to the end of the job listing. 
 *
 * @author Michael Osmian
 */
public class Game{

    /**
     * A list of all jobs currently in the queue.
     */
    private ListADT<Job> list;
    /**
     * Whenever a Job is completed it is added to the scoreboard
     */
    private ScoreboardADT scoreBoard;
    private int timeToPlay;
    private JobSimulator jobSimulator;

    /**
     * Constructor. Initializes all variables.
     * @param seed
     * seed used to seed the random number generator in the Jobsimulator class.
     * @param timeToPlay
     * duration used to determine the length of the game.
     */
    public Game(int seed, int timeToPlay){
    	//Initialize all variables
       scoreBoard = new Scoreboard();
       this.timeToPlay = timeToPlay;
       jobSimulator = new JobSimulator(seed);
       list = new JobList();

    }

    /**
     * Returns the amount of time currently left in the game.
     * @returns the amount of time left in the game.
     */
    public int getTimeToPlay() {
        //return the amount of time left
        return timeToPlay;
    }

    /**
     * Sets the amount of time that the game is to be executed for.
     * Can be used to update the amount of time remaining.
     * @param timeToPlay
     *        the remaining duration of the game
     */
    public void setTimeToPlay(int timeToPlay) {
        //Setter for amount of time to play
    	this.timeToPlay = timeToPlay;
    }

    /**
     * States whether or not the game is over yet.
     * @returns true if the amount of time remaining in
     * the game is less than or equal to 0,
     * else returns false
     */
    public boolean isOver(){
        //check if the game is over or not
    	if(timeToPlay<=0){
    		return true;
    	}
    	else{
        return false;
    	}
    }
    /**
     * This method simply invokes the simulateJobs method
     * in the JobSimulator object.
     */
    public void createJobs(){	
        jobSimulator.simulateJobs(list, timeToPlay);

    }

    /**
     * @returns the length of the Joblist.
     */
    public int getNumberOfJobs(){
        return list.size();
    }

    /**
     * Adds a job to a given position in the joblist.
     * Also requires to calculate the time Penalty involved in
     * adding a job back into the list and update the timeToPlay
     * accordingly
     * @param pos
     *      The position that the given job is to be added to in the list.
     * @param item
     *      The job to be inserted in the list.
     */
    public void addJob(int pos, Job item){
    	list.add(pos, item);
    }

    /**
     * Adds a job to the joblist.
     * @param item
     *      The job to be inserted in the list.
     */
    public void addJob(Job item){
    	list.add(item);
    }

    /**
     * Given a valid index and duration,
     * executes the given job for the given duration.
     *
     * This function should remove the job from the list and
     * return it after applying the duration.
     *
     * This function should set duration equal to the
     * amount of time remaining if duration exceeds it prior
     * to executing the job.
     * After executing the job for a given amount of time,
     * check if it is completed or not. If it is, then
     * it must be inserted into the scoreBoard.
     * This method should also calculate the time penalty involved in
     * executing the job and update the timeToPlay value accordingly
     * @param index
     *      The job to be inserted in the list.
     * @param duration
     *      The amount of time the given job is to be worked on for.
     */
    public Job updateJob(int index, int duration){
    	if(duration>timeToPlay) duration = timeToPlay;
    	if(duration>list.get(index).getTimeUnits()){
    		duration =list.get(index).getTimeUnits();
    	}
    	
    	list.get(index).setSteps(list.get(index).getSteps()+duration);
		duration+=index;
    	timeToPlay-=duration;
    	Job tempJob = list.get(index);
    	
    	if(list.get(index).isCompleted()){
    		scoreBoard.updateScoreBoard(tempJob);
    		System.out.println("Job completed! Current Score: " + this.getTotalScore());
    		list.remove(index);
    	}
    	else{
    		int userPos = GameApp.getIntegerInput("At what position would you like to insert the job back into the list?\n");
    		list.remove(index);
    		list.add(userPos,tempJob);
    	}
    	
    	return tempJob;
    }

    /**
     * This method produces the output for the initial Job Listing, IE:
     * "Job Listing
     *  At position: job.toString()
     *  At position: job.toString()
     *  ..."
     *
     */
    public void displayActiveJobs(){

      //Print header
   
    System.out.println("You have "+timeToPlay+ " left in the game!");
      System.out.println("Job Listing");

      //iterate through list of jobs
      for(int i = 0; i < list.size(); i++){
          //print position and call job to String
          System.out.println("At position: " + i + " " + list.get(i).toString());
      }

      //last line has a \n space
      System.out.println();

    }

    /**
     * This function simply invokes the displayScoreBoard method in the ScoreBoard class.
     */
    public void displayCompletedJobs(){
        scoreBoard.displayScoreBoard();
        
    }

    /**
     * This function simply invokes the getTotalScore method of the ScoreBoard class.
     * @return the value calculated by getTotalScore
     */
    public int getTotalScore(){
        return scoreBoard.getTotalScore();
    }
}
