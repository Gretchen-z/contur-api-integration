package ru.gretchen.conturapiintegration.model.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import ru.gretchen.conturapiintegration.model.req.address.ForeignAddress;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "IN_KF_RESPONSE_UL_HEAD")
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
    private boolean inaccuracyDate;

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