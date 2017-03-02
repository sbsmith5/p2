import java.util.Iterator;

public class Test_JobList {

	public static void main(String[] args) {
		JobList list = new JobList();
		Job j = new Job("Test",10,10);
		Job f = new Job("Test2",10,10);
		Job q = new Job("Test3",10,10);
		list.add(j);
		list.add(f);
		list.add(0,q);
		Iterator itr = list.iterator();
		System.out.println(itr.next());
		System.out.println(itr.next());


		
	}

}
