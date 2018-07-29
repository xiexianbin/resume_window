
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;


public class TheLognInSystem extends MouseAdapter implements WindowListener{

	JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9 ,l10, l11, l12, l13, l14, l15, l16;
	JButton b1, b2, b3, b4;
	JFrame frame;
	Container container, container1, conatiner2;
	JRadioButton rb1, rb2;
	JTextField tf1, tf2, tf3, tf4, tf5, tf6;
	JTextArea ta1;
	JCheckBox checkb1, checkb2, checkb3, checkb4, checkb5, checkb6, checkb7;
	JComboBox cb1, cb2, cb3, cb4;
	JList list;
	JScrollPane scrollPane1, scrollPane2;
	ButtonGroup buttonGroup;
	
	JPopupMenu popMenu = new JPopupMenu();
	
	public int year, month;
	public int[][] a = {{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};
	public int flag;
	public String LogInInfor;//存储录入信息
	public FileWriter fileWriter;
	//菜单
	JMenuBar menuBar;
	JMenu fileMenu, colorMenu, helpMenu, frontColorMenu, rearColorMenu;
	JMenuItem defau, saveMenuItem, commitMenuItem, exitMemuItem, clearnMenuItem, aboutMenuItem, infoMenuItem, frontRedColorMenuItem, frontYellowColorMenuItem, defaultFrontColorMenuItem, rearRedColorMenuItem, rearYellowColorMenuItem, defualtRearColorMenuItem;
	
	//构造器
	public TheLognInSystem(){
		frame = new JFrame("个人简历设计窗口");
		frame.addWindowListener(this);
		container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		p11 = new JPanel(new GridLayout(10, 1));
		
		//创建菜单
		menuBar = new JMenuBar();
		builderMainMenu(menuBar);
		frame.setJMenuBar(menuBar);
		
		container1 = p11;
		container1.setLayout(new FlowLayout(FlowLayout.LEFT));//第二个边框
		//个人简历栏
		builderGerenjianli();
		container.add(p1, BorderLayout.NORTH);
		
		//基本信息栏
		builderBaseInformation();
		p11.setBorder(BorderFactory.createTitledBorder("基本信息"));
		//container.add(container1);
		container1.add(p14, BorderLayout.NORTH);
		container1.add(p5, BorderLayout.CENTER);
		container1.add(p15, BorderLayout.SOUTH);
		
		//保存信息栏
		builderSaveInformation();
		//container.add(p12);
		p12.setBorder(BorderFactory.createTitledBorder("保存信息"));
		
		p13 = new JPanel(new BorderLayout());
		p13.add(p12, BorderLayout.SOUTH);
		p13.add(p11, BorderLayout.CENTER);
		
		container.add(p13, BorderLayout.CENTER);
		
		//基本操作栏
		builderAction();
		container.add(p10, BorderLayout.SOUTH);
		p10.setBorder(BorderFactory.createTitledBorder("基本操作"));
		
		frame.setVisible(true);
		frame.setSize(555, 750);
	}
	
	//创建基本操作栏
	private void builderAction() {
		// TODO Auto-generated method stub
		b1 = new JButton("提交");
		b2 = new JButton("保存");
		b3 = new JButton("清空");
		b4 = new JButton("退出");
		p10 = new JPanel(new FlowLayout());
		p10.add(b1);
		b1.addActionListener(new CommitActionListener());
		
		p10.add(b2);
		b2.addActionListener(new SaveActionListener());
		
		p10.add(b3);
		b3.addActionListener(new ClearnActionListener());
		
		p10.add(b4);
		//内部类
		b4.addActionListener(new ExitActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		
	}
	
	//创建保存信息栏
	private void builderSaveInformation() {
		// TODO Auto-generated method stub
		p12 = new JPanel(new BorderLayout());
		l15 = new JLabel("文件名：");
		tf6 = new JTextField(42);
		p9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p9.add(l15);
		p9.add(tf6);
		p12.add(p9, BorderLayout.NORTH);
		ta1 = new JTextArea(10, 20);
		scrollPane2 = new JScrollPane(ta1);
		p12.add(scrollPane2, BorderLayout.CENTER);
	}

	//创建基本信息栏
	private void builderBaseInformation() {
		// TODO Auto-generated method stub
		p14 = new JPanel(new GridLayout(0, 1));
		p15 = new JPanel(new GridLayout(0, 1));
		//p2
		l2 = new JLabel("姓名：");
		tf1 = new JTextField(28);
		l3 = new JLabel("          "+"性别：");
		rb1 = new JRadioButton("男");
		rb2 = new JRadioButton("女");
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rb1);
		buttonGroup.add(rb2);
		p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p2.add(l2);
		p2.add(tf1);
		p2.add(l3);
		p2.add(rb1);
		p2.add(rb2);
		p14.add(p2);
		//p3
		p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		l4 = new JLabel("生日：");
		l5 = new JLabel("年"+"      ");
		l6 = new JLabel("月"+"      ");
		l7 = new JLabel("日");
		l8 = new JLabel("            "+"                      "+"年龄：");
		l16 = new JLabel("岁");
		cb1 = new JComboBox();
		cb2 = new JComboBox();
		cb3 = new JComboBox();
		
		
		for( int i = 1900; i <= 2012; i++){
			Integer aa = new Integer(i);
			cb1.addItem(aa);
		}
		for(int i = 1; i<13; i++)
		{
			Integer bb = new Integer(i);
			cb2.addItem(bb);
		}
		for(int i = 1; i<=31; i++)
		{
			Integer cc = new Integer(i);
			cb3.addItem(cc);
		}
		
		//为cb1、cb2添加事件监听程序
		cb1.addItemListener(new cb1_addItemListener());
		cb2.addItemListener(new cb2_addItemListener());
		
		year = (Integer) cb1.getSelectedItem();
		month = (Integer) cb2.getSelectedItem();
		cb3.removeAllItems();
		
		if(year%100!=0 && year%4==0 || year%400 == 0)
		{
			for(int i = 1; i<=(int)a[0][month]; i++){
				Integer cc = new Integer(i);
				cb3.addItem(cc);
			}
		}
		else{
			for(int i = 1; i<=(int)a[1][month]; i++){
				Integer cc = new Integer(i);
				cb3.addItem(cc);
			}
		}
		
		tf2 = new JTextField(5);

		Calendar calendar = new GregorianCalendar();
        java.util.Date trialTime = new java.util.Date();
        calendar.setTime(trialTime);
        int nn1 = calendar.get(Calendar.YEAR);
		Integer old = nn1 - year;
		String s = old.toString();
		tf2.setText(s);

		tf2.setEnabled(false);
		p3.add(l4);
		p3.add(cb1);
		p3.add(l5);
		p3.add(cb2);
		p3.add(l6);
		p3.add(cb3);
		p3.add(l7);
		p3.add(l8);
		p3.add(tf2);
		p3.add(l16);
		p14.add(p3);
		
		//p4
		p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		l9 = new JLabel("住址：");
		tf3 = new JTextField(42);
		p4.add(l9);
		p4.add(tf3);
		p14.add(p4);
		
		//p5
		p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		l10 = new JLabel("政治面貌：");
		l11 = new JLabel("                            "+"所学课程：");
		cb4 = new JComboBox();
		cb4.addItem("请选择...");
		cb4.addItem("党员");
		cb4.addItem("预备党员");
		cb4.addItem("团员");
		cb4.addItem("群众");
		cb4.addItem("其他");
		
		Object[] Data = {"网页设计", "SQL数据库", "Java程序设计", "C语言程序设计", "C++程序设计", "C#程序设计", "VB.net程序设计", "Flash动画制作"};
		list = new JList(Data);
		list.setVisibleRowCount(3);
		scrollPane1 = new JScrollPane(list);
		p5.add(l10);
		p5.add(cb4);
		p5.add(l11);
		p5.add(scrollPane1);
		container1.add(p5);
		
		//p6
		p6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		l12 = new JLabel("所学专业：");
		tf4 = new JTextField(40);
		p6.add(l12);
		p6.add(tf4);
		p15.add(p6);
		
		//p7
		p7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		l13 = new JLabel("爱好：");
		checkb1 = new JCheckBox("唱歌");
		checkb2 = new JCheckBox("跳舞");
		checkb3 = new JCheckBox("乒乓球");
		checkb4 = new JCheckBox("篮球");
		checkb5 = new JCheckBox("足球");
		checkb6 = new JCheckBox("乐器");
		checkb7 = new JCheckBox("表演");
		p7.add(l13);
		p7.add(checkb1);
		p7.add(checkb2);
		p7.add(checkb3);
		p7.add(checkb4);
		p7.add(checkb5);
		p7.add(checkb6);
		p7.add(checkb7);
		p15.add(p7);
		
		//p8
		p8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		l14 = new JLabel("毕业学校：");
		tf5 = new JTextField(40);
		p8.add(l14);
		p8.add(tf5);
		p15.add(p8);

	}
	
	//创建个人简历标题
	private void builderGerenjianli() {
		// TODO Auto-generated method stub
		p1 = new JPanel();
		l1 = new JLabel("个人简历");
		l1.setFont(new Font("楷体", Font.BOLD, 30));
		p1.add(l1);
		//p1.setBorder(BorderFactory.createTitledBorder(""));
		
	}

	//创建菜单
	private void builderMainMenu(JMenuBar menubar) {
		// TODO Auto-generated method stub
		//文件菜单
		fileMenu = new JMenu("文件(F)");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		commitMenuItem = new JMenuItem("提交");
		commitMenuItem.addActionListener(new CommitActionListener());//提交
		commitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));//ctrl + c
		
		fileMenu.add(commitMenuItem);
		saveMenuItem = new JMenuItem("保存");
		saveMenuItem.addActionListener(new SaveActionListener());//保存
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));//ctrl + s
		fileMenu.add(saveMenuItem);
		clearnMenuItem = new JMenuItem("清空");
		clearnMenuItem.addActionListener(new ClearnActionListener());//清空
		clearnMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));//ctrl + L
		fileMenu.add(clearnMenuItem);
		exitMemuItem = new JMenuItem("退出");
		exitMemuItem.addActionListener(new ExitActionListener());
		exitMemuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));//ctrl + E
		
		fileMenu.addSeparator();
		fileMenu.add(exitMemuItem);
		menubar.add(fileMenu);
		
		//颜色菜单
		colorMenu = new JMenu("颜色(S)");
		colorMenu.setMnemonic(KeyEvent.VK_S);
		frontColorMenu = new JMenu("前景色");
		rearColorMenu = new JMenu("背景色");
		
		//前景色菜单
		frontRedColorMenuItem = new JMenuItem("红色");
		frontRedColorMenuItem.addActionListener(new setFrontRedColor());
		frontYellowColorMenuItem = new JMenuItem("黄色");
		frontYellowColorMenuItem.addActionListener(new setFrontYellowColor());
		defaultFrontColorMenuItem = new JMenuItem("默认");
		defaultFrontColorMenuItem.addActionListener(new setDefaultFrontColor());
		
		//背景色菜单
		rearRedColorMenuItem = new JMenuItem("红色");
		rearRedColorMenuItem.addActionListener(new setRearRedColor());
		rearYellowColorMenuItem = new JMenuItem("黄色");
		rearYellowColorMenuItem.addActionListener(new setRearYellowColor());
		defualtRearColorMenuItem = new JMenuItem("默认");
		defualtRearColorMenuItem.addActionListener(new setdefualtRearColor());
		
		defau = new JMenuItem("默认");
		defau.addActionListener(new defau());
		
		colorMenu.add(frontColorMenu);
	
		colorMenu.add(rearColorMenu);
		colorMenu.addSeparator();
		colorMenu.add(defau);
		frontColorMenu.add(frontRedColorMenuItem);
		frontColorMenu.add(frontYellowColorMenuItem);
		frontColorMenu.addSeparator();
		frontColorMenu.add(defaultFrontColorMenuItem);
		
		rearColorMenu.add(rearRedColorMenuItem);
		rearColorMenu.add(rearYellowColorMenuItem);
		rearColorMenu.addSeparator();
		rearColorMenu.add(defualtRearColorMenuItem);
		
		
		menubar.add(colorMenu);
		
		
		//帮助菜单
		helpMenu = new JMenu("帮助(H)");
		helpMenu.setMnemonic(KeyEvent.VK_H);
		aboutMenuItem = new JMenuItem("快捷键说明");
		aboutMenuItem.addActionListener(new AboutActionListener());//关于
		aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		helpMenu.add(aboutMenuItem);
		helpMenu.addSeparator();
		infoMenuItem = new JMenuItem("版权说明");
		infoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));//ctil + I
		infoMenuItem.addActionListener(new InfoActionListener());
		helpMenu.add(infoMenuItem);
		
		menubar.add(helpMenu);
		
		//frame.addMouseListener(new mouseLis());
		//popMenu.add(fileMenu);
		//popMenu.add(menubar);
		//popMenu.add(helpMenu);
	}

	class mouseLis extends MouseAdapter {
		// TODO Auto-generated method stub
		public void mouseClicked(MouseEvent e){
				if(e.getButton() == e.BUTTON3)
					popMenu.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//清空事件
	public class ClearnActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			tf1.setText(null);
			tf2.setText("112");
			tf3.setText(null);
			tf4.setText(null);
			tf5.setText(null);
			tf6.setText(null);
			ta1.setText(null);
			cb1.setSelectedIndex(0);
			cb2.setSelectedIndex(0);
			cb3.setSelectedIndex(0);
			cb4.setSelectedIndex(0);
			checkb1.setSelected(false);
			checkb2.setSelected(false);
			checkb3.setSelected(false);
			checkb4.setSelected(false);
			checkb5.setSelected(false);
			checkb6.setSelected(false);
			checkb7.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			buttonGroup.clearSelection();
			list.clearSelection();
		}

	}
	
	//提交事件
	public class CommitActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			LogInInfor = getLogInInformation();
			if(LogInInfor == null || LogInInfor.equals("") == true){
				
			}else{
				ta1.append(LogInInfor);
			}
		}

	}

	//保存事件
	public class SaveActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try{
				LogInInfor = getLogInInformation();
				if(LogInInfor == null || "".equals(LogInInfor) == true){
					//String msg = "文件名不能为空！！\n";
					//String title = "提示信息";
					//JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
					return ;
				}
				if(tf6.getText().trim() == null || "".equals(tf6.getText().trim()) == true){
					String msg = "文件名不能为空，请选输入文件名！！\n注：文件名必须以 *.rtf/*.txt或*.doc结尾！\n";
					String title = "错误信息";
					JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
					return ;
				} else {
					fileWriter = new FileWriter(tf6.getText());
					fileWriter.write(LogInInfor);
					fileWriter.close();
					//FileOutputStream fout = new FileOutputStream(tf6.getText().trim());
					//DataOutputStream dout = new DataOutputStream(fout);
					//dout.writeChars(LogInInfor);
					//dout.flush();
					//dout.close();
					String msg = "请选保存文件名成功！！";
					String title = "信息提示";
					JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
				}
				
			}catch (Exception e2) {
				// TODO: handle exception
				String msg = "保存文件失败！！\n注：文件名必须以 .txt或.doc结尾！\n";
				String title = "错误信息";
				JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
				
			}finally{
				//fileWriter.close();
			}

		}

	}

	//退出事件
	public class ExitActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}

	}
	
	//设定cb1的事件函数
	public class cb1_addItemListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			Integer m, y, old;
			String s;
			
			y = (Integer)cb1.getSelectedItem();
			
			year = y.intValue();

			m = (Integer)cb2.getSelectedItem();
			month = m.intValue();
			//System.out.println(m);
			
			flag = 0;
			if(year%400==0 || year%100!=0&&year%4==0)
				flag = 1;
			else
				flag = 0;
			
			cb3.removeAllItems();
			
			for(int i = 1; i <=a[flag][month]; i++)
			{
				Integer d = new Integer(i);
				cb3.addItem(d);
			}
			
			Calendar calendar = new GregorianCalendar();
	        java.util.Date trialTime = new java.util.Date();
	        calendar.setTime(trialTime);
	        int nn1 = calendar.get(Calendar.YEAR);
			old = nn1 - year;
			s = old.toString();
			tf2.setText(s);
		}

	}

	//设定cb2的事件函数
	public class cb2_addItemListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			Integer m, y;
			y = (Integer)cb1.getSelectedItem();
			year = y.intValue();
			//System.out.println(y);
			
			m = (Integer)cb2.getSelectedItem();
			month = m.intValue();
			//System.out.println(m);
			
			flag = 0;
			if(year%400==0 || year%100!=0&&year%4==0)
				flag = 1;
			else
				flag = 0;
			
			cb3.removeAllItems();
			for(int i = 1; i<=a[flag][month]; i++)
			{
				Integer d = new Integer(i);
				cb3.addItem(d);
			}
			
		}

	}
	
	//设置背景色
	public class setRearRedColor implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Color color = Color.RED;
			menuBar.setBackground(color);
			p1.setBackground(color);
			p2.setBackground(color);
			p3.setBackground(color);
			p4.setBackground(color);
			p5.setBackground(color);
			p6.setBackground(color);
			p7.setBackground(color);
			p8.setBackground(color);
			p9.setBackground(color);
			p10.setBackground(color);
			p11.setBackground(color);
			p12.setBackground(color);
			//p13.setBackground(Color.RED);
			p14.setBackground(color);
		}

	}
	public class setRearYellowColor implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Color color = Color.YELLOW;
			menuBar.setBackground(color);
			p1.setBackground(color);
			p2.setBackground(color);
			p3.setBackground(color);
			p4.setBackground(color);
			p5.setBackground(color);
			p6.setBackground(color);
			p7.setBackground(color);
			p8.setBackground(color);
			p9.setBackground(color);
			p10.setBackground(color);
			p11.setBackground(color);
			p12.setBackground(color);
			//p13.setBackground(Color.RED);
			p14.setBackground(color);
		}

	}
	public class setdefualtRearColor implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Color color = new Color(238, 238, 238);
			menuBar.setBackground(color);
			p1.setBackground(color);
			p2.setBackground(color);
			p3.setBackground(color);
			p4.setBackground(color);
			p5.setBackground(color);
			p6.setBackground(color);
			p7.setBackground(color);
			p8.setBackground(color);
			p9.setBackground(color);
			p10.setBackground(color);
			p11.setBackground(color);
			p12.setBackground(color);
			//p13.setBackground(Color.RED);
			p14.setBackground(color);
		}

	}
	
	//设置前景色
	public class setFrontRedColor implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Color color = Color.RED;
			tf1.setBackground(color);
			tf2.setBackground(color);
			tf3.setBackground(color);
			tf4.setBackground(color);
			tf5.setBackground(color);
			tf6.setBackground(color);
			ta1.setBackground(color);
			rb1.setBackground(color);
			rb2.setBackground(color);
			cb1.setBackground(color);
			cb2.setBackground(color);
			cb3.setBackground(color);
			cb4.setBackground(color);
			checkb1.setBackground(color);
			checkb2.setBackground(color);
			checkb3.setBackground(color);
			checkb4.setBackground(color);
			checkb5.setBackground(color);
			checkb6.setBackground(color);
			checkb7.setBackground(color);
			b1.setBackground(color);
			b2.setBackground(color);
			b3.setBackground(color);
			b4.setBackground(color);
			
			list.setBackground(color);
		}

	}
	public class setFrontYellowColor implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Color color = Color.YELLOW;
			tf1.setBackground(color);
			tf2.setBackground(color);
			tf3.setBackground(color);
			tf4.setBackground(color);
			tf5.setBackground(color);
			tf6.setBackground(color);
			ta1.setBackground(color);
			rb1.setBackground(color);
			rb2.setBackground(color);
			cb1.setBackground(color);
			cb2.setBackground(color);
			cb3.setBackground(color);
			cb4.setBackground(color);
			checkb1.setBackground(color);
			checkb2.setBackground(color);
			checkb3.setBackground(color);
			checkb4.setBackground(color);
			checkb5.setBackground(color);
			checkb6.setBackground(color);
			checkb7.setBackground(color);
			b1.setBackground(color);
			b2.setBackground(color);
			b3.setBackground(color);
			b4.setBackground(color);
			
			list.setBackground(color);
		}

	}
	public class setDefaultFrontColor implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//Color color = new Color(238, 238, 238);
			Color color = new Color(255, 255, 255);
			tf1.setBackground(color);
			tf2.setBackground(color);
			tf3.setBackground(color);
			tf4.setBackground(color);
			tf5.setBackground(color);
			tf6.setBackground(color);
			ta1.setBackground(color);
			rb1.setBackground(color);
			rb2.setBackground(color);
			cb1.setBackground(color);
			cb2.setBackground(color);
			cb3.setBackground(color);
			cb4.setBackground(color);
			checkb1.setBackground(color);
			checkb2.setBackground(color);
			checkb3.setBackground(color);
			checkb4.setBackground(color);
			checkb5.setBackground(color);
			checkb6.setBackground(color);
			checkb7.setBackground(color);
			b1.setBackground(color);
			b2.setBackground(color);
			b3.setBackground(color);
			b4.setBackground(color);
			
			list.setBackground(color);
		}

	}
	
	public class defau implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new setdefualtRearColor();
			Color color = new Color(255, 255, 255);
			tf1.setBackground(color);
			tf2.setBackground(color);
			tf3.setBackground(color);
			tf4.setBackground(color);
			tf5.setBackground(color);
			tf6.setBackground(color);
			ta1.setBackground(color);
			rb1.setBackground(color);
			rb2.setBackground(color);
			cb1.setBackground(color);
			cb2.setBackground(color);
			cb3.setBackground(color);
			cb4.setBackground(color);
			checkb1.setBackground(color);
			checkb2.setBackground(color);
			checkb3.setBackground(color);
			checkb4.setBackground(color);
			checkb5.setBackground(color);
			checkb6.setBackground(color);
			checkb7.setBackground(color);
			b1.setBackground(color);
			b2.setBackground(color);
			b3.setBackground(color);
			b4.setBackground(color);
			
			list.setBackground(color);
			color = new Color(238, 238, 238);
			menuBar.setBackground(color);
			p1.setBackground(color);
			p2.setBackground(color);
			p3.setBackground(color);
			p4.setBackground(color);
			p5.setBackground(color);
			p6.setBackground(color);
			p7.setBackground(color);
			p8.setBackground(color);
			p9.setBackground(color);
			p10.setBackground(color);
			p11.setBackground(color);
			p12.setBackground(color);
			//p13.setBackground(Color.RED);
			p14.setBackground(color);
		}

	}
	
	private String getLogInInformation() {
		// TODO Auto-generated method stub
		if(LogInInfor != "")
		{
			LogInInfor = "";
		}
		tf1.setText(tf1.getText().trim());
		if(tf1.getText() == null || tf1.getText().equals("") == true)
		{
			String msg = "请输入您的姓名！！";
			String title = "错误信息";
			JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
			return null;
		}else{
			LogInInfor += "姓名：" + tf1.getText()+"\n";
		}
		if(buttonGroup.isSelected(null) == true){
			String msg = "请选择性别！！";
			String title = "错误信息";
			JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
			return null;
		}else{
			if(rb1.isSelected() == true)
				LogInInfor += "性别：" + rb1.getText() + "\n";
			else if(rb2.isSelected() == true)
				LogInInfor += "性别：" + rb2.getText() + "\n";
		}
		
		LogInInfor += "生日：" + cb1.getSelectedItem() + "年" + cb2.getSelectedItem() + "月" + cb3.getSelectedItem() + "日\n" + "年龄：" + tf2.getText()+"岁";
		
		
		if(tf3.getText().trim().equals("") == true){
			String msg = "请输入地址！！";
			String title = "错误信息";
			JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
			return null;
		}else{
			LogInInfor += "\n地址：" + tf3.getText() + '\n';
		}
		
		if(cb4.getSelectedIndex() == 0){
			String msg = "请选择政治面貌！！";
			String title = "错误信息";
			JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
			return null;
		}else{
			LogInInfor += "政治面貌：" + cb4.getSelectedItem() + '\n';
		}
		
		try{
			LogInInfor += "所学课程：";
				Object[] data;
				data = list.getSelectedValues();
				int i, n;
				
				n = data.length;
			if(n < 0){
				String msg = "请选择所学课程！！";
				String title = "错误信息";
				JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
				return null;
			}else{
				
				/*if(n < 0)
				{
					String msg = "请输入所学课程！！";
					String title = "错误信息";
					JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
				
				}*/
				i=0;
				for(; i<n-1; i++)
				{
					LogInInfor += data[i].toString() + "、";
				}
				LogInInfor += data[i].toString() + '\n';
			}
		}catch(Exception e){
			String msg = "请选择所学课程！！";
			String title = "错误信息";
			JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
			return null;
		}
		
		if(tf4.getText().trim().equals("") == true){
			String msg = "请输入所学专业！！";
			String title = "错误信息";
			JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
			return null;
		}else{
			LogInInfor += "所学专业：" + tf4.getText() + "\n";

		}
		
		LogInInfor += "爱好：";
		if(checkb1.isSelected())
			LogInInfor += checkb1.getText()+ " ";
		if(checkb2.isSelected())
			LogInInfor += checkb2.getText()+ " ";
		if(checkb3.isSelected())
			LogInInfor += checkb3.getText()+ " ";
		if(checkb4.isSelected())
			LogInInfor += checkb4.getText()+" ";
		if(checkb5.isSelected())
			LogInInfor += checkb5.getText()+ " ";
		if(checkb6.isSelected())
			LogInInfor += checkb6.getText()+" ";
		if(checkb7.isSelected())
			LogInInfor += checkb7.getText()+ " ";
		LogInInfor += '\n';
		
		if(tf5.getText().trim().equals("") == true){
			String msg = "请输入毕业学校！！";
			String title = "错误信息";
			JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
			return null;
		}else{
			LogInInfor += "毕业学校：" + tf5.getText();
		}
		
		LogInInfor += "\n\n";
		
		return LogInInfor;
	}

	//主函数
	public static void main(String[] args) {
		new TheLognInSystem();
		
	}
}