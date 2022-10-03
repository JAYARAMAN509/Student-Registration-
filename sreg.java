import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Desktop;
import java.io.*;
import java.sql.*;
import java.util.*;
class MyFrame extends JFrame implements ActionListener {
	JLabel name,mobile,email,fathername,gender,address,l3,L4,l5;;
	JTextField tname,tmobile,temail,tfathername,taddress;
	JRadioButton male,female;
	ButtonGroup gr;
	JButton submit,save;
	Container c;
	public MyFrame(){
		setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
		
		c = getContentPane();
        c.setLayout(null);
			l5=new JLabel("<html><font size='5' color=red><u> STUDENT REGISTRATION </font> </html>");
		l5.setSize(600,100);
		l5.setLocation(250,10);
		c.add(l5);
		
		name=new JLabel("NAME:");
		name.setSize(100,20);
		name.setLocation(100,100);
		c.add(name);
		
		name=new JLabel("NAME:");
		name.setSize(100,20);
		name.setLocation(100,100);
		c.add(name);
		
		tname=new JTextField();
		tname.setSize(200,20);
		tname.setLocation(200,100);
		c.add(tname);
	
		mobile=new JLabel("MOBILE:");
		mobile.setSize(100,20);
		mobile.setLocation(100,150);
		c.add(mobile);
		
		tmobile=new JTextField();
		tmobile.setSize(200,20);
		tmobile.setLocation(200,150);
		c.add(tmobile);
		
		
		email=new JLabel("EMAIL:");
		email.setSize(100,20);
		email.setLocation(100,200);
		c.add(email);
		
		temail=new JTextField();
		temail.setSize(200,20);
		temail.setLocation(200,200);
		c.add(temail);
		
		fathername=new JLabel("FATHER NAME:");
		fathername.setSize(100,20);
		fathername.setLocation(100,250);
		c.add(fathername);
		
		tfathername=new JTextField();
		tfathername.setSize(200,20);
		tfathername.setLocation(200,250);
		c.add(tfathername);
		
		address=new JLabel("ADDRESS");
		address.setSize(100,20);
		address.setLocation(100,300);
		c.add(address);
		
		taddress=new JTextField();
		taddress.setSize(200,20);
		taddress.setLocation(200,300);
		c.add(taddress);
		
		gender=new JLabel("GENDER:");
		gender.setSize(100,20);
		gender.setLocation(100,350);
		c.add(gender);
		
		male=new JRadioButton("MALE");
		male.setSize(100,20);
		male.setLocation(200,350);
		c.add(male);
		 
		 female=new JRadioButton("FEMALE");
		female.setSize(100,20);
		female.setLocation(300,350);
		c.add(female);
		
		gr=new ButtonGroup();
		gr.add(male);
		gr.add(female);
		
		 submit=new JButton("SUBMIT");
		 submit.setSize(100,40);
		 submit.setLocation(200,400);
		 submit.addActionListener(this);
		 c.add(submit);
		 
		  save=new JButton("SAVE");
		 save.setSize(100,40);
		 save.setLocation(350,400);
		 save.addActionListener(this);
		 c.add(save);
		  l3=new JLabel("");
		l3.setSize(300,100);
		l3.setLocation(100,450);
		c.add(l3);
		 
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == submit){
			l3.setText("REGISTRATION SUCCESSFULL click save");
		}
		File file=new File("D://javacode//studentreg.txt");
		if(e.getSource() == save){
			try{
				FileWriter in=new FileWriter(file,true);
				in.write("\n.................... STUDENT REGISTRATION .....................................\n");
				in.write("\n NAME: "+tname.getText()+
						"\n MOBILE:"+tmobile.getText()+
						"\n EMAIL:"+temail.getText()+
							"\n FATHER NAME:"+tfathername.getText()+ 
							"\n ADDRESS:"+taddress.getText());	
if(male.isSelected()){
	
in.write("\n GENDER: MALE");
}
else{
	
in.write("\n GENDER: FEMALE");	
}

				in.flush();
				in.close();
				Desktop d=Desktop.getDesktop();
				if(file.exists())
				d.open(file);
			
		
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employe","roor","Jay17@00");
		Statement st=con.createStatement();
		/*String query="insert into studenttable(name,mobile,email,Fathername,Address) values('"+a+"',"+b+",'"+c+"','"+z+"','"+x+"')";
		st.executeUpdate(query);*/
		PreparedStatement pst=con.prepareStatement("insert into studenttable(name,mobile,email,Fathername,Address,gender) values(?,?,?,?,?,?)");
		pst.setString(1,tname.getText());
		pst.setLong(2,Long.parseLong(tmobile.getText()));
		pst.setString(3,temail.getText());
		pst.setString(4,tfathername.getText());
		pst.setString(5,taddress.getText());
		String ge="";
		if(male.isSelected()){
		ge=male.getText();
		}
	if(female.isSelected()){
		ge=female.getText();
		}
		pst.setString(6, ge);
		pst.executeUpdate();
		ResultSet rs=st.executeQuery("select * from studenttable");
		
		while(rs.next())
			
			System.out.println(rs.getString(1)+"\t"+rs.getLong(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));
		
			
		}catch(Exception o){System.out.print(o);}
			
		
		}
		
	}


	
}

			
	
public class sreg{
	public static void main(String[] args){
		MyFrame obj=new MyFrame();
		obj.setVisible(true);
		obj.setSize(1000,1000);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
