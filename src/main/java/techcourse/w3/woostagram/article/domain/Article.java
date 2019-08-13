package techcourse.w3.woostagram.article.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String contents;

    @Lob
    @Column(nullable = false)
    private Byte[] image;
}
