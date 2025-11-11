package com.wesovilabs.festify.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesovilabs.festify.dto.request.AlbumRequest;
import com.wesovilabs.festify.dto.response.AlbumResponse;
import com.wesovilabs.festify.mapper.AlbumMapper;
import com.wesovilabs.festify.persistence.jpa.entity.AlbumEntity;
import com.wesovilabs.festify.persistence.jpa.repository.AlbumJpaRepository;
import com.wesovilabs.festify.service.AlbumService;

@Service
public class AlbumServiceImpl implements AlbumService {
    
    @Autowired
    final private AlbumJpaRepository albumJpaRepository;

    @Autowired
    public AlbumServiceImpl(AlbumJpaRepository albumJpaRepository) {
        this.albumJpaRepository = albumJpaRepository;
    }

    @Override
    public List<AlbumResponse> listAlbum() {
        List<AlbumEntity> albums = this.albumJpaRepository.findAll();
        return albums.stream().map(AlbumMapper::mapAlbumtoAlbumResume).toList();
    }

    @Override
    public AlbumResponse createAlbum(AlbumRequest request) {
        AlbumEntity albums = AlbumMapper.mapAlbumRequestToAlbumEntity(request);

        AlbumEntity result = this.albumJpaRepository.save(albums);

        return AlbumMapper.mapAlbumtoAlbumResume(result);
    }

    @Override
    public AlbumResponse updateAlbum(Long id, AlbumRequest request) {
        AlbumEntity album = AlbumMapper.mapAlbumRequestToAlbumEntity(request);

        album.setId(id);

        AlbumEntity result = this.albumJpaRepository.save(album);

        return AlbumMapper.mapAlbumToAlbumDetail(result);
    }

    @Override
    public AlbumResponse getAlbumById(Long id) {
        Optional<AlbumEntity> albums = this.albumJpaRepository.findById(id);
        return AlbumMapper.mapAlbumToAlbumDetail(albums.get());
    }

    @Override
    public void deleteAlbum(Long id) {
        this.albumJpaRepository.deleteById(id);
    }

}
