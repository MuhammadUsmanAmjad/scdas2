import java.util.Scanner;

class EmptyStackException extends RuntimeException {
  public EmptyStackException(String message) {
    super(message);
  }
}

class PopEmptyStackException extends RuntimeException {
  public PopEmptyStackException(String message) {
    super(message);
  }
}

class Stack<T> {
  private class Node {
    public Node next;
    public T data;

    public Node(T data) {
      this.data = data;
    }
  }

  private Node top;

  public void push(T data) {
    Node temp = new Node(data);
    temp.next = top;
    top = temp;
  }

  public T pop() {
    if (isEmpty()) {
      throw new EmptyStackException("Stack is empty. Cannot pop.");
    }
    T data = top.data;
    top = top.next;
    return data;
  }

  public T peek() {
    if (isEmpty()) {
      throw new EmptyStackException("Stack is empty. Cannot peek.");
    }
    return top.data;
  }

  public boolean isEmpty() {
    return top == null;
  }
}

public class Task1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Stack<Integer> s = new Stack<Integer>();
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      s.push(sc.nextInt());
    }
    while (!s.isEmpty()) {
      System.out.println(s.pop());
    }

    Stack<String> s2 = new Stack<String>();
    s2.push("a");
    s2.push("b");
    s2.push("c");
    while (!s2.isEmpty()) {
      System.out.println(s2.pop());
    }

    try {
      s2.pop(); // This will throw a PopEmptyStackException
    } catch (PopEmptyStackException e) {
      System.err.println(e.getMessage());
    }
  }
}
