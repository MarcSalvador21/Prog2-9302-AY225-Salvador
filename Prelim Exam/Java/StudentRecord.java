/*
 Programmer: Marc Timothy Salvador - 23-0191-615
 Student Record System (Java Swing CRUD)
*/

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

public class StudentRecord extends JFrame {

    DefaultTableModel model;
    JTable table;
    JTextField idField, nameField, gradeField;

    public StudentRecord() {
        // REQUIRED IDENTIFIER IN TITLE
        this.setTitle("Records - Marc Timothy Salvador 23-0191-615");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        model = new DefaultTableModel(new String[]{"ID", "Name", "Grade"}, 0);
        table = new JTable(model);

        loadCSV();

        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(2, 4));

        idField = new JTextField();
        nameField = new JTextField();
        gradeField = new JTextField();

        JButton addBtn = new JButton("Add");
        JButton deleteBtn = new JButton("Delete");

        inputPanel.add(new JLabel("ID"));
        inputPanel.add(new JLabel("Name"));
        inputPanel.add(new JLabel("Grade"));
        inputPanel.add(new JLabel(""));

        inputPanel.add(idField);
        inputPanel.add(nameField);
        inputPanel.add(gradeField);
        inputPanel.add(addBtn);

        this.add(inputPanel, BorderLayout.NORTH);
        this.add(deleteBtn, BorderLayout.SOUTH);

        // CREATE
        addBtn.addActionListener(e -> {
            model.addRow(new String[]{
                idField.getText(),
                nameField.getText(),
                gradeField.getText()
            });
            idField.setText("");
            nameField.setText("");
            gradeField.setText("");
        });

        // DELETE
        deleteBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                model.removeRow(row);
            }
        });

        this.setVisible(true);
    }

    // READ CSV
    private void loadCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader("MOCK_DATA.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                model.addRow(data);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading CSV file.");
        }
    }

    public static void main(String[] args) {
        new StudentRecord();
    }
}
