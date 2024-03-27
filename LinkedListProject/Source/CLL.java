import javax.swing.JOptionPane;

/*  Class whose object creates an instance of a Circular Singly Linked List(CLL)
    and performs the abstracts methods of Linked List which include
    Insertion and Deletion of nodes in a CLL.
 */

public class CLL implements LinkedList<NodeC>{
    
    // instance variables
    private NodeC head;
    private NodeC tail;
    private int size;

    // methods
    public NodeC getHead(){
        return this.head;
    }
    
    public int getSize(){
        return this.size;
    }

    public void insertAtBeginning(int value){
        NodeC newNode = new NodeC(value);
        if(head == null){
            head = newNode;
            tail = newNode;
            tail.setNextNode(head);
        }
        else{
            tail.setNextNode(newNode);
            newNode.setNextNode(head);
            head = newNode;
        }
        size++;
    }

    public void insertAtEnd(int value){
        NodeC newNode = new NodeC(value);
        if(head == null){
            head = newNode;
            tail = newNode;
            tail.setNextNode(head);
        }
        else{
            tail.setNextNode(newNode);
            newNode.setNextNode(head);
            tail = newNode;
        }
        size++;
    }

    public void insertAtSpecifiedPosition(int value,int index) {
        try{
            if(index >= 0 && index <= size){
                if(index == 0){
                    insertAtBeginning(value);
                }
                else if(index == size){
                    insertAtEnd(value);
                }
                else{
                    NodeC newNode = new NodeC(value);
                    NodeC temp = head;
                    int i = 1;
                    while(i < index){
                        temp = temp.getNextNode();
                        i++;
                    }
                    newNode.setNextNode(temp.getNextNode());
                    temp.setNextNode(newNode);
                    size++;
                }
            }
            else{
                throw new CLLIndexOutOfBoundsException();
            }
        }catch(CLLIndexOutOfBoundsException cib){
            JOptionPane.showMessageDialog(null, cib, "Index Out of Bounds", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void deleteAtBeginning(){
        if(head == null){
            // System.out.println("No nodes exist.");
            JOptionPane.showMessageDialog(null, "No nodes exist.", "Empty List", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(head.getNextNode() == head){
            head = null;
            tail = null;
            size--;
        }
        else if(head.getNextNode() != head){
            head = head.getNextNode();
            tail.setNextNode(head);
            size--;
        }
    }

    public void deleteAtEnd(){
        if(head == null){
            // System.out.println("No nodes exist.");
            JOptionPane.showMessageDialog(null, "No nodes exist.", "Empty List", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(head.getNextNode() == head){
            head = null;
            tail = null;
            size--;
        }
        else if(head.getNextNode() != head){
            NodeC temp = head;
            while(temp.getNextNode() != tail){
                temp = temp.getNextNode();
            }
            tail = temp;
            tail.setNextNode(head);
            size--;
        }
    }

    public void deleteASpecificValue(int value){
        if(head == null){
            // System.out.println("No nodes exist.");
            JOptionPane.showMessageDialog(null, "No nodes exist.", "Empty List", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if(head.getData() == value){
            if(head.getNextNode() == head){
                head = null;
                tail = null;
            }
            else{
                head = head.getNextNode();
                tail.setNextNode(head);
            }
            size--;
            return;
        }

        NodeC temp = head;
        while(temp.getNextNode() != head){
            if((temp.getNextNode()).getData() == value){
                temp.setNextNode((temp.getNextNode()).getNextNode());
                if(temp.getNextNode() == head){
                    tail = temp;
                }
                size--;
                return;
            }
            temp = temp.getNextNode();
        }
    
        // System.out.println("No node exist with given value.");
        JOptionPane.showMessageDialog(null, "No node exist with given value.", "Not Found", JOptionPane.INFORMATION_MESSAGE);
    }

}