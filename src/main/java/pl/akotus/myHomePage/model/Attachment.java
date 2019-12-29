package pl.akotus.myHomePage.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor(access= AccessLevel.PUBLIC)
@NoArgsConstructor(access= AccessLevel.PUBLIC)
@Data
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

    @Column(name = "size_of_file")
    private Double sizeOfFile;

    @Column(name = "content_type")
    private String contentType;

    @Override
    public String toString() {
        return "Attachment{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", originalFileName='" + originalFileName + '\'' +
                ", sizeOfFile=" + sizeOfFile +
                ", contentType='" + contentType + '\'' +
                '}';
    }

    public Attachment(String fileName, String originalFileName, Double sizeOfFile, String contentType) {
        this.fileName = fileName;
        this.originalFileName = originalFileName;
        this.sizeOfFile = sizeOfFile;
        this.contentType = contentType;
    }
}