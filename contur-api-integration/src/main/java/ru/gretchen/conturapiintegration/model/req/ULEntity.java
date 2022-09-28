package ru.gretchen.conturapiintegration.model.req;

import lombok.*;
import org.hibernate.Hibernate;
import ru.gretchen.conturapiintegration.model.req.address.LegalAddressEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OUT_KF_RESPONSE_UL")
public class ULEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "kpp")
    private String kpp;

    @Column(name = "okpo")
    private String okpo;

    @Column(name = "okato")
    private String okato;

    @Column(name = "okfs")
    private String okfs;

    @Column(name = "oktmo")
    private String oktmo;

    @Column(name = "okogu")
    private String okogu;

    @Column(name = "okopf")
    private String okopf;

    @Column(name = "opf")
    private String opf;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            orphanRemoval = true)
    @JoinColumn(name = "legal_name_id", referencedColumnName = "id")
    private LegalNameEntity legalName;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            orphanRemoval = true)
    @JoinColumn(name = "legal_address_id", referencedColumnName = "id")
    private LegalAddressEntity legalAddress;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            orphanRemoval = true)
    @JoinColumn(name = "ul_id")
    private Set<BranchEntity> branches;

    @Embedded
    private StatusUL status;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "dissolution_date")
    private LocalDate dissolutionDate;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            orphanRemoval = true)
    @JoinColumn(name = "ul_id")
    private Set<HeadEntity> heads;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            orphanRemoval = true)
    @JoinColumn(name = "ul_id")
    private Set<ManagementCompanyEntity> managementCompanies;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            orphanRemoval = true)
    @JoinColumn(name = "history_id", referencedColumnName = "id")
    private HistoryEntity history;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        final ULEntity that = (ULEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
