package com.pluralsight;

import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Book[] books = new Book[20];
        books[0] = new Book(1, "138", "Java", false, null);
        books[1] = new Book(2, "795", "is", false, null);
        books[2] = new Book(3, "498", "hard", false, null);
        books[3] = new Book(4, "201", "Programming", false, null);
        books[4] = new Book(5, "456", "Fundamentals", false, null);
        books[5] = new Book(6, "892", "Data", false, null);
        books[6] = new Book(7, "334", "Structures", false, null);
        books[7] = new Book(8, "667", "Algorithms", false, null);
        books[8] = new Book(9, "523", "Design", false, null);
        books[9] = new Book(10, "741", "Patterns", false, null);
        books[10] = new Book(11, "159", "Object", false, null);
        books[11] = new Book(12, "863", "Oriented", false, null);
        books[12] = new Book(13, "426", "Software", false, null);
        books[13] = new Book(14, "914", "Engineering", false, null);
        books[14] = new Book(15, "378", "Web", false, null);
        books[15] = new Book(16, "652", "Development", false, null);
        books[16] = new Book(17, "289", "Database", false, null);
        books[17] = new Book(18, "735", "Systems", false, null);
        books[18] = new Book(19, "491", "Computer", false, null);
        books[19] = new Book(20, "816", "Science", false, null);

        boolean running = true;
        while (running) {
            System.out.println("==== Home Screen ===");
            System.out.println(" 1 - Available Books: ");
            System.out.println(" 2 - Checked Out Books: ");
            System.out.println(" 3 - Quit \n");

            System.out.print("Enter your command: ");
            int command = input.nextInt();
            input.nextLine();
            switch (command) {
                case 1:
                    availableBooks(books, input);
                    break;
                case 2:
                    checkedOutBooks(books, input);
                    break;
                case 3:
                    running = false;
                    System.out.println("Goodbye, please come again.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

    }

    public static void availableBooks(Book[] books, Scanner input) {
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.println(book);
            } else {
                System.out.println("The Book: " + book.getTitle() + ", is currently checked out");
            }
        }
        System.out.println("Enter book ID to check out, or X to return: ");
        String choice = input.nextLine();
        if (!choice.equalsIgnoreCase("X")) {
            int id = Integer.parseInt(choice);
            Book book = findById(books, id);
            if (book != null && !book.isCheckedOut()) {
                System.out.print("Enter your name: ");
                String name = input.nextLine();
                book.checkOut(name);
                System.out.println("The Book: " + book.getTitle() + " has successfully been checked out to: " + name);
            } else {
                System.out.println("404 Error -UNKNOWN-");
            }

        }
    }


    public static void checkedOutBooks(Book[] books, Scanner input) {
        for (Book book : books) {
            if (book.isCheckedOut()) {
                System.out.println(book);
            } else {
                System.out.println("Title: " + book.getTitle() + "| Id number: " + book.getId() + ": is currently in");
            }

        }
        System.out.print("Enter C to check in a book, or X to return: ");
        String choice = input.nextLine();
        if (choice.equalsIgnoreCase("C")) {
            System.out.print("Enter book ID to check in: ");
            int id = input.nextInt();
            input.nextLine();
            Book book = findById(books, id);
            if (book != null && book.isCheckedOut()) {
                book.checkIn();
                System.out.println("Book checked in successfully.");
            } else {
                System.out.println("404 Error -UNKNOWN-");
            }
        }
    }

    public static Book findById(Book[] books, int id) {
        for (Book book : books) {
            if (book != null && book.getId() == id) {
                return book;
            }
        }
        return null;
    }

}