package com.hcl.matrimony.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.matrimony.entity.UserProfiles;

public interface UserProfilesRepository extends JpaRepository<UserProfiles, Long> {

//	List<UserProfiles> findByPlaceAndOccupationAndGenderNotOrPlaceOrOccupationAndGenderNot(String location, String occupation, String gender);
	List<UserProfiles> findByPlaceAndOccupationAndGenderNot(String location, String occupation, String gender);
	List<UserProfiles> findByPlaceAndGenderNot(String location, String gender);
	List<UserProfiles> findByOccupationAndGenderNot(String occupation, String gender);
	List<UserProfiles> findByGenderNot(String gender);
	UserProfiles findByMobile(Long mobile);
}
