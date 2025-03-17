package java_collection.DSA.SUBSTRING.PrefixSumHashMap;

/*

🔹 Time Complexity: O(n) (Iterate once, use a hash map lookup).
🔹 Space Complexity: O(n) (Storing prefix differences).

Scenarios Where Prefix Sum + Hash Map is Used
    The Prefix Sum + Hash Map algorithm is particularly useful in scenarios where we need to efficiently find subarrays
    or substrings that satisfy a given condition. The main idea is to store the prefix sum at each index and use a hash
    map to detect when a condition is met.

📌 When to Use Prefix Sum + Hash Map
    1. Finding Longest/Balanced Subarray
        If a problem asks for the longest contiguous subarray with specific properties (equal counts, target sum, etc.),
         Prefix Sum + Hash Map is often the best approach.

    2. Checking Subarrays with Target Conditions
        If the problem requires checking whether a subarray exists that meets a given condition, we can use a hash map
        to quickly look up prefix sum differences.

    3. Optimizing Sum-Based Problems
        If a problem involves computing sum-based conditions in O(1) time instead of O(n²) brute force, prefix sum helps
         in reducing complexity.

🚀 Key Scenarios & Examples
    1️⃣ Longest Subarray with Equal 0s and 1s
        🔹 Scenario: Given a binary array, find the longest contiguous subarray with an equal number of 0s and 1s.
        ✅ Use Case:
            Convert 0 to -1, then find the longest subarray with sum 0.
            Use a hash map to store the first occurrence of each prefix sum.

    2️⃣ Longest Subarray with Sum K
        🔹 Scenario: Given an integer array, find the longest subarray that sums to a given K.
        ✅ Use Case:
            Compute the prefix sum and store the first occurrence in a hash map.
            If prefixSum - K exists, the subarray between indices is a valid solution.

    3️⃣ Contiguous Subarray with Equal Positive and Negative Numbers
        🔹 Scenario: Given an array with positive and negative numbers, find the longest subarray where the sum is zero.
        ✅ Use Case:
            Convert positive numbers to +1 and negative numbers to -1.
            Use a hash map to track prefix sum occurrences.
            If the same prefix sum appears, it means the subarray between them is balanced.

    4️⃣ Balanced Substring (Two Characters)
        🔹 Scenario: Given a string containing only two types of characters (c1 and c2), find the longest balanced
        substring.
        ✅ Use Case:
            Assign +1 for c1 and -1 for c2, reducing the problem to longest subarray with sum 0.
            Use a hash map to store prefix sum indices.

    5️⃣ Longest Subarray with Equal Even and Odd Numbers
        🔹 Scenario: Find the longest subarray where the number of even and odd numbers is equal.
        ✅ Use Case:
            Convert even numbers to +1 and odd numbers to -1.
            Apply the prefix sum + hash map technique.

💡 Summary

    Problem Type	                Transformation	                    Condition to Check

    Equal 0s and 1s	                Convert 0 → -1	                    Find longest subarray with sum 0
    Subarray Sum K	                Use normal prefix sum	            Check prefixSum - K in hash map
    Equal As, Bs, Cs	            Use frequency difference	        Find repeating (countA, countB)
    Equal Positives & Negatives	    Convert +1 and -1	                Find longest subarray with sum 0
    Balanced Substring	            Convert characters to +1/-1	        Find longest subarray with sum 0
    Equal Even & Odd	            Convert even → +1, odd → -1	        Find longest subarray with sum 0
*/
