package ro.ubb.catalog.web.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
public class ClientDto extends BaseDto{
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String city;


}
