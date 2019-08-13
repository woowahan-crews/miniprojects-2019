package techcourse.w3.woostagram.article.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Article {
    @Column(length = 200)
    String contents;

    @Lob
    @Column(nullable = false)
    private Byte[] image;
}
