import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class theAbout implements ActionListener{
	JFrame f = new JFrame("帮助--快捷键使用说明");
	Container c;
	JLabel l, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;
	JPanel jpanel, jp1;
	JButton button;
	public theAbout(){
		c = f.getContentPane();
		jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(5, 3));
		l = new JLabel("   "+"快捷键使用说明如下：");
		l.setFont(new Font("宋体", Font.CENTER_BASELINE, 24));
		f.add(l, BorderLayout.NORTH);
		l1 = new JLabel("    "+"文件：Alt + F");
		l2 = new JLabel("颜色：Alt + S");
		l3 = new JLabel("帮助: Alt + H");
		l4 = new JLabel("      "+"提交：Ctrl + C");
		l5 = new JLabel(" ");
		l6 = new JLabel("      "+"快捷键： Ctrl + H");
		l7 = new JLabel("      "+"保存：Ctrl + S");
		l8 = new JLabel(" ");
		l9 = new JLabel("      "+"说明： Ctrl + I");
		l10 = new JLabel("      "+"清空: Ctrl + L");
		l11 = new JLabel(" ");
		l12 = new JLabel(" ");
		l13 = new JLabel("      "+"退出: Ctrl + E");
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
		button = new JButton("确定");
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
