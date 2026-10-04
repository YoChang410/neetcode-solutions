'''
https://neetcode.io/problems/search-for-word/history?list=blind75&submissionIndex=0
'''

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.board = board
        self.taken = [[False for _ in range(len(board[0]))] for _ in range(len(board))]
        for x in range(len(board)):
            for y in range(len(board[x])):
                if board[x][y] == word[0]:
                    #print("found ", word[0], x, y)
                    self.taken[x][y] = True
                    if self.search(word[1:], x, y):
                        return True
                    self.taken[x][y] = False
        return False


    def search(self, word:str, x:int, y:int) -> bool:
        if len(word) == 0:
            return True
        adjacent = [(x+1, y), (x, y+1), (x-1, y), (x, y-1)]
        for adj in adjacent:
            if adj[0] >= 0 and adj[0] < len(self.board) and adj[1] >= 0 and adj[1] < len(self.board[0]):
                #print("in bounds", adj[0], adj[1])
                if not self.taken[adj[0]][adj[1]]:
                    #print("not taken", adj[0], adj[1])
                    if self.board[adj[0]][adj[1]] == str(word[0]):
                        #print("found ", word[0], adj[0], adj[1])
                        self.taken[adj[0]][adj[1]] = True
                        if self.search(word[1:], adj[0], adj[1]):
                            return True
                        self.taken[adj[0]][adj[1]] = False
        return False