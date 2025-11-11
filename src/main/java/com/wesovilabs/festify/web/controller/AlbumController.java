package com.wesovilabs.festify.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wesovilabs.festify.dto.request.AlbumRequest;
import com.wesovilabs.festify.dto.response.AlbumResponse;
import com.wesovilabs.festify.service.AlbumService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Album", description = "Gestión de albums")
@CrossOrigin(origins = "*")
@RestController
public class AlbumController {

    final private AlbumService albumService;

    @Autowired
    public AlbumController (AlbumService albumService){
        this.albumService = albumService;
    }

    @GetMapping ("/albums")
    @ResponseStatus(HttpStatus.OK)
    public List<AlbumResponse> listAlbum(){
        return this.albumService.listAlbum();
    }

    @PostMapping ("/albums")
    @ResponseStatus(HttpStatus.OK)
    public AlbumResponse createAlbum(AlbumRequest request){
        return this.albumService.createAlbum(request);
    }

    @DeleteMapping("/albums/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlbum(Long id){
        this.albumService.deleteAlbum(id);
    }

    @GetMapping("/albums/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlbumResponse getAlbumById(Long id){
        return this.albumService.getAlbumById(id);
    }

    @PutMapping("/albums/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlbumResponse updateAlbum(Long id, AlbumRequest request){
        return this.albumService.updateAlbum(id, request);
    }

}
