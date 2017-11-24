import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
class myframe
{
	JFrame f;
	JLabel JL1,JL2,JL3,JL4;
	JTextField t1,t2,t3,t4;
	JButton JB1,JB2,JB3,JB4,JB5,JB6,JB7;
	myframe()
	{	
		f=new JFrame("Student Management System");
		f.getContentPane().setLayout(null);
		JL1=new JLabel("Student ID");
		t1=new JTextField(15);
		JL2=new JLabel("Student NAME");
		t2=new JTextField(15);
		JL3=new JLabel("IdentityCard Validity");
		t3=new JTextField(25);
		JL4=new JLabel("Student DOB");
		t4=new JTextField(15);
		JB1=new JButton("|<");
		JB2=new JButton("<");
		JB3=new JButton(">");
		JB4=new JButton(">|");
		JB5=new JButton("Add");
		JB6=new JButton("Delete");
		JB7=new JButton("Search");
		JB4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				fileread a=new fileread();
				try
				{
					a.read();
				}
				catch(Exception e){}
				t1.setText(a.id.substring(0,8));
				t2.setText(a.name.substring(0,12));
				t3.setText(a.validity.substring(0,12));
				t4.setText(a.dob.substring(0,13));
			}
        	
        });
				JB2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				rownum a3=new rownum();
				try
				{
					a3.read(t1.getText());
				}
				catch(Exception e){}
			}
        	
        });
		JB7.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				search a=new search();
				try
				{
					a.read(t1.getText(),t2.getText(),t3.getText(),t4.getText());
				}
				catch(Exception e){}
				String t11=t1.getText();
				String t22=t2.getText();
				String t33=t3.getText();
				String t44=t4.getText();
				String p=" ";
				for(int i=t11.length();i<8;i++)
				{
					t11=t11+p;
				}
				for(int j=t22.length();j<12;j++)
				{
					t22=t22+p;
				}
				for(int k=t33.length();k<12;k++)
				{
					t33=t33+p;
				}
				for(int l=t44.length();l<13;l++)
				{
					t44=t44+p;
				}
				if(t11.equals(a.id)||t22.equals(a.name)||t33.equals(a.validity)||t44.equals(a.dob))
				 {
				 t1.setText(a.id.substring(0,7));
				 t2.setText(a.name.substring(0,11));
				 t3.setText(a.validity.substring(0,11));
				 t4.setText(a.dob.substring(0,12));
				 }
				 else
				 {
					JOptionPane.showMessageDialog(f, "No Match Found");
				}
			}
        	
        });
		
		JB5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				String id,name,validity,dob;
				String id1=" ";
				String name1=" ";
				String validity1=" ";
				String doJB1=" ";
				id=t1.getText().toString();
				for(int i=id.length();i<7;i++)
				{
					id1=id1+" ";
				}
				name=t2.getText().toString();
				for(int j=name.length();j<11;j++)
				{
					name1=name1+" ";
				}
				validity=t3.getText().toString();
				for(int k=validity.length();k<11;k++)
				{
					validity1=validity1+" ";
				}
				dob=t4.getText().toString();
				for(int l=dob.length();l<12;l++)
				{
					doJB1=doJB1+" ";
				}
				try
				{
					FileWriter w1=new FileWriter("V:\\project1.txt",true);
					w1.write(System.getProperty("line.separator"));
					w1.write(id+id1+"| ");
					w1.write(name+name1+"| ");
					w1.write(validity+validity1+"| ");
					w1.write(dob+doJB1+"| ");
					JOptionPane.showMessageDialog(f, "Data Added");
					w1.close();
				}
					catch(Exception e){
					JOptionPane.showMessageDialog(f, "Error");
					}		
			}
		});
		JB1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				data d=new data();
				try
				{
					d.read(4);
				}
				catch(Exception e){}
				t1.setText(d.id);
				t2.setText(d.name);
				t3.setText(d.validity);
				t4.setText(d.dob);

			}
        	
        });
				JB2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				rownum r=new rownum();
				data d=new data();
				try
				{
					int i=r.read(t1.getText());
					d.read(i-1);
				}
				catch(Exception e){}
				t1.setText(d.id);
				t2.setText(d.name);
				t3.setText(d.validity);
				t4.setText(d.dob);

			}
        	
        });
						JB3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				rownum r=new rownum();
				data d=new data();
				try
				{
					int i=r.read(t1.getText());
					d.read(i+1);
				}
				catch(Exception e){}
				t1.setText(d.id);
				t2.setText(d.name);
				t3.setText(d.validity);
				t4.setText(d.dob);

			}
        	
        });
		JL1.setBounds(50,20,120,27);
		JL2.setBounds(50,90,120,27);
		JL3.setBounds(50,160,120,27);
		JL4.setBounds(50,230,120,27);
		t1.setBounds(220,20,180,27);
		t2.setBounds(220,90,180,27);
		t3.setBounds(220,160,180,27);
		t4.setBounds(220,230,180,27);
		JB1.setBounds(50,300,80,27);
		JB2.setBounds(140,300,80,27);
		JB3.setBounds(230,300,80,27);
		JB4.setBounds(320,300,80,27);
		JB5.setBounds(50,370,80,27);
		JB6.setBounds(185,370,80,27);
		JB7.setBounds(320,370,80,27);
		JL1.setForeground(Color.blue);
		JL2.setForeground(Color.blue);
		JL3.setForeground(Color.blue);
		JL4.setForeground(Color.blue);
		f.getContentPane().add(JL1);
		f.getContentPane().add(JL2);
		f.getContentPane().add(JL3);
		f.getContentPane().add(JL4);
		f.getContentPane().add(t1);
		f.getContentPane().add(t2);
		f.getContentPane().add(t3);
		f.getContentPane().add(t4);
		f.getContentPane().add(JB1);
		f.getContentPane().add(JB2);
		f.getContentPane().add(JB3);
		f.getContentPane().add(JB4);
		f.getContentPane().add(JB5);
		f.getContentPane().add(JB6);
		f.getContentPane().add(JB7);
		f.setSize(500,500);
		
		f.setVisible(true);
	}
}
class rownum{
			String line,id,name,validity,dob;
			int i=0;
	int read(String t1)throws IOException{
	FileReader fr=new FileReader("V:\\project1.txt");
	BufferedReader br=new BufferedReader(fr);
		while((line=br.readLine())!=null)
		{
		i++;
		id=line.substring(0,8);
		name=line.substring(10,22);
		validity=line.substring(24,36);
		dob=line.substring(38,line.length()-2);
		if(t1.equals(id))
		{
			break;
		}
		}
	br.close();
	return i;
}
}
class data
{
	String line,id,name,validity,dob;
	void read(int n)throws IOException{
	
	FileReader fr=new FileReader("V:\\project1.txt");
	BufferedReader br=new BufferedReader(fr);
		while(((line=br.readLine())!=null)&&(n>0))
		{
		id=line.substring(0,8);
		name=line.substring(10,22);
		validity=line.substring(24,36);
		dob=line.substring(38,line.length()-2);
		n--;
		}
	br.close();
}
}
class search
{
	String line,id,name,validity,dob;
	void read(String t1,String t2,String t3,String t4)throws IOException{
	
	FileReader fr=new FileReader("V:\\project1.txt");
	BufferedReader br=new BufferedReader(fr);
	String p=" ";
	while((line=br.readLine())!=null)
	{
		 id=line.substring(0,8);
		 name=line.substring(10,22);
		 validity=line.substring(24,36);
		 dob=line.substring(38,line.length()-2);
		 for(int i=t1.length();i<8;i++)
		 {
			t1=t1+p;
		 }
		 for(int j=t2.length();j<12;j++)
		 {
			t2=t2+p;
		 }
		 for(int k=t3.length();k<12;k++)
		 {
			t3=t3+p;
		 }
		 for(int l=t4.length();l<13;l++)
		 {
			t4=t4+p;
		 }
		 if(t1.equals(id)||t2.equals(name)||t3.equals(validity)||t4.equals(dob))
		 {
			break;
		 }
	}
	br.close();
}
}
class fileread
{
	String line,id,name,validity,dob;
	void read()throws IOException{
	
	FileReader fr=new FileReader("V:\\project1.txt");
	BufferedReader br=new BufferedReader(fr);
	while((line=br.readLine())!=null)
	{
		id=line.substring(0,9);
		name=line.substring(10,23);
		validity=line.substring(24,37);
		dob=line.substring(38,line.length()-1);
		System.out.print(id);
		System.out.print(name);
		System.out.print(validity);
		System.out.println(dob);
	}
	br.close();
}
}
class project{
	public static void main(String [] args) throws IOException
	{
		fileread f=new fileread();
		f.read();
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new myframe();
			}
		});
	}
}
