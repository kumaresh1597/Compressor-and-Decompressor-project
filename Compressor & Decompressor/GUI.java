import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GUI extends JFrame implements ActionListener{

    JButton compressButton = new JButton("Select File to compress");
    JButton DecompressButton = new JButton("Select File to Decompress");

    GUI(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel head = new JLabel("COMPRESSOR & DECOMPRESSOR");
        head.setFont(new Font("Arial", Font.BOLD, 30));
        head.setForeground(Color.yellow);
        head.setBounds(250, 50, 600, 50);
        this.add(head);

        JLabel head2 = new JLabel("Select any files");
        head2.setFont(new Font("Arial", Font.BOLD, 20));
        head2.setForeground(Color.RED);
        head2.setBounds(450, 80, 600, 50);
        this.add(head2);

        JLabel Fimage = new JLabel();
        Fimage.setIcon(new ImageIcon("fileimage.jpg"));
        Dimension s = Fimage.getPreferredSize();
        Fimage.setBounds(200, 300,s.width, s.height);
        this.add(Fimage);

        JLabel Zimage = new JLabel();
        Zimage.setIcon(new ImageIcon("zipimage.jpg"));
        Dimension d = Zimage.getPreferredSize();
        Zimage.setBounds(700, 300,d.width, d.height);
        this.add(Zimage);

        JLabel Aimage = new JLabel();
        Aimage.setIcon(new ImageIcon("arrowimage.jpg"));
        Dimension size = Aimage.getPreferredSize();
        Aimage.setBounds(400, 325,size.width, size.height);
        this.add(Aimage);
        
        compressButton.setBounds(100,200,300,50);
        compressButton.setBackground(Color.green);
        compressButton.setFont(new Font("Arial", Font.BOLD, 20));
        compressButton.setForeground(Color.darkGray);
        DecompressButton.setBounds(600,200,300,50);
        DecompressButton.setFont(new Font("Arial", Font.BOLD, 20));
        DecompressButton.setForeground(Color.darkGray);
        DecompressButton.setBackground(Color.green);

        this.add(compressButton);
        compressButton.addActionListener(this);
        this.add(DecompressButton);
        DecompressButton.addActionListener(this);


       


        setTitle("Compress Or Decompress");
        setLocation(50, 50);
        setSize(1000, 500);
        getContentPane().setBackground(Color.black);
        setVisible(true);  
        
    }


    public void actionPerformed(ActionEvent evt){

        if(evt.getSource() == compressButton){
        JFileChooser chooseFile = new JFileChooser();
        int response = chooseFile.showSaveDialog(null);
        if(response == JFileChooser.APPROVE_OPTION){
          File file = new File(chooseFile.getSelectedFile().getAbsolutePath());

          try {
            Compressor.method(file);
            JOptionPane.showMessageDialog(this,"File Succesfully Compressed");
          } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
          }
        }
        }

        if(evt.getSource() == DecompressButton){
            JFileChooser chooseFile = new JFileChooser();
            int response = chooseFile.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
              File file = new File(chooseFile.getSelectedFile().getAbsolutePath());
    
              try {
                Decompressor.method(file);
                JOptionPane.showMessageDialog(this,"File Succesfully Decompressed");
              } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());;
              }
              } 
        }
    }
}
