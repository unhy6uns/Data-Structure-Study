# Prob.1
더미 헤드를 사용하지 않는 경우 맨 앞의 원소를 삭제하는 경우와 다른 원소를 삭제하는 경우에 다른 알고리즘을 써야 한다.  
그러나 더미 헤드를 사용하면 하나의 알고리즘으로 모든 경우에 원소를 삭제할 수 있다.  
원소를 추가하는 경우에도 마찬가지이다.  
단점으로는 더미헤드 만큼의 메모리를 추가로 사용해야 한다는 점이 있다.

# Prob.2
```
public boolean contains(E x){
    if(indexOf(x) == NOT_FOUND) return false;
    else return true;
}
```

# Prob.3
## void add(int index, Integer x)
```
public void add(int index, integer x){
    if (numItems >= item.length || index < 1 || index > numItems + 1){  // index의 범위 수정
    /* 에러 처리 */
    } else {
        for (int i = numItems - 1; i >= index - 1; i--) // for문의 범위 수정
            item[i + 1] = item[i];
        item[index - 1] = x;
        numItems++;
    }
}
```
## void append(Integer x)
```
publid void append(Integer x) {
    if (numItems >= item.length){
        /* 에러 처리 */
    } else {
        item[++numItems] = x;   // ++연산자를 앞으로 변경
    }
}
```
## Integer remove(int index)
```
public Integer remove(int index){
    if (isEmpty() || index < 1 || index > numItems)
        return null;
    else {
        Integer tmp = item[index - 1];  //index - 1의 원소를 tmp에 저장
        for (int i = index - 1; i <= numItems - 2; i++) // for문의 범위 수정
            item[i] = item[i+1];
        numItems--;
        return tmp;
    }
}
```
## Integer get(int index)
```
public Integer get(int index) {
    if (index >= 1 && index <= numItems)    //조건문의 범위 수정
        return item[index - 1]; //반환하는 원소 수정
    else
        return null;
}
```
## void set(int index, Integer x)
```
public void set(int index, Integer x){
    if (index >= 1 && index <= numItems - 1)
        item[index - 1] = x;
    else { /* 에러 처리 */ }
}
```
## int indexOf(E x)
```
public int idnexOf(E x) {
    int i=1;
    for (i=1; i<= numItems; i++){
        if(((Comparable)item[i]).compareTo(x)==0)
            return i;
    }
    return NOT_FOUNC;
}
```
# Prob.4
```
public void printInterval(int i, int j){
    if (i<=j && i>=0 && j<numItems){
        for(int k=i; k<=j; k++){
            System.out.println(item[k]);
        }
    } else {/* 에러 처리 */}
}
```
# Prob.5
```
public void printInterval(int i, int j){
    if (i<=j && i>=0 && j<numItems){
        Node<E> node = getNode(i);
        for(int k=i; k<=j; k++){
            System.out.println(node.item);
            node = node.next;
        }
    } else { /* 에러 처리 */ }
}
```
# Prob.6
## 재귀를 사용하지 않는 알고리즘
```
public int numItems() {
    Node now = head;
    int count = 0;
    while(now.item!=null){
        count++;
        now = now.next;
    }
    return count;
}
```
## 재귀를 사용하는 알고리즘
호출하고 나면 원래 리스트가 빈 리스트가 되는데,,
```
public int numItems() {
    remove(0);
    if(head.item == null){
        return 0;
    } else {
        return 1 + numItems();
    }
}
```
다른 메소드도 써도 되나?
```
public int numItems() {
    Node tmp = get(0);
    remove(0);
    if(isEmpty()){
        add(0,tmp);
        return 0;
    } else {
        int count = 1 + numItems();
        add(0,tmp);
        return count;
    }
}
```
# Prob.7
```
public void remove(int index, int k) {
    if (index >= 0 && index <= numItems - 1) {
        Node prevNode = getNode(index - 1);
        prevNode.next = prevnode.next.next;
        numItems--;
        if(index <= numItems - 1)
            remove(int index, int k-1);
    } else { /* 에러 처리 */}
}
```
# Prob.8
```
public void add(int x){
    BidirectionalNode itr = head.next;
    while(x > itr.item){
        itr = itr.next;
    }
    BidirectionalNode newNode = new BidirectionalNode(x,itr.prev,itr);
    itr.prev = newNode;
    itr.prev.next = newNode;
}
```
# Prob.9
```
public void concat(LinkedList list1, LinkedList list2) {
    Node lastOf1;
    Node firstOf2;
    lastOf1 = list1.getNode(list1.len()-1);
    firstOf2 = list2.getNode(0);
    lastOf1.next = firstOf2;
}
```
# Prob.10 
```
public static boolean isSameList(Node<E> node1, Node<E> node2){
    Node itr = node1;
    while(itr.item!=null){
        if(itr==node2)
            return true;
        else
            itr = itr.next;
    }
    itr = node2;
    while(itr.item!=null){
        if(itr==node1)
            return true;
        else
            itr = itr.next;
    }
    return false;
}
```
# Prob.11
```
public int lastIndexOf(Integer x){
    int i = 0;
    for (i = numItems - 1; i>=0; i--){
        if(((Comparable)item[i]).compareTo(x) == 0)
            return i;
    }
    return NOT_FOUND;
}
```
# Prob.12
```
public int lastIndexOf(E x){
    Node<E> currNode = head;
    int i;
    int index=0;
    for (i=0; i<numItems>; i++){
        currNode = currNode.next;
        if(((Comparable)(currNode.item)).compareTo(x) == 0){
            index = i;
        }
    }
    return index;
}
```