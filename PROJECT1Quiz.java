import javax.swing.*;
import java.awt.event.*;
class PROJECT1Quiz extends JFrame implements ActionListener


{
    JLabel question;
    JRadioButton optionA,optionB,optionC,optionD,optionE;
    ButtonGroup group;
    JButton next;
int pagenumber=1,correctAnswers=0, incorrectAnswers;
    public static void main(String args[])
    {
        PROJECT1Quiz a=new PROJECT1Quiz();
    }

PROJECT1()
{


    setVisible(true);
    setSize(600,350);
    setLayout(null);
    setLocation(400,100);

    
   question =new JLabel();
   question.setBounds(30,40,550,20);
   add(question);
   optionA=new JRadioButton();
    optionA.setBounds(50,80,200,20);
    add( optionA);
   optionB=new JRadioButton();
    optionB.setBounds(50,110,200,20);
    add( optionB);
   optionC=new JRadioButton();
    optionC.setBounds(50,140,200,20);
    add( optionC);
   optionD=new JRadioButton();
    optionD.setBounds(50,170,200,20);
    add(optionD);
    optionE=new JRadioButton();
    add(optionE);
   next=new JButton("Next");
    next.setBounds(30,200,100,30);
    add(next);
    group =new ButtonGroup();
   group.add(optionA);
    group.add(optionB);
    group.add(optionC);
    group.add(optionD);
group.add(optionE);
    next.addActionListener(this);
    dynamicStatement();
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}
 public  void actionPerformed(ActionEvent e)
 {
   if(e.getActionCommand().equals("Next"))
   {
       if(check())
       {
           correctAnswers++;
       }
       if(pagenumber==5)
       {
           next.setText("Submit");
       }
      pagenumber++;
       dynamicStatement();
   }
   if(e.getActionCommand().equals("Submit"))
   {
       if(check())
       {
           correctAnswers++;
       }
       incorrectAnswers=5-correctAnswers;
      JOptionPane.showMessageDialog(this,"Number of correct answers ="+correctAnswers+"\nNumber of incorrect answers ="+ incorrectAnswers);
System.exit(0);
   }
 }
void dynamicStatement()
{
    optionE.setSelected(true);
    if(pagenumber==1)
{
    question.setText("Which among this is not a primitive data type");
    optionA.setText("int");
    optionB.setText("Float");
    optionC.setText("boolean");
    optionD.setText("char");
}
   else if(pagenumber==2)
    {
        question.setText("Which class is a super class of all java classes automatically?");
        optionA.setText("Swing");
        optionB.setText("Applet");
        optionC.setText("Object");
        optionD.setText("ActionEvent");

    }
   else if(pagenumber==3)
    {
        question.setText("Which package is directly available to our class without importing it");
        optionA.setText("swing");
        optionB.setText("applets");
        optionC.setText("event");
        optionD.setText("lang");

    }
   else if(pagenumber==4)
    {
        question.setText("Which one among these is not a keyword");
        optionA.setText("class");
        optionB.setText("int");
        optionC.setText("get");
        optionD.setText("if");

    }
   else if(pagenumber==5)
    {
        question.setText("Which institute is best for java coaching");
        optionA.setText("Aptech");
        optionB.setText("NEIT");
        optionC.setText("CDAC");
        optionD.setText("Study circle");


    }
}
boolean check()
{
switch (pagenumber)
{
    case 1:return optionB.isSelected();
    case 2:return optionC.isSelected();
    case 3:return optionD.isSelected();
    case 4:return optionC.isSelected();
    case 5:return optionD.isSelected();
    default:return false;
}
}
}