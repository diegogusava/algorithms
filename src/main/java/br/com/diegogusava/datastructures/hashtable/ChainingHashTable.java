package br.com.diegogusava.datastructures.hashtable;

public class ChainingHashTable {

    private Entry[] table;

    public ChainingHashTable(int size) {
        table = new Entry[size];
    }

    public boolean put(int key, int value) {

        Entry item = new Entry(key, value);

        int index = hash(key);

        if (table[index] == null) {
            table[index] = item;
            return true;
        } else {
            Entry current = table[index];
            while (current != null) {
                if (current.key == key) {
                    //update value
                    current.value = value;
                    return true;
                } else {
                    if (current.next == null) {
                        current.next = item;
                        return true;
                    } else {
                        current = current.next;
                    }
                }
            }
        }

        return false;

    }

    public Integer get(int key) {
        int index = hash(key);

        Entry current = table[index];

        if (current == null) {
            return null;
        }

        if (current.key == key) {
            return current.value;
        } else {
            current = current.next;
            while (current != null) {
                if (current.key == key) {
                    return current.value;
                } else {
                    current = current.next;
                }
            }

            return null;
        }
    }

    private int hash(int key) {
        return key % table.length;
    }

}
