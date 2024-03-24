package pl.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bookstore.entity.BookEntity;

@Repository
public interface BookJpaRepository extends JpaRepository<BookEntity, Integer> {
}
