# Algorithm
This repository will contains steps for prepare algorithm interview.

## 1 Array & Hashtable [2022/04/13 - 2022/04/20]

## 2 Sort Algorithm & Binary Search [2022/04/20 - 2022/04/27]
### 2.1 Sort
#### 2.1.1 Merge Sort
Recursion Function:
  1. Base case: (if n == 0 || n == 1) return;
  2. mergesort(left part), mergesort(right part)
  3. merge(left, right)

Time Complexity:

  **divide**: 1 + 2 + 4 ... + n/2 = 1 + 1 + 2 + 4 + 8 + ... + n/2 - 1 = n/2 + n/2 - 1 = n - 1 = O(N)
  
  **conquer**:
  For each level, we have N nodes to sort in total. And we have log(N) levels. Thus, time complexity in conquer is O(N) * O(log(N)) = O(N*log(N))
  
  ```java
  for (int k = left; k <= right; k++) {
            help[k] = nums[k];
        }

        while (i <= mid && j <= right) {
            if (help[i] < help[j]) {
                nums[index++] = help[i++];
            } else {
                nums[index++] = help[j++];
            }
        }
  ```
  
  In conclusion: Time complexity is O(N) + O(N * log(N)) = O(N * log(N))
##### Array points
 
  1. Use a helper array to sort in `merge()` function, and save result to original nums.
##### LinkedList points
  1. Get mid ListNode:
    a. slow and fast next is head
    b. return slow
  2. Set mid next to null -> cut left and right part
### 2.2 Binary Search
