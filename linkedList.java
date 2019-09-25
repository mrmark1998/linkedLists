public class LinkedList {
	Node head;
	Node tail;
	int size;
	
	
	//Default constructor---------------------------------------
	public LinkedList() {
		head = null;
		tail = null;
		size =0;		
	}
	
	
	//Methods ---------------------------------------------------
	
	//Add/insert nodes -------------------------
	public void addFirst(int value) {
		Node t = new Node(value);
		if (head == null) {
			head = t;
			tail = t;
			size++;
		} else {
			t.next = head;
			head = t;
			size++;
		}
	}
	
	public void addLast(int value) {
		if (head == null) {
			addFirst(value);
		} else {
			Node t = new Node(value);
			tail.next = t;
			tail = t;
			size++;
		}
	}
	
	public void insert(int value, int index) {
		if (head == null)
			addFirst(value);
		else if (index == size)
			addLast(value);
	    else if (index > size)
		    return;
	    else {
			Node t = new Node(value);

			Node temp = head;
			for(int i=0; i<index-1;i++)
				temp = temp.next; //set temp to 1 nodes before index
			
			t.next = temp.next;
			temp.next = t;
			size++;
		}
	}
	
	//Remove nodes -------------------------
	public void removeFirst() {
		if (head == null)
			return;
		else if (size == 1) {
			head = null;
			tail = null;
			size--;
		} else {
		Node temp = head;
		head = head.next;
		temp.next = null;
		size--;
		}
	}
	
	public void removeLast() {
		if (head == null)
			return;
		else if (size == 1) {
			head = null;
			tail = null;
			size--;
		} else {
			Node temp = head;
			for(int i=0; i<size-2;i++)
				temp = temp.next; //set temp to 2 nodes before last
			tail = temp;
			temp.next = null;
			size--;
		}
	}
    
    public void removeIndex(int index) {
	    if (index == 0)
			removeFirst();
		else if (index == size - 1)
		    removeLast();
	    else if (index > size)
		    return;
		else {
			Node temp = head;
			for(int i=0; i<index-1;i++)
				temp = temp.next; //set temp to 1 nodes before index
			
			Node t = temp.next;
			temp.next = temp.next.next;
			t.next = null;
			size--;
		}
	}

	//Displays entire linked list and node values in order
	public void display() {
			
		Node temp = head;
		
		for(int i=0; i<size;i++) {
			System.out.print(temp.data + " --> ");
			temp = temp.next;
		}
	}
	
	//Search node for first occurance of matched value passed
	public int search(int val) {
	    Node temp = head;
	    int index = -1; //-1 is default and will be outputted if loop
	    
	    for(int i=0; i<size;i++) {
    		if(temp.data != val)
    		    temp = temp.next;
    		else { 
        		index = i;
        		break;
    		}
	    }
    	return index;
	}
	
	public static void main(String[] args) {
		
		LinkedList l = new LinkedList();
		l.addFirst(20);
		l.addLast(5);
		l.addLast(10);
		l.addLast(15);
		l.addLast(100);
		l.addFirst(111);
		l.display();
		System.out.println();
		
		l.removeFirst();
		l.display();
		System.out.println();
		
		l.insert(12, 2);
		l.display();
		System.out.println();
		
		l.removeIndex(2);
		l.display();
		System.out.println();
				
		l.removeIndex(0);
		l.display();
		System.out.println();
				
		l.insert(50, 4);
		l.display();
		System.out.println();
		
		System.out.println("10 is located at index: " + l.search(10));
		l.addLast(10);
		l.display();
		System.out.println();
		
		System.out.println("10 is located at index: " + l.search(10) +" /1st occurrance only");
		System.out.println("100 is located at index: " + l.search(100));
		System.out.println("8 is located at index: " + l.search(8) + " /not found");
		System.out.println();
		
		System.out.println("Special cases---------------------");
		//These cases shouldn't produce any errors
		LinkedList m = new LinkedList();
		m.removeFirst();
		m.removeLast();
		m.removeIndex(3);
		m.addLast(100);
		m.display();
		System.out.println();
		m.removeIndex(3);
		m.insert(50, 0);
		m.display();
	}

	
}

class Node
{
	int data;
	Node next;
	
	public Node(int data)
	{
		this.data = data;
		next = null;
	}
	
}
