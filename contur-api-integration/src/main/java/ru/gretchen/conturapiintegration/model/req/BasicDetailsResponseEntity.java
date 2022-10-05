package ru.gretchen.conturapiintegration.model.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import ru.gretchen.conturapiintegration.model.briefreport.BriefReport;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "OUT_KF_RESPONSE_BASIC_DETAILS")
public class BasicDetailsResponseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "inn")
    private String inn;

    @Column(name = "ogrn")
    private String ogrn;

    @Column(name = "focus_href")
    private String focusHref;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            orphanRemoval = true)
    @JoinColumn(name = "ul_id", referencedColumnName = "id")
    @JsonProperty("UL")
    private ULEntity UL;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            orphanRemoval = true)
    @JoinColumn(name = "ip_id", referencedColumnName = "id")
    @JsonProperty("IP")
    private IPEntity IP;

    @Embedded
    private BriefReport briefReport;

    @Embedded
    private СontactPhones contactPhones;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        final BasicDetailsResponseEntity that = (BasicDetailsResponseEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
