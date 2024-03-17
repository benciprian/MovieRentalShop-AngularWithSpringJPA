package ro.ubb.catalog.core.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Movie extends BaseEntity<Long>{
    private String title;
    private int year;
    private String genre;
    private double rentalPrice;

}
