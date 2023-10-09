class FirstNonRepeatingStream {
  private Node[] chatacters_Array;
  private Node head;
  private Node tail;

  private class Node {
    char character;
    Node next;
    Node prev;

    Node(char c) {
      character = c;
    }
  }

  public FirstNonRepeatingStream() {
    chatacters_Array = new Node[256]; //  ASCII characters
    head = null;
    tail = null;
  }

  public void add(char c) {
    int index = (int) c;
    if (chatacters_Array[index] == null) {
      Node newNode = new Node(c);
      chatacters_Array[index] = newNode;
      if (head == null) {
        head = newNode;
        tail = newNode;
      } else {
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
      }
    } else if (chatacters_Array[index] != null) {
      Node existing_Char = chatacters_Array[index];
      if (existing_Char != null) {
        if (existing_Char == head) {
          head = existing_Char.next;
          if (head != null) {
            head.prev = null;
          }
        } else {
          if (existing_Char.prev != null) existing_Char.prev.next = existing_Char.next;
        }
        if (existing_Char == tail) {
          tail = existing_Char.prev;
        } else {
          existing_Char.next.prev = existing_Char.prev;
        }
        chatacters_Array[index] = null; // Mark as repeated
      }
    }
  }

  public char getFirstNonRepeating() {
    if (head != null) {
      return head.character;
    }
    return '-';
  }
}

public class Task2 {
  public static void main(String[] args) {
    FirstNonRepeatingStream f = new FirstNonRepeatingStream();
    f.add('a');
    f.add('b');
    f.add('a');
    System.out.println(f.getFirstNonRepeating()); // Output: 'b'

    f.add('b');
    System.out.println(f.getFirstNonRepeating()); // Output: '-'
    FirstNonRepeatingStream f1 = new FirstNonRepeatingStream();
    f1.add('a');
    f1.add('b');
    f1.add('c');
    f1.add('b');
    System.out.println(f1.getFirstNonRepeating()); // Output: 'a'
  }
}
