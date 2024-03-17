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
public class Client extends BaseEntity<Long> {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String city;

}
