import java.util.Scanner;

    public class Qfour {
        static class ContactNode {
            String name; // Contact name
            String phone; // Phone number
            ContactNode left, right; // Left and right children

            public ContactNode(String name, String phone) {
                this.name = name;
                this.phone = phone;
                this.left = null;
                this.right = null;
            }
        }

        static class PhoneBook {
            ContactNode root;

            // Insert a contact into the BST
            public void insert(String name, String phone) {
                root = insertRec(root, name, phone);
            }

            private ContactNode insertRec(ContactNode root, String name, String phone) {
                if (root == null) {
                    return new ContactNode(name, phone);
                }
                if (name.compareToIgnoreCase(root.name) < 0) {
                    root.left = insertRec(root.left, name, phone);
                } else if (name.compareToIgnoreCase(root.name) > 0) {
                    root.right = insertRec(root.right, name, phone);
                } else {
                    System.out.println("Contact with this name already exists!");
                }
                return root;
            }

            // Search for a contact in the BST
            public void search(String name) {
                ContactNode result = searchRec(root, name);
                if (result == null) {
                    System.out.println("Contact not found!");
                } else {
                    System.out.println("Name: " + result.name + ", Phone: " + result.phone);
                }
            }

            private ContactNode searchRec(ContactNode root, String name) {
                if (root == null || root.name.equalsIgnoreCase(name)) {
                    return root;
                }
                if (name.compareToIgnoreCase(root.name) < 0) {
                    return searchRec(root.left, name);
                }
                return searchRec(root.right, name);
            }

            // Update a contact's phone number
            public void update(String name, String newPhone) {
                ContactNode contact = searchRec(root, name);
                if (contact == null) {
                    System.out.println("Contact not found!");
                } else {
                    contact.phone = newPhone;
                    System.out.println("Phone number updated successfully!");
                }
            }

            // Delete a contact from the BST
            public void delete(String name) {
                root = deleteRec(root, name);
            }

            private ContactNode deleteRec(ContactNode root, String name) {
                if (root == null) {
                    System.out.println("Contact not found!");
                    return null;
                }
                if (name.compareToIgnoreCase(root.name) < 0) {
                    root.left = deleteRec(root.left, name);
                } else if (name.compareToIgnoreCase(root.name) > 0) {
                    root.right = deleteRec(root.right, name);
                } else {
                    // Node with one child or no child
                    if (root.left == null) {
                        return root.right;
                    } else if (root.right == null) {
                        return root.left;
                    }

                    // Node with two children: Get the inorder successor
                    ContactNode successor = minValueNode(root.right);
                    root.name = successor.name;
                    root.phone = successor.phone;
                    root.right = deleteRec(root.right, successor.name);
                }
                return root;
            }

            private ContactNode minValueNode(ContactNode root) {
                while (root.left != null) {
                    root = root.left;
                }
                return root;
            }

            // Display all contacts in alphabetical order (inorder traversal)
            public void display() {
                if (root == null) {
                    System.out.println("Phone book is empty!");
                } else {
                    displayRec(root);
                }
            }

            private void displayRec(ContactNode root) {
                if (root != null) {
                    displayRec(root.left);
                    System.out.println("Name: " + root.name + ", Phone: " + root.phone);
                    displayRec(root.right);
                }
            }
        }

        public static void main(String[] args) {
            PhoneBook phoneBook = new PhoneBook();
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\nPhone Book Menu:");
                System.out.println("1. Add Contact");
                System.out.println("2. Search Contact");
                System.out.println("3. Update Contact");
                System.out.println("4. Delete Contact");
                System.out.println("5. Display All Contacts");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline

                switch (choice) {
                    case 1: // Add contact
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter phone: ");
                        String phone = sc.nextLine();
                        phoneBook.insert(name, phone);
                        break;
                    case 2: // Search contact
                        System.out.print("Enter name to search: ");
                        name = sc.nextLine();
                        phoneBook.search(name);
                        break;
                    case 3: // Update contact
                        System.out.print("Enter name to update: ");
                        name = sc.nextLine();
                        System.out.print("Enter new phone number: ");
                        phone = sc.nextLine();
                        phoneBook.update(name, phone);
                        break;
                    case 4: // Delete contact
                        System.out.print("Enter name to delete: ");
                        name = sc.nextLine();
                        phoneBook.delete(name);
                        break;
                    case 5: // Display all contacts
                        phoneBook.display();
                        break;
                    case 6: // Exit
                        System.out.println("Exiting Phone Book...");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }


