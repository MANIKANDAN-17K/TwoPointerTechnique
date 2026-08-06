/*
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain

Brute Force

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        for(int i = 1;i<n;i++){
            int l = height[i];
            for(int j = 0;j<i;j++){
                l = Math.max(l,height[j]);
            }
            int r = height[i];
            for(int j = i+1;j<n;j++){
                r = Math.max(r,height[j]);
            }
            res += Math.min(l,r) - height[i];
        }
        return res;
    }
}


better

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = height[0];
        for (int i = 1;i<n;i++){
            pre[i] = Math.max(pre[i-1],height[i]);
        }
        suf[ n - 1] = height[n-1];
        for(int i = n - 2;i>=0;i--){
            suf[i] = Math.max(suf[i + 1],height[i]);
        }
        int minOf = 0;
        for(int i = 1;i<n;i++){
            minOf += Math.min(pre[i],suf[i]) - height[i];
        }
        return minOf;
    }
} 
*/

optimal 

class Solution {
    public int trap(int[] height) {
        int l = 1;
        int r = height.length - 2;
        int ml = height[l - 1];
        int mr = height[r+1];
        int res = 0;
        while(l <= r){
            if(ml >= mr){
                res += Math.max(mr - height[r],0);
                mr = Math.max(mr,height[r]);
                r--;
            }else{
                res += Math.max(ml - height[l],0);
                ml = Math.max(ml,height[l]);
                l++;
            }
        }
       return res;
    }
}

