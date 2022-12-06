package com.example.firstapplication.examples.leak;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "aKey")
public class LeakyEntity {
    @Id
    private Integer aKey;
    private String aValue;
}
