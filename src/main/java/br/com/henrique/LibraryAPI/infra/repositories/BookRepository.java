package br.com.henrique.LibraryAPI.infra.repositories;

import br.com.henrique.LibraryAPI.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByIsbn(String isbn);

}
