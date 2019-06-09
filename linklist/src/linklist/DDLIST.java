package linklist;
public class DDLIST {

	public NODE head;
	public NODE tail;

	DDLIST ()
	{head=null;
	tail=null;}

	public int numNodes(){
		int num=0;
		NODE temp=head;
		while(temp!=null){
			num++;
			temp=temp.next;
		}
		return(num);
	}

	public void addtoHead(NODE nd){
		if(head==null){
			head=nd;
			tail=nd;
			return;
		}
		nd.next=head;
		head.prev=nd;
		head=nd;
		return;
	}

	public void addinTail(NODE nd){
		if(tail==null){
			tail=nd;
			head=nd;
			return;
		}
		nd.prev=tail;
		tail.next=nd;
		tail=nd;
		return;
	}

	public NODE delHead(){
		NODE temp=head;
		if(temp==null){
			return(null);
		}
		if(temp.next==null){
			head=null;
			return(temp);
		}
		head=head.next;
		head.prev=null;
		temp.next=null;
		return(temp);
	}

	public NODE delTail(){
		NODE temp=tail;
		if(temp==null){
			return(null);
		}
		if(temp.prev==null){
			tail=null;
			return(temp);
		}
		tail=tail.prev;
		tail.next=null;
		temp.prev=null;
		return(temp);
	}
}

