package ro.ubb.catalog.web.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
public class MovieDto extends BaseDto{
    private String title;
    private int year;
    private String genre;
    private double rentalPrice;

}
