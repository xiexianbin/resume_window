import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class theAbout implements ActionListener{
	JFrame f = new JFrame("����--��ݼ�ʹ��˵��");
	Container c;
	JLabel l, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;
	JPanel jpanel, jp1;
	JButton button;
	public theAbout(){
		c = f.getContentPane();
		jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(5, 3));
		l = new JLabel("   "+"��ݼ�ʹ��˵�����£�");
		l.setFont(new Font("����", Font.CENTER_BASELINE, 24));
		f.add(l, BorderLayout.NORTH);
		l1 = new JLabel("    "+"�ļ���Alt + F");
		l2 = new JLabel("��ɫ��Alt + S");
		l3 = new JLabel("����: Alt + H");
		l4 = new JLabel("      "+"�ύ��Ctrl + C");
		l5 = new JLabel(" ");
		l6 = new JLabel("      "+"��ݼ��� Ctrl + H");
		l7 = new JLabel("      "+"���棺Ctrl + S");
		l8 = new JLabel(" ");
		l9 = new JLabel("      "+"˵���� Ctrl + I");
		l10 = new JLabel("      "+"���: Ctrl + L");
		l11 = new JLabel(" ");
		l12 = new JLabel(" ");
		l13 = new JLabel("      "+"�˳�: Ctrl + E");
		l14 = new JLabel(" ");
		l15 = new JLabel(" ");
		
		jpanel.add(l1);
		jpanel.add(l2);
		jpanel.add(l3);
		jpanel.add(l4);
		jpanel.add(l5);
		jpanel.add(l6);
		jpanel.add(l7);
		jpanel.add(l8);
		jpanel.add(l9);
		jpanel.add(l10);
		jpanel.add(l11);
		jpanel.add(l12);
		jpanel.add(l13);
		jpanel.add(l14);
		jpanel.add(l15);
		
		c.add(jpanel, BorderLayout.CENTER);
		button = new JButton("ȷ��");
		button.addActionListener(this);
		jp1 = new JPanel();
		jp1.add(button);
		f.add(jp1, BorderLayout.SOUTH);
		
		f.setSize(400,250);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		f.dispose();
	}
}
