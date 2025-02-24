package br.com.henrique.FirstStepsWithSpringBoot.repositories;

import br.com.henrique.FirstStepsWithSpringBoot.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByIsbn(String isbn);

}
