package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainWindow extends JFrame {

    private final CharacterManager manager;
    private final JPanel characterPanel;
    private final JLabel averageLevelLabel;
    private final JButton kurangButton;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        setTitle("Character Manager - TP8");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));

        JLabel titleLabel = new JLabel(
                "DAFTAR KARAKTER",
                SwingConstants.CENTER
        );

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBorder(
                BorderFactory.createEmptyBorder(15, 10, 10, 10)
        );

        add(titleLabel, BorderLayout.NORTH);

        characterPanel = new JPanel();
        characterPanel.setLayout(
                new BoxLayout(characterPanel, BoxLayout.Y_AXIS)
        );

        JScrollPane scrollPane = new JScrollPane(characterPanel);
        add(scrollPane, BorderLayout.CENTER);

        averageLevelLabel = new JLabel("", SwingConstants.CENTER);
        averageLevelLabel.setFont(
                new Font("Arial", Font.BOLD, 15)
        );

        averageLevelLabel.setBorder(
                BorderFactory.createEmptyBorder(12, 10, 15, 10)
        );

        kurangButton = new JButton("Kurangi Level");

        kurangButton.addActionListener(e -> {
            ArrayList<Character> characters =
                    manager.getAllCharacters();

            if (!characters.isEmpty()) {
                Character character = characters.get(0);

                if (character.getLevel() > 1) {
                    character.setLevel(
                            character.getLevel() - 1
                    );

                    displayCharacters();

                    JOptionPane.showMessageDialog(
                            this,
                            "Level karakter berhasil dikurangi!"
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "Level karakter sudah minimum!"
                    );
                }

            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Belum ada karakter!"
                );
            }
        });

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(averageLevelLabel, BorderLayout.CENTER);
        bottomPanel.add(kurangButton, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        displayCharacters();

        setVisible(true);
    }

    private void displayCharacters() {
        characterPanel.removeAll();

        ArrayList<Character> characters =
                manager.getAllCharacters();

        for (Character character : characters) {

            JLabel characterLabel = new JLabel(
                    character.getName()
                    + " | Tipe: " + character.getType()
                    + " | Level: " + character.getLevel()
            );

            characterLabel.setFont(
                    new Font("Arial", Font.PLAIN, 14)
            );

            characterLabel.setBorder(
                    BorderFactory.createEmptyBorder(8, 15, 8, 15)
            );

            characterPanel.add(characterLabel);
        }

        double averageLevel = manager.getAverageLevel();

        averageLevelLabel.setText(
                String.format(
                        "Rata-rata Level: %.2f",
                        averageLevel
                )
        );

        characterPanel.revalidate();
        characterPanel.repaint();
    }
}
