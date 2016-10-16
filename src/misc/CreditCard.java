package misc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CreditCard {
    
    class Result {
        boolean isWord;
        CardType cardType;
        
        Result(boolean isWord, CardType cardType) {
            this.isWord = isWord;
            this.cardType = cardType;
        }
        
        @Override
        public String toString() {
            return String.format("%s: %s", isWord, cardType);
        }
    }
    
    class Trie {
        TrieNode root;
        
        public Trie() {
            root = new TrieNode(' ', true, CardType.UNAVAILABLE);
        }
        
        Result hasWord(String word) {
            TrieNode node = root;
            for(int i = 0; i < word.length() - 1; i++) {
                char c = word.charAt(i);
                boolean match = false;
                for(TrieNode child : node.children) {
                    if(child.data == c) {
                        match = true;
                        node = child;
                        break;
                    }
                }
                if(!match) {
                    return new Result(false, CardType.UNAVAILABLE);
                }
            }
            char lastChar = word.charAt(word.length() - 1);
            for(TrieNode child : node.children) {
                if(child.data == lastChar && child.isWord) {
                    return new Result(true, child.cardType);
                }
            }
            return new Result(false, CardType.UNAVAILABLE);
        }
    
        void addWord(String word, CardType cardType) {
            TrieNode node = root;
            for(int i = 0; i < word.length() - 1; i++) {
                char c = word.charAt(i);
                TrieNode match = null;
                for(TrieNode child : node.children) {
                    if(child.data == c) {
                        match = child;
                        break;
                    }
                }
                if(match == null) {
                    match = new TrieNode(c, false, CardType.UNAVAILABLE);
                    node.addChildren(match);
                }
                node = match;
            }
            char lastChar = word.charAt(word.length() - 1);
            boolean exists = false;
            for(TrieNode child : node.children) {
                if(child.data == lastChar) {
                    exists = true;
                    child.isWord = true;
                    break;
                }
            }
            if(!exists) {
                TrieNode last = new TrieNode(lastChar, true, cardType);
                node.children.add(last);
            }
        }
    }
    
    class TrieNode {
        char data;
        boolean isWord;
        CardType cardType;
        Set<TrieNode> children;
        
        TrieNode(char data, boolean isWord, CardType cardType) {
            this.data = data;
            this.isWord = isWord;
            this.cardType = cardType;
            children = new HashSet<>();
        }
        
        void addChildren(TrieNode...nodes) {
            children.addAll(Arrays.asList(nodes));
        }
        
        @Override
        public String toString() {
            return String.format("%s", data);
        }
    }
    
    enum CardType {
        VISAELECTRON(16, "4026", "417500", "4405", "4508", "4844", "4913", "4917"),
        VISA(16, "4"),
        AMEX(15, "34", "37"),
        DC(14, "36"),
        UNAVAILABLE(-1);
        
        Set<String> prefixes;
        int length;
        
        private CardType(int length, String... prefixes) {
            this.length = length;
            this.prefixes = new HashSet<>(Arrays.asList(prefixes));
        }
    }
    
    private Trie trie;
    
    public CreditCard() {
        trie = new Trie();
        for(CardType ct : CardType.values()) {
            for(String prefix : ct.prefixes) {
                trie.addWord(prefix, ct);
            }
        }
        for(TrieNode child : trie.root.children) {
            System.out.println(child + " " + child.isWord + " " + child.cardType);
        }
    }
    
    CardType findIssuer(String cardNumber) {
        CardType candidate = CardType.UNAVAILABLE;
        StringBuilder build = new StringBuilder();
        for(int i = 0; i < cardNumber.length(); i++) {
            build.append(cardNumber.charAt(i));
            Result result = trie.hasWord(build.toString());
            if(result.isWord) {
                candidate = result.cardType;
            }
        }
        return (candidate.length == cardNumber.length()) ? candidate : CardType.UNAVAILABLE;
    }
    
    public static void main(String[] args) {
        CreditCard cc = new CreditCard();
        String[] ccs = new String[]{
                                    "4175004175004172",
                                    "4917491749174917",
                                    "346416800707698",
                                    "376416800707698",
                                    "37641680070769832112",
                                    "36641680070769",
                                    "54545641680070769",
                                    "4111111111111111"};
        
        for(String card : ccs) {
            System.out.println(cc.findIssuer(card));
        }
    }

}
