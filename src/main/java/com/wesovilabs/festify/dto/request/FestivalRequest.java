package com.wesovilabs.festify.dto.request;

import java.sql.Date;
import java.util.List;

public record FestivalRequest(
    String name,
    String city,
    String country,
    Date date,
    List<String> genres
) {

}
