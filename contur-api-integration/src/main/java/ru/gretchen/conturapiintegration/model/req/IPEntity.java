package ru.gretchen.conturapiintegration.model.req;

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
@Table(name = "OUT_KF_RESPONSE_IP")
public class IPEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fio")
    private String fio;

    @Column(name = "okpo")
    private String okpo;

    @Column(name = "okato")
    private String okato;

    @Column(name = "okfsd")
    private String okfs;

    @Column(name = "okogu")
    private String okogu;

    @Column(name = "okopf")
    private String okopf;

    @Column(name = "opf")
    private String opf;

    @Column(name = "oktmo")
    private String oktmo;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "dissolution_date")
    private LocalDate dissolutionDate;

    @Embedded
    private StatusIP status;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        final IPEntity that = (IPEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
