import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class MyCalendar extends JFrame {
	Calendar SAT = new GregorianCalendar(2019, 9, 14);
	Calendar today = Calendar.getInstance();
	Calendar day = Calendar.getInstance();
	Calendar s_day = Calendar.getInstance();

	int year = s_day.get(Calendar.YEAR);
	int month = s_day.get(Calendar.MONTH) + 1;
	int date = s_day.get(Calendar.DAY_OF_MONTH);
	int hour = s_day.get(Calendar.HOUR_OF_DAY);
	int minute = s_day.get(Calendar.MINUTE);
	int YYYY, MM;

	JButton prevMonth, nextMonth, gotoday;
	JLabel YYYYMM = new JLabel();
	DayPanel todate[] = new DayPanel[42];

	MyCalendar() {
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(new CenterPanel(), BorderLayout.CENTER);
		setDays(today);
		setTitle("SAT Calendar");
		setVisible(true);
		setSize(800, 750);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	class NorthPanel extends JPanel {
		NorthPanel() {
			setLayout(new FlowLayout());
			setBackground(Color.PINK);
			setPreferredSize(new Dimension(700, 300));
			prevMonth = new JButton("◀");
			nextMonth = new JButton("▶");
			gotoday = new JButton("today");
			YYYYMM.setOpaque(true);
			YYYYMM.setFont(new Font("Gothic", Font.PLAIN, 25));
			YYYYMM.setText(year + "년 " + month + "월");

			prevMonth.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (month >= 1) {
						month -= 1;
						s_day.set(year, month, s_day.get(Calendar.DAY_OF_WEEK));
						setDays(s_day);
						repaint();
					} else {
						year -= 1;
						month = 11;
						s_day.set(year, month, s_day.get(Calendar.DAY_OF_WEEK));
						setDays(s_day);
						repaint();
					}
				}
			});
			nextMonth.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (month < 11) {
						month += 1;
						s_day.set(year, month, s_day.get(Calendar.DAY_OF_WEEK));
						setDays(s_day);
						repaint();
					} else {
						year += 1;
						month = 0;
						s_day.set(year, month, s_day.get(Calendar.DAY_OF_WEEK));
						setDays(s_day);
						repaint();
					}
				}
			});
			gotoday.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					year = today.get(Calendar.YEAR);
					month = today.get(Calendar.MONTH);
					s_day.set(year, month, s_day.get(Calendar.DAY_OF_WEEK));
					setDays(s_day);
					repaint();
				}
			});
			add(prevMonth);
			add(YYYYMM);
			add(nextMonth);
			add(gotoday);
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setOpaque(false);
			if (1 == s_day.get(Calendar.MONTH) + 1) {
				ImageIcon icon1 = new ImageIcon("images/11.jpg");
				g.drawImage(icon1.getImage(), 0, 0, getWidth(), getHeight(), this);
			} else if (2 == s_day.get(Calendar.MONTH) + 1) {
				ImageIcon icon2 = new ImageIcon("images/2.jpg");
				g.drawImage(icon2.getImage(), 0, 0, getWidth(), getHeight(), this);
			} else if (3 == s_day.get(Calendar.MONTH) + 1) {
				ImageIcon icon3 = new ImageIcon("images/3.jpg");
				g.drawImage(icon3.getImage(), 0, 0, getWidth(), getHeight(), this);
			} else if (4 == s_day.get(Calendar.MONTH) + 1) {
				ImageIcon icon4 = new ImageIcon("images/12.jpg");
				g.drawImage(icon4.getImage(), 0, 0, getWidth(), getHeight(), this);
			} else if (5 == s_day.get(Calendar.MONTH) + 1) {
				ImageIcon icon5 = new ImageIcon("images/5.jpg");
				g.drawImage(icon5.getImage(), 0, 0, getWidth(), getHeight(), this);
			} else if (6 == s_day.get(Calendar.MONTH) + 1) {
				ImageIcon icon6 = new ImageIcon("images/6.jpg");
				g.drawImage(icon6.getImage(), 0, 0, getWidth(), getHeight(), this);
			} else if (7 == s_day.get(Calendar.MONTH) + 1) {
				ImageIcon icon7 = new ImageIcon("images/7.jpg");
				g.drawImage(icon7.getImage(), 0, 0, getWidth(), getHeight(), this);
			} else if (8 == s_day.get(Calendar.MONTH) + 1) {
				ImageIcon icon8 = new ImageIcon("images/8.jpg");
				g.drawImage(icon8.getImage(), 0, 0, getWidth(), getHeight(), this);
			} else if (9 == s_day.get(Calendar.MONTH) + 1) {
				ImageIcon icon9 = new ImageIcon("images/9.jpg");
				g.drawImage(icon9.getImage(), 0, 0, getWidth(), getHeight(), this);
			} else if (10 == s_day.get(Calendar.MONTH) + 1) {
				ImageIcon icon10 = new ImageIcon("images/10.jpg");
				g.drawImage(icon10.getImage(), 0, 0, getWidth(), getHeight(), this);
			} else if (11 == s_day.get(Calendar.MONTH) + 1) {
				ImageIcon icon11 = new ImageIcon("images/1.jpg");
				g.drawImage(icon11.getImage(), 0, 0, getWidth(), getHeight(), this);
			} else if (12 == s_day.get(Calendar.MONTH) + 1) {
				ImageIcon icon12 = new ImageIcon("images/4.jpg");
				g.drawImage(icon12.getImage(), 0, 0, getWidth(), getHeight(), this);
			}
		}
	}
	public void setDays(Calendar cal) {
		YYYY = cal.get(Calendar.YEAR);
		MM = cal.get(Calendar.MONTH);
		YYYYMM.setText(year + "년 " + (MM + 1) + "월");

		day.set(YYYY, MM, 1);
		day.get(Calendar.DAY_OF_WEEK);
		day.add(Calendar.DATE, -day.get(Calendar.DAY_OF_WEEK) + 1);

		for (int i = 0; i < todate.length; i++, day.add(Calendar.DATE, 1)) {
			String s = Integer.toString(day.get(Calendar.DATE));
			if (day.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				if (day.get(Calendar.MONTH) == MM) todate[i].getDate().setForeground(Color.BLUE);
				else todate[i].getDate().setForeground(Color.BLACK);
			} else if (day.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				if (day.get(Calendar.MONTH) == MM) todate[i].getDate().setForeground(Color.RED);
				else todate[i].getDate().setForeground(Color.BLACK);
			}
			todate[i].getDate().setText(s);
			if (day.get(Calendar.MONTH) != MM) {
				todate[i].setOpaque(true);
				todate[i].setBackground(Color.LIGHT_GRAY);
				todate[i].getPlus().setText(null);
				todate[i].getNon().setText(null);
			} else {
				todate[i].setOpaque(true);
				todate[i].setBackground(Color.WHITE);
				todate[i].getPlus().setText("+");
				int dday = (int) (((SAT.getTimeInMillis() - (new GregorianCalendar(day.get(Calendar.YEAR),
						day.get(Calendar.MONTH) - 1, Integer.parseInt(s))).getTimeInMillis())) / 1000 / 60 / 60 / 24);
				if (dday > 0) {
					String strDday = Integer.toString(dday);
					todate[i].getNon().setText("D-" + strDday);
				} else if (dday < 0) {
					dday *= -1;
					String strDday = Integer.toString(dday);
					todate[i].getNon().setText("D+" + strDday);
				} else if (dday == 0) {
					todate[i].getNon().setText("D-Day!!");
					todate[i].setBackground(Color.ORANGE);
				}
			}
		}
	}

	class CenterPanel extends JPanel {
		JLabel yoil[] = new JLabel[7];
		CenterPanel() {
			setLayout(new GridLayout(7, 7, 5, 5));
			setDayLabel();
			setDateLabel();
			for (int i = 0; i < yoil.length; i++) {
				yoil[i].setOpaque(true);
				yoil[i].setBackground(Color.ORANGE);
				yoil[i].setBorder(new LineBorder(Color.BLACK, 3));
				add(yoil[i]);
			}
			for (int i = 0; i < todate.length; i++)
				add(todate[i]);
		}
		public void setDayLabel() {
			yoil[0] = new JLabel(" Sun ", JLabel.CENTER);
			yoil[1] = new JLabel(" Mon ", JLabel.CENTER);
			yoil[2] = new JLabel(" Tue ", JLabel.CENTER);
			yoil[3] = new JLabel(" Wed ", JLabel.CENTER);
			yoil[4] = new JLabel(" Thu ", JLabel.CENTER);
			yoil[5] = new JLabel(" Fri ", JLabel.CENTER);
			yoil[6] = new JLabel(" Sat ", JLabel.CENTER);
			yoil[0].setFont(new Font("Arial", Font.PLAIN, 15));
			yoil[1].setFont(new Font("Arial", Font.PLAIN, 15));
			yoil[2].setFont(new Font("Arial", Font.PLAIN, 15));
			yoil[3].setFont(new Font("Arial", Font.PLAIN, 15));
			yoil[4].setFont(new Font("Arial", Font.PLAIN, 15));
			yoil[5].setFont(new Font("Arial", Font.PLAIN, 15));
			yoil[6].setFont(new Font("Arial", Font.PLAIN, 15));
			yoil[0].setForeground(Color.RED);
			yoil[6].setForeground(Color.BLUE);
		}
		public void setDateLabel() {
			for (int i = 0; i < todate.length; i++) {
				todate[i] = new DayPanel();
				this.add(todate[i]);
			}
		}
	}
	private class DayPanel extends JPanel {
		JLabel plusLabel = new JLabel("+");
		JLabel dateLabel = new JLabel();
		JLabel nonLabel = new JLabel();

		DayPanel() {
			setLayout(new BorderLayout(2, 5));
			setBackground(Color.WHITE);
			Box box1 = Box.createHorizontalBox();
			Box box2 = Box.createVerticalBox();

			plusLabel.setFont(new Font("Arial", Font.PLAIN, 20));
			plusLabel.setForeground(Color.MAGENTA);
			plusLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			plusLabel.setVisible(false);
			dateLabel.setFont(new Font("Arial", Font.PLAIN, 17));

			nonLabel.setVisible(false);
			this.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					DayPanel p = (DayPanel) e.getSource();
					Box boxTemp = Box.createHorizontalBox();
					boxTemp.add(Box.createHorizontalStrut(7));
					boxTemp.setMaximumSize(new Dimension(p.getWidth() - 10, 20));
					String memo = JOptionPane.showInputDialog(plusLabel, "ADD Memo");
					boxTemp.add(new JLabel(memo));
					box2.add(boxTemp);
					revalidate();
					repaint();
				}
				public void mouseEntered(MouseEvent e) {
					setBorder(new LineBorder(Color.CYAN, 2, true));
					plusLabel.setVisible(true);
					nonLabel.setVisible(true);
				}
				public void mouseExited(MouseEvent e) {
					setBorder(null);
					plusLabel.setVisible(false);
					nonLabel.setVisible(false);
				}
			});
			box1.add(Box.createHorizontalStrut(7));
			box1.add(dateLabel);
			box1.add(Box.createHorizontalStrut(7));
			box1.add(plusLabel);
			box1.add(Box.createHorizontalStrut(7));
			box1.add(nonLabel);
			this.add(box1, BorderLayout.NORTH);
			this.add(box2, BorderLayout.CENTER);
		}
		public JLabel getPlus() {return plusLabel;}
		public JLabel getDate() {return dateLabel;}
		public JLabel getNon() {return nonLabel;}
	}
	public static void main(String[] args) {
		new MyCalendar();
	}
}