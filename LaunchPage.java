import java.awt.Color;
import java.awt.event.*;


import javax.swing.*;

public class LaunchPage implements ActionListener{
	
	static String activeplayer = "x";
	String[] matrix = {
			"1","2","3",
			"4","5","6",
			"7","8","9"};
	int[] xpos ={20,75,130}; 
	int[] ypos ={30,85,140}; 
	 
	JFrame frame = new JFrame();
	JLabel label = new JLabel("choose a box");
	JLabel labelPlayer = new JLabel("it's x turn");
	JButton a = new JButton("");
	JButton b = new JButton("");
	JButton c = new JButton("");
	JButton d = new JButton("");
	JButton e = new JButton("");
	JButton f = new JButton("");
	JButton g = new JButton("");
	JButton h = new JButton("");
	JButton i = new JButton("");

	LaunchPage(){
		drawButtons(a ,0, 0);
		drawButtons(b ,1, 0);
		drawButtons(c ,2, 0);
		drawButtons(d ,0, 1);
		drawButtons(e ,1, 1);
		drawButtons(f ,2, 1);
		drawButtons(g ,0, 2);
		drawButtons(h ,1, 2);
		drawButtons(i ,2, 2);
		
		label.setBounds(70,0, 100,30); 
		frame.add(label);
		labelPlayer.setBounds(70,200, 100,30); 
		frame.add(labelPlayer);
		  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tik Tak Toe");
		frame.getContentPane().setBackground(Color.decode("#AAFFFF"));
		frame.setSize(220,270);
		frame.setLayout(null);
		frame.setVisible(true);
		
		  
	}
	public void drawButtons(JButton x, int j, int k ) {
		x.setBounds(xpos[j],ypos[k],50,50);
		x.setFocusable(false);
		x.addActionListener(this);
		frame.add(x);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent z) {
		if (CheckWin() == false) {
			if (z.getSource()== a) {
				a.setLabel(ticked(0, matrix,labelPlayer));
			}else if(z.getSource()==b) {
				b.setLabel(ticked(1, matrix, labelPlayer));
			}else if(z.getSource()==c) {
				c.setLabel(ticked(2, matrix,labelPlayer));
			}else if(z.getSource()==d) {
				d.setLabel(ticked(3, matrix,labelPlayer));
			}else if(z.getSource()==e) {
				e.setLabel(ticked(4, matrix,labelPlayer));
			}else if(z.getSource()==f) {
				f.setLabel(ticked(5, matrix,labelPlayer));
			}else if(z.getSource()==g) {
				g.setLabel(ticked(6, matrix,labelPlayer));
			}else if(z.getSource()==h) {
				h.setLabel(ticked(7, matrix,labelPlayer));
			}else if(z.getSource()==i) {
				i.setLabel(ticked(8, matrix,labelPlayer));
			}
			CheckWin();
		}
		
			
					
		
	}
	@SuppressWarnings("unused")
	private Boolean CheckWin() {
		for (int t = 0; t < 8; t++) {
            String line = null;
            
            switch (t) {
            case 0:
                line = matrix[0] + matrix[1] + matrix[2];
                break;
            case 1:
                line = matrix[3] + matrix[4] + matrix[5];
                break;
            case 2:
                line = matrix[6] + matrix[7] + matrix[8];
                break;
            case 3:
                line = matrix[0] + matrix[3] + matrix[6];
                break;
            case 4:
                line = matrix[1] + matrix[4] + matrix[7];
                break;
            case 5:
                line = matrix[2] + matrix[5] + matrix[8];
                break;
            case 6:
                line = matrix[0] + matrix[4] + matrix[8];
                break;
            case 7:
                line = matrix[2] + matrix[4] + matrix[6];
                break;
            	
            
            }
            if (line.equals("xxx")) {
            	label.setText("x has won !");
            	labelPlayer.setText("");
            	return true;
            }
            else if (line.equals("ooo")) {
            	label.setText("o has won !");
            	labelPlayer.setText("");
                return true;
            }
            
            
            
		}
		return false;
		  
		
	}
	private static String ticked(int n, String[] matrix, JLabel labelPlayer2) {
		System.out.println(matrix[0]+ matrix[1]+matrix[2]+matrix[3]+matrix[4]+matrix[5]+matrix[6]+matrix[7]+matrix[8]);
		
		if (matrix[n]!= "x" && matrix[n] != "o" ) {
			
			if (activeplayer == "x") {
				
				matrix[n] = "x";
				activeplayer = "o";
				labelPlayer2.setText("it's o turn");
				
			}else if(activeplayer == "o") {
				
				matrix[n] = "o";
				activeplayer = "x";
				labelPlayer2.setText("it's x turn");
				
			}
				
		}
		System.out.println(matrix[0]+ matrix[1]+matrix[2]+matrix[3]+matrix[4]+matrix[5]+matrix[6]+matrix[7]+matrix[8]);
		return matrix[n];
		
	}
	
}