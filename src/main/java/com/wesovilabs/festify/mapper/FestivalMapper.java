package com.wesovilabs.festify.mapper;

import com.wesovilabs.festify.dto.request.FestivalRequest;
import com.wesovilabs.festify.dto.response.FestivalResponse;
import com.wesovilabs.festify.persistence.jpa.entity.FestivalEntity;

public class FestivalMapper {

    public static FestivalResponse mapFestivaltoFestivalResume(FestivalEntity e){
        return new FestivalResponse(
            e.getId(),
            e.getName(),
            e.getCity(),
            e.getCountry(),
            e.getDate(),
            e.getGenres()
        );
    }

    public static FestivalEntity mapFestivaltoFestivalEntity(FestivalRequest request) {
        return new FestivalEntity(
            null,
            request.name(),
            request.city(),
            request.country(),
            request.date(),
            request.genres()
        );
    }

    public static FestivalResponse mapFestivaltoFestivalDetail(FestivalEntity e) {
        return new FestivalResponse(
            e.getId(),
            e.getName(),
            e.getCity(),
            e.getCountry(),
            e.getDate(),
            e.getGenres()
        );
    }
}
