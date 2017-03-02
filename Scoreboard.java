
public class Scoreboard implements ScoreboardADT{

	private JobList completedJobs;

	//Constructor for class
	public Scoreboard(){
		completedJobs = new JobList();
	}


	@Override
	public int getTotalScore() {

		int acomulatedScore = 0;
		JobListIterator iterator = (JobListIterator) completedJobs.iterator();

		//step through list and add score
		while(iterator.hasNext()){
			acomulatedScore += iterator.next().getPoints();
		}

		return acomulatedScore;
	}

	@Override
	public void updateScoreBoard(Job job) {

		//if job has not been completed throw illegal argument exception
		if(!job.isCompleted()){
			throw new IllegalArgumentException();
		}

		completedJobs.add(job);

		return;
	}

	@Override
	public void displayScoreBoard() {

		//TODO do not understand what this method is supposed to do

	}



}
