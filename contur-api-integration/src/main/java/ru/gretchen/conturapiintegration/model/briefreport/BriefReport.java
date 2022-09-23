package ru.gretchen.conturapiintegration.model.briefreport;

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
public class BriefReport {

    @Embedded
    private Summary summary;

    @Column(name = "href")
    private String href;
}
