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

//Create a GUI for this project using Jframe in java swing
//Created a GUI class which extends JFrame with ActionListener
public class GUI extends JFrame implements ActionListener{
     
    // created two buttons compress and decompress button
    JButton compressButton = new JButton("Select File to compress");
    JButton DecompressButton = new JButton("Select File to Decompress");
    
    // Constructor which get implement the action
    GUI(){

        // Create a JFrame with Following structure
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        setTitle("Compress Or Decompress");
        setLocation(50, 50);
        setSize(1000, 500);
        getContentPane().setBackground(Color.black);
        setVisible(true);

        // JLable which has to to displayed on the top of the the frame with following structure and font
        JLabel head = new JLabel("COMPRESSOR & DECOMPRESSOR"); // Lable name
        head.setFont(new Font("Arial", Font.BOLD, 30)); // Font and font size
        head.setForeground(Color.yellow); // Text Color
        head.setBounds(250, 50, 600, 50); // position and size of the lable
        this.add(head); // add this lable to the frame

        JLabel head2 = new JLabel("Select any files");
        head2.setFont(new Font("Arial", Font.BOLD, 20));
        head2.setForeground(Color.RED);
        head2.setBounds(450, 80, 600, 50); 
        this.add(head2);
        
        // Creating a lable to attach image in frame
        JLabel Fimage = new JLabel();
        Fimage.setIcon(new ImageIcon("fileimage.jpg")); // this fuction helps to get the image from the folder
        Dimension s = Fimage.getPreferredSize(); // getting the orginal dimensions of the image
        Fimage.setBounds(200, 300,s.width, s.height); // position and size of the lable
        this.add(Fimage); // add the image lable to the frame

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
        
        //Creating size,position,boundray,color of the buttons
        compressButton.setBounds(100,200,300,50);
        compressButton.setBackground(Color.green);
        compressButton.setFont(new Font("Arial", Font.BOLD, 20));
        compressButton.setForeground(Color.darkGray);
        DecompressButton.setBounds(600,200,300,50);
        DecompressButton.setFont(new Font("Arial", Font.BOLD, 20));
        DecompressButton.setForeground(Color.darkGray);
        DecompressButton.setBackground(Color.green);
        
        //adding the buttons to the frame
        this.add(compressButton);
        // adding action listeners to the button
        compressButton.addActionListener(this);
        this.add(DecompressButton);
        DecompressButton.addActionListener(this);  
        
    }

    // overriding the abstract method actionPerformed in action listeners
    public void actionPerformed(ActionEvent evt){

        //recieving the action on which button is clicked
        //if compress button is clicked a file chooser is created to select the file from the system and 
        //getting the absolute path of the choosen file and created a new file.And calling the compress method with the new file.
        if(evt.getSource() == compressButton){
        JFileChooser chooseFile = new JFileChooser();
        int response = chooseFile.showSaveDialog(null);
        if(response == JFileChooser.APPROVE_OPTION){
          File file = new File(chooseFile.getSelectedFile().getAbsolutePath());

          try {
            //calling the compressor class.method function with the created file
            Compressor.method(file);
            // if the file compressed succesfully displays the message JoptioPane does the job 
            JOptionPane.showMessageDialog(this,"File Succesfully Compressed");
          } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
          }
        }
        }
        // Similarly for Decompress button
        if(evt.getSource() == DecompressButton){
            JFileChooser chooseFile = new JFileChooser();
            int response = chooseFile.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
              File file = new File(chooseFile.getSelectedFile().getAbsolutePath());
    
              try {
                //calling the decompressor class.method function with the created file
                Decompressor.method(file);
                // if the file compressed succesfully displays the message JoptioPane does the job 
                JOptionPane.showMessageDialog(this,"File Succesfully Decompressed");
              } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());;
              }
              } 
        }
    }
}
