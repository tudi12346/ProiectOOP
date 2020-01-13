package com.accommodation.frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import com.accommodation.service.CaminService;

public class ManagementWindow {

	private JFrame managementWindowFrame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void launch() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagementWindow window = new ManagementWindow();
					window.managementWindowFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManagementWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		managementWindowFrame = new JFrame();
		managementWindowFrame.setTitle("Management");
		managementWindowFrame.setBounds(100, 100, 650, 400);
		managementWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		managementWindowFrame.getContentPane().setLayout(null);

		CaminService serv = new CaminService();

		table = new JTable(serv.caminToTableModel(serv.findAll()));
		table.setBounds(290, 120, 340, 230);
		managementWindowFrame.getContentPane().add(table);

	}
}
