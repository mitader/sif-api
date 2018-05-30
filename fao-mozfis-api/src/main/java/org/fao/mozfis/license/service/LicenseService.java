package org.fao.mozfis.license.service;

import org.fao.mozfis.license.model.LicenseEntity;
import org.springframework.stereotype.Service;

/**
 * Service implementation for License operations
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Service
public class LicenseService {

	/**
	 * Load an existing license into the repository.
	 * 
	 * @deprecated This is only to be used for initial loading purpose and will be
	 *             removed after all existing licenses be loaded
	 * 
	 * @param license
	 *            the license to be loaded
	 * @return
	 */
	@Deprecated
	public LicenseEntity loadExistingLicense(LicenseEntity license) {
		// TODO: implement me!
		return null;
	}

}