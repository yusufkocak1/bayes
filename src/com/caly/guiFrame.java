package com.caly;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.sun.xml.internal.bind.v2.model.annotation.FieldLocatable;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;

public class guiFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nametextfield;
	private JTable table;
	JComboBox gbcombo = new JComboBox();
	JComboBox cfcombo = new JComboBox();
	JComboBox lwcombo = new JComboBox();
	JComboBox hlcombo = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiFrame frame = new guiFrame();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public guiFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Bayes Sýnýflayýcý");
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 11, 68, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Give birth");
		lblNewLabel_1.setBounds(10, 36, 68, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Can fly");
		lblNewLabel_2.setBounds(10, 61, 68, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Live in water");
		lblNewLabel_3.setBounds(10, 86, 68, 14);
		contentPane.add(lblNewLabel_3);

		nametextfield = new JTextField();
		nametextfield.setBounds(88, 8, 86, 20);
		contentPane.add(nametextfield);
		nametextfield.setColumns(10);

		JButton btnClassifier = new JButton("Classifier");
		btnClassifier.setBounds(199, 57, 89, 23);
		contentPane.add(btnClassifier);

		JLabel lblSnf = new JLabel("S\u0131n\u0131f:");
		lblSnf.setBounds(316, 61, 46, 14);
		contentPane.add(lblSnf);

		JLabel sinifresult = new JLabel("");
		sinifresult.setBounds(346, 61, 77, 14);
		contentPane.add(sinifresult);

		gbcombo.setBounds(88, 33, 86, 20);
		contentPane.add(gbcombo);

		cfcombo.setBounds(88, 58, 86, 20);
		contentPane.add(cfcombo);

		lwcombo.setBounds(88, 83, 86, 20);
		contentPane.add(lwcombo);

		JLabel lblNewLabel_4 = new JLabel("have legs");
		lblNewLabel_4.setBounds(10, 111, 68, 14);
		contentPane.add(lblNewLabel_4);

		hlcombo.setBounds(88, 108, 86, 20);
		contentPane.add(hlcombo);

		JPanel panel = new JPanel();
		panel.setBounds(10, 145, 423, 166);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

		// table fill
		fullTableSelect fullTableSelect = new fullTableSelect();
		fullTableSelect.select();
		filtable(fullTableSelect.getlist());
		// item adding
		additem();
		btnClassifier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				contact contact = new contact.Builder(nametextfield.getText()
						.toString(), gbcombo.getSelectedItem().toString(),
						cfcombo.getSelectedItem().toString(), lwcombo
								.getSelectedItem().toString(), hlcombo
								.getSelectedItem().toString()).build();

				sinifresult.setText(new insertData().insertData(contact));

				fullTableSelect.select();
				filtable(fullTableSelect.getlist());
			}
		});
	}

	private void filtable(ArrayList<contact> getlist) {
		// TODO Auto-generated method stub

		String dizim[][] = new String[getlist.size()][];
		for (int i = 0; i < getlist.size(); i++) {

			dizim[i] = new String[] { getlist.get(i).getName(),
					getlist.get(i).getGivebirth(), getlist.get(i).getCanfly(),
					getlist.get(i).getLivewater(),
					getlist.get(i).getHavelegs(), getlist.get(i).getClas() };
			TableModel tabloModel = new DefaultTableModel(dizim, new String[] {
					"Name", "Give birth", "Can fly", "Live in water",
					"Have legs", "Class" });

			table.setModel(tabloModel);

		}
	}

	private void additem() {
		// give birth
		gbcombo.addItem("yes");
		gbcombo.addItem("no");

		// can fly
		cfcombo.addItem("yes");
		cfcombo.addItem("no");

		// Live in water
		lwcombo.addItem("yes");
		lwcombo.addItem("no");
		lwcombo.addItem("sometimes");

		// have legs
		hlcombo.addItem("yes");
		hlcombo.addItem("no");

	}
}
