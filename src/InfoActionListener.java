import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

//��Ȩ˵��
public class InfoActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String msg = "���˼��¼��ϵͳV1.0\nCorpyright(C)2012-2012\n\nBy л�ȱ�\n�༶���������ѧ�뼼��10-01��\nѧ�ţ�541007010144";
		String title = "������Ϣ";
		JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
	}
}
