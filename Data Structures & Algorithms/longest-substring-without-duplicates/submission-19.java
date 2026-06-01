class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int maxlength=0, i=0, j=0;

        //set.add(s.charAt(j));
        //j++;

        while(j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;

                maxlength = Math.max(maxlength, (j-i)); //you have to record max length
                //every time you inc window, otherwise if there is a window "abced" wthout repeting character
                //else is never executed and if you put maxlength cals there it will never be executed
            }
            else{
                set.remove(s.charAt(i));
                i++; //inc i as soon as you find a duplicate
            }
        }
        return maxlength;
        
    }
}
