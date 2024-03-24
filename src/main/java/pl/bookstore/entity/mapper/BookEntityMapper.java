package pl.bookstore.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.bookstore.business.dto.BookDTO;
import pl.bookstore.entity.BookEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookEntityMapper {
    BookEntity mapToEntity(BookDTO bookDTO);


    default BookDTO mapToDTO(BookEntity bookEntity){
        BookDTO.BookDTOBuilder bookDTO = BookDTO.builder()
                .id(bookEntity.getId())
                .title(bookEntity.getTitle())
                .author(bookEntity.getAuthor())
                .price(bookEntity.getPrice());

        return bookDTO.build();
    }
}
