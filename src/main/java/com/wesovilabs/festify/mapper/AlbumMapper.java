package com.wesovilabs.festify.mapper;

import com.wesovilabs.festify.dto.request.AlbumRequest;
import com.wesovilabs.festify.dto.response.AlbumResponse;
import com.wesovilabs.festify.persistence.jpa.entity.AlbumEntity;

public class AlbumMapper {
    
    public static  AlbumResponse mapAlbumtoAlbumResume (AlbumEntity albumEntity){
        return new AlbumResponse (
            albumEntity.getId(),
            albumEntity.getArtist_id(),
            albumEntity.getTitle(),
            albumEntity.getRealeaseDate(),
            albumEntity.getTracksCount(),
            albumEntity.getDurationSeconds(),
            albumEntity.getCreatedAt(),
            albumEntity.getUpdatedAt()
        );
    }

    public static AlbumEntity mapAlbumRequestToAlbumEntity(AlbumRequest request) {
        return new AlbumEntity(
            null,
            request.artist_id(),
            request.title(),
            request.releaseDate(),
            request.tracksCount(),
            request.durationSeconds(),
            request.createdAt(),
            request.updatedAt()
        );
    }

    public static AlbumResponse mapAlbumToAlbumDetail(AlbumEntity a) {
        return new AlbumResponse(
            a.getId(),
            a.getArtist_id(),
            a.getTitle(),
            a.getRealeaseDate(),
            a.getTracksCount(),
            a.getDurationSeconds(),
            a.getCreatedAt(),
            a.getUpdatedAt()
        );
    }
}
