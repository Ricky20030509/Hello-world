package test;

import java.util.Scanner;

public class CustomList<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public CustomList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    public int size() {
        return size;
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
    }

    public static void main(String[] args) {
        CustomList<Book> bookList = new CustomList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Print all books");
            System.out.println("4. Check if a book exists");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the book: ");
                    scanner.nextLine(); // Consume newline character
                    String name = scanner.nextLine();
                    System.out.print("Enter the author of the book: ");
                    String author = scanner.nextLine();
                    Book newBook = new Book(name, author);
                    bookList.add(newBook);
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    if (bookList.size() == 0) {
                        System.out.println("The list is empty.");
                        break;
                    }
                    System.out.print("Enter the index of the book to remove: ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < bookList.size()) {
                        bookList.remove(index);
                        System.out.println("Book removed successfully.");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 3:
                    System.out.println("Books in the list:");
                    Book book ;
                    for (int i = 0; i < bookList.size(); i++) {
                    	book = bookList.get(i);
                        System.out.println((i + 1) + ". Name:" + book.getName() +" Author:" +book.getAuthor());
                    }
                    break;
                case 4:
                    System.out.print("Enter the name of the book to search: ");
                    scanner.nextLine(); // Consume newline character
                    String searchName = scanner.nextLine();
                    System.out.print("Enter the author of the book to search: ");
                    String searchAuthor = scanner.nextLine();
                    Book searchBook = new Book(searchName, searchAuthor);
                    if (bookList.contains(searchBook)) {
                        System.out.println("The book exists in the list.");
                    } else {
                        System.out.println("The book does not exist in the list.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }
}

class Book {
    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return name.equals(book.name) && author.equals(book.author);
    }

    
}
