public interface LinkedList<Node> {
    
    public Node getHead(); // returns the head node of the linked list
    public int getSize(); // returns the size(number of nodes) of the linked list
    public void insertAtBeginning(int value); // inserts a new node of the given value at the starting of the list
    public void insertAtEnd(int value); // inserts a new node of the given value at the ending of the list
    public void insertAtSpecifiedPosition(int value, int index); // inserts a new node of the given value at the given position of the list
    public void deleteAtBeginning(); // deletes a node at the start of the list
    public void deleteAtEnd(); // deletes a node at the end of the list
    public void deleteASpecificValue(int value); // deletes a node whose value is given, if exists

}