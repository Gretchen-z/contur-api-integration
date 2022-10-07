package ru.gretchen.conturapiintegration.model.req;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "OUT_KF_RESPONSE_UL_HEAD")
public class HeadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fio")
    private String fio;

    @Column(name = "innfl")
    private String innfl;

    @Column(name = "position")
    private String position;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "first_date")
    private LocalDate firstDate;

    @Column(name = "is_inaccuracy")
    private boolean isInaccuracy;

    @Column(name = "inaccuracy_date")
    private LocalDate inaccuracyDate;

    @Embedded
    private StructuredFio structuredFio;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        final HeadEntity that = (HeadEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
