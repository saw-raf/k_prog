import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

class OutOfRangeException extends Exception{}

class PascalsTriangleLine{

	private int size;
	private int line[];

	public PascalsTriangleLine(int n){
		size=n+1;
		line=new int[size];
		line[0]=1;
		for(int i=1;i<size;i++)
			line[i]=line[i-1]*(n-(i-1))/i;//property C(n,k+1)=C(n,k)*(n-k)/(k+1)

	}

	public int coefficient(int m) throws ArrayIndexOutOfBoundsException{
		if(m>=size || m<0)
			throw new ArrayIndexOutOfBoundsException();	
		return line[m];
	}
}


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
		setBackground(new Color(0,97,131));
		setForeground(new Color(255,255,255));
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
	
	Label name;
	TextField size;
	Button execute;
	Panel leftPanel;
	Panel rightPanel;

	
	MyFrame(){
		super("TrojkatPascala");
		setBackground(new Color(255,255,255));
		setBounds(100,100,1024,768);
		setLayout(new BorderLayout());
		addWindowListener(new MyWindowAdapter());
		
		name=new Label("Trojkat Pascala",Label.CENTER);
		name.setBackground(new Color(85,85,85));
		name.setForeground(new Color(255,255,255));
		name.setFont(new Font(Font.MONOSPACED,Font.BOLD,50));
		
		
		//-----creating leftPanel----//
		leftPanel=new Panel();
		leftPanel.setBackground(new Color(0,97,131));
		leftPanel.setLayout(new FlowLayout());
		size=new TextField("5");
		leftPanel.add(size);
		execute=new Button("wykonaj");
		execute.setBackground(new Color(219,60,0));
		execute.setForeground(new Color(255,255,255));
		leftPanel.add(execute);
		MyButtonListener mak=new MyButtonListener(this);
		execute.addActionListener(mak);
		
		//--rightPanel--//
		rightPanel=new Panel();
		Label tmp=new Label("Podaj liczbe z zakresu 0-29 i wcisnij wykonaj",Label.CENTER);
		tmp.setForeground(new Color(0,97,131));
		tmp.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
		rightPanel.add(tmp);
		

		add(name,BorderLayout.NORTH);
		add(leftPanel,BorderLayout.WEST);
		add(rightPanel,BorderLayout.CENTER);
		setVisible(true);
	}
	
	public void action(){
		try{
				int rozmiar=Integer.parseInt(size.getText())+1;
					if(rozmiar<1 || rozmiar>30) throw new OutOfRangeException();
				rightPanel.removeAll();
				rightPanel.setBackground(new Color(0,97,131));
				Label[] arrayLabel=new Label[rozmiar];
				rightPanel.setLayout(new GridLayout(rozmiar,1,3,2));
				for(int i=0;i<rozmiar;i++){
					PascalsTriangleLine tmpLine=new PascalsTriangleLine(i);
					String tmpString=new String();
					for(int j=0;j<=i;j++){
						tmpString=tmpString+"  "+Integer.toString(tmpLine.coefficient(j));
					}
					arrayLabel[i]=new Label(tmpString,Label.CENTER);
					arrayLabel[i].setBackground(new Color(255,255,255));
					arrayLabel[i].setForeground(new Color(0,97,131));
					arrayLabel[i].setFont(new Font(Font.MONOSPACED,Font.BOLD,200/rozmiar));
					arrayLabel[i].setVisible(true);
					rightPanel.add(arrayLabel[i]);
				}
				rightPanel.setVisible(true);
				rightPanel.revalidate();
		}
		catch(OutOfRangeException e){
			ErrorDialog blad=new ErrorDialog(this, "Podaj liczbe z zakresu 0-29");
			blad.setVisible(true);
		}
		catch(NumberFormatException e){
			ErrorDialog blad=new ErrorDialog(this, "Podaj liczbe calkowita!");
			blad.setVisible(true);
		}
	}

}

public class TrojkatPascalaGUI{
	public static void main (String[] args){
		MyFrame okienko=new MyFrame();
		
	}
}