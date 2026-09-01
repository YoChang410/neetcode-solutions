//pass
class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;
        int[] lettercountS = new int[26];
        int[] lettercountT = new int[26];
        for(int i=0; i<s.length(); i++){
            lettercountS[s.charAt(i)-97] ++;
            lettercountT[t.charAt(i)-97] ++;
        }
        for(int i=0; i<26; i++){
            if(lettercountS[i] != lettercountT[i]){
                return false;
            }
        }
        return true;

    }
}
