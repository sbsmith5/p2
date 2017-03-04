/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2016 
// PROJECT:          Program2
// FILE:             JobList.java
//
// TEAM:    (Team 17, MAVSYR)
// Author1: (Michael Osmian,Osmian@wisc.edu,osmian,001)
// Author2: (Sidney Smith,sbSmith5@wisc.edu,sbSmith5,001)
//
// ---------------- OTHER ASSISTANCE CREDITS 
// Persons: N/A
// 
// Online sources:N/A
//////////////////////////// 80 columns wide //////////////////////////////////
import java.util.Iterator;
import java.util.NoSuchElementException;

public class JobListIterator implements Iterator<Job> {

//The listnode at which the iterator is referencing
private Listnode<Job> curr;

public JobListIterator(Listnode<Job> head) {
	//sets the current iterator reference to the header dummy node
	curr = head;
	}



/**
 * A boolean method returning true if there exists another job after the
 * current one it is referencing.
 *

 * @return boolean, true if there is another job, false if there is not
 */
@Override
public boolean hasNext() {
	if(curr.getNext()!=null){
		return true;
	}
	return false;
}
/**
 * This method returns the data of the next job in the list.
 *
 * @throws NoSuchElementException
 * 				Throws a no such element exception if the job after the one it
 * 				is currently referencing is null.
 * @return the the data of the next job
 */
@Override
public Job next() {
	if(curr.getNext()==null){
		throw new NoSuchElementException();
	}
	return curr.getNext().getData();
}
}
