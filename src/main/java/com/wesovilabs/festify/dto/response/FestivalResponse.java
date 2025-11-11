package com.wesovilabs.festify.dto.response;

import java.sql.Date;
import java.util.List;

public record FestivalResponse(
    Long id,
    String name,
    String city,
    String country,
    Date date,
    List<String> genres
) {

}
