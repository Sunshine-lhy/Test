import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;


public class JTextFieldDemo2 {
JFrame frame=new JFrame("课堂测试");
JLabel nameLabel=new JLabel("User name");
JLabel pwLabel=new JLabel("Password");
JTextField nameField=new JTextField();
JPasswordField pwField=new JPasswordField();
JTextArea ta=new JTextArea(5,20);


public static void main(String args[]){
	JTextFieldDemo2 tfd2=new JTextFieldDemo2();
	tfd2.go();
}
public void go(){
	UpperCaseDocument ucDocument=new UpperCaseDocument();
	nameField.setDocument(ucDocument);
	nameField.setForeground(Color.gray);


	JPanel labelPanel=new JPanel();
	labelPanel.setLayout(new GridLayout(2,1));
	labelPanel.add(nameLabel);
	labelPanel.add(pwLabel);
	
	JPanel fieldPanel=new JPanel();
	fieldPanel.setLayout(new GridLayout(2,1));
	fieldPanel.add(nameField);
	fieldPanel.add(pwField);
	
	JPanel northPanel=new JPanel();
	northPanel.setLayout(new GridLayout(2,1));
	northPanel.add(labelPanel);
	northPanel.add(fieldPanel);
	
	JScrollPane jsp=new JScrollPane(ta,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	Container cp=frame.getContentPane();
	cp.add(northPanel, BorderLayout.NORTH);
	cp.add(jsp,BorderLayout.CENTER);
	
	
	JButton a=new JButton("Yes");
	JButton b=new JButton("cancel");


	a.addActionListener(
			 new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String username=nameField.getText();//获取文本域的内容
			ta.append("User name:"+username+"\n");//将获取到的内容显示在文本区中
			char pw[]=pwField.getPassword();
			String password=new String(pw);
			ta.append("Password:"+password+"\n");
		}
	}  );
	
	b.addActionListener(
		new ActionListener(){
		public void actionPerformed(ActionEvent e){
		pwField.setText("");
		nameField.setText("");
		}
	}  );
	
	northPanel.add(a,BorderLayout.SOUTH);
	northPanel.add(b,BorderLayout.SOUTH);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.pack();
	frame.setVisible(true);
	
}
}
//自定义的Document，当用户输入字符串时，自动将小写转化为大写
class UpperCaseDocument extends PlainDocument{
	public void insertString(int offset,String string,AttributeSet attributeSet)
	throws BadLocationException{
		string=string.toUpperCase();
		super.insertString(offset, string, attributeSet);
	}
}
