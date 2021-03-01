package logs.logtests;


import logs.logtests.repo.AccountRepo;
import logs.logtests.repo.UserRepo;
import logs.logtests.service.AccountService;
import logs.logtests.service.UserService;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class LoggingExamples {

    public static void main(String[] args) throws Exception {
        UserService userService = new UserService(new UserRepo(), new AccountService(new AccountRepo()));
        userService.login("dsfgr", "dfhg");
    }


}
