package com.voting.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.voting.Dto.UsersDto;
import com.voting.Entity.Users;
import com.voting.Repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	UsersRepository usersRepository;
	
	@Transactional
	public String userRegistation(UsersDto usersDto) {
		Optional<Users> optUser=usersRepository.findByAadharNo(usersDto.getAadharNo());
		if(optUser.isPresent()) {
			throw new RuntimeException("User with this aadar is already exists");
		}
		Users u=new Users();
		u.setUserName(usersDto.getUserName());
		u.setUserDob(usersDto.getUserDob());
		u.setUserAge(age(usersDto.getUserDob()));
		u.setAadharNo(usersDto.getAadharNo());
		u.setAddress(usersDto.getAddress());
		u.setUserPassword(usersDto.getUserPassword());
		u.setConfirmPassword(usersDto.getUserPassword());
		u.setRole(usersDto.getRole());
		u.setUserMobileNumber(usersDto.getUserMobileNumber());
		u.setUserGender(usersDto.getUserGender());
		usersRepository.save(u);
		return "New User Registration Successfull ! ";
	}
	
	@Transactional
	public int age(String userDob) {
		 	Date dob = Date.valueOf(userDob);
	        LocalDate currentDate = LocalDate.now();
	        LocalDate dobLocalDate = dob.toLocalDate();
	        Period period = Period.between(dobLocalDate, currentDate);
	        int years = period.getYears();
	        //int months = period.getMonths();
	        //int days = period.getDays();
			return years;
	}
	
	@Transactional
	public String login(UsersDto usersDto) {
		Optional<Users> optUser=usersRepository.findByAadharNo(usersDto.getAadharNo());
		if(optUser.isEmpty()) {
			return ("User with Aadhar no not found");
		}
		if(optUser.get().getUserPassword().equalsIgnoreCase(usersDto.getUserPassword())) {
			return "Login Successfull ! ";
		}
		return "Password Incorrect ! ";
	}
	
	 @Transactional
	 public String updateName(UsersDto usersDto) {
	        Optional<Users> optUser = usersRepository.findByAadharNo(usersDto.getAadharNo());
	        
	        if (optUser.isEmpty()) {
	            throw new RuntimeException("User with Aadhar no not found");
	        }
	        Users userToUpdate = optUser.get();
	        userToUpdate.setUserName(usersDto.getUserName());
	        usersRepository.save(userToUpdate);
	        return "UserName Updated Successfully";
	    }
	 
	 @Transactional
	 public String updateMobileNo(UsersDto usersDto) {
	        Optional<Users> optUser = usersRepository.findByAadharNo(usersDto.getAadharNo());
	        
	        if (optUser.isEmpty()) {
	            throw new RuntimeException("User with Aadhar no not found");
	        }
	        Users userToUpdate = optUser.get();
	        userToUpdate.setUserMobileNumber(usersDto.getUserMobileNumber());
	        usersRepository.save(userToUpdate);
	        return "UserMobileNo Updated Successfully";
	    }
	 
	 @Transactional
	 public String updateAddress(UsersDto usersDto) {
	        Optional<Users> optUser = usersRepository.findByAadharNo(usersDto.getAadharNo());
	        if (optUser.isEmpty()) {
	            throw new RuntimeException("User with Aadhar no not found");
	        }
	        Users userToUpdate = optUser.get();
	        userToUpdate.setAddress(usersDto.getAddress());
	        usersRepository.save(userToUpdate);
	        return "Updated Successfully";
	    }
	 
	 @Transactional
	 public String updatePassword(UsersDto usersDto) {
	        Optional<Users> optUser = usersRepository.findByAadharNo(usersDto.getAadharNo());
	        if (optUser.isEmpty()) {
	            throw new RuntimeException("User with Aadhar no not found");
	        }
	        Users userToUpdate = optUser.get();
	        userToUpdate.setUserPassword(usersDto.getUserPassword());
	        userToUpdate.setConfirmPassword(usersDto.getUserPassword());
	        usersRepository.save(userToUpdate);
	        return "Password updated successfull";
	 }
	 
	 @Transactional
	 public Optional<Users> viewUserprofile(UsersDto usersDto) {
		 Optional<Users> optUser = usersRepository.findByAadharNo(usersDto.getAadharNo());
	        if (optUser.isEmpty()) {
	            throw new RuntimeException("User with Aadhar no not found");
	        }
		 return usersRepository.findByAadharNo(usersDto.getAadharNo());
	 }
}
