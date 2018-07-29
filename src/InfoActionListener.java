import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

//版权说明
public class InfoActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String msg = "个人简介录入系统V1.0\nCorpyright(C)2012-2012\n\nBy 谢先斌\n班级：计算机科学与技术10-01班\n学号：541007010144";
		String title = "作者信息";
		JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
	}
}
