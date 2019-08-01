import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Utility {

    //TODO: make it generic in future for List<Object>

    /**
     * Merge two lists such that elements are unique
     * @param one
     * @param two
     * @return
     */
    public static List<ActionType> mergeList(List<ActionType> one, List<ActionType>two) {
        Set<ActionType> mergedSet = new LinkedHashSet<>(one);
        mergedSet.addAll(two);
        List<ActionType> finalList = new ArrayList<>(mergedSet);
        return finalList;
    }
}
