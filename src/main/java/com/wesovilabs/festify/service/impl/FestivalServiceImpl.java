package com.wesovilabs.festify.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesovilabs.festify.dto.request.FestivalRequest;
import com.wesovilabs.festify.dto.response.FestivalResponse;
import com.wesovilabs.festify.mapper.FestivalMapper;
import com.wesovilabs.festify.persistence.jpa.entity.FestivalEntity;
import com.wesovilabs.festify.persistence.jpa.repository.FestivalJpaRepository;
import com.wesovilabs.festify.service.FestivalService;

@Service
public class FestivalServiceImpl implements FestivalService {

    final private FestivalJpaRepository festivalJpaRepository;

    @Autowired
    public FestivalServiceImpl (FestivalJpaRepository festivalJpaRepository){
        this.festivalJpaRepository = festivalJpaRepository;
    }
    
    @Override
    public List<FestivalResponse> listFestival() {
        List<FestivalEntity> festivales = this.festivalJpaRepository.findAll();
        return festivales.stream().map(FestivalMapper::mapFestivaltoFestivalResume).toList();
    }

    @Override
    public FestivalResponse createFestival(FestivalRequest request) {
        FestivalEntity festivales = FestivalMapper.mapFestivaltoFestivalEntity(request);

        FestivalEntity result = this.festivalJpaRepository.save(festivales);

        return FestivalMapper.mapFestivaltoFestivalResume(result);
    }

    @Override
    public FestivalResponse updateFestival(Long id, FestivalRequest request) {
       FestivalEntity festival = FestivalMapper.mapFestivaltoFestivalEntity(request);

       festival.setId(id);

       FestivalEntity result = this.festivalJpaRepository.save(festival);

       return FestivalMapper.mapFestivaltoFestivalDetail(result);
    }

    @Override
    public FestivalResponse getFestivalById(Long id) {
        Optional<FestivalEntity> festivales = this.festivalJpaRepository.findById(id);
        return FestivalMapper.mapFestivaltoFestivalDetail(festivales.get());
    }

    @Override
    public void deleteFestival(Long id) {
        this.festivalJpaRepository.deleteById(id);
    }

}
