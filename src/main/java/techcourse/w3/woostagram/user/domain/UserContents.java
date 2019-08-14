package techcourse.w3.woostagram.user.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;

@EqualsAndHashCode
@ToString
@Getter
@Embeddable
@NoArgsConstructor
public class UserContents {

    @NotBlank(message = "빈칸을 허용하지 않는 항목입니다.")
    @Column(nullable = false, unique = true)
    private String userName;

    private String name;

    @Lob
    private String contents;

    private String profile;

    @Builder
    public UserContents(String userName, String name, String contents, String profile) {
        this.userName = userName;
        this.name = name;
        this.contents = contents;
        this.profile = profile;
    }
}
