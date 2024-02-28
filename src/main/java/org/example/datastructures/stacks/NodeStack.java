package org.example.datastructures.stacks;

public class NodeStack<Item> {
    private Item data;

    private static NodeStack<?> head;
    private NodeStack<?> previous;
    private static int size = 0;

    public NodeStack() {
    }

    private NodeStack(Item item) {
        this.data = item;
    }
    public void push(Item item) {
        NodeStack<Item> newNs = new NodeStack<Item>(item);

        if (this.isEmpty()) {
            NodeStack.setHead(new NodeStack<>(item));
            newNs.setNext(null);
            newNs.setPrevious(null);
        } else {
            newNs.setPrevious(NodeStack.head);
            NodeStack.head.setNext(newNs);
            NodeStack.setHead(newNs);
        }

        NodeStack.setSize(NodeStack.getSize() + 1);
    }
    public Item pop() {
        Item item = (Item) NodeStack.head.getData();

        NodeStack.setHead(NodeStack.head.getPrevious());
        NodeStack.head.setNext(null);

        NodeStack.setSize(NodeStack.getSize() - 1);

        return item;
    }

    public Item peek() {
        return (Item) NodeStack.head.getData();
    }

    public boolean isEmpty() {
        return NodeStack.getSize() == 0;
    }

    public int size() {
        return NodeStack.getSize();
    }

    public void print() {
        for (NodeStack<?> n = NodeStack.head; n != null; n = n.previous) {
            System.out.println(n.getData().toString());
        }
    }

    private static void setHead(NodeStack<?> ns) {
        NodeStack.head = ns;
    }

    private void setNext(NodeStack<?> next) {
    }

    private NodeStack<?> getPrevious() {
        return previous;
    }

    private void setPrevious(NodeStack<?> previous) {
        this.previous = previous;
    }

    private static int getSize() {
        return size;
    }

    private static void setSize(int size) {
        NodeStack.size = size;
    }

    private Item getData() {
        return this.data;
    }
}
