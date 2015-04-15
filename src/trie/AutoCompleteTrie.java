/**
 * 
 */
package trie;
import java.util.*;
import java.util.Map.Entry;

/**
 * @author Thierry Edson Noumessi
 *
 * @date Apr 14, 2015
 * @12:30:42 AM
 * @AutoComplete.java
 */


public class AutoCompleteTrie {

    protected final Map<Character, AutoCompleteTrie> children;
    protected String value;
    protected boolean isWord = false;

    public AutoCompleteTrie() {
        this(null);
    }

    private AutoCompleteTrie(String value) {
        this.value = value;
        children = new HashMap<Character, AutoCompleteTrie>();
    }
    
    public void insert(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Can't Add NULL.");
        }
        AutoCompleteTrie node = this;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.add(c);
            }
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    protected void add(char c) {
        String val;
        if (this.value == null) {
            val = Character.toString(c);
        } else {
            val = this.value + c;
        }
        children.put(c, new AutoCompleteTrie(val));
    }

    public String find(String word) {
        AutoCompleteTrie node = this;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return "";
            }
            node = node.children.get(c);
        }
        return node.value;
    }

    public Collection<String> autoComplete(String prefix) {
        AutoCompleteTrie node = this;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return Collections.emptyList();
            }
            node = node.children.get(c);
        }
        return node.allPrefixes();
    }

    protected Collection<String> allPrefixes() {
        List<String> results = new ArrayList<String>();
        if (this.isWord) {
            results.add(this.value);
        }
        for (Entry<Character, AutoCompleteTrie> entry : children.entrySet()) {
            AutoCompleteTrie child = entry.getValue();
            Collection<String> childPrefixes = child.allPrefixes();
            results.addAll(childPrefixes);
        }
        return results;
    }
    
    public static void main(String[] args) {
		AutoCompleteTrie root = new AutoCompleteTrie();
		root.insert("team.com");
		root.insert("tea.in");
		root.insert("teamwork.org");
		root.insert("teams.com");
		root.insert("pot.uk");
		root.insert("potter.in");
		root.insert("post.com");
		
		Collection<String> results = root.autoComplete("te") ;
		for (String string : results) {
			System.out.println(" "+ string);
		}
	}
}
