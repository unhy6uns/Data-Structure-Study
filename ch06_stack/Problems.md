# Prob.1
오른쪽이 stack top  
15  
15/25  
40  
40/10 
40/10/2  
40/20  
20

# Prob.2
```
public class ListStack implements StackInterface {
    private ListInterface list;
    public ListStack() {
        list = new LinkedList();
    }
    public void push(E newItem){
        list.add(list.len());
    }
    public E pop() {
        E x = list.get(list.len());
        list.remove(list.len());
        return x;
    }
    public E top(){
        return list.get(list.len());
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public void popAll() {
        list.clear();
    }
}
```
# prob.3
```
public class LinkedStack<E> implements StackInterface<E> {
    private Node<E> head;
    private final E ERROR = null;
    public LinkedStack(){
        head = new Node<>(null,null);
    }
    public void push(E newItem) {
        Node<E> newNode = new Node<>();
        newNode.item = newItem;
        newNode.next = head.next;
        head.next = newNode;
    }
    public E pop(){
        if(isEmpty()) return ERROR;
        E temp = head.next.item;
        head.next = head.next.next;
        return temp;
    }
    public E top(){
        if(isEmpty()) return ERROR;
        return head.next.item;
    }
    public boolean isEmpty(){
        return (head.next==null);
    }
    public void popAll(){
        head.next = null;
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

        Stack<Character> stack = new Stack<>();

        character ch;
        int i=0;
        boolean indicator = true;

        while(ch!='$'){
            stack.push(read.charAt(i++));
        }
        while(i<read.length()){
            if(stack.pop()!=read.charAt(++i))
                indicator = false;
                break;
        }

        // indicator의 값이 true이면 주어진 집합의 원소가 맞고, false이면 아니다.
    }
}
// $가 없는 경우 체크 안함
```
# Prob.5
```
public void printAll(){
    for(int i=topIndex; i>=0; i--){
        System.out.println(stack[i]);
    }
}
```
# Prob.6
```
public void printAll() {
    Node<E> currNode = new Node<>();
    currNode = topNode;
    while(currNode!=null){
        System.out.println(currNode.item);
        currNode = currNode.next;
    }
}
```
# Prob.7
코드 6-6 InheritedStack
```
public void printAll() {
    for(int i=len()-1; i>=0; i++){
        System.out.println(get(i));
    }
}
```
코드 6-7 ADT 리스트를 이용한 ListStack
```
public void printAll() {
    for(int i=list.len()-1; i>=0; i++){
        System.out.println(list.get(i));
    }
}
```
# Prob.8
```
public void copyLinkedStack(LinkedStack<E> a, LinkedStack<E> b) {
    b.popAll();
    LinkedStack<E> temp = new LinkedStack<>();
    while(!a.isEmpty()){
        temp.push(a.pop());
    }
    while(!temp.isEmpty()){
        E item;
        item = temp.pop();
        a.push(item);
        b.push(item);
    }
}
```
# Prob.9
```
public void push(E newItem) {
    if (isFull()) {
        E[] largeStack = (E[]) new Object[2*stack.length];
        for(int i=0; i<stack.length; i++){
            largeStack[i] = stack[i];
        }
        largeStack[++topIndex] = newItem;
        stack = largeStack;
    } else stack[++topIndex] = newItem;
}
```
# Prob.10
```
public void printReverse(){
    LinkedStack<E> stack = new LinkedStack<>();
    for(int i=0; i<len(); i++){
        stack.push(get(i));
    }
    while(!stack.isEmpty()){
        System.out.println(stack.pop());
    }
}
```