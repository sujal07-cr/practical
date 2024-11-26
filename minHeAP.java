import java.util.Scanner;

public class Qnine {

    static class MinHeap {
        int[] heap; // Array to store heap elements
        int size;   // Current size of the heap
        int capacity; // Maximum size of the heap

        // Constructor to initialize the Min Heap
        public MinHeap(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.heap = new int[capacity];
        }

        // Function to insert an element into the Min Heap
        public void insert(int value) {
            if (size == capacity) {
                System.out.println("Heap is full!");
                return;
            }
            heap[size] = value; // Add the new value at the end
            size++;
            heapifyUp(size - 1); // Fix the heap property upwards
        }

        // Function to get the minimum value (root)
        public int getMin() {
            if (size == 0) {
                System.out.println("Heap is empty!");
                return -1;
            }
            return heap[0]; // Root of the heap
        }

        // Heapify upwards to maintain Min Heap property
        private void heapifyUp(int index) {
            int parent = (index - 1) / 2;
            while (index > 0 && heap[index] < heap[parent]) {
                // Swap the current node with its parent
                int temp = heap[index];
                heap[index] = heap[parent];
                heap[parent] = temp;

                // Move up to the parent's position
                index = parent;
                parent = (index - 1) / 2;
            }
        }

        // Function to display the heap (for debugging)
        public void displayHeap() {
            for (int i = 0; i < size; i++) {
                System.out.print(heap[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the number of students
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        // Create a Min Heap with capacity equal to the number of students
        MinHeap minHeap = new MinHeap(n);

        // Input marks and insert them into the Min Heap
        System.out.println("Enter the marks obtained by students:");
        for (int i = 0; i < n; i++) {
            int marks = sc.nextInt();
            minHeap.insert(marks);
        }

        // Get the minimum marks
        int lowestMarks = minHeap.getMin();
        System.out.println("The lowest marks obtained are: " + lowestMarks);

        sc.close();
    }
}

