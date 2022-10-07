package ru.gretchen.conturapiintegration.model.req;

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
public class StructuredFio {

    @Column(name = "head_first_name")
    private String firstName;

    @Column(name = "head_last_name")
    private String lastName;

    @Column(name = "head_middle_name")
    private String middleName;
}
