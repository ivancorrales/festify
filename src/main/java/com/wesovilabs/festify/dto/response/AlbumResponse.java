package com.wesovilabs.festify.dto.response;

import java.sql.Timestamp;
import java.sql.Date;

public record AlbumResponse(
    Long id,
    Long artist_id,
    String title,
    Date realeaseDate,
    Integer tracksCount,
    Integer durationSeconds,
    Timestamp createdAt,
    Timestamp updatedAt) 
{
}
