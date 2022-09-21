package ru.gretchen.conturapiintegration.model.req.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ForeignAddress {

    @Column(name = "foreign_address_county_name")
    private String countryName;

    @Column(name = "foreign_address_string")
    private String addressString;
}
