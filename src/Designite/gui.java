package Designite;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
//--------
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;


  
public class gui {

	static String Ians,Oans,go,disPath;
	static int tot,sml;
	static int rec=0;

	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void mainGui() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		}
	
	public String Ipass()
	{
		return Ians;
	}
	public String Opass()
	{
		return Oans;
	}
	public String pressed()
	{
		return go;
	}
	public void gotAns(int a,int b,int c)
	{
		rec=a;
		tot=b;
		sml=c;
	}



	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}
	


	/**
	 * Initialize the contents of the frame.
	 * @return 
	 */
	
	private void initialize() {	
		
		
		Ians="";
		Oans="";
		go="0";
	    JFileChooser chooser = new JFileChooser(); 
	    String choosertitle = null;
		frame = new JFrame();
		frame.setTitle("Field Smell Application");
		frame.getContentPane().setBackground(SystemColor.text);
		frame.setBounds(100, 100, 900, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		


		
		JButton b1 = new JButton("Select");
		b1.setForeground(new Color(255, 255, 255));
		b1.setBackground(new Color(147, 112, 219));
		b1.setFont(new Font("UD Digi Kyokasho NK-B", Font.PLAIN, 16));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println("button clicked");	
			    int result;
		        
			    
			    chooser.setCurrentDirectory(new java.io.File("."));
			    chooser.setDialogTitle(choosertitle);
			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    //
			    // disable the "All files" option.
			    //
			    chooser.setAcceptAllFileFilterUsed(false);
			    //    
			    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
			      System.out.println("getCurrentDirectory(): " 
			         +  chooser.getCurrentDirectory());
			      System.out.println("getSelectedFile() : " 
			         +  chooser.getSelectedFile());
			      String sin=chooser.getSelectedFile().toString();
			      sin = sin.replace("\\", "\\\\");
			      Ians=sin;
			      }
			    else {
			      System.out.println("No Selection ");
			      }
			    b1.setText("Selected");
			    b1.setBackground(new Color(148, 0, 211));
			}
		});
		b1.setBounds(327, 108, 120, 34);
		frame.getContentPane().add(b1);
		
		JLabel heading = new JLabel("DesigniteJava - Field Smell Tool ");
		heading.setBackground(SystemColor.textHighlight);
		heading.setForeground(Color.DARK_GRAY);
		heading.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 24));
		heading.setBounds(27, 26, 396, 44);
		frame.getContentPane().add(heading);
		
		JLabel Linp = new JLabel("Select Input Directory ");
		Linp.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 20));
		Linp.setForeground(SystemColor.textHighlight);
		Linp.setBounds(66, 106, 226, 34);
		frame.getContentPane().add(Linp);
		
		JLabel Lout = new JLabel("Select Output Directory");
		Lout.setForeground(SystemColor.textHighlight);
		Lout.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 19));
		Linp.setForeground(SystemColor.textHighlight);
		Lout.setBounds(66, 168, 226, 34);
		frame.getContentPane().add(Lout);
		
		JButton b2 = new JButton("Select");
		b2.setForeground(new Color(255, 255, 255));
		b2.setBackground(new Color(147, 112, 219));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("button clicked");	
			    int result;
		        
			    
			    chooser.setCurrentDirectory(new java.io.File("."));
			    chooser.setDialogTitle(choosertitle);
			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    //
			    // disable the "All files" option.
			    //
			    chooser.setAcceptAllFileFilterUsed(false);
			    //    
			    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
			      System.out.println("getCurrentDirectory(): " 
			         +  chooser.getCurrentDirectory());
			      System.out.println("getSelectedFile() : " 
			         +  chooser.getSelectedFile());
			      String sout=chooser.getSelectedFile().toString();
			      disPath=sout;
			      sout = sout.replace("\\", "\\\\");
			      Oans=sout;
			    }
			    else {
			      System.out.println("No Selection ");
			      }
			    b2.setText("Selected");
			    b2.setBackground(new Color(148, 0, 211));
			
			}
		});
		b2.setFont(new Font("UD Digi Kyokasho NK-B", Font.PLAIN, 16));
		b2.setBounds(327, 165, 120, 34);
		frame.getContentPane().add(b2);
		
		JLabel lblNewLabel = new JLabel("Results : ");
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(199, 21, 133));
		lblNewLabel.setBounds(530, 102, 146, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel displayResult = new JLabel("");
		displayResult.setForeground(Color.DARK_GRAY);
		displayResult.setFont(new Font("Source Code Pro Semibold", Font.BOLD, 18));
		displayResult.setBounds(530, 138, 327, 166);
		frame.getContentPane().add(displayResult);
		
		JLabel showPath = new JLabel("");
		showPath.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		showPath.setFont(new Font("Source Code Pro Medium", Font.PLAIN, 16));
		showPath.setBounds(66, 345, 755, 76);
		frame.getContentPane().add(showPath);
		
		JLabel per = new JLabel("");
		per.setForeground(new Color(199, 21, 133));
		per.setFont(new Font("Segoe UI Historic", Font.BOLD, 36));
		per.setBounds(729, 206, 105, 82);
		frame.getContentPane().add(per);
		
		JButton btnNewButton = new JButton("Go !");
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				go="1";
				displayResult.setText("<html>" + "Please wait !"+ "<br />" +"<br />" + "Processing..." + "</html>");
				
				
                new SwingWorker<Void, String>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        // Worken hard or hardly worken...

        				while(true) {
        					try {
        						Thread.sleep(1000);
        						if(rec==1){
        							displayResult.setText("<html>" + "Total Classes : "+tot + "<br />" + "Field Smell Classes : "+sml + "<br />"+"<br />" + "Percentage Smell : "+ "</html>"); //+(sml*100/tot)+"%"
        							per.setText(" "+(sml*100/tot)+"%");
        							showPath.setText("<html>" + "Detailed results are stored in Result.txt at following path : " + "<br />" + disPath + "</html>");
        							break;
        						}
        						
        					} catch (InterruptedException e2) {
        						e2.printStackTrace();
        					}
        				}
        			
        				btnNewButton.setText("Completed");
        				
        				
                        
                        return null;
                    }

                    @Override
                    protected void done() {
                        
                    }
                }.execute();
				
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("UD Digi Kyokasho NK-B", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(66, 268, 226, 44);
		frame.getContentPane().add(btnNewButton);
		

		

		

		
		

	}
}


