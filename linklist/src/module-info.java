

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;





public class linklist {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f1= new File("C:\\Users\\edgu1\\Desktop\\111.txt");
		System.out.println("the size of list1 is:");
		DDLIST F1=readfile(f1);
		File f2= new File("C:\\Users\\edgu1\\Desktop\\222.txt");
		System.out.println("the size of list2 is:");
		DDLIST F2=readfile(f2);
		File f3= new File("C:\\Users\\edgu1\\Desktop\\333.txt");
		System.out.println("the size of list3 is:");
		DDLIST F3=readfile(f3);
		//Prints to the screen the prime numbers in each list.
		prime("list1", F1);
		prime("list2", F2);
		prime("list3", F3);
		//Prints to the screen the numbers in each list in reverse order.
		reverse("list1", F1);
		reverse("list2", F2);
		reverse("list3", F3);
		//Prints to the screen all the numbers that appear in the three lists.
		appear(F1, F2, F3);

	}


	private static DDLIST readfile(File f) {
		DDLIST DLL = new DDLIST();
		int n=0;
		try{
			Scanner sc =new Scanner(f);
			while(sc.hasNext()){
				NODE temp=new NODE(sc.nextInt());
				DLL.addinTail(temp);
				n++;
			}
		}catch(Exception e){
			System.out.println("cant find the file");
		}
		System.out.println(n);
		return DLL;

	}

	private static boolean prinum(int n) {
		boolean t=true;
		if(n>2){
			for(int i=2;i<=Math.sqrt(n);i++ ){
				if(n%i==0){
					t=false;
					break;
				}
			}
		}
		else t=false;
		return t;
	}

	private static void prime(String name,DDLIST dll) {
		int n=0;
		NODE node=dll.head;
		System.out.println("the prime numbers in " + name + " are:");
		while(node.next!=null){
			if(prinum(node.num)){
				n++;
				if(n%5==0){
					System.out.print(node.num+"\n");
				}
				else{System.out.print(node.num+" ");}
			}
			node=node.next;
			if(node.next==null){
				if(prinum(node.num)){
					n++;
					if(n%5==0){
						System.out.print(node.num+"\n");
					}
					else{System.out.print(node.num+" ");}
				}
			}
		}
		System.out.println("");
	}

	private static void reverse(String name,DDLIST dll) {
		NODE tail=dll.tail;
		System.out.print(name + " reverse order are:");
		if(tail==null){
			System.out.print("file is empty.");
		}
		while(tail.prev!=null){
			System.out.print(tail.num+" ");
			tail=tail.prev;
			if(tail.prev==null){
				System.out.print(tail.num+" ");
			}
		}
		System.out.println("");
	}

	private static void appear(DDLIST dll1,DDLIST dll2,DDLIST dll3){
		NODE h1=dll1.head;
		NODE h2=dll2.head;
		NODE h3=dll3.head;
		int x=0;
		List<Integer> list = new ArrayList<Integer>();
		//Set<Integer> set= new HashSet<Integer>();

		while(h1.next!=null){
			h2=dll2.head;
			while(h2.next!=null){
				if(h1.num==h2.num){
					list.add(h2.num);	
				}
				h2=h2.next;
				if(h2.next==null){
					if(h1.num==h2.num){
						list.add(h2.num);						
					}
				}
			}
			h1=h1.next;
			if(h1.next==null){
				h2=dll2.head;
				while(h2.next!=null){
					if(h1.num==h2.num){
						list.add(h2.num);		
					}
					h2=h2.next;
					if(h2.next==null){
						if(h1.num==h2.num){
							list.add(h2.num);
						}
					}
				}
			}
		}
		System.out.print("Intersection are:");
		for(int i=0;i<list.size();i++){
			h3=dll3.head;
			while(h3.next!=null){
				if(list.get(i)==h3.num){
					//set.add(list.get(i));
					System.out.print(h3.num+" ");
				}
				h3=h3.next;
				if(h3.next==null){
					if(list.get(i)==h3.num){
						//set.add(list.get(i));
						System.out.print(h3.num+" ");
					}
				}
			}
		}
		
		//System.out.print(set);
	}//The Set Interface  no repeat;
}


