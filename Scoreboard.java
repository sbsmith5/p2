/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2016 
// PROJECT:          Program2
// FILE:             Scoreboard.java
//
// TEAM:    (Team 17, MAVSYR)
// Author1: (Michael Osmian,Osmian@wisc.edu,osmian,001)
// Author2: (Roberto O'dogherty)
//
// ---------------- OTHER ASSISTANCE CREDITS 
// Persons: N/A
// 
// Online sources:N/A
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * This class is in charge of holding the completed jobs in a joblist. It also
 * updates the scoreboard by adding jobs and displays it by iterating throgh the
 * list and printing out the required information
 *
 * @author Michael Osmian
 */
public class Scoreboard implements ScoreboardADT {
	// creates an instance of the listADT in the form of a JobList
	public ListADT<Job> completedJobs = new JobList();

	/**
	 * This method iterates through the completed jobs list and sums up the
	 * total points and returns it.
	 *
	 * @return sum the total points of all the jobs within the list
	 */
	@Override
	public int getTotalScore() {
		int sum = 0;
		for (int i = 0; i < completedJobs.size(); i++) {
			sum += completedJobs.get(i).getPoints();
		}
		return sum;
	}

	/**
	 * This method adds a job to the scoreboard.
	 *
	 * @param job
	 *            a job of the type Job.
	 */
	@Override
	public void updateScoreBoard(Job job) {
		completedJobs.add(job);
	}

	/**
	 * This method displays the scoreboard by getting the job name and the
	 * points earned.
	 * 
	 */
	@Override
	public void displayScoreBoard() {
		System.out.println("The jobs completed: ");
		for (int i = 0; i < completedJobs.size(); i++) {
			System.out.println("Job Name: " + completedJobs.get(i).getJobName());
			System.out.println("Points earned for this job: " + completedJobs.get(i).getPoints());
			System.out.println("--------------------------------------------");
		}

	}

}
