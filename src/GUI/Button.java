package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.event.*;

public class Button 
{

	public static void main(String[] args) 
	{
	      JFrame mainFrame = new JFrame("TalkBox GUI Test");
	      mainFrame.setSize(600,600);						//set the size of window (you guys can change the dimensions if you'd like
	      mainFrame.setLayout(new GridLayout(10, 1));			//rows, columns (way of making text and buttons centered

	      JLabel headerLabel = new JLabel("",JLabel.CENTER );
   
	      JPanel controlPanel= new JPanel();
	      controlPanel.setLayout(new FlowLayout());

	      mainFrame.add(headerLabel);
	      mainFrame.add(controlPanel);
	      mainFrame.setLocationRelativeTo(null);					//when app opens, open in the center of the screen
	      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      headerLabel.setText("TalkBox Configuration");      		//what text do we want here?

	      JPanel panel = new JPanel();				//making a smaller panel within the frame (design choice...can be changed)
	      panel.setBackground(Color.darkGray);		//what colour would you guys prefer (if any)
	      FlowLayout layout = new FlowLayout();		//created this variable in order to be able to adjust the space between components
	      layout.setHgap(10);              			//horizontal distance between components
	      layout.setVgap(10);						//vertical distance between components
	      
	      JButton recordAudio = new JButton("Record Audio");
	      JButton playAudio = new JButton("Play Audio");
	      JButton saveAudio = new JButton("Save Recorded Audio");//maybe we want this button to allow the user to decide whether or not the recorded audio will be saved?  
	      														//Or else the "Record Audio" button will automatically save it and we'll need a remove button...  
	      
	      /*Here is where we want to make the buttons actually work
	       * ...
	       * recordAudio.addActionListener();
	       * playAudio.addActionListener();
	       * ...
	       */
	      
	      panel.setLayout(layout);        
	      panel.add(recordAudio);
	      panel.add(playAudio);  
	      panel.add(saveAudio);
	      controlPanel.add(panel);
	      mainFrame.setVisible(true); 			//make everything visible...cause that's a little important
	}
}
