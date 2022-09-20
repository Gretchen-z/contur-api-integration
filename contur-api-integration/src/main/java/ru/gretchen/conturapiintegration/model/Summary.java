package ru.gretchen.conturapiintegration.model;

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
public class Summary {

    @Column(name = "green_statements")
    private boolean greenStatements;

    @Column(name = "yellow_statements")
    private boolean yellowStatements;
}
