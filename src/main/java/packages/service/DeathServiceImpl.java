package packages.service;

import packages.DAO.JavaDeathDAO;
import packages.DAO.JavaDeathDAOImpl;
import packages.models.Account;
import packages.models.User;

import java.util.List;

public class DeathServiceImpl implements DeathService {
    private JavaDeathDAO javaDeathDAO = new JavaDeathDAOImpl();
    private static DeathService service;

    private DeathServiceImpl() {

    }

    public static DeathService getService() {
        if (service != null) {
            return service;
        } else {
            service = new DeathServiceImpl();
            return service;
        }
    }

    @Override
    public User getRichest() {
        List<Account> allAccounts = javaDeathDAO.getAllAccounts();
        Account maxAccount = allAccounts.get(0);

        for (Account account : allAccounts) {
            if (account.getAccount() > maxAccount.getAccount()) {
                maxAccount = account;
            }
        }

        return javaDeathDAO.getUserById(maxAccount.getUserId());
    }

    @Override
    public int getSumAccounts() {
        List<Account> allAccounts = javaDeathDAO.getAllAccounts();
        int sumAccounts = 0;

        for (Account account : allAccounts) {
            sumAccounts += account.getAccount();
        }

        return sumAccounts;
    }
}
