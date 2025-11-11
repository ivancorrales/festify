package com.wesovilabs.festify.service;

import java.util.List;

import com.wesovilabs.festify.dto.request.FestivalRequest;
import com.wesovilabs.festify.dto.response.FestivalResponse;

public interface FestivalService {
    List<FestivalResponse> listFestival();

    FestivalResponse createFestival(FestivalRequest request);

    FestivalResponse updateFestival(Long id, FestivalRequest request);

    FestivalResponse getFestivalById(Long id);

    void deleteFestival(Long id);
}
