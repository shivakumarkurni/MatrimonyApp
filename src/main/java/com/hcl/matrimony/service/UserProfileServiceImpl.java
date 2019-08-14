package com.hcl.matrimony.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimony.entity.UserProfiles;
import com.hcl.matrimony.repository.UserProfilesRepository;

/**
 * @author Laxman
 *
 */
@Service
public class UserProfileServiceImpl implements UserProfileService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserProfileServiceImpl.class);
	
	@Autowired
	private UserProfilesRepository userProfilesRepository;
	
	/**
	 * @param mobile
	 * @param place
	 * @param occupation
	 * @return
	 */
	@Override
	public Object searchProfile(long mobile, String place, String occupation) {
		
		LOGGER.info("UserProfileServiceImpl :: "+mobile+", "+place+", "+occupation+"-- start");
		
		Object returnObject= "No recors found for matching profile.";
		UserProfiles userProfiles = userProfilesRepository.findByMobile(mobile);
		List<UserProfiles> list = null;
		if(userProfiles!=null){
			if(place!=null && occupation!=null){
				list = userProfilesRepository.findByPlaceAndOccupationAndGenderNot(place, occupation, userProfiles.getGender());
			}else if(place!=null){
				list = userProfilesRepository.findByPlaceAndGenderNot(place, userProfiles.getGender());
			} else if(occupation!=null){
				list = userProfilesRepository.findByOccupationAndGenderNot(occupation, userProfiles.getGender());
			} else{
				list = userProfilesRepository.findByGenderNot(userProfiles.getGender());
			}
		}
		
//		List<UserProfiles> list = userProfilesRepository.findByPlaceAndOccupationAndGenderNotOrPlaceOrOccupationAndGenderNot(place, occupation, userProfiles.getGender());
		
		LOGGER.info("UserProfileServiceImpl :: list "+list);
		if(list!=null){
			returnObject = list;
		}
		
		LOGGER.info("UserProfileServiceImpl :: end ");
		return returnObject;
	}

}
