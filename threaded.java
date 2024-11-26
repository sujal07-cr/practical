// Java program Insertion in Threaded Binary Search Tree.
import java.util.*;
public class Qfive
{
    static class Node{
        int data;
        Node left,right;
        boolean isRightThreaded,isLeftThreaded;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
            isRightThreaded=false;
            isLeftThreaded=false;
        }
    }
    static Node insert(Node root,int newData){
        Node curr=root;
        Node parent=null;
        while(curr!=null){
            if (newData == curr.data){
                System.out.println("its a duplicate");
                return root;
            }
            parent = curr;
            if (newData < curr.data){
                if (!curr.isLeftThreaded){
                    curr = curr.left;
                }
                else {
                    break;
                }
            }
            else{
                if (!curr.isRightThreaded){
                    curr = curr.right;
                }
                else {
                    break;
                }
            }
        }
        Node newNode = new Node(newData);
        newNode.isLeftThreaded=true;
        newNode.isRightThreaded=true;
        if (parent == null){
            root = newNode;
            newNode.left=null;
            newNode.right=null;
            }
        else if(newData < parent.data) {
            newNode.left = parent.left;
            newNode.right = parent;
            parent.isLeftThreaded = false;
            parent.left = newNode;
        }
        else {
            newNode.right = parent.right;
            newNode.left = parent;
            parent.isRightThreaded = false;
            parent.right = newNode;
        }
        return root;
    }
    public static Node inOrderSuccesor(Node curr){
        if (curr.isRightThreaded){
            return curr.right;
        }
        curr = curr.right;
        while(!curr.isLeftThreaded){
            curr = curr.left;
        }
        return curr;
    }
    public static void inOrderTraversal(Node root){
        if (root == null){
            System.out.println("empty");
            return;
        }
        Node curr = root;
        while(!curr.isLeftThreaded){
            curr = curr.left;
        }
        while(curr != null){
            System.out.print(" " +curr.data);
            curr = inOrderSuccesor(curr);
        }
    }

    public static void main(String[] args) {
        Node root = null;

        // Insert nodes into the tree
        root = insert(root, 20);
        root = insert(root, 10);
        root = insert(root, 30);
        root = insert(root, 5);
        root = insert(root, 16);
        root = insert(root, 14);
        root = insert(root, 17);
        root = insert(root, 13);

        // Perform inorder traversal using threads
        System.out.println("Inorder traversal using threading:");
        inOrderTraversal(root);
    }

}
//contributed by Arnab Kundu

// This code is updated By Susobhan Akhuli
