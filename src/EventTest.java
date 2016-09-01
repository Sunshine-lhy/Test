import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class EventTest {
private JFrame frame;


JComboBox jcb1;
private JPanel jcb2;
JTextArea ta=new JTextArea(0,30);
public static void main(String args[]){
	EventTest that=new EventTest();
	that.go();
}
void go(){
	frame =new JFrame("事件测试");
	JButton b=new JButton();
	
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel p4=new JPanel();
	 
	String[] itemList={" ","one","two","three","four"};
	jcb1=new JComboBox(itemList);
	jcb1.setSelectedIndex(1);//设置第四个可选项为当前的显示项
	 
	p1.add(jcb1);
	Border etched=BorderFactory.createEtchedBorder();
	Border border=BorderFactory.createTitledBorder(etched,"选项框");
	p1.setBorder(border);
	 
	jcb2=new JPanel();
	Container contentPane=frame.getContentPane();




	jcb2.setLayout(new BoxLayout(jcb2,BoxLayout.Y_AXIS));
	
	b.addMouseListener(new ButtonMouseHander());
	
	jcb2.add(new JButton(">"));
	jcb2.add(new JButton(">>"));
	jcb2.add(new JButton("<"));
	jcb2.add(new JButton("<<"));
	
	contentPane.add(jcb2, BorderLayout.CENTER);
	
	JScrollPane jp=new JScrollPane(ta);
	p3.setLayout(new BorderLayout());
	p3.add(jp);
	border=BorderFactory.createTitledBorder(etched,"Resualts");
	p3.setBorder(border);
	 
	ActionListener a1=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			JComboBox jcb=(JComboBox)e.getSource();
			 
			if(jcb==jcb1){
				//将选项到jcb2的第一个位置
//				
				((JComboBox) jcb1).removeItemAt(0);
				ta.append("\n"+jcb1.getSelectedItem());
			}else{
				ta.append("\n You selected item:"+jcb1.getSelectedItem());
				jcb1.addItem(jcb1.getSelectedItem());
			}
		}
	};
	jcb1.addActionListener(a1);
	
	 
	p4.setLayout(new GridLayout(0,1));
	p4.add(p1);
	p4.add(p2);
	 
	 
	Container cp=frame.getContentPane();
	cp.setLayout(new GridLayout(1,3));
	cp.add(p4);
	cp.add(p3);
	 
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	frame.pack();
	frame.setVisible(true);
}


}


