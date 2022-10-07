package ru.gretchen.conturapiintegration.model.req.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class Settlement {

    @Column(name = "settlement_topo_short_name")
    private String topoShortName;

    @Column(name = "settlement_topo_full_name")
    private String topoFullName;

    @Column(name = "settlement_topo_value")
    private String topoValue;
}
