package pl.akotus.myHomePage.service;

import org.springframework.stereotype.Service;
import pl.akotus.myHomePage.model.Attachment;
import pl.akotus.myHomePage.repository.AttachmentRepository;

@Service("attachmentService")
public class AttachmentService {

    private AttachmentRepository attachmentRepository;

    public AttachmentService(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    public void save(Attachment attachment) {
        attachmentRepository.save(attachment);
    }
}
