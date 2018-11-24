package com.spring.site.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.site.request.SiteDetails;
import com.spring.site.service.domain.Site;
import com.spring.site.service.service.SiteService;

@RestController
@RequestMapping("/site-service")

/**
 * @author Sreedevi
 *
 */
public class SiteController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	SiteService siteService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/site", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Site getSiteByName(@RequestParam(value = "name", required = false) String name)
	{
		log.info("Inside getSiteByName method - siteName" + name);
		return siteService.findByName(name);
	}

	

	@RequestMapping(method = RequestMethod.PUT, value = { "/site" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public void updateSite(@RequestBody SiteDetails siteDetails) {
		log.info("Inside updateSite method - SiteDetails" + siteDetails);
		siteService.saveChanges(siteDetails);
	}

	
	@RequestMapping(method = RequestMethod.POST, value = "/site", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Site createNewSite(@RequestBody SiteDetails siteDetails) {
		log.info("Inside createNewSite method - SiteDetails" + siteDetails);
		return siteService.create(siteDetails);
	}
}
