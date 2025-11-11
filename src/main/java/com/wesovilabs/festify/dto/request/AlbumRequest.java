package com.wesovilabs.festify.dto.request;

import java.sql.Timestamp;
import java.sql.Date;

public record AlbumRequest(
    Long artist_id,
    String title,
    Date releaseDate,
    Integer tracksCount,
    Integer durationSeconds,
    Timestamp createdAt,
    Timestamp updatedAt
) {
}