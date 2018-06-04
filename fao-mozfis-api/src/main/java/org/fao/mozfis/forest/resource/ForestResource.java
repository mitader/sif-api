package org.fao.mozfis.forest.resource;

import java.util.Arrays;
import java.util.List;

import org.fao.mozfis.request.util.Purpose;
import org.fao.mozfis.request.util.Regime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API to expose REST resources for Provinces
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@RestController
@RequestMapping("/forest")
public class ForestResource {

	@GetMapping("regimes")
	public List<Regime> getRegimes() {
		return Arrays.asList(Regime.values());
	}

	@GetMapping("purposes")
	public List<Purpose> getPurposes() {
		return Arrays.asList(Purpose.values());
	}

}