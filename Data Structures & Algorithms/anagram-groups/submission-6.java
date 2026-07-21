class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();


        for(String s: strs){
            HashMap<Character, Integer> map2 = new HashMap<>();
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                map2.put(ch, map2.getOrDefault(ch, 0)+1);
            }
            if(map.containsKey(map2)){
                ArrayList<String> a = map.get(map2);
                a.add(s);
                map.put(map2, a);
            }
            else{
                map.put(map2, new ArrayList<>());
                map.get(map2).add(s); //its add not put
            }
        }
        return new ArrayList(map.values());
        
    }
}
