package theatre.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * author :  kh
 * date : 04/04/2021
 */

@Service
public class PasswordEncoderService {

	private BCryptPasswordEncoder passwordEncoder;

	public PasswordEncoderService() {
		passwordEncoder = new BCryptPasswordEncoder();
	}

	public String encoder(String rawPassword) {
		return passwordEncoder.encode(rawPassword);
	}

	public boolean verifier(String rawPassword, String encodedPassword) {
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}
}
