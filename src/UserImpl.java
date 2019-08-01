import java.util.*;

public class UserImpl extends User {

    UserImpl(){
        this.id = UUID.randomUUID().toString().replace("-", "");;
    }

    /**
     * Gives all resources and its actions for a particular user
     * @return
     */
    public Map<String, List<ActionType>> getAllResources() {
        List<Role> roles = this.getRole();

        Map<String, List<ActionType>> resources = new HashMap<>();

        for(Role role : roles) {
            Map<String, List<ActionType>> currentResource= role.getResourceList();

            currentResource.forEach((key, value) -> resources.merge(key, value, Utility::mergeList));
        }
        return resources;
    }
}
