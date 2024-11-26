public class StackWithLinkedList {

    // Node class for Linked List
    static class Node {
        int data;
        Node next;

        // Constructor to initialize a new node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Stack class using Linked List
    static class Stack {
        private Node top; // Top of the stack

        // Constructor to initialize an empty stack
        public Stack() {
            this.top = null;
        }

        // Push operation: Add an element to the stack
        public void push(int data) {
            Node newNode = new Node(data); // Create a new node
            newNode.next = top; // Link the new node to the current top
            top = newNode; // Update the top to the new node
            System.out.println(data + " pushed onto the stack.");
        }

        // Pop operation: Remove and return the top element
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty. Cannot pop.");
                return -1; // Return -1 to indicate an empty stack
            }
            int poppedData = top.data; // Get the data at the top
            top = top.next; // Move the top to the next node
            System.out.println(poppedData + " popped from the stack.");
            return poppedData;
        }

        // Peek operation: Return the top element without removing it
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty. Nothing to peek.");
                return -1; // Return -1 to indicate an empty stack
            }
            return top.data; // Return the data at the top
        }

        // isEmpty operation: Check if the stack is empty
        public boolean isEmpty() {
            return top == null;
        }

        // Display operation: Print all elements in the stack
        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return;
            }
            Node current = top;
            System.out.print("Stack elements: ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        // Perform stack operations
        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        System.out.println("Top element is: " + stack.peek());

        stack.pop();
        stack.display();

        System.out.println("Stack is empty: " + stack.isEmpty());
    }
}
