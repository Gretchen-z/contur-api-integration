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
public class Flat {

    @Column(name = "flat_topo_short_name")
    private String topoShortName;

    @Column(name = "flat_topo_full_name")
    private String topoFullName;

    @Column(name = "flat_topo_value")
    private String topoValue;
}
