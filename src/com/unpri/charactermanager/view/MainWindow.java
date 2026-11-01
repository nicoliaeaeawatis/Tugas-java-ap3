
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainWindow extends JFrame {

    // Batas level untuk teks emas
    private static final int GOLD_LEVEL_LIMIT = 5;

    private final CharacterManager manager;
    private JPanel characterPanel;
    private JLabel totalLabel;
    private JLabel averageLabel;

    public MainWindow(CharacterManager manager) {

        this.manager = manager;

        setTitle("Character Manager v0.4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout(15, 15));
        getContentPane().setBackground(AppTheme.BACKGROUND);

        // Header
        JLabel title = new JLabel("CHARACTER MANAGER");
        title.setFont(AppTheme.TITLE_FONT);
        title.setForeground(AppTheme.PRIMARY);

        JLabel subtitle = new JLabel(
                "Manage your characters and levels"
        );
        subtitle.setFont(AppTheme.NORMAL_FONT);
        subtitle.setForeground(AppTheme.TEXT);

        JPanel header = new JPanel(new GridLayout(2, 1, 5, 5));
        header.setBackground(AppTheme.CARD);
        header.setBorder(
                BorderFactory.createEmptyBorder(20, 25, 20, 25)
        );

        header.add(title);
        header.add(subtitle);

        add(header, BorderLayout.NORTH);

        // Daftar karakter
        characterPanel = new JPanel();
        characterPanel.setLayout(
                new BoxLayout(characterPanel, BoxLayout.Y_AXIS)
        );
        characterPanel.setBackground(AppTheme.BACKGROUND);
        characterPanel.setBorder(
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        );

        JScrollPane scrollPane = new JScrollPane(characterPanel);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(AppTheme.BACKGROUND);

        add(scrollPane, BorderLayout.CENTER);

        // Footer
        totalLabel = new JLabel();
        averageLabel = new JLabel();

        totalLabel.setFont(AppTheme.NORMAL_FONT);
        averageLabel.setFont(AppTheme.NORMAL_FONT);

        totalLabel.setForeground(AppTheme.TEXT);
        averageLabel.setForeground(AppTheme.TEXT);

        JPanel footer = new JPanel(new GridLayout(1, 2));
        footer.setBackground(AppTheme.CARD);
        footer.setBorder(
                BorderFactory.createEmptyBorder(15, 25, 15, 25)
        );

        footer.add(totalLabel);
        footer.add(averageLabel);

        add(footer, BorderLayout.SOUTH);

        refreshCharacters();

        pack();
        setMinimumSize(new Dimension(750, 550));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void refreshCharacters() {

        characterPanel.removeAll();

        ArrayList<Character> characters =
                manager.getAllCharacters();

        for (Character character : characters) {

            JPanel card = createCharacterCard(character);

            characterPanel.add(card);
            characterPanel.add(Box.createVerticalStrut(12));
        }

        totalLabel.setText(
                "Total Characters: " + manager.getTotalCharacters()
        );

        averageLabel.setText(
                String.format(
                        "Average Level: %.2f",
                        manager.getAverageLevel()
                )
        );

        characterPanel.revalidate();
        characterPanel.repaint();
    }

    private JPanel createCharacterCard(Character character) {

        JPanel card = new JPanel(new BorderLayout(15, 10));

        card.setBackground(AppTheme.colorFor(character.getType()));
        card.setBorder(AppTheme.CARD_BORDER);
        card.setOpaque(true);

        // Informasi karakter
        JPanel information = new JPanel();
        information.setLayout(
                new BoxLayout(information, BoxLayout.Y_AXIS)
        );

        information.setOpaque(false);

        JLabel nameLabel = new JLabel(character.getName());
        nameLabel.setFont(AppTheme.NAME_FONT);
        nameLabel.setForeground(AppTheme.PRIMARY);

        JLabel typeLabel = new JLabel(
                "Role: " + character.getType()
        );
        typeLabel.setFont(AppTheme.NORMAL_FONT);
        typeLabel.setForeground(AppTheme.TEXT);

        JLabel levelLabel = new JLabel(
                "Level: " + character.getLevel()
                + " | HP: " + character.getHitPoints()
                + " | Attack: " + character.getAttack()
                + " | Mana: " + character.getMana()
        );

        // Mini-challenge: level 5 ke atas berwarna emas
        if (character.getLevel() >= GOLD_LEVEL_LIMIT) {
            levelLabel.setForeground(AppTheme.GOLD);
            levelLabel.setFont(AppTheme.GOLD_FONT);
        } else {
            levelLabel.setForeground(AppTheme.TEXT);
            levelLabel.setFont(AppTheme.NORMAL_FONT);
        }

        information.add(nameLabel);
        information.add(Box.createVerticalStrut(8));
        information.add(typeLabel);
        information.add(Box.createVerticalStrut(8));
        information.add(levelLabel);

        // Properti tambahan 1: Tooltip HP dan Attack
        card.setToolTipText(
                "Character: " + character.getName()
                + " | HP: " + character.getHitPoints()
                + " | Attack: " + character.getAttack()
                + " | Mana: " + character.getMana()
        );

        // Properti tambahan 2: Level 1 dinonaktifkan
        if (character.getLevel() == 1) {
            card.setEnabled(false);
            nameLabel.setForeground(Color.GRAY);
        }

        card.add(information, BorderLayout.CENTER);

        return card;
    }
}
