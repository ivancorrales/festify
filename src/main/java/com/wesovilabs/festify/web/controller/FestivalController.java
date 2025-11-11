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

import com.wesovilabs.festify.dto.request.FestivalRequest;
import com.wesovilabs.festify.dto.response.FestivalResponse;
import com.wesovilabs.festify.service.FestivalService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Festival", description = "Gestión de festivales")
@CrossOrigin(origins = "*")
@RestController
public class FestivalController {
    final private FestivalService festivalService;

    @Autowired
    public FestivalController (FestivalService festivalService){
        this.festivalService = festivalService;
    }

    @GetMapping ("/festivales")
    @ResponseStatus(HttpStatus.OK)
    public List<FestivalResponse> listFestival(){
        return this.festivalService.listFestival();
    }

    @PostMapping ("/festivales")
    @ResponseStatus(HttpStatus.OK)
    public FestivalResponse createFestival(FestivalRequest request){
        return this.festivalService.createFestival(request);
    }

    @DeleteMapping ("/festivales/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFestival(Long id){
        this.festivalService.deleteFestival(id);
    }

    @GetMapping ("/festivales/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FestivalResponse getFestivalById(Long id){
        return this.festivalService.getFestivalById(id);
    }

    @PutMapping ("/festivales/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FestivalResponse updateFestival(Long id, FestivalRequest request){
        return this.festivalService.updateFestival(id, request);
    }

}
