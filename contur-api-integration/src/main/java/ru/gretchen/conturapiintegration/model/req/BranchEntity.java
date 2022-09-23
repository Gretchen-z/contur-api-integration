package ru.gretchen.conturapiintegration.model.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import ru.gretchen.conturapiintegration.model.req.address.ForeignAddress;
import ru.gretchen.conturapiintegration.model.req.address.ParsedAddressRFEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "IN_KF_RESPONSE_UL_BRANCH")
public class BranchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "kpp")
    private String kpp;

    @OneToOne(fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JoinColumn(name = "parsed_address_rf_id", referencedColumnName = "id")
    private ParsedAddressRFEntity parsedAddressRF;

    @Embedded
    private ForeignAddress foreignAddress;

    @Column(name = "date")
    private LocalDate date;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        final BranchEntity that = (BranchEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
