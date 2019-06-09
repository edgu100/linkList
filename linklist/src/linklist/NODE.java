package linklist;

public class NODE {

	public int num;
	public NODE next;
	public NODE prev;

	NODE(int num){
		this.next=null;
		this.prev=null;
		this.num=num;
	}
}