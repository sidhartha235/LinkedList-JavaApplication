import javax.swing.JOptionPane;

/*  Class whose object creates an instance of a Doubly Linked List(DLL)
    and performs the abstracts methods of Linked List which include
    Insertion and Deletion of nodes in a DLL.
 */

public class DLL implements LinkedList<NodeD>{
    
    // instance variables
    private NodeD head;
    private int size;

    // methods
    public NodeD getHead(){
        return this.head;
    }
    
    public int getSize(){
        return this.size;
    }

    public void insertAtBeginning(int value){
        NodeD newNode = new NodeD(value);
        if(head == null){
            head = newNode;
        }
        else{
            newNode.setNextNode(head);
            head.setPreviousNode(newNode);
            head = newNode;
        }
        size++;
    }

    public void insertAtEnd(int value){
        NodeD newNode = new NodeD(value);
        if(head == null){
            head = newNode;
        }
        else{
            NodeD temporaryNode = head;
            while(temporaryNode.getNextNode() != null){
                temporaryNode = temporaryNode.getNextNode();
            }
            temporaryNode.setNextNode(newNode);
            newNode.setPreviousNode(temporaryNode);
        }
        size++;
    }

    public void insertAtSpecifiedPosition(int value,int index){
        try{
            if(index >= 0 && index <= size){
                if(index == 0){
                    insertAtBeginning(value);
                }
                else if(index == size){
                    insertAtEnd(value);
                }
                else{
                    NodeD newNode = new NodeD(value);
                    NodeD temporaryNode = head;
                    int i = 0;
                    while(i < index){
                        temporaryNode = temporaryNode.getNextNode();
                        i++;
                    }
                    newNode.setNextNode(temporaryNode);
                    newNode.setPreviousNode(temporaryNode.getPreviousNode());
                    temporaryNode.setPreviousNode(newNode);
                    (newNode.getPreviousNode()).setNextNode(newNode);
                    size++;
                }
            }
            else{
                throw new DLLIndexOutOfBoundsException();
            }
        }catch(DLLIndexOutOfBoundsException dib){
            JOptionPane.showMessageDialog(null, dib, "Index Out of Bounds", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void deleteAtBeginning(){
        if(head == null){
            // System.out.println("No nodes exist.");
            JOptionPane.showMessageDialog(null, "No nodes exist.", "Empty List", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(head.getPreviousNode() == null && head.getNextNode() == null){
            head = null;
            size--;
        }
        else if(head.getNextNode() != null){
            (head.getNextNode()).setPreviousNode(null);
            head = head.getNextNode();
            size--;
        }
    }

    public void deleteAtEnd(){
        if(head == null){
            // System.out.println("No nodes exist.");
            JOptionPane.showMessageDialog(null, "No nodes exist.", "Empty List", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(head.getPreviousNode() == null && head.getNextNode() == null){
            head = null;
            size--;
        }
        else if(head.getNextNode() != null){
            NodeD temporaryNode = head;
            while(temporaryNode.getNextNode() != null){
                temporaryNode = temporaryNode.getNextNode();
            }
            (temporaryNode.getPreviousNode()).setNextNode(null);
            temporaryNode.setPreviousNode(null);
            size--;
        }
    }

    public void deleteASpecificValue(int value){
        if(head == null){
            // System.out.println("No nodes exist.");
            JOptionPane.showMessageDialog(null, "No nodes exist.", "Empty List", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if(head.getPreviousNode() == null && head.getNextNode() == null){
            if(head.getData() == value){
                head = null;
                size--;
            }
            return;
        }

        NodeD temporaryNode = head;
        while(temporaryNode != null && temporaryNode.getData() != value){
            temporaryNode = temporaryNode.getNextNode();
        }
        if(temporaryNode == null){
            // System.out.println("Value not found.");
            JOptionPane.showMessageDialog(null, "No node exist with given value.", "Not Found", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if(temporaryNode == head){
            head = temporaryNode.getNextNode();
            head.setPreviousNode(null);
        }
        else if(temporaryNode.getNextNode() == null){
            temporaryNode.getPreviousNode().setNextNode(null);
        }
        else{
            temporaryNode.getPreviousNode().setNextNode(temporaryNode.getNextNode());
            temporaryNode.getNextNode().setPreviousNode(temporaryNode.getPreviousNode());
        }
        temporaryNode.setNextNode(null);
        temporaryNode.setPreviousNode(null);
        size--;
    }
    
}