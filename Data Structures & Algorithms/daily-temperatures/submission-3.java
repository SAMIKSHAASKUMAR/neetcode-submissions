class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] result = new int[temperatures.length];

        for(int i=1; i<temperatures.length;i++){
            if(temperatures[i]<temperatures[stack.peek()]){
                //if less, push
                stack.push(i);
            }
            else{
                //if greater, add to result and pop as long as greater, then
                //push greater element
                while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int index = stack.pop();
                result[index] = i-index;
                }
                stack.push(i);


            }
            

        }
        return result;
        
    }
}
