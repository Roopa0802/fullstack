import java.util.function.Consumer;

public class lList {

    public static void main(String[] args){
        lList list = new lList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.traverse();
        list.insertInBetween(3, 66);
        list.deleteByIndex(5);

    }//main end


        //---------------Node class---------------
        class Node{
            private int data;
            private Node next;


            public Node(int data){
                this.data = data;
                next = null;
            }//Node constructor
        }//--------------Node class end---------------

        private Node head;

        void lList(){
            head.data = 0;
            head.next = null;
        }//lList constructor end

    //-------------Method to insert a new node to the list--------------
        void insert(int data){
            Node newNode = new Node(data);
            if (head == null){
                head = newNode;
            }
            else {
                Node temp = head;
                while(temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }//--------------------------insert() end ------------------------

    //-----------Method to traverse all the nodes in the list--------------
    void traverse(){
            if (head == null) System.out.println("List is empty");
            else{
                Node temp = head;
                while(temp.next != null)
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
            while(temp.next != null && !found){
                if (counter == index){
                    Node newNode = new Node(data);
                    Node currentNode = temp;
                    temp = newNode;
                    temp.next = currentNode;
                    prevNode.next = temp;
                    found = true;
                }
                prevNode = temp;
                temp = temp.next;
                counter++;
            }//loop end
            if(index == counter && !found){
                Node newNode = new Node(data);
                Node currentNode = temp;
                temp = newNode;
                temp.next = currentNode;
                prevNode.next = temp;
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
            while(temp.next != null && !found){
                if (counter == index){
                    prevNode.next = temp.next;
                    found = true;
                    //temp = null;
                }
                else{
                prevNode = temp;
                temp = temp.next;
                counter++;}
            }//loop end
            if(index == counter && !found){
                prevNode.next = null;
                //temp = null;
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

