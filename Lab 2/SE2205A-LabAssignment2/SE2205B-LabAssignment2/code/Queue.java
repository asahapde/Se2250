/* Authors: Abdullah Sahapdeen - Id: asahapde - Student Number: 251033977 and Mayank Sood - Id: msood - Student Number: 251000865
   Date Created: November 4, 2019
*/
public interface Queue<E>{
  int size();
  boolean isEmpty();
  E first();
  void enqueue(E node);
  E dequeue();
}
