package techcourse.w3.woostagram.follow.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import techcourse.w3.woostagram.user.domain.User;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User from;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User to;

    @Builder
    public Follow(User from, User to) {
        this.from = from;
        this.to = to;
    }

    public void nullify() {
        from = null;
        to = null;
    }
}