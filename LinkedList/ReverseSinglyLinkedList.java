package LinkedList;

public class ReverseSinglyLinkedList {
	   Node reverse(Node head)
	   {
		   /* Iterative Approach */
//	        Node prev = null;
//	        Node curr = head;
//	        Node next = null;
//	        if(head != null){
//	            while(curr != null){
//	                next = curr.next;
//	                curr.next = prev;
//	                
//	                prev = curr;
//	                curr = next;
//	            }
//	            head = prev;
//	      }
//	        
//	        return head;
		   
		   /* Recursive Approach */
	        if(head.next == null) 
	            return head;
	        
	        Node prev = reverse(head.next);
	        head.next.next = head;
	        head.next = null;
	       
	        return prev;
	   }
	   
	   //reverse nodes in groups of k
	    public static Node reverse(Node node, int k)
	    {
	        Node curr = node, prev = null, next = null;
	        int count = 0;
	        while(curr != null && count < k)
	        {
	            next = curr.next;
			    curr.next = prev;
			    prev = curr;
			    curr = next;
			    count++;
	        }
	        
	        if (next != null)
		      node.next = reverse(next, k); 
		      return prev;
	    }
	   
	   //rotate list anti-clockwise by k steps
		public void rotate(Node head,int k)
        {
         //add code here.
            if(head != null){
                while(k>0){
                    Node temp = head;
                    Node newHead = null;
                    while(temp.next != null){
                        temp = temp.next;
                    }
                    
                    newHead = head.next;
                    temp.next = head;
                    head.next = null;
                    head = newHead;
                    k--;
                }
                while(head != null){
                    System.out.print(""+head.data+" ");
                    head = head.next;
                }
            }
            
         }
}

class Node{
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
	}
}
