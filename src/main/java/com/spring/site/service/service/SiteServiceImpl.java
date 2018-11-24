package com.spring.site.service.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.spring.site.request.SiteDetails;
import com.spring.site.service.domain.Site;
import com.spring.site.service.repository.SiteRepository;

/**
 * @author Sreedevi
 *
 */
@Service
public class SiteServiceImpl implements SiteService{
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SiteRepository repository;

	@Override
	public Site findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public Site create(SiteDetails siteDetails) {
		Site existing = repository.findByName(siteDetails.getName());
		Assert.isNull(existing, "site already exists: " + siteDetails.getName());
		
		
		Site site = new Site();
		site.setName(siteDetails.getName());		
		site.setLocation(siteDetails.getLocation());
		site.setCustomerId(siteDetails.getCustomerId());

		repository.save(site);

		log.info("new site has been created: " + site.getName());

		return site;
		
	}
	
	/**
	 * 
	 */
	@Override
	public void saveChanges(SiteDetails siteDetails) {
		Site site = repository.findByName(siteDetails.getName());
		Assert.notNull(site, "can't find site with name " + siteDetails.getName());

		site.setName(siteDetails.getName());		
		site.setLocation(siteDetails.getLocation());
		site.setCustomerId(siteDetails.getCustomerId());
		repository.save(site);

		log.debug("site {} changes has been saved", siteDetails.getName());	
		
	}

}
