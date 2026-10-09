'''
https://neetcode.io/problems/design-word-search-data-structure/question?list=blind75
'''

class PrieNode:
    def __init__(self, character: str):
        self.character = character
        self.isWord = False
        #Maps strings to prienodes
        self.children = {}

class WordDictionary:

    def __init__(self):
        self.prie = PrieNode("")

    def addWord(self, word: str) -> None:
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
        return self.find(self.prie, word)
    
    def find(self, current: PrieNode, word: str) -> bool:
        #print("finding", word)
        if len(word) == 0:
            return current.isWord
        if word[0] == ".":
            #print("iterating all children")
            for _, node in list(current.children.items()):
                if self.find(node, word[1:]):
                    return True
            return False
        else:
            #print("searching for specific child")
            if word[0] not in current.children:
                return False
            else:
                return self.find(current.children[word[0]], word[1:])
            

