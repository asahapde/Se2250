/* Authors: Abdullah Sahapdeen - Id: asahapde - Student Number: 251033977 and Mayank Sood - Id: msood - Student Number: 251000865
   Date Created: November 4, 2019
*/
public class LinkedListQueue<E> implements Queue<E>{
  SinglyLinkedList<E> linkedList;

  public LinkedListQueue(){
    linkedList = new SinglyLinkedList<E>();
  }
  public int size(){
    return linkedList.size();
  }
  public boolean isEmpty(){
    return linkedList.isEmpty();
  }
  public E first(){
    return linkedList.first();
  }
  public void enqueue(E node){
    linkedList.addLast(node);
  }
  public E dequeue(){
    return linkedList.removeFirst();
  }
}
