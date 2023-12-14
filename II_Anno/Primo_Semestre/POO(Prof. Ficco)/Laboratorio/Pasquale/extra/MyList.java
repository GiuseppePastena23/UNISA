/**
 * MyList è una classe che rappresenta una lista di interi
 *
 * @version 1.0
 * @since 1.0
 * @see MyNode
 */
public class MyList {
    /**
     * size è la dimensione della lista
     */
    private int size;

    /**
     * head è il primo nodo della lista (se esiste)
     */
    private MyNode head;

    /**
     * Costruttore di default
     * size = 0
     */
    public MyList() {
        size = 0;
    }


    /**
     * Restituisce la dimensione della lista
     * @return size
     */
    public int getSize() {
        return size;
    }


    /**
     * Restituisce il nodo alla posizione index
     * @param index indice del nodo da restituire
     * @return nodo alla posizione index
     */
    private MyNode getNodeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        MyNode tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.getNext();
        }
        return tmp;
    }


    /**
     * Restituisce l'ultimo nodo della lista
     * @return ultimo nodo della lista
     */
    private MyNode getFirstNode() {
        if (size == 0) {
            throw new IllegalStateException("List is empy");
        }
        return getNodeAt(0);
    }

    /**
     * Restituisce l'ultimo nodo della lista
     * @return ultimo nodo della lista
     */
    private MyNode getLastNode() {
        if (size == 0) {
            throw new IllegalStateException("List is empy");
        }
        return getNodeAt(size-1);
    }

    /**
     * Restituisce il valore del nodo alla posizione index
     * @param index indice del nodo da restituire
     * @return valore del nodo alla posizione index
     */
    public int getValueAt(int index) {
        return getNodeAt(index).getValue();
    }

    /**
     * Restituisce il primo valore della lista
     * @return primo valore della lista
     */
    public int getValueFirst() {
        if (size == 0) {
            throw new IllegalStateException("List is empy");
        }
        return getValueAt(0);
    }

    /**
     * Restituisce l'ultimo valore della lista
     * @return ultimo valore della lista
     */
    public int getValueLast() {
        if (size == 0) {
            throw new IllegalStateException("List is empy");
        }
        return getValueAt(size-1);
    }

    /**
     * Aggiunge un nodo con valore value alla posizione index
     * @param index indice in cui aggiungere il nodo
     * @param value valore del nodo da aggiungere
     */
    public void addAt(int index, int value) {
        if (index == 0) {
            addHead(value);
            return;
        }
        else if (index == size) { // adding at last
            append(value);
            return;
        }

        MyNode prev, suc;
        prev = getNodeAt(index-1);
        suc = getNodeAt(index);
        MyNode tmp = new MyNode(value, suc);
        prev.setNext(tmp);
        size++;
    }

    /**
     * Aggiunge un nodo con valore value in testa alla lista
     * @param value valore del nodo da aggiungere
     */
    public void addHead(int value) {
        head = new MyNode(value, head);
        size++;
    }

    /**
     * Aggiunge un nodo con valore value in coda alla lista
     * @param value valore del nodo da aggiungere
     */
    public void append(int value) {
        MyNode nuovo = new MyNode(value);
        if (size == 0) {
            head = nuovo;
        } else {
            MyNode tmp = getLastNode();
            tmp.setNext(nuovo);
        }

        size++;
    }


    /**
     * Rimuove il nodo alla posizione index
     * @param index indice del nodo da rimuovere
     * @return true se l'operazione è andata a buon fine, false altrimenti
     */
    public boolean removeAt(int index) {
        if (size == 0 || index < 0 || index >= size) {
            return false;
        }

        if (index == 0) {
            head = head.getNext();
            size--;
            return true;
        }

        if (index == size-1) {
            MyNode prev = getNodeAt(size-2);
            prev.setNext(null);
            size--;
            return true;
        }

        MyNode prev = getNodeAt(index-1);
        MyNode suc = getNodeAt(index);
        prev.setNext(suc.getNext());
        size--;
        return true;
    }

    /**
     * Rimuove il primo nodo della lista
     * @return true se l'operazione è andata a buon fine, false altrimenti
     */
    public boolean removeFirst() {
        return removeAt(0);
    }

    /**
     * Rimuove l'ultimo nodo della lista
     * @return true se l'operazione è andata a buon fine, false altrimenti
     */
    public boolean removeLast() {
        if (size > 0) {
            return removeAt(size-1);
        }
        return false;
    }

    /**
     * Stampa la lista
     * #index element: value
     */
    public void printListClassic() {
        for (int i = 0; i < size; i++) {
            System.out.println("#" + i + " element: " + getValueAt(i));
        }
    }

    /**
     * Stampa la lista in modo dettagliato
     * #index Node: MyNode{value=value, next=next}
     */
    public void printListDetailed() {
        for (int i = 0; i < size; i++) {
            System.out.println("#" + i + " Node: " + getNodeAt(i).toString());
        }
    }

    @Override
    public String toString() {
        return "MyList{" +
                "size=" + size +
                ", head=" + head +
                '}';
    }


    @Override
    public MyList clone() {
        MyList nuova = new MyList();
        for (int i = 0; i < size; i++) {
            nuova.append(this.getValueAt(i));
        }
        return nuova;
    }

}


/**
 * MyNode è una classe che rappresenta un nodo di una lista formata da interi
 *
 */
class MyNode {
    /**
     * value è il valore del nodo
     */
    private int value;

    /**
     * next è il nodo successivo
     */
    private MyNode next;


    /**
     * Costruttore di default
     * value = 0
     * next = null
     *
     */
    MyNode() {
        value = 0;
        next = null;
    }

    /**
     * Costruttore con valore
     * next = null
     * @param value valore del nodo
     */
    MyNode(int value) {
        this.value = value;
        next = null;
    }

    /**
     * Costruttore con valore e nodo successivo
     * @param value valore del nodo
     * @param next nodo successivo
     */
    MyNode(int value, MyNode next) {
        this.value = value;
        this.next = next;
    }

    /**
     * Imposta il valore del nodo
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Imposta il nodo successivo
     * @param next
     */
    public void setNext(MyNode next) {
        this.next = next;
    }


    /**
     * Restituisce il valore del nodo
     * @return valore del nodo
     */
    public int getValue() {
        return value;
    }

    /**
     * Restituisce il nodo successivo
     * @return nodo successivo
     */
    public MyNode getNext() {
        return next;
    }


    /**
     * Restituisce una stringa che rappresenta il nodo
     * @return
     */
    @Override
    public String toString() {
        return "MyNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }

}
