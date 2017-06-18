package br.com.diegogusava.datastructures.tries;

public class Trie {

    private Node root;

    public Trie() {
        root = new Node(' ');
    }

    /**
     * d i e g o
     * @param word
     */
    public void insert(String word) {

        char[] chars = word.toCharArray();

        Node current = root;

        for (char c : chars) {
            if (current.children[c - 'a'] == null) {
                Node node = new Node(c);
                current.children[c - 'a'] = node;
                current = node;
            } else {
                current = current.children[c - 'a'];
            }
        }
    }

    /**
     * Time Complexity: O(length(key))
     *
     * @param word
     * @return
     */
    public boolean search(String word) {

        char[] chars = word.toCharArray();

        Node current = root;

        for (char c : chars) {
            if (current.children[c - 'a'] == null) {
                return false;
            } else {
                current = current.children[c - 'a'];
            }
        }

        return true;

    }

}
