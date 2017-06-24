package Yerchik.controllers;

import Yerchik.dto.BookDTO;
import Yerchik.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yerchik on 22.05.2017.
 */
@Controller
public class BaseControllers {

    @Autowired
    private BookService bookService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    @ResponseBody
    public void addSpending(@RequestBody BookDTO dto) {
        bookService.add(dto);
    }

    @RequestMapping(value = "/getAllBooks", method = RequestMethod.GET)
    @ResponseBody
    public List<BookDTO> getAllCurrency(){
        return bookService.getAll();
    }

    @RequestMapping(value = "/remove/{author},{name}", method = RequestMethod.POST)
    @ResponseBody
    public void clearDate(@PathVariable String author, @PathVariable String name){
        bookService.remove(author, name);
    }

    @RequestMapping(value = "/edit/{author},{name},{newName}", method = RequestMethod.POST)
    @ResponseBody
    public void clearDate(@PathVariable String author, @PathVariable String name, @PathVariable String newName){
        bookService.edit(author, name, newName);
    }


}
