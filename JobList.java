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

/**
 * This is the list class that implements the ListADT of type Job. It is a
 * singly linked list of jobs with a header dummy node.
 *
 * @author Michael Osmian
 */
public class JobList implements ListADT<Job> {

	// Reference to the first node
	private Listnode<Job> head;
	// Counts the number of items within this linked list
	private int numItems;

	
/** Constructor for the JobList
*/
	public JobList() {
		//creates a header node which is null
		head = new Listnode<Job>(null);
		//sets the number of jobs in the list to 0
		numItems = 0;
	}
	
	
/** Creates an Iterator for the JobList
* @return a JobListIterator pointing to head reference
*/
	public Iterator iterator() {
		return new JobListIterator(head);

	}
	
/** Add a job at the end of the list
* @param newJob
*              an item to be added to the list
* @throws IllegalArgumentException
*              if job is null
*/
	public void add(Job newJob) {
		if (null == newJob) {
			throw new IllegalArgumentException();
		}

		Listnode<Job> newNode = new Listnode<Job>(newJob);

		Listnode<Job> curr = head;
		while (curr.getNext() != null) {
			curr = curr.getNext();
		}
		curr.setNext(newNode);
		// Increments number of items within the list
		numItems++;

	}

	
/** Add an item at any position in the list
* @param job
*              an item to be added to the list
* @param pos
*              position at which the item must be added. Indexing starts from 0
* @throws IllegalArgumentException
*              if job is null
* @throws IndexOutOfBoundsException
*              if pos is less than 0 or greater than or equal to
*              number of jobs in the list
*              
*/
	public void add(int pos, Job newJob) {
		if (pos < 0 || pos >= numItems) {
			throw new IndexOutOfBoundsException();
		}

		Listnode<Job> newNode = new Listnode<Job>(newJob);
		Listnode<Job> curr = head;

		for (int p = 0; p < pos; p++) {
			curr = curr.getNext();
		}
		newNode.setNext(curr.getNext());
		curr.setNext(newNode);
		// increments number of items within the list
		numItems++;

	}

/** Check if a particular item exists in the list
* @param Job
*              the item to be checked for in the list
* @return found
*              if value exists, else false
*/
	public boolean contains(Job j) {

		Listnode<Job> curr = head;
		// boolean value if the job was found
		boolean found = false;
		while (curr.getNext() != null) {
			curr = curr.getNext();
			if (curr.getData().toString().equals(j.toString())) {
				found = true;
				// job was found so it returns true
				return found;
			}
		}

		// Job was not found so it returns false
		return found;
	}
	
/** Returns true if the list is empty
* @return value is true if the list is empty
*              else false
*/
	public boolean isEmpty() {

		Listnode<Job> curr = head;
		if (curr.getNext() != null) {
			return false;
		} else {
			return true;
		}
	}
	
/** Returns the size of the singly linked list
* @return the size of the singly linked list
*/
	public int size() {
		return numItems;
	}

	
/**
* Traverses the linked list and gets the job at the 
* asked for position.
*
* @param int pos
* 				The position within the linked list
* @throws IndexOutOfBoundsException
* 				Throws this exception if the position is not within
* 				the correct range for the linked list.
* @return Job
* 				It returns the job at position's data
*/
	@Override
	public Job get(int pos) {
		if (pos < 0 || pos >= numItems) {
			throw new IndexOutOfBoundsException();
		}

		Listnode<Job> curr = head.getNext();
		for (int p = 0; p < pos; p++) {
			curr = curr.getNext();
		}
		return curr.getData();

	}
	/**
	 * Removes and returns the job at the position contained in the parameter
	 * 
	 * @param pos
	 * 				The job at position to be removed
	 * @return temp
	 * 				The job at the specified position is removed and returned
	 */
	@Override
	public Job remove(int pos) {

		if (pos < 0 || pos >= numItems) {
			throw new IndexOutOfBoundsException();
		}

		Listnode<Job> curr = head;

		for (int p = 0; p < pos; p++) {
			curr = curr.getNext();
		}
		Job temp = curr.getNext().getData();
		curr.setNext(curr.getNext().getNext());
		numItems--;
		return temp;

	}

}
