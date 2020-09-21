package project;

import org.junit.jupiter.api.Test;
import packages.models.User;
import packages.service.DeathService;
import packages.service.DeathServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestService {
    private DeathService service = DeathServiceImpl.getService();

    @Test
    public void testService() {
        assertEquals(service.getSumAccounts(), 9080);
        User user = new User(6, "Victor", "Javnerovskiy");
        assertEquals(service.getRichest(), user);
        DeathService projectService = DeathServiceImpl.getService();
        assertEquals(this.service, projectService);
    }
}
