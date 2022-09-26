package ru.gretchen.conturapiintegration.model.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class СontactPhones {

    @Column(name = "count_contact_phones")
    private int count;
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            orphanRemoval = true)
    @JoinColumn(name = "contact_phone_id")
    private Set<ContactPhoneEntity> phones;

}
