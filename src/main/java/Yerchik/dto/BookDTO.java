package Yerchik.dto;

import Yerchik.entity.Book;

/**
 * Created by Yerchik on 24.06.2017.
 */
public class BookDTO {
    private String name;
    private String author;

    public BookDTO() {
    }

    public BookDTO(String author, String name) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static BookDTO convertToDTO(Book book){
        return new BookDTO(book.getAuthor(), book.getName() );
    }
}
