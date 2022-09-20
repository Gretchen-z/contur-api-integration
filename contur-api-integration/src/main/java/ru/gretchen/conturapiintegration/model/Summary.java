package ru.gretchen.conturapiintegration.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Summary {

    @Column(name = "green_statements")
    boolean greenStatements;

    @Column(name = "yellow_statements")
    boolean yellowStatements;
}
