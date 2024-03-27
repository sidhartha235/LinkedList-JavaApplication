/*  Graphical User Interface for the DLL object which uses
    AWT and Swing packages of Java to demonstrate the creation
    and implementation of a DLL(Doubly Linked List).
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DLLGUI extends JFrame implements ActionListener{

    // instance variables
    private JLabel value, size, index;
    private JTextField valueField, sizeField, indexField;
    private JButton insertButton, deleteButton;
    private JPanel visualizerPanel;
    private JPanel controlPanel;
    private JComboBox<String> deleteComboBox;
    private JComboBox<String> insertComboBox;

    JScrollPane scrollPane;
    JScrollBar horizontalScrollBar;

    LinkedList<NodeD> dll;

    // constructor for Graphical interface
    public DLLGUI(){
        super("Doubly Linked List");
        setLayout(new BorderLayout());
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dll = new DLL(); 

        visualizerPanel = new JPanel(null) {
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.setFont(new Font("Times New Roman", Font.BOLD, 18));
                if(dll.getSize() > 0){
                    NodeD tempNode = dll.getHead();
                    int x = 100, y = 50, w = 100, h = 40;
                    while (tempNode != null) {
                        g.drawRect(x, y, w, h);
                        g.drawRect(x + w, y, w, h);
                        g.drawRect(x + (2*w), y, w, h);
                        if(tempNode.getPreviousNode() != null){
                            g.drawString(Integer.toHexString((tempNode.getPreviousNode()).hashCode()), x + (w/6) , y + (h/2));
                        }
                        else{
                            g.drawString("null", x + (w/3) , y + (h/2));
                        }
                        g.drawString(Integer.toString(tempNode.getData()), x + (3*w/2) , y + (h/2));
                        if(tempNode.getNextNode() != null){
                            g.drawString(Integer.toHexString((tempNode.getNextNode()).hashCode()), x + (13*w/6) , y + (h/2));
                        }
                        else{
                            g.drawString("null", x + (7*w/3) , y + (h/2));
                        }
                        if (tempNode.getNextNode() != null) {
                            int[] x1Points = {x + (3*w) ,x + (3*w) + 50, x + (3*w) + 40, x + (3*w) + 50, x + (3*w) + 40};
                            int[] y1Points = {y + (h/4), y + (h/4), y + (h/4) - 10, y + (h/4), y + (h/4) + 10};
                            g.drawPolyline(x1Points, y1Points, 5);
                            int[] x2Points = {x + (3*w) + 10 ,x + (3*w), x + (3*w) + 10, x + (3*w), x + (3*w) + 50};
                            int[] y2Points = {y + (3*h/4) - 10, y + (3*h/4), y + (3*h/4) + 10, y + (3*h/4), y + (3*h/4)};
                            g.drawPolyline(x2Points, y2Points, 5);
                        }
                        tempNode = tempNode.getNextNode();
                        x += (3*w) + 50;
                    }
                }
                else{
                    removeAll();
                }
            }
        };
        
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        add(controlPanel, BorderLayout.SOUTH);
        
        scrollPane = new JScrollPane(visualizerPanel);
        horizontalScrollBar = scrollPane.getHorizontalScrollBar();
        add(horizontalScrollBar, BorderLayout.NORTH);

        visualizerPanel.setBackground(Color.WHITE);
        add(visualizerPanel, BorderLayout.CENTER);

        String[] insertOptions = {"Insert","Insert At Beginning","Insert At Specific Position","Insert At End"};
        insertComboBox = new JComboBox<String>(insertOptions);
        controlPanel.add(insertComboBox);
        insertComboBox.addActionListener(this);

        insertButton = new JButton("Insert");
        insertButton.setFocusable(false);
        controlPanel.add(insertButton);
        insertButton.addActionListener(this);

        value = new JLabel("Enter value:");
        controlPanel.add(value);

        valueField = new JTextField("0",5);
        controlPanel.add(valueField);

        index = new JLabel("Position:");
        controlPanel.add(index);

        indexField = new JTextField("0",5);
        controlPanel.add(indexField);
        
        String[] deleteOptions = {"Delete","Delete At Beginning","Delete A Specific Value","Delete At End"};
        deleteComboBox = new JComboBox<String>(deleteOptions);
        controlPanel.add(deleteComboBox);
        deleteComboBox.addActionListener(this);
        
        deleteButton = new JButton("Delete");
        deleteButton.setFocusable(false);
        controlPanel.add(deleteButton);
        deleteButton.addActionListener(this);

        size = new JLabel("Size:");
        controlPanel.add(size);

        sizeField = new JTextField(5);
        sizeField.setEditable(false);
        controlPanel.add(sizeField);

        setLocation(30, 50);
        setSize(1500, 750);
        setResizable(false);
        setVisible(true);
        //pack();
    }

    // action performed method implementation
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == insertComboBox){
            String selectedItem = (String)insertComboBox.getSelectedItem();
            
            switch(selectedItem) {
                case "Insert At Beginning" :
                    valueField.setText("0");
                    indexField.setText("0");
                    valueField.setEditable(true);
                    indexField.setEditable(false);
                    break;
                case "Insert At End" :
                    valueField.setText("0");
                    indexField.setText("0");
                    valueField.setEditable(true);
                    indexField.setEditable(false);
                    break;
                case "Insert At Specific Position" :
                    valueField.setText("0");
                    indexField.setText("0");
                    valueField.setEditable(true);
                    indexField.setEditable(true);
                    break;
            }
        }
        
        if(e.getSource() == deleteComboBox){
            String selectedItem = (String)deleteComboBox.getSelectedItem();
            
            switch(selectedItem) {
                case "Delete At Beginning" :
                    valueField.setText("0");
                    indexField.setText("0");
                    valueField.setEditable(false);
                    indexField.setEditable(false);
                    break;
                case "Delete At End" :
                    valueField.setText("0");
                    indexField.setText("0");
                    valueField.setEditable(false);
                    indexField.setEditable(false);
                    break;
                case "Delete A Specific Value" :
                    valueField.setText("0");
                    indexField.setText("0");
                    valueField.setEditable(true);
                    indexField.setEditable(false);
                    break;
            }
        }

        if(e.getSource() == insertButton){
            int value = Integer.parseInt(valueField.getText());
            String selectedItem = (String)insertComboBox.getSelectedItem();
            
            switch(selectedItem) {
                case "Insert At Beginning" :
                    dll.insertAtBeginning(value);
                    valueField.setText("");
                    sizeField.setText(Integer.toString(dll.getSize()));
                    visualizerPanel.repaint();
                    break;
                case "Insert At End" :
                    dll.insertAtEnd(value);
                    valueField.setText("");
                    sizeField.setText(Integer.toString(dll.getSize()));
                    visualizerPanel.repaint();
                    break;
                case "Insert At Specific Position" :
                    int index = Integer.parseInt(indexField.getText());
                    dll.insertAtSpecifiedPosition(value,index);
                    valueField.setText("");
                    sizeField.setText(Integer.toString(dll.getSize()));
                    visualizerPanel.repaint();
                    break;
            }

            valueField.setText("0");
            indexField.setText("0");
            insertComboBox.setSelectedIndex(0);
            deleteComboBox.setSelectedIndex(0);
        }
        
        if(e.getSource() == deleteButton){
            String selectedItem = (String)deleteComboBox.getSelectedItem();
            
            switch(selectedItem) {
                case "Delete At Beginning" :
                    dll.deleteAtBeginning();
                    valueField.setText("");
                    sizeField.setText(Integer.toString(dll.getSize()));
                    visualizerPanel.repaint();
                    break;
                case "Delete At End" :
                    dll.deleteAtEnd();
                    valueField.setText("");
                    sizeField.setText(Integer.toString(dll.getSize()));
                    visualizerPanel.repaint();
                    break;
                case "Delete A Specific Value" :
                    int value = Integer.parseInt(valueField.getText());
                    dll.deleteASpecificValue(value);
                    valueField.setText("");
                    sizeField.setText(Integer.toString(dll.getSize()));
                    visualizerPanel.repaint();
                    break;
            }

            
            valueField.setText("0");
            indexField.setText("0");
            insertComboBox.setSelectedIndex(0);
            deleteComboBox.setSelectedIndex(0);
        }
    }

}