import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;

import javax.swing.*;


public class TimerGUI extends JFrame implements ActionListener {

	JButton but1=new JButton("Snooze");
	JButton but2=new JButton("Okay");
	JFrame Frame1 = new JFrame("Eye Timer");
	Timer ti=new Timer();
	public long delay=(long) (20.0*6000000);
	public long period=6000000;
	Reminder rem= new Reminder();
	public TimerTask task;
	public TimerGUI() {
		Frame1.setSize(400, 500);
		Frame1.setDefaultCloseOperation(HIDE_ON_CLOSE);
		Frame1.setVisible(true);
		but1.setSize(200, 250);
		but2.setSize(100, 100);
		Frame1.getContentPane().add(but1);
		Frame1.getContentPane().add(but2);
		but1.addActionListener(this);
		but2.addActionListener(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton but=(JButton) e.getSource();
		Frame1.setVisible(false);
		if (but.equals(but1)) {
			System.out.println("but1 ptessed");
			ti.schedule(task, delay);
			Frame1.setVisible(true);
		}
		else{
			System.out.println("but2 ptessed");
			ti.schedule(task, period);
			Frame1.setVisible(true);
		}
	}
	

}
