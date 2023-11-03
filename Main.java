import java.util.ArrayList;
import java.util.List;

// Создаем интерфейс LibraryItem
interface LibraryItem extends Comparable<LibraryItem> {
    String getDescription();
}

// Создаем класс Book, представляющий книгу в библиотеке
class Book implements LibraryItem, Comparable<LibraryItem> {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getDescription() {
        return "Book: " + title + " by " + author;
    }

    @Override
    public int compareTo(LibraryItem other) {
        if (other == null) return 1;
        return this.getDescription().compareTo(other.getDescription());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book otherBook = (Book) obj;
        return title.equals(otherBook.title) && author.equals(otherBook.author);
    }
}

// Создаем класс DVD, реализующий интерфейс LibraryItem
class DVD implements LibraryItem {
    private String title;

    public DVD(String title) {
        this.title = title;
    }

    public String getDescription() {
        return "DVD: " + title;
    }

    @Override
    public int compareTo(LibraryItem other) {
        if (other == null) return 1;
        return this.getDescription().compareTo(other.getDescription());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DVD otherDVD = (DVD) obj;
        return title.equals(otherDVD.title);
    }
}

// Создаем класс Library, представляющий библиотеку
class Library {
    private List<LibraryItem> items = new ArrayList<>();

    // Метод для добавления элемента в библиотеку
    public void addItem(LibraryItem item) {
        items.add(item);
    }

    // Метод для вывода описаний всех элементов в библиотеке
    public void listItems() {
        for (LibraryItem item : items) {
            System.out.println(item.getDescription());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Создаем объекты Book и DVD
        Book book = new Book("The Catcher in the Rye", "A.S.Pushkin");
        DVD dvd = new DVD("Inception");

        // Добавляем элементы в библиотеку
        library.addItem(book);
        library.addItem(dvd);

        // Выводим список всех элементов в библиотеке
        library.listItems();

        // Сравниваем элементы с использованием Comparable
        System.out.println("Comparing items:");
        int comparisonResult = book.compareTo(dvd);
        if (comparisonResult < 0) {
            System.out.println("Book comes before DVD.");
        } else if (comparisonResult > 0) {
            System.out.println("DVD comes before Book.");
        } else {
            System.out.println("Book and DVD are equal.");
        }

        // Проверяем элементы на равенство с использованием equals
        System.out.println("Checking for equality:");
        boolean areEqual = book.equals(dvd);
        if (areEqual) {
            System.out.println("Book and DVD are equal.");
        } else {
            System.out.println("Book and DVD are not equal.");
        }
    }
}