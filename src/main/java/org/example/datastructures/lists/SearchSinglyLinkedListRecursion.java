package org.example.datastructures.lists;

public class SearchSinglyLinkedListRecursion extends SinglyLinkedList {

    public static void main(String[] args) {
        SearchSinglyLinkedListRecursion list = new SearchSinglyLinkedListRecursion();
        for (int i = 1; i <= 10; ++i) {
            list.insert(i);
        }

        for (int i = 1; i <= 10; ++i) {
            assert list.search(i);
        }
        assert !list.search(-1) && !list.search(100);
    }

    private boolean searchRecursion(Node node, int key) {
        return (node != null && (node.value == key || searchRecursion(node.next, key)));
    }

    @Override
    public boolean search(int key) {
        return searchRecursion(getHead(), key);
    }
}
