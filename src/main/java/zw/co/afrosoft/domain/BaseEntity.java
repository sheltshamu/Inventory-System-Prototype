package zw.co.afrosoft.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:MM")
    @Column(updatable = false)
    private LocalDateTime dateCreated;
    @JsonFormat(pattern = "yyyy-MM-dd HH:MM")
    private LocalDateTime dateModified;



}
