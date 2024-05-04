package com.crudoperationRestApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/usr")
public class UserController {
	
	@Autowired
//	UsreRepo userRepo;
	UserService userService;
	
	@Autowired
	UsreRepo userRepo;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody User user){
		System.out.println(new JSONObject(user));
		java.util.Date dob = user.getDob();
		
		String pattern = "MM-dd-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date1 = simpleDateFormat.format(dob);
//		System.out.println(date1);
//		Date date2;
//		try {
//			date2 = new SimpleDateFormat("YYYY-MM-dd").parse(date1);
//			System.out.println(date2);
//			user.setDob(date2);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    
	    try {
	        Date date3 = sdf.parse(date1);
	        System.out.println("Parsed Date: " + date3);
	        user.setDob(date3);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

		System.out.println();
		
		
		User u = userService.saveUser(user);
		return new ResponseEntity<>(u,HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public ResponseEntity<?> getAllUser(){
		java.util.List<User> allUser = userRepo.findAll();
		for(User u : allUser) {
			System.out.println(u.getDob());
			System.out.println(((Object)u.getDob()).getClass().getSimpleName());
		}
		return new ResponseEntity<>(allUser,HttpStatus.OK);
	}

	@PostMapping("/newUser")
	public ResponseEntity<?> saveNewUser(@RequestBody NewUserInput newUserInput){
		return null;
	}
}
