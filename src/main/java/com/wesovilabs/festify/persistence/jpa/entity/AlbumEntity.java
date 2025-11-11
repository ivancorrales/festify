package com.wesovilabs.festify.persistence.jpa.entity;

import java.sql.Timestamp;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "albums")

public class AlbumEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private Long artist_id;

    @Column (nullable = false)
    private String title;

    @Column (name = "release_date",  nullable = false)
    private Date releaseDate;

    @Column (name = "tracks_count", nullable = false)
    private Integer tracksCount;

    @Column (name = "duration_seconds", nullable = false)
    private Integer durationSeconds;

    @Column (name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column (name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    public AlbumEntity (Long id, Long artist_id, String title, Date releaseDate, Integer tracksCount, Integer durationSeconds, Timestamp createdAt, Timestamp updatedAt){
        this.id = id;
        this.artist_id = artist_id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.tracksCount = tracksCount;
        this.durationSeconds = durationSeconds;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id; 
    }

    public Long getArtist_id(){
        return id;
    }

    public void setArtist_id(Long artist_id){
        this.artist_id = artist_id; 
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title; 
    }

    public Date getRealeaseDate(){
        return releaseDate;
    }

    public void setRealeaseDate(Date realeaseDate){
        this.releaseDate = realeaseDate; 
    }

    public Integer getTracksCount(){
        return tracksCount;
    }

    public void setTracksCount(Integer tracksCount){
        this.tracksCount = tracksCount;
    }

    public Integer getDurationSeconds(){
        return durationSeconds;
    }

    public void setDurationSeconds(Integer durationSeconds){
        this.durationSeconds = durationSeconds;
    }

    public Timestamp getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt){
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt(){
        return updatedAt;
    }

    public void setuUdatedAt(Timestamp updatedAt){
        this.updatedAt = updatedAt;
    }  
}
