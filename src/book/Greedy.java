package book;

import java.util.*;

/**
 * @author caoduanxi
 * @2019/10/3 10:54
 */
public class Greedy {
    public static void main(String[] args) {
        HashMap<String,HashSet<String>> broadcasts = new HashMap<String,HashSet<String>>();
        broadcasts.put("K1", new HashSet(Arrays.asList(new String[] {"ID","NV","UT"})));
        broadcasts.put("K2", new HashSet(Arrays.asList(new String[] {"WA","ID","MT"})));
        broadcasts.put("K3", new HashSet(Arrays.asList(new String[] {"OR","NV","CA"})));
        broadcasts.put("K4", new HashSet(Arrays.asList(new String[] {"NV","UT"})));
        broadcasts.put("K5", new HashSet(Arrays.asList(new String[] {"CA","AZ"})));

        //需要覆盖的全部地区
        HashSet<String> allAreas = new HashSet(Arrays.asList(new String[] {"ID","NV","UT","WA","MT","OR","CA","AZ"}));
        System.out.println(getAll(broadcasts,allAreas));
    }

    public static List<String> getAll(HashMap<String, HashSet<String>> broadCasts, HashSet<String> allAreas){
        List<String> selects = new ArrayList<>();
        HashSet<String> tempSet = new HashSet<>();
        String maxKey;
        if(allAreas.size() != 0){
            maxKey = null;
            for (String key : broadCasts.keySet()) {
                tempSet.clear();
                HashSet<String> areas = broadCasts.get(key);
                tempSet.addAll(allAreas);
                // 取交集
                tempSet.retainAll(allAreas);
                if(tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadCasts.get(key).size())){
                    maxKey = key;
                }
                if(maxKey != null){
                    selects.add(maxKey);
                    allAreas.removeAll(broadCasts.get(maxKey));
                }
            }
        }
        return selects;
    }
}
