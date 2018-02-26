import java.util.LinkedList;


public class myDoublyLinkedList<E> {
	  Node head;              //First Node in the list
	  Node tail;	
	  
		myDoublyLinkedList() {
			 head = new Node();
			 tail = new Node();
			 head.next = tail;
			 tail.prev = head;//last Node in the list
		}  
		  
	 class Node {
	    	
	        E data;
	        Node next;
	        Node prev;
	        
	 public Node() {
		 data = null; 
		 next = null;
		 prev = null;
	 }	  
	 
	 public Node(E newData, int index) { //Constructor for Node with 2 input
		 Node current = head;
		 int counter = 1;
		 while(counter-1 !=index) {
			 current = current.next;	
			 counter++;
		 }	
		 data = newData;
		 this.next = current.next;
		 current.next.prev = this; 
		 current.next = this;
		 this.prev = current;
				 
	 	}
	 }
	 
	 public int getSize() {
			Node temp = head.next;
//			System.out.println("TEMP's PREV"+temp.prev.data);
			int count = 1;
			while (temp.next.next != null) {
				count++;
				temp = temp.next;
//				System.out.println(" Temp goes here:" + temp.data);
			}
			return count;
	}
	 	    		
	public void push(E newData) {    //Function to Add at the beginning
			
	        Node newNode = new Node();
	        newNode.data = newData;        
	        newNode.next = head.next;
	        head.next.prev = newNode;
	        head.next = newNode;
	        newNode.prev = head;						
	}
		
		public void append(E item) {     // Function to Add at the end of the list 
				
			  int size = getSize();	       
//			  System.out.println(size);
			  Node newNode = new Node(item, size);			  					  
	  }		
						
		public void insertAfter(E data, int index) {    //Function to Add in a specific location
			Node newNode = new Node(data, index);			
		}	
	    
	    void deleteFirst() {   //Function to Remove from the list/first
	       	   
	        if (head == null) {
	        	return;
	        }		        
	        if (head != null){
	        head = head.next;
	        head.prev = null;	        
	        }
	    }
	    void deleteLast() {    //Function to Remove from the list/last
	    	
	    		if(tail == null) {
	    		return;
	    		}
	    		if(tail !=null) {
	    		tail = tail.prev;
	    		tail.next = null;
	    		}
	   }
	     
	    void delete(int index) {     //Function to Remove from the list/inside
	    		System.out.println(getSize());
	    		if(index<0 || index> getSize()-1) {
	    			return;
	    		}
	    		if (index == 0){
				deleteFirst();
	    		} 
		    	else if(index == getSize()) {
		    		deleteLast();
		    	}
		    	else {
		    		Node current = head.next;
		    		int counter = 0;
		    		while(counter != index) {
		    			current = current.next;
		    			counter++;
		    		}
		    		current.prev.next = current.next;
		    		current.next.prev = current.prev;
		    		current.next = null;
		    		current.prev = null;
		    	}	    			    			  
   }
	    
		 public void interateForwrad() {
			 Node current = head.next;
			 while(current.next != null) {
				System.out.println(current.data);
				current = current.next;
			 }
			 return;
		 }
		 
		 public void interateBackward() {
			 Node current = tail.prev;
			 while(current.prev != null) {
				 System.out.println(current.data);
				 current = current.prev;
			 }
			 
			 return;
		 }
	    		
	    public void traverse() {
			
			Node current = head.next;
			while(current.next !=null) {
				System.out.println(current.data);
				current = current.next;
			}
	  }	
	
	    public static void main(String[] args) { 
	 
	    	myDoublyLinkedList<String> llist = new myDoublyLinkedList<String>();
	    			
	  			System.out.println("My list is: ");  //Print the list
	  			llist.push("Juan");
	  			llist.push("Pedro");
	  			llist.push("Maria");
	  			llist.push("Tom");
	  			llist.traverse();
	  				  			
	  			System.out.println("\nMy list with last added: "); // Add at End
	  			llist.append("Carlos");
	  			llist.append("Rosa");
	  			llist.traverse();
	  			
	  			System.out.println("\nMy list with the add name after change: "); //Change 			  			
	  			llist.insertAfter("Fernando",3);
	  			llist.insertAfter("Paulina", 0);
	  			llist.insertAfter("Leon", 1);
	  			llist.insertAfter("Julia", 1);
	  			llist.traverse();
			
	  			llist.deleteFirst();
	  			System.out.println("\nCalled delete first: ");
	  			llist.traverse();
	  			System.out.println();
	  			llist.deleteLast();
	  			System.out.println("\nCalled delete last: ");
	  			llist.traverse();
	  			System.out.println();
	  			llist.delete(3);
	  			System.out.println("\nCalled delete at index 3: ");
	  			llist.traverse();
	  				  			
	      		System.out.println("\nMy list interate forwrad: ");
  				llist.interateForwrad();

	      	
  				System.out.println("\nMy list interate backward: ");
  				llist.interateBackward();

	  			
	    }
}
