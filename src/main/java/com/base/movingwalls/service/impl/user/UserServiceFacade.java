package com.base.movingwalls.service.impl.user;

import com.base.movingwalls.common.core.*;
import com.base.movingwalls.model.user.User;
import com.base.movingwalls.model.user.UserInfo;
import com.base.movingwalls.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.List;

public class UserServiceFacade implements UserDetailsService {

	@Autowired
	private UserRepository userDao;

	/**
	 * @return
	 */
	public static Reader<UserRepository, Promise<List<UserInfo>>> findAll() {
		return Reader.of(repo -> React.of(() -> repo.findAll())
				.then(FunctionUtils.asList(UserConverter::convertToInfo))
				.getPromise());
	}

	/**
	 * @param id
	 * @return
	 */
	public static Reader<UserRepository, Promise<TwoTrack<UserInfo>>> find(final Long id) {
		return Reader.of(repo -> React.of(() -> repo.getOne(id))
				.then(TwoTrack::ofNullable)
				.then(FunctionUtils.asTwoTrack(UserConverter::convertToInfo))
				.getPromise());

	}

	/**
	 * @param id
	 * @param userInfo
	 * @return
	 */
	public static Reader<UserRepository, Promise<UserInfo>> update(final Long id, final UserInfo userInfo) {
		return Reader.of(repository -> React.of(() -> UserConverter.convertWithId(userInfo, id))
				.then(repository::saveAndFlush)
				.then(UserConverter::convertToInfo)
				.getPromise());
	}

	/**
	 * @param id
	 * @return
	 */
	public static Reader<UserRepository, Promise<Long>> delete(final Long id) {
		return Reader.of(repo -> React.of(() -> id)
				.thenV(repo::deleteById)
				.getPromise());
	}

	/**
	 * @param userInfo
	 * @return
	 */
	public static Reader<UserRepository, Promise<UserInfo>> save(final UserInfo userInfo) {
		return Reader.of(repo -> React.of(() -> userInfo)
				.then(UserConverter::convertToUser)
				.then(repo::save)
				.then(UserConverter::convertToInfo)
				.getPromise());
	}

	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = userDao.findOneByUsername(userId);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

}
