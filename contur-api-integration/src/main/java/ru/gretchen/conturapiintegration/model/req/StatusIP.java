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
public class StatusIP {

    @Column(name = "status_string")
    private String statusString;

    @Column(name = "dissolving")
    private boolean dissolving;

    @Column(name = "dissolved")
    private boolean dissolved;

    @Column(name = "status_date")
    private LocalDate date;
}
