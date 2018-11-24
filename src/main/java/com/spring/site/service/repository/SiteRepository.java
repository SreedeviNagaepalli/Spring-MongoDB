package com.spring.site.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.site.service.domain.Site;

@Repository
public interface SiteRepository extends MongoRepository<Site, Integer>{
	
	Site findByName(String name);

}
