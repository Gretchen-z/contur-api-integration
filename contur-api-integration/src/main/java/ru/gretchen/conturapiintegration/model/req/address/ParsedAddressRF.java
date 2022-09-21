package ru.gretchen.conturapiintegration.model.req.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParsedAddressRF {

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "kladr_code")
    private String kladrCode;

    @Column(name = "region_code")
    private String regionCode;

    @Embedded
    private RegionName regionName;

    @Embedded
    private City city;

    @Embedded
    private Settlement settlement;

    @Embedded
    private Street street;

    @Embedded
    private House house;

    @Embedded
    private Bulk bulk;

    @Embedded
    private Flat flat;

    @Column(name = "house_raw")
    private String houseRaw;

    @Column(name = "bulk_raw")
    private String bulkRaw;

    @Column(name = "flat_raw")
    private String flatRaw;

    @Column(name = "is_converted")
    private boolean isConverted;
}
