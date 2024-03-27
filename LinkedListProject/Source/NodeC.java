/*  Node class for the Circular Singly Linked List
 */

public class NodeC{
    
    // instance variables
    private int data;
    private NodeC nextNode;

    // constructor
    public NodeC(int value){
        data = value;
        nextNode = null;
    }

    // methods
    int getData(){
        return this.data;
    }

    NodeC getNextNode(){
        return this.nextNode;
    }
    
    void setData(int value){
        this.data = value;
    }

    void setNextNode(NodeC right){
        this.nextNode = right;
    }

}