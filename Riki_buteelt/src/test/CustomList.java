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
            System.out.println("Цэс:");
            System.out.println("1. Ном нэмэх");
            System.out.println("2. Ном устгах");
            System.out.println("3. Бүх номыг харах");
            System.out.println("4. Ном байгаа эсэхийг шалгах");
            System.out.println("5. Нарах");
            System.out.print("Сонголт оо оруулна уу: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Номын нэр оруулна уу: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.print("Зохиолчийн нэр оруулна уу: ");
                    String author = scanner.nextLine();
                    Book newBook = new Book(name, author);
                    bookList.add(newBook);
                    System.out.println("Ном амжилттай нэмэгдлээ");
                    break;
                case 2:
                    if (bookList.size() == 0) {
                        System.out.println("Хоосон байна.");
                        break;
                    }
                    System.out.print("Номын индэксийг оруулна уу: ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < bookList.size()) {
                        bookList.remove(index);
                        System.out.println("Ном амжилттай устлаа.");
                    } else {
                        System.out.println("Буруу индекс");
                    }
                    break;
                case 3:
                    System.out.println("Номын жагсаалт:");
                    Book book ;
                    for (int i = 0; i < bookList.size(); i++) {
                    	book = bookList.get(i);
                        System.out.println((i + 1) + ". Нэр:" + book.getName() +" Зохиолч:" +book.getAuthor());
                    }
                    break;
                case 4:
                    System.out.print("Хайх номын нэр: ");
                    scanner.nextLine(); // Consume newline character
                    String searchName = scanner.nextLine();
                    System.out.print("Хайх номын зохиолч: ");
                    String searchAuthor = scanner.nextLine();
                    Book searchBook = new Book(searchName, searchAuthor);
                    if (bookList.contains(searchBook)) {
                        System.out.println("Ном олдлоо.");
                    } else {
                        System.out.println("Ном олдсонгүй");
                    }
                    break;
                case 5:
                    System.out.println("Гарч байна...");
                    break;
                default:
                    System.out.println("Буруу сонголт 1-5 хооронд сонгоно уу");
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
