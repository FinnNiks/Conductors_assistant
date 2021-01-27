import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Secondary {
	JFrame f1, f2, f3, f4;
	JLabel l1, l2;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
	JTextField t1, t2, t3;
	JComboBox cb1, cb2;
	JList list;
	chief m = new chief();
	DefaultComboBoxModel<String> m1 = new DefaultComboBoxModel<String>(new String[] { "1", "2", "3" });
	DefaultComboBoxModel<String> m2 = new DefaultComboBoxModel<String>(new String[] { "4", "5", "6" });
	DefaultComboBoxModel<String> m3 = new DefaultComboBoxModel<String>(new String[] { "7", "8", "9" });

	wind fire = new wind();
	earth great = new earth();
	 MyWindowAdapter windAdpter = new MyWindowAdapter();

	public Secondary() {
		
		
		f1 = new JFrame("«Conductor’s Assistant»");
		f2 = new JFrame("«Conductor’s Assistant»");
		f3 = new JFrame("«Conductor’s Assistant»");
		f4 = new JFrame("«Conductor’s Assistant»");
		b1 = new JButton("Базы");
		b2 = new JButton("Ведение учёта заказов");
		b3 = new JButton("Настройки");
		b4 = new JButton("Выход");
		b5 = new JButton("Добавить пассажира");
		b6 = new JButton("Добавить");
		b7 = new JButton("Управление базами");
		b8 = new JButton("Назад");
		b9 = new JButton("Назад");
		b10 = new JButton("Назад");
		t1 = new JTextField("№ Места");
		list = new JList(m.getListData());
		list.setVisibleRowCount(3);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cb1 = new JComboBox(m.mas);
		cb1.setEditable(true);
		cb2 = new JComboBox(m1);
		cb2.setEditable(true);
		f1.add(b1);
		f1.add(b2);
		f1.add(b3);
		f1.add(b4);
		f2.add(b7);
		f2.add(b5);
		f2.add(b9);
		f3.add(t1);
		f3.add(cb1);
		f3.add(cb2);
		f3.add(b6);
		f3.add(b8);
		f4.add(new JScrollPane(list));
		f4.add(b10);
		b1.addActionListener(fire);
		b4.addActionListener(fire);
		b5.addActionListener(fire);
		b6.addActionListener(fire);
		b7.addActionListener(fire);
		b8.addActionListener(fire);
		b9.addActionListener(fire);
		b10.addActionListener(fire);
		cb1.addItemListener(great);
		cb2.addItemListener(great);
		cb1.addActionListener(fire);
		f1.addWindowListener(windAdpter);
		f2.addWindowListener(windAdpter);
		f3.addWindowListener(windAdpter);
		f4.addWindowListener(windAdpter);

	}

	public class wind implements ActionListener {
		String catname;

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == cb1) {
				String a = (String) cb1.getSelectedItem();
				if (m.catnamesList.contains(a) == false) {
					m.catnamesList.add(a);
					try {
						m.f.write(" " + a);
						m.f.close();
					} catch (Exception i) {
						JOptionPane.showMessageDialog(null, "File not found "
								+ i.toString());
					}
				}
			}

			if (e.getSource() == b1) {
				f1.setVisible(false);
				f2.setVisible(true);

			}

			
			  if (e.getSource()==b4){ 
				  System.exit(0);
			  
			   }


			if (e.getSource() == b5) {
				f2.setVisible(false);
				f3.setVisible(true);
			}
			if (e.getSource() == b6) {
				for (int row = 0; row < m.catnamesList.size(); row++) {
					catname = catname + m.catnamesList.get(row) + " ";
				}
				System.out.print(catname);
			}
			if (e.getSource() == b7) {
				f2.setVisible(false);
				f4.setVisible(true);
			}
			if (e.getSource() == b8) {
				f3.setVisible(false);
				f2.setVisible(true);
			}
			if (e.getSource() == b9) {
				f2.setVisible(false);
				f1.setVisible(true);
			}
			if (e.getSource() == b10) {
				f4.setVisible(false);
				f2.setVisible(true);
			}

		}
	}

	public class MyWindowAdapter extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent arg0) {
			Object[] options = { "Да", "Нет!" };
			int n = JOptionPane.showOptionDialog(arg0.getWindow(),
					"Закрыть окно?", "Подтверждение",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, options, options[0]);
			if (n != JOptionPane.NO_OPTION) {
				System.exit(0);
			}
		}

	}

	public class earth implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String a = (String) cb1.getSelectedItem();
				if (m.catnamesList.contains(a) == false) {
					cb1.insertItemAt(e.getItem(), cb1.getItemCount());

				}

				if (cb1.getSelectedIndex() == 0) {
					cb2.setModel(m1);
				} else if (cb1.getSelectedIndex() == 1) {
					cb2.setModel(m2);

				} else if (cb1.getSelectedIndex() == 2) {
					cb2.setModel(m3);
				}
				if (cb2.getSelectedIndex() == 1) {
					if (cb2.getModel() == m2) {
						JOptionPane.showMessageDialog(null, "5");
					} else if (cb2.getModel() == m1) {
						JOptionPane.showMessageDialog(null, "2");
					}
				}

			}
		}

	}

}
