/* Authors: Abdullah Sahapdeen - Id: asahapde - Student Number: 251033977 and Mayank Sood - Id: msood - Student Number: 251000865
   Date Created: November 4, 2019
*/
public class SinglyLinkedList<E>{

  private Node<E> first;
  private Node<E> last;
  private int size;

  private static class Node<E>{
    private E element;
    private Node<E> next;

    public Node(E e, Node<E> n){
      element = e;
      next = n;
    }
    public E getElement(){
      return element;
    }
    public Node<E> getNext(){
      return next;
    }
    public void setNext(Node<E> n){
      next = n;
    }
  }

  public SinglyLinkedList(){
    first = new Node<E>(null,null);
    last = new Node<E>(null,null);
    size = 0;
  }

  public int size(){
    return size;
  }

  public boolean isEmpty(){
    return (size==0);
  }

  public E first(){
    if (!isEmpty())
      return first.getElement();
    return null;
  }

  public E last(){
    if (!isEmpty())
      return last.getElement();
    return null;
  }

  public void addFirst(E element){
    Node<E> node = new Node<E>(element,null);
    node.setNext(first);
    first = node;
    if(isEmpty()) last = node;
    size++;
  }

  public void addLast(E element){
    Node<E> node = new Node<E>(element,null);
    if(isEmpty()){
      first = node;
      last = node;
      size++;
    }
    else {
      last.setNext(node);
      last = node;
      size++;
    }
  }

  public E removeFirst(){
    if(isEmpty()) return null;
    E temp = first.getElement();
    if(first==last){
      first = null;
      last = null;
    }
    else{
      first = first.getNext();
    }
    size--;
    return temp;
  }

}
