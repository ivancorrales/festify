package com.wesovilabs.festify.persistence.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wesovilabs.festify.persistence.jpa.entity.FestivalEntity;

public interface FestivalJpaRepository extends JpaRepository <FestivalEntity, Long> {

}
