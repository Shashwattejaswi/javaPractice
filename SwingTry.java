import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SwingTry extends JFrame implements ActionListener
{
	JTextField result;
	Integer i=0;
	Integer k=0;
	int r=0,a,flag=0;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,bx,bd,bpl,bm,beq,bc,b0;
	ArrayList<Integer> forNum = new ArrayList<Integer>();
	ArrayList<Character> forChar = new ArrayList<Character>();
	char em [] = {'/','x','+','-'};
	SwingTry()
	{
		setBounds(200,200,310,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
	}
	public void addComp()
	{
		
		result = new JTextField("0");
		result.setFont(new Font("Verdana",Font.PLAIN,22));
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		bc = new JButton("C");
		bpl = new JButton("+");
		bx = new JButton("x");
		b0 = new JButton("0");
		bd = new JButton("/");
		bm = new JButton("-"); 
		beq = new JButton("="); 
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		bc.addActionListener(this);
		beq.addActionListener(this);
		bx.addActionListener(this);
		bd.addActionListener(this);
		bm.addActionListener(this);
		bpl.addActionListener(this);
		b1.setBounds(20,90,50,50);
		b2.setBounds(90,90,50,50);
		b3.setBounds(160,90,50,50);
		bc.setBounds(230,90,50,50);
		b4.setBounds(20,160,50,50);
		b5.setBounds(90,160,50,50);
		b6.setBounds(160,160,50,50);
		bx.setBounds(230,160,50,50);
		b7.setBounds(20,230,50,50);
		b8.setBounds(90,230,50,50);
		b9.setBounds(160,230,50,50);
		bpl.setBounds(230,230,50,50);
		b0.setBounds(20,300,50,50);
		bd.setBounds(90,300,50,50);
		bm.setBounds(160,300,50,50);
		beq.setBounds(230,300,50,50);
		result.setBounds(20,20,260,50);
		add(result);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b9);add(bc);add(bpl);add(bx);add(bm);add(bd);add(b0);add(beq);
	}
	public void actionPerformed(ActionEvent e)
		{	
			
			Object oo=e.getSource();
			String ss=oo.toString();
			char theMain=ss.charAt(ss.length()-22);
			int ascii = (int)theMain;
			if(ascii>=48 && ascii <=57)
			{
				k++;
				numberDisplay(theMain);
			}
			else if(ascii==67 || ascii==61)
			{
				winLoose(theMain);
			}
			else
			{
				
				setOperation(theMain);
			}
			System.out.println(theMain+ "" +ascii);
			
		}
		private void setOperation(Character o)
		{
			
			String val=new String();
			val=result.getText();
			int as = (int)val.charAt(val.length()-1);
			if(o=='0')
			{
				System.out.println("first enter number");
			}
			else{
				if(as>=48 && as<=57)
				{
				k++;
				forNum.add(Integer.parseInt(val.substring(r,val.length())));
				result.setText(result.getText()+o);
				forChar.add(result.getText().charAt(result.getText().length()-1));
				System.out.println(forNum +""+forChar);
				a=r;
				r=k;
				}
			}
		}
		
		private void winLoose(Character j)
		{
			String val=new String();
			val=result.getText();
			int present,presentNext;
			String b;
			b = new String();
			b= result.getText();
			if(j=='C')
			{
				k--;
				if(flag==1)
				{
					result.setText("0");
					i=r=a=k=0;
					forNum.clear();
					forChar.clear();
					
				}
				
				else if(!((int)b.charAt(b.length()-1)>=48) || !((int)b.charAt(b.length()-1)<=57))
				{
					forNum.remove(forNum.size()-1);
					forChar.remove(forChar.size()-1);
					r=a;
					System.out.println(forNum + "" + forChar);
					result.setText(b.substring(0,b.length()-1));
				}
				else
				result.setText(b.substring(0,b.length()-1));
			}
			else
			{
				if( (int)b.charAt(b.length()-1)>=48 && (int)b.charAt(b.length()-1)<=57)
				{
					forNum.add(Integer.parseInt(val.substring(r,val.length())));
					for(int q=0;q<=3;q++)
					{
						for(int u=0;u<forChar.size();u++)
						{
							if(forChar.get(u)==em[q])
							{	
								present=forNum.get(u);
								presentNext=forNum.get(u+1);
								forNum.remove(u+1);
								forNum.remove(u);
								forNum.add(u,cal(present,presentNext,forChar.get(u)));
								forChar.remove(u);
								
							}		
						}
					}
					
				}
				System.out.println(forNum+"  "+forChar);
				result.setText(result.getText()+'='+forNum.get(0));
				flag=1;
			}
			
		}
		
	private int cal(int a,int b, char c){
		
			switch (c)
			{
				case '/':
					return a/b;
				case 'x':
					return a*b;
				case '+':
					return a+b;
				case '-':
					return a-b;
			}
		return 0;
		}

	private void numberDisplay(Character ii)
		{	
		
			if(i==0)  // for first time intry to disapper the 0
				{
					result.setText(ii.toString());
					i=1;
				}
			else	{	
					result.setText(result.getText()+ii);
				}
				
		}
	
	public static void main( String Arg [])
	{
		SwingTry t=new SwingTry();
		t.addComp();
		
	
	}
}
