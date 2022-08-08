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
    
}