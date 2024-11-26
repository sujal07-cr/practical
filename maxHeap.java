import java.util.Scanner;

public class Qten {

    static class MaxHeap {
        int[] heap; // Array to store heap elements
        int size;   // Current size of the heap
        int capacity; // Maximum size of the heap

        // Constructor to initialize the Max Heap
        public MaxHeap(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.heap = new int[capacity];
        }

        // Function to insert an element into the Max Heap
        public void insert(int value) {
            if (size == capacity) {
                System.out.println("Heap is full!");
                return;
            }
            heap[size] = value; // Add the new value at the end
            size++;
            heapifyUp(size - 1); // Fix the heap property upwards
        }

        // Function to get the maximum value (root)
        public int getMax() {
            if (size == 0) {
                System.out.println("Heap is empty!");
                return -1;
            }
            return heap[0]; // Root of the heap
        }

        // Heapify upwards to maintain Max Heap property
        private void heapifyUp(int index) {
            int parent = (index - 1) / 2;
            while (index > 0 && heap[index] > heap[parent]) {
                // Swap the current node with its parent
                int temp = heap[index];
                heap[index] = heap[parent];
                heap[parent] = temp;

                // Move up to the parent's position
                index = parent;
                parent = (index - 1) / 2;
            }
        }

        // Function to display the heap (optional, for debugging)
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

        // Create a Max Heap with capacity equal to the number of students
        MaxHeap maxHeap = new MaxHeap(n);

        // Input marks and insert them into the Max Heap
        System.out.println("Enter the marks obtained by students:");
        for (int i = 0; i < n; i++) {
            int marks = sc.nextInt();
            maxHeap.insert(marks);
        }

        // Get the maximum marks
        int highestMarks = maxHeap.getMax();
        System.out.println("The highest marks obtained are: " + highestMarks);

        sc.close();
    }
}

