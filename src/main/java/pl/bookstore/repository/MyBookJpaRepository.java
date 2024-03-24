package pl.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bookstore.entity.MyBooksEntity;

@Repository
public interface MyBookJpaRepository extends JpaRepository<MyBooksEntity, Integer> {
}
