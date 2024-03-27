/*  Node class for the Double Linked List
 */

public class NodeD{
    
    // instance variables
    private NodeD previousNode;
    private int data;
    private NodeD nextNode;

    // constructor
    public NodeD(int value){
        previousNode= null;
        data = value;
        nextNode = null;
    }

    // methods
    int getData(){
        return this.data;
    }

    NodeD getPreviousNode(){
        return this.previousNode;
    }

    NodeD getNextNode(){
        return this.nextNode;
    }
    
    void setData(int value){
        this.data = value;
    }

    void setPreviousNode(NodeD previous){
        this.previousNode = previous;
    }

    void setNextNode(NodeD right){
        this.nextNode = right;
    }

}