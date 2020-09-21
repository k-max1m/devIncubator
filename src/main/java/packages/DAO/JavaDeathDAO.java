package packages.DAO;

import packages.models.Account;
import packages.models.User;

import java.util.List;

public interface JavaDeathDAO {
    User getUserById(int id);

    List<Account> getAllAccounts();
}
