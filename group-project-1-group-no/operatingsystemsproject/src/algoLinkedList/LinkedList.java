/** 
 * 
 * SCS 321 01 Project 1
 * Marissa Homer
 * Matthew Lewis
 * Shane Simpson
 * 
 */

package algoLinkedList;

public class LinkedList<T>  {
    Node<T> head;

    public LinkedList() {
        head = null;
    }

    /**
     * <h1>Add Last</h1>
     * Add a node at the end of the LinkedList.
     * 
     * @param <T> data
     */
    public void addLast(T data) {
        Node<T> newNode = new Node<T>(data);
        if (isEmpty()) {
            head = newNode;
            return;
        }

        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }
    
    
    /**
     * <h1>Add First</h1>
     * Add a node at the beginning of the LinkedList. This changes the head Node.
     * 
     * @param <T> data
     */
    public void addFirst(T data) {
    	Node<T> newNode = new Node<T>(data);
        newNode.next = head;
        head = newNode;
    }
    
    
    /**
     * <h1>Get Last</h1>
     * Get and return the Last Node on the list.
     * 
     * @return LastNode
     */
    public T getLast() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return null;
        }

        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }

        return current.data;
    }
    
    
    /**
     * <h1>Get First</h1>
     * Get and return the First Node on the list.
     * 
     * @return FirstNode
     */
    public T getFirst() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return null;
        }

        return head.data;
    }
    
    
    /**
     * <h1>Remove First</h1>
     * Remove the head Node and replace it with the next.
     */
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("This list is empty.");
            return;
        }

        head = head.next;
    }
    
    
    /**
     * <h1>Remove Last</h1>
     * Remove the last Node.
     */
    public void removeLast() {
        if (head == null) {
            System.out.println("This list is empty.");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
    }
    

    /**
     * <h1>Print List</h1>
     *  Prints the full list.
     */
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    
    /**
     * <h1>Pop</h1>
     * Get the "firstNode" and remove it from the stack.
     * 
     * @return lastNode
     * @see #getFirst()
     * @see #removeLast()
     */
    public T pop() {
    	T e = getFirst();
    	removeFirst();
    	return e;
    }
    
    /**
     * <h1>Size of List</h1>
     * Returns the number of nodes in the linked list.
     * 
     * @return number of nodes in list
     */
    public int sizeOfList() {
    	Node<T> current = head;
    	if (current == null) return 0;
    	int i = 0;
    	while (current.next != null) {
            current = current.next;
            i++;
        }
    	return i;
    }
    
    /**
     * <h1>Get at index</h1>
     * returns the node at the given index
     * 
     * @param index
     * @see #sizeOfList()
     * @return the data at requested index
     */
    public T getAtIndex(int index) {
    	if(index < 0 || index>sizeOfList()) {
    		System.out.println("Given index is outside list bounds");
    		return null;
    	}
    	
    	Node<T> current = head;
        int currentIndex = 0;
        
    	while (current != null && currentIndex < index && current.next != null) {
            current = current.next;
            currentIndex++;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        return current.data;
    }
    
    /**
     * <h1>Remove at index</h1>
     * Removes the node at the given index
     * 
     * @param index
     * @see #sizeOfList()
     */
    public void removeAtIndex(int index) {
    	if (index < 0 || head == null) {
            return;
        }
    	
        if (index == 0) {
            head = head.next;
            return;
        }
        
    	Node<T> current = head;
    	Node<T> previous = null;
        int currentIndex = 0;

        while (current != null && currentIndex < index) {
            previous = current;
            current = current.next;
            currentIndex++;
        }

        if (current != null) {
            previous.next = current.next;
        }
    }
    
    /**
     * <h1>isEmpty</h1>
     * If the head is null then the list is empty.
     * returns true if empty, false if it has things in it
     * 
     * @return boolean
     */
    public boolean isEmpty() {
    	return head == null;
    }
    
    public void addAtIndex(int index, T data) {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be negative.");
        }

        Node<T> insertingDataNode = new Node<T>(data);

        if (index == 0) {
        	insertingDataNode.next = head;
            head = insertingDataNode;
        } else {
            Node<T> current = head;
            
            int i = 0;
            while (i < index - 1 && current != null) { //make current the correct index
                current = current.next;
                i++;
            }

            if (current == null) {
            	// add to the end if the index given is higher than the max
                addLast(data);
            } else { 
            	//replace the current node in the list
            	insertingDataNode.next = current.next;
                current.next = insertingDataNode;
            }
        }
    }//addAtIndex
}//LinkedList
