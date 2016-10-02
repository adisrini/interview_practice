public int max(int[] nums) {

  int n = nums.length;

  if(n == 0 || n == 1) {
    return n;
  }

  int[] D = new int[n];
  D[0] = 1;
  Boolean high = null;          // high is whether we are looking for higher
                                // will be null if we haven't started a wiggle sequence yet

  for(int i = 1; i < n; i++) {
    if(high == null) {
      if(nums[i] == nums[i - 1]) {
        D[i] = 1;
      } else {
        D[i] = 2;
        high = D[i] < D[i - 1];
      }
    } else if(high){
      if(D[i] > D[i - 1]) {
        D[i] = D[i - 1] + 1;
        high = false;
      } else {
        D[i] = D[i - 1];
      }
    } else {
      if(D[i] < D[i - 1]) {
        D[i] = D[i - 1] + 1;
        high = true;
      } else {
        D[i] = D[i - 1];
      }
    }
  }

  int max = 1;

  for(int i = 0; i < D.length; i++) {
    if(max < D[i]) {
      max = D[i];
    }
  }

  return max;

}
