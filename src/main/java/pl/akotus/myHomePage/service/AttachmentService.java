package pl.akotus.myHomePage.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.akotus.myHomePage.model.Attachment;
import pl.akotus.myHomePage.repository.AttachmentRepository;

@Service("attachmentService")
public class AttachmentService {

    private AttachmentRepository attachmentRepository;

    public AttachmentService(@Qualifier("attachmentRepository") AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    public void save(Attachment attachment) {
        attachmentRepository.save(attachment);
    }

    public Attachment getById(Integer id) {return attachmentRepository.findById(id).get();}

    public Attachment getByFileName(String fileName) {
        return attachmentRepository.getByFileName(fileName);
    }
}
