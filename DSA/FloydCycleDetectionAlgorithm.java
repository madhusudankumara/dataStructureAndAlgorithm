package java_collection.DSA;

public class FloydCycleDetectionAlgorithm {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next;

        Boolean detectCycle = detectCycle(head);

        System.out.println(detectCycle);

    }

    private static Boolean detectCycle(Node node) {
        Node slow = node;
        Node fast = node;

        while (fast != null || fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                System.out.println(slow + "," + fast);
                return true;
            }
        }
        return false;
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
