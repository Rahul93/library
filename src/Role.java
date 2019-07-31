import java.util.List;
import java.util.Map;

public abstract class Role {
    public Map<String, List<ActionType>> getResourceList() {
        return resourceList;
    }

    public void setResourceList(Map<String, List<ActionType>> resourceList) {
        this.resourceList = resourceList;
    }

    private Map<String, List<ActionType>> resourceList;

}
