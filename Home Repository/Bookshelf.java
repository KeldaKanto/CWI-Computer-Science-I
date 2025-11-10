//************************************************************************************
// 5.7
// Design and implement a class called Book that contains instance
// data for the title, author, publisher, and copyright date. Define the
// Book constructor to accept and initialize these data. Include set-
// ter and getter methods for all instance data. Include a toString
// method that returns a nicely formatted, multiline description of
// the book. Create a driver class called Bookshelf, whose main
// method instantiates and updates several Book objects.
//************************************************************************************

import java.util.Scanner;

public class Bookshelf {
    private static final int NUM_BOOKS = 5, BOOK_INDEX = NUM_BOOKS + 1, currentBooks = 2;
    private static Book[] Books = new Book[BOOK_INDEX];
    public static void main(String[] args) {
        Books[1] = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Charles Scribner's Sons", "4/10/1925");
        Books[2] = new Book("Twenty Thousand Leagues Under the Sea", "Jules Verne", "Pierre-Jules Hetzel", "1872");
        Books[3] = new Book("", "", "", ""); // Books[3] = new Book("Pride and Prejudice", "Jane Austen", "T. Egerton", "1/28/1813");
        Books[4] = new Book("", "", "", "");
        Books[5] = new Book("", "", "", "");

        Scanner scanInput = new Scanner(System.in);

        System.out.println("This program will save the data of " + NUM_BOOKS + " books.\n");

        printCurrentBooks(currentBooks);

        for (int bookNum = 3; bookNum <= NUM_BOOKS; bookNum++) {
            System.out.print("Please enter the title, author, publisher, and copyright date of \nbook " + bookNum + " separated by commas: ");
            Scanner scanLine = new Scanner(scanInput.nextLine());
            scanLine.useDelimiter(",");
            while (scanLine.hasNext()) {
                Books[bookNum].setTitle(scanLine.next().replaceAll("^\\s+|\\s+$", ""));
                Books[bookNum].setAuthor(scanLine.next().replaceAll("^\\s+|\\s+$", ""));
                Books[bookNum].setPublisher(scanLine.next().replaceAll("^\\s+|\\s+$", ""));
                Books[bookNum].setCopyrightDate(scanLine.next().replaceAll("^\\s+|\\s+$", ""));
            }
            System.out.printf("%nYou entered: %n%nBOOK %d - %n%s", bookNum, Books[bookNum].toString());
            scanLine.close();
        }

        printCurrentBooks(NUM_BOOKS);

        // Example book information to enter and test the bookshelf driver
        // Pride and Prejudice, Jane Austen, T. Egerton, 1/28/1813
        // To Kill a Mockingbird, Harper Lee, J. B. Lippincott & Co., 7/11/1960
        // 1984, George Orwell, Secker & Warburg, 8/8/1949
        
        scanInput.close();
    }

    private static void printCurrentBooks(int limit) {
        System.out.println("Current books: \n");
        for (int bookNum = 1; bookNum <= limit; bookNum++) {
            System.out.printf("BOOK " + bookNum + " - %n%s", Books[bookNum].toString());
        }

    }
}