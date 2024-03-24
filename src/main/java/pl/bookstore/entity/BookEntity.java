package pl.bookstore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"id", "title", "author","price"})
@EqualsAndHashCode(of = "id")
@Getter
@Builder
@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", unique = true)
    private Integer id;

    @Column (name = "title")
    private String title;

    @Column (name = "author")
    private String author;
    @Column (name = "price")
    private BigDecimal price;
}
