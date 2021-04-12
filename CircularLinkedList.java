public class CircularLinkedList {

   public static void main(String[] args){
        CircularLinkedList list = new CircularLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.traverse();
        //list.insertInBetween(2, 66);
        list.deleteByIndex(5);

    }//main end


    //---------------Node class---------------
    class Node{
        private int data;
        private Node next;
        private Node previous;


        public Node(int data){
            this.data = data;
            next = null;
            previous = null;
        }//Node constructor
    }//--------------Node class end---------------

    private Node head;
   private Node lastNode;

    void CircularLinkedList(){
        head.data = 0;
        head.next = null;
        head.previous = null;
    }//CircularLinkedList constructor end

    //-------------Method to insert a new node to the list--------------
    void insert(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            head.next = head;
            head.previous = head;
            lastNode = head;
        }
        else {
            Node temp = head;
            while(temp.next != head) {
                temp = temp.next;
            }
            newNode.previous = temp;
            temp.next = newNode;
            newNode.next = head;
            head.previous = newNode;
            lastNode = newNode;
        }
    }//--------------------------insert() end ------------------------

    //-----------Method to traverse all the nodes in the list--------------
    void traverse(){
        if (head == null) System.out.println("List is empty");
        else{
            Node temp = head;
            while(temp.next != head)
            {
                System.out.println("Data:" + temp.data);
                temp = temp.next;
            }//loop end
            System.out.println("Data:" + temp.data);
        }
    }//--------------------traverse() end-------------------------------

    //------------insertInBetween():Insert element in between------------------------------
    void insertInBetween(int index, int data){

        if (head == null){
            System.out.println("List is empty");
            throw new NullPointerException();
        }
        else
        {
            boolean found = false;
            Node temp = head;
            int counter = 1;
            Node prevNode = head;
            while(temp.next != head && !found){
                if (counter == index){
                    Node newNode = new Node(data);
                    if(temp == head){
                        newNode.next = temp;
                        newNode.previous = lastNode;
                        head = newNode;
                        lastNode.next = head;
                    }else {
                        newNode.next = temp;
                        newNode.previous = prevNode;
                        prevNode.next = newNode;
                    }
                    found = true;
                }
                prevNode = temp;
                temp = temp.next;
                counter++;
            }//loop end
            if(index == counter && !found){
                Node newNode = new Node(data);
                newNode.next = temp;
                newNode.previous = prevNode;
                prevNode.next = newNode;
            }
            if(index > counter){
                System.out.println("Position is greater than the list size");
                throw new NullPointerException();
            }
            else{
                System.out.println("After insertion:");
                traverse();
            }
        }

    }//----------insertInBetween() end---------------------------------------

    //------------deleteByIndex():Delete element in between------------------------------
    void deleteByIndex(int index){
        if (head == null){
            System.out.println("Lost is empty");
            throw new NullPointerException();
        }
        else
        {
            boolean found = false;
            Node temp = head;
            int counter = 1;
            Node prevNode = head;
            while(temp.next != head && !found){
                if (counter == index){
                    if(temp == head){
                        head = temp.next;
                        head.previous = lastNode;
                        lastNode.next = head;
                    }
                    else {prevNode.next = temp.next; }
                    found = true;
                    //temp = null;
                }
                else{
                    prevNode = temp;
                    temp = temp.next;
                    counter++;}
            }//loop end
            if(index == counter && !found){
                prevNode.next = head;
            }
            if(index > counter){
                System.out.println("Position given is greater than the list size");
                throw new NullPointerException();
            }
            else {
                System.out.println("After Deletion:");
                traverse();
            }
        }
    }//----------end deleteByIndex()
}
