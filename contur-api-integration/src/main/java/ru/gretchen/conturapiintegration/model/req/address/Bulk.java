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
public class Bulk {

    @Column(name = "bulk_topo_short_name")
    private String topoShortName;

    @Column(name = "bulk_topo_full_name")
    private String topoFullName;

    @Column(name = "bulk_topo_value")
    private String topoValue;
}