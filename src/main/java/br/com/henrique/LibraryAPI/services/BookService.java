package br.com.henrique.LibraryAPI.services;

import br.com.henrique.LibraryAPI.controllers.BookController;
import br.com.henrique.LibraryAPI.data.DTOs.BookDTO;
import br.com.henrique.LibraryAPI.exceptions.BookAlreadyExistsException;
import br.com.henrique.LibraryAPI.exceptions.IdNotFoundException;
import br.com.henrique.LibraryAPI.exceptions.InvalidBookDataException;
import br.com.henrique.LibraryAPI.mapping.Mapper;
import br.com.henrique.LibraryAPI.model.entities.Book;
import br.com.henrique.LibraryAPI.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.logging.Logger;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;
    private final Logger logger = Logger.getLogger(BookService.class.getName());

    public BookDTO getById(Long id) {
        logger.info("Returning book with ID: " + id);
        var dto = Mapper.parseObjects(repository.findById(id).orElseThrow(() -> new IdNotFoundException("Id not found")), BookDTO.class);
        addHateOASLinks(dto);
        return dto;
    }

    public List<BookDTO> getAll() {
        logger.info("Returning all books!");
        var dto = Mapper.parseObjectsList(repository.findAll(), BookDTO.class);
        dto.forEach(this::addHateOASLinks);
        return dto;
    }

    public BookDTO post(BookDTO book) {
        if (repository.existsByIsbn(book.getIsbn())) {
            throw new BookAlreadyExistsException("ISBN is already registered in a book");
        }

        if (book.getAuthor() == null || book.getTitle() == null) {
            throw new InvalidBookDataException("The data provided for the book is invalid");
        }

        var entity = Mapper.parseObjects(book, Book.class);

        repository.save(entity);
        logger.info("Posting a new book");
        var dto = Mapper.parseObjects(entity, BookDTO.class);
        addHateOASLinks(dto);
        return dto;
    }

    public BookDTO put(BookDTO book) {
        if (repository.existsByIsbn(book.getIsbn())) {
            throw new BookAlreadyExistsException("ISBN is already registered in a book");
        }

        if (book.getAuthor() == null || book.getTitle() == null) {
            throw new InvalidBookDataException("The data provided for the book is invalid");
        }

        var entity = Mapper.parseObjects(repository.findById(book.getId()).orElseThrow(() -> new IdNotFoundException("Id not found")), Book.class);

        entity.setId(book.getId());
        entity.setTitle(book.getTitle());
        entity.setAuthor(book.getAuthor());
        entity.setPublicationYear(book.getPublicationYear());
        entity.setIsbn(book.getIsbn());
        entity.setGenre(book.getGenre());
        entity.setLanguage(book.getLanguage());
        entity.setPages(book.getPages());
        entity.setSummary(book.getSummary());
        entity.setPublisher(book.getPublisher());
        entity.setCreatedAt(book.getCreatedAt());
        entity.setUpdatedAt(book.getUpdatedAt());

        repository.save(entity);
        logger.info("Updating book with ID: " + book.getId());

        var dto = Mapper.parseObjects(entity, BookDTO.class);
        addHateOASLinks(dto);
        return dto;
    }

    public void delete(Long id) {
        var entity = repository.findById(id).orElseThrow(() -> new IdNotFoundException("Id not found"));
        repository.delete(entity);
        logger.info("Deleting book with ID: " + id);
    }

    private void addHateOASLinks(BookDTO dto) {
        dto.add(linkTo(methodOn(BookController.class).getBookById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(BookController.class).getAllBooks()).withRel("getAll").withType("GET"));
        dto.add(linkTo(methodOn(BookController.class).postBook(dto)).withRel("getAll").withType("POST"));
        dto.add(linkTo(methodOn(BookController.class).putBook(dto)).withRel("getAll").withType("PUT"));
        dto.add(linkTo(methodOn(BookController.class).deleteBook(dto.getId())).withRel("delete").withType("DELETE"));
    }
}
