import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


class Project2EmployeeManagement extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l41,l42,l43,l5,l61,l62,l7,l8,l9,l10,l19;
    JTextField t2,t41,t42,t43,t61,t62,t8;
    JButton b2,b4,b6,b8,b9,b10;
    Connection conn;
    Statement stmt;
    int affectedRecords,j,x=0;

    String tablename="",name="",id,id1,id2,Salary,Salary2;


    public static void main(String args[])
    {
        Project2EmployeeManagement a=new Project2EmployeeManagement();
    }

    Project2EmployeeManagement()
    {
        super("Employee Management system");
        setLayout(null);
        setSize(700,700);
        setVisible(true);


        l1=new JLabel("CREATE TABLE");
       l1.setBounds(20,30,100,30);
        add(l1);
         l2=new JLabel("Table Name:");
       l2.setBounds(20,70,100,30);
        add(l2);
         l3=new JLabel("INSERT EMPLOYEE RECORD");
       l3.setBounds(20,120,300,30);
        add(l3);
        l41=new JLabel("Id:");
        l41.setBounds(20,170,20,30);
        add(l41);
         l42=new JLabel("Name:");
        l42.setBounds(120,170,50,30);
        add(l42);
        l43=new JLabel("Salary");
       l43. setBounds(340,170,50,30);
        add(l43);
         l5=new JLabel("UPDATE EMPLOYEE RECORD");
      l5.  setBounds(20,220,300,30);
        add(l5);
         l61=new JLabel("id:");
       l61. setBounds(20,270,20,30);
        add(l61);
        l62=new JLabel("New Salary");
        l62.setBounds(120,270,80,30);
        add(l62);
      l7=new JLabel("DELETE RECORD");
       l7. setBounds(20,320,150,30);
        add(l7);
        l8=new JLabel("id");
       l8. setBounds(20,370,20,30);
        add(l7);
        l9=new JLabel("DROP TABLE");
        l9.setBounds(20,420,80,30);
        add(l9);
        l10 =new JLabel("SHOW TABLE");
        setBounds(20,480,80,30);
        add(l10);

        t2=new JTextField();
        t2.setBounds(130,70,100,30);
        add(t2);
        t41=new JTextField();
        t41.setBounds(50,170,60,30);
        add(t41);
        t42=new JTextField();
       t42. setBounds(180,170,150,30);
        add(t42);
        t43=new JTextField();
        t43.setBounds(400,170,70,30);
        add(t43);
        t61=new JTextField();
      t61.  setBounds(50,270,60,30);
        add(t61);
        t62=new JTextField();
       t62. setBounds(210,270,150,30);
        add(t62);
        t8=new JTextField();
        t8.setBounds(40,370,60,30);
        add(t8);

        b2=new JButton("Create Table");
       b2. setBounds(240,70,130,30);
        add(b2);
        b4=new JButton("Insert Record");
      b4.  setBounds(480,170,150,30);
        add(b4);
        b6=new JButton("Update Salary");
        b6.setBounds(370,270,150,30);
        add(b6);
        b8=new JButton("Delete employee");
       b8. setBounds(110,370,130,30);
        add(b8);
        b9=new JButton("Submit");
        b9.setBounds(110,420,100,30);
        add(b9);
        b10=new JButton("Show");
        b10.setBounds(10,480,80,30);
        add(b10);


        b2.addActionListener(this);
        b4.addActionListener(this);
        b6.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 public void actionPerformed(ActionEvent e)
   {

       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "bhosale", "Bhosale8428");
      stmt = conn.createStatement();


          if(e.getSource()==b2)
          {
             tablename= t2.getText();
              stmt.executeUpdate("CREATE TABLE "+tablename+" (id char(5) , Name varchar(20) , salary varchar(20)) ");
          }
           if(e.getSource()==b4)
           {
                  id= t41.getText();
                   name= t42.getText();
              Salary= t43.getText();
               int j = stmt.executeUpdate("INSERT INTO  "+tablename+" VALUES('"+id+ "', '"+name+"','"+Salary+"')");

           }
           if(e.getSource()==b6)
           {
               id1=t61.getText();
               Salary2=t62.getText();
               affectedRecords = stmt.executeUpdate("UPDATE  "+tablename+" SET salary='"+ Salary2 + "' WHERE id='" + id1+"'");
           }
           if(e.getSource()==b8)
           {
               id2=t8.getText();
               affectedRecords = stmt.executeUpdate("DELETE FROM "+tablename+" WHERE id='" + id2+"'");
           }
           if(e.getSource()==b9)
           {
               stmt.executeUpdate("DROP TABLE  "+tablename);
           }
           if(e.getSource()==b10)
           {
             ResultSet  rs=stmt.executeQuery("select * from  "+tablename);
               while(rs.next())
         {
             l19 = new JLabel(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
             add(l19);
             l19.setBounds(20,520+x,600,20) ;
             x=x+20;
         }
           }
           conn.close();
       }
       catch(Exception ae)
           {
               System.out.println(ae);
           }
       }


   }


