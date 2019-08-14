package com.hcl.matrimony.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimony.service.UserProfileService;
/**
 * @author Laxman
 *
 */
@RestController
public class SearchProfileController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SearchProfileController.class);
	
	@Autowired
	private UserProfileService userProfileService;
	
	/**
	 * @param mobile
	 * @param place
	 * @param occupation
	 * @return
	 */
	@GetMapping("/{mobile}/profiles/interest/")
	public ResponseEntity<Object> searchProfile(@PathVariable("mobile") long mobile, @RequestParam(value="place", required=false) String place, @RequestParam(value="occupation", required=false) String occupation ){
		
		LOGGER.info("SearchProfileController :: searchProfile"+mobile+", "+place+", "+occupation);
		
		return new ResponseEntity<>(userProfileService.searchProfile(mobile, place, occupation), HttpStatus.OK);
	}
	
}
