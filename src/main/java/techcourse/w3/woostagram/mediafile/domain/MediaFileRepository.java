package techcourse.w3.woostagram.mediafile.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import techcourse.w3.woostagram.mediafile.MediaFile;

public interface MediaFileRepository extends JpaRepository<MediaFile, Long> {
}
