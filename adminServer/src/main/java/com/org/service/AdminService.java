package com.org.service;

import com.org.dto.AdminDTO;
import com.org.exception.AdminServiceException;

public interface AdminService {
	
	AdminDTO adminLogin(String userName, String password) throws AdminServiceException;
	String adminRegistration (AdminDTO admin) throws AdminServiceException;

}
