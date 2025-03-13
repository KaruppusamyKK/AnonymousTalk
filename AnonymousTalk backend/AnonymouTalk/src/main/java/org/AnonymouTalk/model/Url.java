package org.AnonymouTalk.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Url",uniqueConstraints = {
        @UniqueConstraint(columnNames = "url")
})
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private LocalDateTime insertedAt;
    @PrePersist
    private void setDefault(){
        this.insertedAt = LocalDateTime.now();
    }

    public Url(String url) {
        this.url = url;
    }
}
