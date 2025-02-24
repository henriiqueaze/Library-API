package br.com.henrique.FirstStepsWithSpringBoot.services;

import br.com.henrique.FirstStepsWithSpringBoot.data.DTOs.BookDTO;
import br.com.henrique.FirstStepsWithSpringBoot.exceptions.BookAlreadyExistsException;
import br.com.henrique.FirstStepsWithSpringBoot.exceptions.IdNotFoundException;
import br.com.henrique.FirstStepsWithSpringBoot.exceptions.InvalidBookDataException;
import br.com.henrique.FirstStepsWithSpringBoot.mapping.Mapper;
import br.com.henrique.FirstStepsWithSpringBoot.model.entities.Book;
import br.com.henrique.FirstStepsWithSpringBoot.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return Mapper.parseObjects(repository.findById(id).orElseThrow(() -> new IdNotFoundException("Id not found")), BookDTO.class);
    }

    public List<BookDTO> getAll() {
        logger.info("Returning all books!");
        return Mapper.parseObjectsList(repository.findAll(), BookDTO.class);
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
        return Mapper.parseObjects(entity, BookDTO.class);
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

        return Mapper.parseObjects(entity, BookDTO.class);
    }

    public void delete(Long id) {
        var entity = repository.findById(id).orElseThrow(() -> new IdNotFoundException("Id not found"));
        repository.delete(entity);
        logger.info("Deleting book with ID: " + id);
    }
}
