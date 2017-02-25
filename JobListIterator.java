import java.util.Iterator;
import java.util.NoSuchElementException;

public class JobListIterator implements Iterator<Job> {

private Listnode<Job> curr;

public JobListIterator(Listnode<Job> head) {
	curr = head;
	}




@Override
public boolean hasNext() {
	if(curr.getNext()!=null){
		return true;
	}
	return false;
}

@Override
public Job next() {
	
	if(curr.getNext()==null){
		throw new NoSuchElementException();
	}
	curr = curr.getNext();
	return curr.getData();
	
	
}
}
