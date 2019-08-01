import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Runner {

    public static void main (String args[]) {

        Resource r1 = new ResourceImpl();
        r1.setName("test1");
        r1.setPath(System.getProperty("user.dir")+"/resources/test1");
        r1.setAllowedActionTypes(Arrays.asList(ActionType.READ, ActionType.WRITE, ActionType.DELETE, ActionType.UPDATE));

        Resource r2 = new ResourceImpl();
        r2.setAllowedActionTypes(Arrays.asList(ActionType.READ, ActionType.WRITE, ActionType.DELETE));
        r2.setName("test2");
        r2.setPath(System.getProperty("user.dir")+"/resources/test2");
        Role rl1 = new RoleImpl();

        Map<String, List<ActionType>> m1 = Map.of(r1.getName(), Arrays.asList(ActionType.READ, ActionType.WRITE), r2.getName(), Arrays.asList(ActionType.READ, ActionType.WRITE, ActionType.DELETE));
        rl1.setResourceList(m1);

        User user = new UserImpl();
        user.setRole(Arrays.asList(rl1));
        user.setName("test1");
        user.setPassword("password");
        user.setStatus(true);
        Data.addUser(user);

        boolean output = Data.isUserAuthorized(user, "READ", "test2");
        System.out.print(output);
    }
}
