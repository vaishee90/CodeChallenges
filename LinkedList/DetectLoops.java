package LinkedList;

public class DetectLoops {

	int detectLoop(Node head)
	  {
	   if(head != null){
	        Node slow = head;
	        Node fast = head;
	        while(fast.next!= null && fast!=null){
	            slow = slow.next;
	            fast = fast.next.next;
	        
	            if(slow == fast)
	                return 1;
	        }
	    }
	    return 0;
	    }
	
	int removeTheLoop(Node node) {
		//add code here.
		        if(node != null){
		            Node slow = node;
		            Node fast = node;
		            
		            while(fast!= null && fast.next!=null){
		                fast = fast.next.next;
		                slow = slow.next;
		                
		                if(slow == fast){
		                    fast.next = null;
		                    return 1;
		                }
		            }
		        }
		        return 0;
		    }
}
