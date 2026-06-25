package deepskilling.week_1.algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class Exercise06LibrarySearch {
    static class Book {
        private final int bookId;
        private final String title;
        private final String author;

        Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return bookId + " - " + title + " by " + author;
        }
    }

    static Book linearSearchByTitle(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    static Book binarySearchByTitle(Book[] sortedBooks, String title) {
        int low = 0;
        int high = sortedBooks.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = sortedBooks[mid].title.compareToIgnoreCase(title);
            if (comparison == 0) {
                return sortedBooks[mid];
            }
            if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
                new Book(1, "Clean Code", "Robert Martin"),
                new Book(2, "Effective Java", "Joshua Bloch"),
                new Book(3, "Design Patterns", "GoF")
        };
        Book[] sortedBooks = books.clone();
        Arrays.sort(sortedBooks, Comparator.comparing(book -> book.title.toLowerCase()));

        System.out.println(linearSearchByTitle(books, "Effective Java"));
        System.out.println(binarySearchByTitle(sortedBooks, "Clean Code"));
        System.out.println("Use linear search for small or unsorted data; use binary search for large sorted collections.");
    }
}
