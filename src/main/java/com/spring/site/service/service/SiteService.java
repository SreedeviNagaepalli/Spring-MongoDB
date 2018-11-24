package com.spring.site.service.service;

import com.spring.site.request.SiteDetails;
import com.spring.site.service.domain.Site;

/**
 * 
 * @author Sreedevi
 *
 */

public interface SiteService {

	Site findByName(String name);

	Site create(SiteDetails siteDetails);

	void saveChanges(SiteDetails siteDetails);

}
