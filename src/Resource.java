import java.util.List;

public abstract class Resource {
    private String name;
    private String path;
    private List<ActionType> allowedActionTypes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<ActionType> getAllowedActionTypes() {
        return allowedActionTypes;
    }

    public void setAllowedActionTypes(List<ActionType> allowedActionTypes) {
        this.allowedActionTypes = allowedActionTypes;
    }

}
