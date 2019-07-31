import java.util.*;

public class UserImpl extends User {

    UserImpl(){
        this.id = UUID.randomUUID().toString().replace("-", "");;
    }

    public Map<String, List<ActionType>> getAllResources() {
        List<Role> roles = this.getRole();

        Map<String, List<ActionType>> resources = new HashMap<>();

        for(Role role : roles) {
            Map<String, List<ActionType>> currentResource= role.getResourceList();

            currentResource.forEach((key, value) -> resources.merge(key, value, (v1,v2) -> Utility.mergeList(v1, v2)));
        }
        return resources;
    }
}
