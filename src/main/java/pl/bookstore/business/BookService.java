package pl.bookstore.business;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bookstore.business.dto.BookDTO;
import pl.bookstore.repository.BookJpaRepository;
import pl.bookstore.entity.mapper.BookEntityMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    @Autowired
    private final BookJpaRepository bookJpaRepository;

    private final BookEntityMapper bookEntityMapper;

    @Transactional
    public void createNewBook(BookDTO bookDTO){
        bookJpaRepository.save(
                bookEntityMapper.mapToEntity(bookDTO)
        );
    }

    public List<BookDTO> showAllBooks(){
        return bookJpaRepository.findAll().stream().map(bookEntityMapper::mapToDTO).toList();
    }
    public BookDTO getBookById(Integer id){
        return bookJpaRepository.findById(id).map(bookEntityMapper::mapToDTO).get();
    }

    public void deleteById(Integer id){
        bookJpaRepository.deleteById(id);
    }
}
