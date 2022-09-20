package ru.gretchen.conturapiintegration.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class BriefReport {

    @Embedded
    private Summary summary;

    @Column(name = "href")
    private String href;
}
