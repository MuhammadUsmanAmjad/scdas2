class FirstNonRepeatingStream {
  private Node[] characters_Array;
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
    characters_Array = new Node[256]; //  ASCII characters
    head = null;
    tail = null;
  }
}

public class Task2 {
  public static void main(String[] args) {
    FirstNonRepeatingStream f = new FirstNonRepeatingStream();
  }
}
