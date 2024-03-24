package pl.bookstore.business.dto;

import lombok.*;

import java.math.BigDecimal;


@Data
@Builder
@AllArgsConstructor

public class BookDTO {

    private Integer id;
    private String title;
    private String author;
    private BigDecimal price;

}
