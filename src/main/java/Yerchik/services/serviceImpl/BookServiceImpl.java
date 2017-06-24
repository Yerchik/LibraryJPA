package Yerchik.services.serviceImpl;

import Yerchik.dao.BookDao;
import Yerchik.dto.BookDTO;
import Yerchik.entity.Book;
import Yerchik.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yerchik on 24.06.2017.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;

    @Override
    public void add(BookDTO dto) {
        bookDao.save(new Book(dto.getAuthor(), dto.getName()));
    }

    @Override
    public void edit(String author, String  name, String  newName) {
        Book book = bookDao.findByAuthorAndName(author, name);
        book.setName(newName);
        bookDao.save(book);
    }

    @Override
    public void remove(String author, String name) {
        bookDao.delete(bookDao.findByAuthorAndName(author, name));
    }

    @Override
    public List<BookDTO> getAll() {
        List<BookDTO> dtos = new ArrayList<>();
        for (Book book : bookDao.findAll()) {
            dtos.add(BookDTO.convertToDTO(book));
        }
        return dtos;
    }
}
