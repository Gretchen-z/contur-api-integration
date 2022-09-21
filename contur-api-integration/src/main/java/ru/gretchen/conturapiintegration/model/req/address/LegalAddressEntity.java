package ru.gretchen.conturapiintegration.model.req.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "IN_KF_RESPONSE_UL_LEGAL_ADDRESS")
public class LegalAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Embedded
    private ParsedAddressRF parsedAddressRF;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "first_date")
    private LocalDate firstDate;

    @Column(name = "is_inaccuracy")
    private boolean isInaccuracy;

    @Column(name = "inaccuracy_date")
    private boolean inaccuracyDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        final LegalAddressEntity that = (LegalAddressEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
