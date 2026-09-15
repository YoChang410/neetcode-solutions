# Working

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

from collections import deque
from typing import Optional

class Codec:
    
    # Encodes a tree to a single string.
    def serialize(self, root: Optional[TreeNode]) -> str:
        if root == None or root.val == None:
            return ''
        s = deque()
        ans = ''
        s.append(root)
        while s:
            cur = s.pop()
            ans = ans + str(cur.val) + " "
            if not (cur.val == 'N' or cur.val == 'E'):
                if cur.right == None and cur.left == None:
                    s.append(TreeNode('E', None, None))
                else:
                    if cur.right == None:
                        s.append(TreeNode('N', None, None))
                    else:
                        s.append(cur.right)    
                    if cur.left == None:
                        s.append(TreeNode('N', None, None))
                    else:
                        s.append(cur.left)    
        print('ans is ' + ans)
        return ans
            

        
    # Decodes your encoded data to tree.
    def deserialize(self, data: str) -> Optional[TreeNode]:
        if data == '':
            return None
        s = deque()
        skipLeft = False
        root = None
        for c in data.split():
            print(c)
            if root == None:
                root = TreeNode(int(c), None, None)
                s.append(root)
            else:
                if not s:
                    print('deque empty')
                last = s[-1]
                if c == 'E':
                    s.pop()
                    continue
                elif c == 'N':
                    if not last.left == None:
                        s.pop()
                        continue
                    else:
                        skipLeft = True
                else:
                    if skipLeft:
                        last.right = TreeNode(int(c), None, None)
                        s.pop()
                        s.append(last.right)
                        skipLeft = False
                    else:
                        if last.left == None:
                            last.left = TreeNode(int(c), None, None)
                            s.append(last.left)
                        else:
                            last.right = TreeNode(int(c), None, None)
                            s.pop()
                            s.append(last.right)
        return root