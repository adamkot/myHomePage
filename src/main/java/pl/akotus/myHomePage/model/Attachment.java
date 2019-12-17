package pl.akotus.myHomePage.model;

import javax.persistence.*;

@Entity
@Table(name = "attachment")
public class Attachment {
    @Id
    @Column(insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "original_file_name")
    private String originalFileName;

    @Column(name = "document_id")
    private Integer documentId;

    @Column(name = "image_number")
    private Integer imageNumber;

    @Column(name = "size_of_file")
    private Double sizeOfFile;

    @Column(name = "content_type")
    private String contentType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public Integer getImageNumber() {
        return imageNumber;
    }

    public void setImageNumber(Integer imageNumber) {
        this.imageNumber = imageNumber;
    }

    public Double getSizeOfFile() {
        return sizeOfFile;
    }

    public void setSizeOfFile(Double sizeOfFile) {
        this.sizeOfFile = sizeOfFile;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", originalFileName='" + originalFileName + '\'' +
                ", documentId=" + documentId +
                ", imageNumber=" + imageNumber +
                ", sizeOfFile=" + sizeOfFile +
                ", contentType='" + contentType + '\'' +
                '}';
    }

    public Attachment(Integer id, String fileName, String originalFileName, Integer documentId, Integer imageNumber,
                      Double sizeOfFile, String contentType) {
        this.id = id;
        this.fileName = fileName;
        this.originalFileName = originalFileName;
        this.documentId = documentId;
        this.imageNumber = imageNumber;
        this.sizeOfFile = sizeOfFile;
        this.contentType = contentType;
    }

    public Attachment(String fileName, String originalFileName, Integer documentId, Integer imageNumber,
                      Double sizeOfFile, String contentType) {
        this.fileName = fileName;
        this.originalFileName = originalFileName;
        this.documentId = documentId;
        this.imageNumber = imageNumber;
        this.sizeOfFile = sizeOfFile;
        this.contentType = contentType;
    }

    public Attachment() {

    }


}