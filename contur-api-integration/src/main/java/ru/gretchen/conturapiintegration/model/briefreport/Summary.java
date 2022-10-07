package ru.gretchen.conturapiintegration.model.briefreport;

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
public class Summary {

    @Column(name = "green_statements")
    private boolean greenStatements;

    @Column(name = "yellow_statements")
    private boolean yellowStatements;

    @Column(name = "red_statements")
    private boolean redStatements;
}
