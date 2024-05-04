package com.crudoperationRestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	UsreRepo useRepo;
	
	@Override
	public User saveUser(User usre) {
		User u = useRepo.save(usre);
		return u;
	}

}
