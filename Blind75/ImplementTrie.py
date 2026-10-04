'''
https://neetcode.io/problems/implement-prefix-tree/history?submissionIndex=2 
'''

class PrieNode:
    def __init__(self, character: str):
        self.character = character
        self.isWord = False
        #Maps strings to prienodes
        self.children = {}

class PrefixTree:

    def __init__(self):
        self.prie = PrieNode("")

    def insert(self, word: str) -> None:
        current = self.prie
        for let in word:
            if let in current.children:
                current = current.children[let]
            else:
                temp = PrieNode(let)
                current.children[let] = temp
                current = temp
        current.isWord = True

    def search(self, word: str) -> bool:
        current = self.prie
        for let in word:
            if let in current.children:
                current = current.children[let]
            else:
                return False
        return current.isWord


    def startsWith(self, prefix: str) -> bool:
        current = self.prie
        for let in prefix:
            if let in current.children:
                current = current.children[let]
            else:
                return False
        return True