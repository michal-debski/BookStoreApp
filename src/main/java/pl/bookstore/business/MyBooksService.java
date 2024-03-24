package pl.bookstore.business;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bookstore.business.dto.BookDTO;
import pl.bookstore.business.dto.MyBookDTO;
import pl.bookstore.entity.mapper.MyBookEntityMapper;
import pl.bookstore.repository.MyBookJpaRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MyBooksService {

    @Autowired
    private MyBookJpaRepository myBookJpaRepository;

    private MyBookEntityMapper myBookEntityMapper;

    @Transactional
    public void saveMyBooks(BookDTO bookDTO){
        MyBookDTO myBookDTO = MyBookDTO.builder()
                .title(bookDTO.getAuthor())
                .author(bookDTO.getAuthor())
                .price(bookDTO.getPrice())
                .build();
        myBookJpaRepository.save(
                myBookEntityMapper.mapToEntity(myBookDTO)
        );
    }

    public List<MyBookDTO> getAllMyBooks(){
        return myBookJpaRepository.findAll().stream().map(myBookEntityMapper::mapToDTO).toList();
    }

    public void deleteById(Integer id){
        myBookJpaRepository.deleteById(id);
    }

}
