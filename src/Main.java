import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Text Search");
            JTextField searchField = new JTextField(20);
            JButton countButton = new JButton("Count");
            JButton clearButton = new JButton("Clear");
            JLabel resultLabel = new JLabel("Enter a word or phrase");

            JPanel panel = new JPanel();
            panel.add(searchField);
            panel.add(countButton);
            panel.add(resultLabel);
            panel.add(clearButton);

            countButton.addActionListener(e -> {
                String search = searchField.getText();

                if (search.isEmpty()) {
                    resultLabel.setText("Enter a word or phrase");
                    return;
                }

                try {
                    String text = Files.readString(
                            Paths.get("D:\\WarAndPeace\\WarAndPeace.txt"));

                    int count = 0;
                    int position = 0;

                    while ((position = text.indexOf(search, position)) != -1) {
                        count++;
                        position += search.length();
                    }

                    resultLabel.setText("Matches: " + count);
                } catch (IOException ex) {
                    resultLabel.setText("Could not read file: " + ex.getMessage());
                }
            });

            clearButton.addActionListener(e -> {
                searchField.setText("");
                resultLabel.setText("Enter a word or phrase");
                searchField.requestFocusInWindow();
            });

            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
