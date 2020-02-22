import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class OddDialog extends JInternalFrame {
   
   private static OddDialog instance = null;
   
   private JTextField tf;
   private JButton btn;
   private JLabel lbl, lbl2;
   private JPanel upperPanel, lowerPanel;

   // private constructor
   private OddDialog() {
      
      // call constructor of JInternalFrame
      // Arguments: title, resizability, closability, 
      //               maximizability, and iconifiability
      super("Odd", false, true, false, false);
      
      tf = new JTextField(10);
      btn = new JButton("Odd?");
      lbl = new JLabel("Answer: ");
      lbl2 = new JLabel();      
      upperPanel = new JPanel();
      lowerPanel = new JPanel();
      upperPanel.setLayout(new FlowLayout());
      upperPanel.setLayout(new FlowLayout());
     
      upperPanel.add(tf);
      upperPanel.add(btn);
      
      lowerPanel.add(lbl);
      lowerPanel.add(lbl2);
      
      add(upperPanel, BorderLayout.NORTH);
      add(lowerPanel, BorderLayout.SOUTH);
      // add button listener
      btn.addActionListener(new ActionListener() { 
         public void actionPerformed(ActionEvent e) { 
            oddActionPerformed();
         } 
      });      
      
      setBounds(25, 25, 250, 120);
      setLocation(100, 100);
      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      
   } // end private constructor 
   public static OddDialog getInstance() {
      if(instance == null) {
         instance = new OddDialog();
      }
      return instance;
   }
   private void oddActionPerformed() {

      int input = 0;
      lbl2.setText("");
      try {
         input = Integer.parseInt(tf.getText());
         if(input % 2 != 0) {
            lbl2.setText("Yes!");
         }
         else {
            lbl2.setText("Nope!");
         }
      }
      catch(Exception e) {
         JOptionPane.showMessageDialog(this, "Bad input! Try again.");
      }
      
   } // end oddActionPerformed
   
} // end class OddDialog