# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

from collections import deque
from typing import Optional

class Codec:
    
    # Encodes a tree to a single string.
    def serialize(self, root: Optional[TreeNode]) -> list:
        q = deque()
        ans = list()
        if root is None:
            return ans
        else:
            ans.append(root.val)
            q.append(root.left)
            q.append(root.right)
        while not q:
            node = q.popleft()
            if not node is None:
                ans.append(node.val)
                q.append(node.left)
                q.append(node.right)
            else:
                ans.append(None)
        return ans        

        
    # Decodes your encoded data to tree.
    def deserialize(self, data: list) -> Optional[TreeNode]:
        q = deque()
        root = TreeNode()
        q.append(root)
        first_placed = False
        for i in data:
            if i is None:
            else:
                

        return root