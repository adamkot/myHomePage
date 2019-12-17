package pl.akotus.myHomePage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.akotus.myHomePage.model.Attachment;

@Repository("attachmentRepository")
public interface AttachmentRepository extends CrudRepository<Attachment, Integer> {
}
