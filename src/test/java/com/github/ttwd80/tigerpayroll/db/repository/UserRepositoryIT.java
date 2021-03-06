package com.github.ttwd80.tigerpayroll.db.repository;

import static com.github.ttwd80.tigerpayroll.db.repository.UserRepositoryTestHelper.*;
import static org.junit.Assert.*;

import java.time.ZonedDateTime;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.ttwd80.tigerpayroll.model.entity.Gender;
import com.github.ttwd80.tigerpayroll.model.entity.User;
import com.github.ttwd80.tigerpayroll.model.repository.GenderRepository;
import com.github.ttwd80.tigerpayroll.model.repository.UserRepository;

public class UserRepositoryIT extends BaseRepositoryIT {

	@Autowired
	UserRepository userRepository;

	@Autowired
	GenderRepository genderRepository;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		userRepository.deleteAll();
		genderRepository.deleteAll();

		genderRepository.save(new Gender(new Character('M'), "Male"));

	}

	@Test
	public void testStartWithZero() {
		assertEquals(0L, userRepository.count());
	}

	@Test
	public void testInsertOne() {
		userRepository.save(createUser("user#1"));
		assertEquals(1L, userRepository.count());
	}

	@Test
	public void testInsertTwo() {
		userRepository.save(createUser("user#1"));
		userRepository.save(createUser("user#2"));
		assertEquals(2L, userRepository.count());
	}

	@Test
	public void testCreatedDateNotNull() {
		final User user = createUser("user");
		userRepository.save(user);
		final User userFromDb = userRepository.findOne("user");
		assertNotNull(userFromDb.getCreatedDate());
	}

	@Test
	public void testCreatedDateValidFromDatabase() {
		final ZonedDateTime dateBefore = ZonedDateTime.now();
		final User user = createUser("user");
		userRepository.save(user);
		final ZonedDateTime dateAfter = ZonedDateTime.now();
		final User userFromDb = userRepository.findOne("user");
		final ZonedDateTime date = userFromDb.getCreatedDate();
		assertTrue(dateBefore.compareTo(date) <= 0);
		assertTrue(date.compareTo(dateAfter) <= 0);
	}

	@Test
	public void testModifiedNull() {
		final User user = createUser("user");
		userRepository.save(user);
		assertNull(user.getLastModifiedDate());
	}

	@Test
	public void testPrimaryKeyOnUsername() {
		final User user1 = createUser("user");
		final User user2 = createUser("user");
		userRepository.save(user1);
		userRepository.save(user2);
		assertEquals(1L, userRepository.count());
	}

	@Test
	public void testModifiedAfterCreated() {
		User user = createUser("user");
		userRepository.save(user);

		user = userRepository.findOne("user");
		user.setPassword("$$$");
		userRepository.save(user);

		final User fromDatabase = userRepository.findOne("user");
		final ZonedDateTime dateCreated = fromDatabase.getCreatedDate();
		final ZonedDateTime dateLastModified = fromDatabase.getLastModifiedDate();
		assertNotNull(dateCreated);
		assertNotNull(dateLastModified);
		assertTrue(dateCreated.compareTo(dateLastModified) < 0);
	}
}
