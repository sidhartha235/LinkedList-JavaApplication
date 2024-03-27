import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI implements ActionListener{
    
    JButton dll;
    JButton cll;

    GUI(){
        JFrame linkedList = new JFrame("Linked List");
        linkedList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        linkedList.setLayout(new FlowLayout());
        linkedList.setLocation(600, 350);
        
        dll = new JButton("Double Linked List");
        cll = new JButton("Circular Singly Linked List");

        dll.setFont(new Font("Times New Roman", Font.BOLD, 20));
        cll.setFont(new Font("Times New Roman", Font.BOLD, 20));

        dll.setFocusable(false);
        cll.setFocusable(false);
        
        dll.addActionListener(this);
        cll.addActionListener(this);
        
        linkedList.add(dll);
        linkedList.add(cll);

        linkedList.setSize(300, 120);
        linkedList.setResizable(false);
        linkedList.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == dll){
            new DLLGUI();
        }
        if(e.getSource() == cll){
            new CLLGUI();
        }
    }
}