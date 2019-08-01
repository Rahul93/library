import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Data {

    static private Map<String, Object> data = new HashMap<>();

    /**
     * Add user to database(in this case ram object)
     * @param user
     * @return
     */
    public static String addUser(User user) {
        Map<String, User> users = (Map<String, User>) data.get("user");
        if(users == null) {
            users = new HashMap<>();
            data.put("user",users);
        }
        users.put(user.getId(), user);

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
        return user.getId();
    }

    public static User searchByUid(String uid) throws Exception {
        Map<String, User> users = (Map<String, User>) data.get("user");
        if(users.containsKey(uid)){
            return users.get(uid);
        }
        throw new Exception("You are not a user!");
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
    public static boolean isUserAuthorized(String uid, String actionType, String name) {
        try{
            User user = searchByUid(uid);
            String key = getCacheKey(user, name, actionType);
            Set<String> cache = (Set<String>) data.get("cache");
            return cache.contains(key);
        } catch(Exception e) {
            return false;
        }

    }
}
