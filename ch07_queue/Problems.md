# Prob.1
```
public boolean isEmpty() {
    if(head.next.item == null)
        return true;
    else
        return false;
}
```
```
public void enqueue(Object newItem){
    newNode = new Dnode(newItem, head.prev, head);
    head.prev.next = newNode;
    head.prev = newNode;
}
```
```
public Object dequeue() {
    if(isEmpty()) {
        /* 에러 처리 */
    } else {
        Object tmp = head.next.item;
        head.next = head.next.next;
        head.next.prev = head;
    }
}
```
# Prob.2
```
public LinkedQueue() {
    tail = new Node<>(null);
    tail.next = tail;
}
```
```
public void enqueqe(E newItem){
    Node<E> newNode = new Node<>(newItem);
    newNode.next = tail.next;
    tail.next = newNode;
    tail = newNode;
}
```
```
public E dequeue() {
    if (isEmpty()) return ERROR;
    else {
        Node<E> front = tail.next.next;
        tail.next.next = front.next;
        return front.item;
    }
}
```
```
public E front() {
    if (isEmpty()) return ERROR;
    else return tail.next.next.item;
}
```
```
public boolean isEmpty(){
    return (tail.next==tail);
}
```
```
public void dequeueAll() {
    tail.next = tail;
}
```
# Prob.3
```
public class ListQueue implemets QueueInterface {
    private ListInterface list;
    public ListQueue() {
        list = new LinkedList();
    }
    public void enqueue(E newItem) {
        list.add(0,newItem);
    }
    public E dequeue() {
        E x = list.get(list.size()-1);
        list.remove(list.size()-1);
        return x;
    }
    public E front() {
        return list.get(list.size()-1);
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public void dequeueAll() {
        list.clear();
    }
}
```
# Prob.4
```
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String read = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        read = br.readLine();

        Queue<Character> queue = new Queue<>();

        character ch;
        int i=0;
        boolean indicator = true;

        while(ch!='$'){
            if(i<read.length)
                queue.enqueue(read.charAt(i++));
            else
                indicator = false;
                break;
                // 문자열에 $가 포함되지 않은 경우
        }
        while(!queue.isEmpty() && queue.dequeue() == read.charAt(++i)){
        }
        if(!queue.isEmpty())
            indicator = false;

        // indicator의 값이 true이면 주어진 집합의 원소가 맞고, false이면 아니다.
    }
}
```
# Prob.5
```
public void printAll(){
    if(numItems == 0)
        return;
    int l = queue.length;
    while(i=0;i<numItems;i++){
        System.out.println((front+i)%l);
    }
}
```
# Prob.6
```
public void printAll() {
    Node<E> currNode = tail.next;
    if(tail==null)
        return;
    do {
        System.out.println(currNode.item);
        currNode = currNode.next;
    } while (currNode == tail);
}
```
# Prob.7
## 7-6 Inherited Queue
```
public void printAll(){
    int n=len();
    for(int i=0; i<n; i++){
        System.out.println(get(i));
    }
}
```
## 7-7 List Queue (ADT List)
```
public void printAll(){
    int n=list.len();
    for(int i=0; i<n; i++) {
        System.out.println(list.get(i));
    }
}
```
# Prob.8
```
public void copyLinkedQueue(LinkedQueue<E> b){
    LinkedQueue<E> temp;
    clear();
    while(!b.isEmpty()){
        temp.enqueue(b.dequeue);
    }
    E tempItem;
    while(!queue.isEmpty()){
        tempItem = temp.dequeue();
        enqueue(tempItem);
        b.enqueue(tempItem);
    }
}
```
# Prob.9
```
public void enqueue(E newItem) {
    if(isFull(){
        E largeQueue[] = (E[]) new Object[2*numItems];
        int index = front;
        while(index == tail){
            largeQueue[i] = queue[(front+i) % queue.length];
            ++i;
        }
        front = 0;
        tail = numItems-1;
    }
    tail = (tail+1) % queue.length;
    queue[tail] = newItem;
    ++numItems;
}
```