package java_collection.DSA;


/*
 *
 * Floyd’s Cycle Detection Algorithm is a classic example of the two pointers method.
 *
 * O(n) — You only go through the list once, and inside the cycle, it takes at most k steps (size of cycle) to detect it.
 *
 * */

public class FloydCycleDetectionAlgorithm {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next;

        Boolean detectCycle = detectCycle(head);
        System.out.println("Cycle detected = " + detectCycle);
        int detectCycleStart = detectCycleStart(head);
        System.out.println("cycle entry is at node = "+detectCycleStart);

    }

    private static int detectCycleStart(Node head) {
        Node slow = head;
        Node fast = head;
        Node entry = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                entry=head;
                while(entry!=slow){
                    entry=entry.next;
                    slow=slow.next;
                }
                return entry.data;
            }
        }
        return -1;
    }

    private static Boolean detectCycle(Node node) {
        Node slow = node;
        Node fast = node;

        while (fast != null && fast.next != null) {
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
