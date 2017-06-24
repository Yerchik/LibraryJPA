package Yerchik.dao;

import Yerchik.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Yerchik on 22.05.2017.
 */
public interface BookDao extends JpaRepository<Book, Integer> {
    Book findByAuthorAndName(String author, String name);
}
