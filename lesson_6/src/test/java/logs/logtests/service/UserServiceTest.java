package logs.logtests.service;


import logs.logtests.model.User;
import logs.logtests.repo.UserRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    private static final String USER_NAME = "TEST_NAME";
    private static final String USER_PASSWORD = "TEST_PASSWORD";


    @Mock
    UserRepo userRepo;

    @Mock
    AccountService accountService;

    @InjectMocks
    UserService userService;


    @Test
    public void testGetKeyForUser() {
        Long id = 48459854852L;
        User user = new User(id, USER_NAME, USER_PASSWORD, null);
        Long accountId = 345345L;

        when(userRepo.createUser(USER_NAME, USER_PASSWORD)).thenReturn(user);
        when(accountService.createAccountByUserId(user.getId())).thenReturn(accountId);
        when(userRepo.save(user)).thenReturn(user);

        User result = userService.createUserWithAccount(USER_NAME, USER_PASSWORD);

        Assert.assertEquals(accountId, result.getAccountId());
        Assert.assertEquals(id, user.getId());

        verify(userRepo).createUser(USER_NAME, USER_PASSWORD);
        verify(accountService).createAccountByUserId(user.getId());
        verify(userRepo).save(user);
    }
}
