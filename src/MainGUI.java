import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class MainGUI extends JFrame { 
	JTextArea write = new JTextArea();
	JTextField messages = new JTextField();
	TreeWalker tree = new TreeWalker("((10 20 30) 40 (null 50 (60 70 80)))");		
	Position current = tree.root();
	
	public MainGUI(String string) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = makeGUI ();
		setContentPane (mainPanel);
		pack();
		setVisible(true);
		write.setText(tree.PrettyPrint());
	}
	
	public static void main(String[] args) throws IOException{
		@SuppressWarnings("unused")
		MainGUI gui = new MainGUI("");
	}

	public JPanel makeGUI() {
		JPanel GUI = new JPanel ();
		GUI.setLayout (new BorderLayout ());
		write.setEditable(false);
		write.setLineWrap(false);
		write.setWrapStyleWord(false);
	    write.setFont(new Font("monospaced", Font.PLAIN, 12));
		
		JScrollPane jsp = new JScrollPane(write);
		jsp.setPreferredSize(new Dimension(400, 400));
		GUI.add (jsp, BorderLayout.CENTER);

		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout (3,4));
		JButton root = new JButton ("root");
		root.addActionListener(new listener(1));
		buttons.add(root);
		JButton parent = new JButton ("parent");
		parent.addActionListener(new listener(2));
		buttons.add(parent);
		JButton leftChild = new JButton ("leftChild");
		leftChild.addActionListener(new listener(3));
		buttons.add(leftChild);
		JButton rightChild = new JButton ("rightChild");
		rightChild.addActionListener(new listener(4));
		buttons.add(rightChild);
		JButton first = new JButton ("first");
		first.addActionListener(new listener(8));
		buttons.add(first);
		JButton previous = new JButton ("previous");
		previous.addActionListener(new listener(11));
		buttons.add(previous);
		JButton next = new JButton ("next");
		next.addActionListener(new listener(10));
		buttons.add(next);
		JButton last = new JButton ("last");
		last.addActionListener(new listener(9));
		buttons.add(last);
		JButton rotateL = new JButton ("rotateL");
		rotateL.addActionListener(new listener(7));
		buttons.add(rotateL);
		JButton rotateR = new JButton ("rotateR");
		rotateR.addActionListener(new listener(6));
		buttons.add(rotateR);
		JButton insert = new JButton ("insert");
		insert.addActionListener(new listener(5));
		buttons.add(insert);
		JButton delete = new JButton ("delete");
		delete.addActionListener(new listener(12));
		buttons.add(delete);


		/* JButton evaluate = new JButton ("evaluate");
		evaluate.addActionListener(new listener(12));
		buttons.add(evaluate);
		JButton compile = new JButton ("compile");
		compile.addActionListener(new listener(13));
		buttons.add(compile);
		JButton simplify = new JButton ("simplify");
		simplify.addActionListener(new listener(14));
		buttons.add(simplify); */

		GUI.add(buttons, BorderLayout.SOUTH);
		
		messages.addActionListener(new messagesListener());
		messages.setText("((10 20 30) 40 (null 50 (60 70 80)))");
		GUI.add(messages, BorderLayout.NORTH);
		return GUI;
	}
	
	public class listener implements ActionListener{
		int button;
		public listener(int i) {
			button=i;
		}
		public void actionPerformed(ActionEvent arg0) {
			tree.notCurrent(current);
			switch (button){
			case 1:	current = tree.root(current);  	   	break;
			case 2:	current = tree.parent(current);	   	break;
			case 3:	current = tree.leftChild(current); 	break;
			case 4:	current = tree.rightChild(current);	break;
			case 5:	current = tree.insert(current);	   	break;
			case 6:	current = tree.rotateR(current);	break;
			case 7:	current = tree.rotateL(current);	break;
			case 8:	current = tree.first(current);		break;
			case 9:	current = tree.last(current);		break;
			case 10:current = tree.next(current);		break;
			case 11:current = tree.previous(current);	break;
			case 12:current = tree.delete(current);	   	break;
			}
			tree.makeCurrent(current);
			write.setText(tree.PrettyPrint());
		}
	}
	
	public class messagesListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			tree = new TreeWalker(messages.getText());	
			current = tree.root();
			write.setText(tree.PrettyPrint());
		}
	}
}
