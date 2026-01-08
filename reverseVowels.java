class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            while(start<end && !isVow(arr[start])){
                start++;
            }
            while(start < end && !isVow(arr[end])){
                end--;
            }
            if(start < end){
                swap(start,end,arr);
                start++;
                end--;
            }
        }
        return new String(arr);
    }
    private void swap(int s,int e, char[] a){
        char t = a[s];
        a[s] = a[e];
        a[e] = t;
    }
    private boolean isVow(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'O' || c == 'I' || c == 'U'){
            return true;
        }
        return false;
    }
}
