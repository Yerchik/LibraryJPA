package Yerchik.services;

import Yerchik.dto.BookDTO;

import java.util.List;

/**
 * Created by Yerchik on 22.05.2017.
 */
public interface BookService {
    void add(BookDTO dto);

    void edit(String author, String  name, String  newName);

    void remove(String author, String name);

    List<BookDTO> getAll();
}
