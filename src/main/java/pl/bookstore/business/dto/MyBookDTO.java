package pl.bookstore.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor

public class MyBookDTO {

    private Integer id;
    private String title;
    private String author;
    private BigDecimal price;
}
