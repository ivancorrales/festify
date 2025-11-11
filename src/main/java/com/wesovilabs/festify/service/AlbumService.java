package com.wesovilabs.festify.service;

import java.util.List;

import com.wesovilabs.festify.dto.request.AlbumRequest;
import com.wesovilabs.festify.dto.response.AlbumResponse;

public interface AlbumService {
    List<AlbumResponse> listAlbum();

    AlbumResponse createAlbum(AlbumRequest request);

    AlbumResponse updateAlbum(Long id, AlbumRequest request);

    AlbumResponse getAlbumById(Long id);

    void deleteAlbum(Long id);
}
