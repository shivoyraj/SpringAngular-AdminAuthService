package com.org.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.org.dto.AdminDTO;
import com.org.entity.Admin;
import com.org.exception.AdminServiceException;
import com.org.repository.AdminRepository;
import com.org.utility.PasswordEncryption;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepo;

	@Autowired
	private Environment environment;

	@Override
	public AdminDTO adminLogin(String userName, String password) throws AdminServiceException {
		Optional<Admin> adminOpt = adminRepo.findByUserName(userName);

		Admin admin = adminOpt
				.orElseThrow(() -> new AdminServiceException(environment.getProperty("USERNAME_INVALID")));

		Optional<Admin> adminopt1 = adminRepo.findByUserName(userName);

		String decryptedPassword = PasswordEncryption.decrypt(adminopt1.get().getPassword());

		if (!decryptedPassword.equals(password))
			throw new AdminServiceException(environment.getProperty("PASSWORD_INVALID"));

		AdminDTO adminDTO = new AdminDTO(admin.getUserName(), decryptedPassword, admin.getEmail());
		return adminDTO;
	}

	@Override
	public String adminRegistration(AdminDTO adminDTO) throws AdminServiceException {

		Optional<Admin> adminopt = adminRepo.findByUserName(adminDTO.getUserName());
		if (adminopt.isPresent())
			throw new AdminServiceException(environment.getProperty("USERNAME_ALREADY_EXIST"));

		Optional<Admin> adminopt1 = adminRepo.findByEmail(adminDTO.getEmail());

		if (adminopt1.isPresent())
			throw new AdminServiceException(environment.getProperty("EMAIL_ALREADY_EXIST"));

		String encryptedPassword = PasswordEncryption.encrypt(adminDTO.getPassword());

		Admin admin = new Admin(adminDTO.getUserName(), adminDTO.getEmail(), encryptedPassword);

		adminRepo.save(admin);

		return environment.getProperty("REGISTRATION_SUCCESS");

	}

}
