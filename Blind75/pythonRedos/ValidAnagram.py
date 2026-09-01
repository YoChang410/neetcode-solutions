from collections import Counter


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # Quick length check — different lengths can't be anagrams
        if len(s) != len(t):
            return False

        # Count character frequencies and compare
        return Counter(s) == Counter(t)
