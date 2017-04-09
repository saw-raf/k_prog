import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.*;

class OutOfRangeException extends Exception{}

class MyWindowAdapter extends WindowAdapter {
  public void windowClosing(WindowEvent e) { System.exit(0); }
}

class MyButtonListener implements ActionListener{
	MyFrame f;
	MyButtonListener(MyFrame f){this.f=f;}
	public void actionPerformed(ActionEvent e){
		f.action();
	}
}

class ErrorDialog extends Dialog{
	ErrorDialog(MyFrame Parent, String msg){
		super(Parent,"Blad !");
		setBackground(new Color(255,255,255));
		setForeground(new Color(34,34,34));
		Label label = new Label(msg,Label.CENTER);
		label.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
		add(label);
        setBounds(100,100,400,200);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
               dispose();
            }
         });
	}
}

class MyFrame extends Frame{
	TextField par1;
	Label lab1;
	TextField par2;
	Label lab2;
	Button execute;
	
	MyFrame(){
		super("TrojkatPascala");
		setBackground(new Color(255,255,255));
		setBounds(100,100,1024,220);
		setLayout(null);
		setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
		addWindowListener(new MyWindowAdapter());
		
		lab1=new Label("Podaj nr wiersza: ");
		lab1.setBounds(50,50,200,40);
		par1=new TextField("");
		par1.setBounds(280,55,200,35);
		lab2=new Label("Podaj argumenty: ");
		lab2.setBounds(510,50,200,40);
		par2=new TextField("");
		par2.setBounds(740,55,200,35);
		
		add(lab1);
		add(par1);
		add(lab2);
		add(par2);
		
		
		
		execute=new Button("wykonaj");
		execute.setBackground(new Color(34,34,34));
		execute.setBounds(412,130,200,50);
		execute.setForeground(new Color(255,255,255));
		MyButtonListener mak=new MyButtonListener(this);
		execute.addActionListener(mak);
		add(execute);
		
		
		setVisible(true);
		setResizable(false);
	}
	
	public void action(){
		 String command = "ping www.onet.net";
 
		try {
				Process process = Runtime.getRuntime().exec(command);
		 
				BufferedReader reader = new BufferedReader(
				new InputStreamReader(process.getInputStream()));
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}
				reader.close();

			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
}


public class Process{
	public static void main (String[] args){
		MyFrame okienko=new MyFrame();
		
	}
}