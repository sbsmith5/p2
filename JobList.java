import java.util.Iterator;

public class JobList implements ListADT<Job> {

	// Reference to the first node
	private Listnode<Job> head;
	// Counts the number of items within this linked list
	private int numItems;

	public JobList() {
		head = new Listnode<Job>(null);
		numItems = 0;

	}

	public Iterator iterator() {
		return new JobListIterator(head);

	}

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
		numItems++;

	}

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
		numItems++;
	
	}

	public boolean contains(Job j) {
		
		Listnode<Job> curr = head;
		boolean found=false;
		while (curr.getNext() != null) {
			curr = curr.getNext();
			if(curr.getData().toString().equals(j.toString())){
				found=true;
				return found;
			}
		}
		
		
		return found;
	}

	public boolean isEmpty() {
		
		Listnode<Job> curr = head;
		if(curr.getNext()!=null){
			return false;
		}
		else{
		return true;
		}
	}

	public int size() {
		return numItems;
	}

	@Override
	public Job get(int pos) throws IndexOutOfBoundsException{
		if (pos < 0 || pos >= numItems) {
			throw new IndexOutOfBoundsException();
		}

		Listnode<Job> curr = head.getNext();
		for (int p = 0; p < pos; p++) {
			curr = curr.getNext();
		}
		return curr.getData();

	}

	@Override
	public Job remove(int pos) throws IndexOutOfBoundsException{
		
		if (pos < 0 || pos >= numItems) {
			throw new IndexOutOfBoundsException();
		}

		Listnode<Job> curr = head;
		
		for (int p = 0; p < pos-1; p++) {
			curr = curr.getNext();
		}
				Job temp = curr.getNext().getData();
				curr.setNext(curr.getNext().getNext());
				numItems--;
			return temp;
			
		}

	}


