package com.fossgen.healthcare.AidXpert.config;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fossgen.healthcare.AidXpert.Util.AppUtils;
import com.fossgen.healthcare.AidXpert.enums.ERole;
import com.fossgen.healthcare.AidXpert.enums.SocialProvider;
import com.fossgen.healthcare.AidXpert.model.Role;
import com.fossgen.healthcare.AidXpert.model.User;
import com.fossgen.healthcare.AidXpert.repository.RoleRepository;
import com.fossgen.healthcare.AidXpert.repository.UserRepository;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private boolean alreadySetup = false;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		if (alreadySetup) {
			return;
		}
		// Create initial roles
		Role userRole = createRoleIfNotFound(ERole.ROLE_USER);
		Role adminRole = createRoleIfNotFound(ERole.ROLE_ADMIN);
		Role modRole = createRoleIfNotFound(ERole.ROLE_DOCTOR);
		createUserIfNotFound("admin@gmail", Set.of(userRole, adminRole, modRole));
		alreadySetup = true;
	}

	@Transactional
	private final User createUserIfNotFound(final String email, Set<Role> roles) {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			user = new User();
			user.setUsername("Admin");
			user.setDisplayName("Admin");
			user.setPhoneNumber("9096488159");
			user.setEmail(email);
			user.setPassword(passwordEncoder.encode("admin@123"));
			user.setRoles(roles);
			user.setProvider(SocialProvider.LOCAL.getProviderType());
			user.setEnabled(true);
			user.setVersion(AppUtils.VERSION);
			user.setLostLogin(AppUtils.getTimestamp());
			user.setCreatedBy("Admin");
			user.setCreatedDate(AppUtils.getTimestamp());
			user = userRepository.save(user);
		}
		return user;
	}

	@Transactional
	private final Role createRoleIfNotFound(final ERole name) {
		Role role = roleRepository.findByName(name);
		return role;
	}
}