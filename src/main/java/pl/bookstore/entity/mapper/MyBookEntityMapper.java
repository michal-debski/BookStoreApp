package pl.bookstore.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.bookstore.business.dto.MyBookDTO;
import pl.bookstore.entity.MyBooksEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface MyBookEntityMapper {

    MyBooksEntity mapToEntity(MyBookDTO myBookDTO);
    default MyBookDTO mapToDTO(MyBooksEntity myBooksEntity){
        MyBookDTO.MyBookDTOBuilder myBookDTO= MyBookDTO.builder()
                .id(myBooksEntity.getId())
                .title(myBooksEntity.getTitle())
                .author(myBooksEntity.getAuthor())
                .price(myBooksEntity.getPrice());

        return myBookDTO.build();
    }
}
