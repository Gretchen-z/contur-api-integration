package ru.gretchen.conturapiintegration.model.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatusUL {

    @Column(name = "status_string")
    private String statusString;

    @Column(name = "reorganizing")
    private boolean reorganizing;

    @Column(name = "bankrupting")
    private boolean bankrupting;

    @Column(name = "dissolving")
    private boolean dissolving;

    @Column(name = "dissolved")
    private boolean dissolved;

    @Column(name = "date")
    private LocalDate date;
}
