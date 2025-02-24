package br.com.henrique.LibraryAPI.controllers;

import br.com.henrique.LibraryAPI.data.DTOs.BookDTO;
import br.com.henrique.LibraryAPI.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public BookDTO getBookById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<BookDTO> getAllBooks() {
        return service.getAll();
    }

    @PostMapping(produces = {MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public BookDTO postBook(@RequestBody BookDTO book) {
        return service.post(book);
    }

    @PutMapping(produces = {MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public BookDTO putBook(@RequestBody BookDTO book) {
        return service.put(book);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable Long id) {
        service.delete(id);
    }

}
