package com.souravjune.author_book;

import java.util.ArrayList;
import java.util.List;

/** Question: How to get the sum of ages of all male authors younger than 50 */
public class FilterAuthorAgeSum {

    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book("The Great Gatsby", 500.00,
                new Author("F. Scott Fitzgerald", "fscottfitzgerald@yahoo.com", 51, 'M')));

        bookList.add(new Book("The Catcher in the Rye", 300.00,
                new Author("J.D. Salinger", "jdsalinger@yahoo.com", 29, 'M')));

        bookList.add(new Book("Harry Potter and the Sorcerer's Stone", 550.00,
                new Author("J.K. Rowling", "jkrowling@yahoo.com", 54, 'F')));

        bookList.add(new Book("To Kill a Mockingbird", 400.00,
                new Author("Harper Lee", "harperlee@yahoo.com", 34, 'M')));

        bookList.add(new Book("Little Women", 480.00,
                new Author("Louisa May Alcott", "louisamayalcott@yahoo.com", 47, 'F')));

        bookList.add(new Book("1984", 280.00,
                new Author("George Orwell", "georgeorwell@yahoo.com", 46, 'M')));

        bookList.add(new Book("Pride and Prejudice", 450.00,
                new Author("Jane Austen", "janeausten@yahoo.com", 41, 'M')));

        bookList.add(new Book("Wuthering Heights", 350.00,
                new Author("Emily Bronte", "emilybronte@yahoo.com", 30, 'F')));

        Integer totalAgeOfMaleAuthors = bookList.stream()
                .map(Book::getAuthor)
                .filter(author -> author.getAge() < 50 && author.getGender() == 'M')
                .mapToInt(Author::getAge)
                .sum();

        System.out.println(totalAgeOfMaleAuthors);
    }
}
