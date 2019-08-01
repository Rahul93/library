import java.util.*;

public class Data {

    static private Map<String, Object> data = new HashMap<>();

    /**
     * Add user to database(in this case ram object)
     * @param user
     * @return
     */
    public static boolean addUser(User user) {
        List<User> users = (List<User>) data.get("user");
        if(users == null) {
            users = new ArrayList<>();
            data.put("user",users);
        }
        users.add(user);

        Map<String, List<ActionType>> resources = user.getAllResources();
        Set<String> cache = (Set<String>) data.get("cache");
        if(cache == null) {
            cache = new HashSet<>();
            data.put("cache", cache);
        }
        for(Map.Entry<String, List<ActionType>> resource : resources.entrySet()) {
            List<ActionType> currentActionTypes = resource.getValue();
            String resourceName = resource.getKey();
            for(ActionType actionType : currentActionTypes) {
                cache.add(getCacheKey(user, resourceName, actionType.name()));
            }
        }
        return true;
    }

    /**
     *
     * @param user
     * @param fileName
     * @param actionType
     * @return
     */
    public static String getCacheKey(User user, String fileName, String actionType) {
        return user.getId()+"_"+fileName+"_"+actionType;
    }

    /**
     * Checks if given user has certain access to certain resource or not
     * @param user
     * @param actionType
     * @param name
     * @return
     */
    public static boolean isUserAuthorized(User user, String actionType, String name) {
        String key = getCacheKey(user, name, actionType);
        Set<String> cache = (Set<String>) data.get("cache");
        return cache.contains(key);
    }
}
