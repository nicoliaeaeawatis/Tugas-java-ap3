
package com.unpri.charactermanager.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class MainWindow extends JFrame {

    private static final int GOLD_LEVEL_LIMIT = 5;

    private final ArrayList<Character> characterList;

    public MainWindow(ArrayList<Character> characterList) {

        super("Character Manager v0.5");

        this.characterList = characterList;

        initComponents();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 550);
        setMinimumSize(new Dimension(700, 450));
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        setLayout(new BorderLayout());

        // Bagian atas
        add(createHeader(), BorderLayout.NORTH);

        // Bagian tengah
        JPanel content = new JPanel(new BorderLayout(16, 0));
        content.setBackground(AppTheme.BG_MAIN);
        content.setBorder(BorderFactory.createEmptyBorder(16, 20, 16, 20));

        content.add(createCharacterList(), BorderLayout.CENTER);
        content.add(createRoleLegend(), BorderLayout.EAST);

        add(content, BorderLayout.CENTER);

        // Bagian bawah
        add(createFooter(), BorderLayout.SOUTH);
    }

    // HEADER
    private JPanel createHeader() {

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(AppTheme.BG_HEADER);
        header.setBorder(
            BorderFactory.createEmptyBorder(22, 26, 18, 26)
        );

        JPanel left = new JPanel();
        left.setOpaque(false);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("CHARACTER MANAGER");
        title.setFont(AppTheme.FONT_HEADER);
        title.setForeground(AppTheme.PRIMARY);

        JLabel subtitle = new JLabel(
            "Manage your characters and levels"
        );
        subtitle.setFont(AppTheme.FONT_BODY);
        subtitle.setForeground(AppTheme.TEXT_MAIN);

        left.add(title);
        left.add(Box.createVerticalStrut(8));
        left.add(subtitle);

        JPanel stats = new JPanel(new BorderLayout());
        stats.setOpaque(false);
        stats.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        Set<CharacterType> roles = new HashSet<>();

        double totalLevel = 0;

        for (Character c : characterList) {
            roles.add(c.getType());
            totalLevel += c.getLevel();
        }

        double average = characterList.isEmpty()
                ? 0
                : totalLevel / characterList.size();

        JLabel leftStats = new JLabel(
            "<html>Total Characters: " + characterList.size()
            + "<br><br>Total Roles: " + roles.size()
            + "</html>"
        );

        JLabel rightStats = new JLabel(
            "<html>Average Level: "
            + String.format(Locale.forLanguageTag("id-ID"), "%.2f", average)
            + "<br><br>Version: v0.5"
            + "</html>"
        );

        leftStats.setFont(AppTheme.FONT_BODY);
        rightStats.setFont(AppTheme.FONT_BODY);

        leftStats.setForeground(AppTheme.TEXT_MAIN);
        rightStats.setForeground(AppTheme.TEXT_MAIN);

        stats.add(leftStats, BorderLayout.WEST);
        stats.add(rightStats, BorderLayout.CENTER);

        JPanel headerContent = new JPanel(new BorderLayout());
        headerContent.setOpaque(false);

        headerContent.add(left, BorderLayout.NORTH);
        headerContent.add(stats, BorderLayout.SOUTH);

        header.add(headerContent, BorderLayout.CENTER);

        return header;
    }

    // DAFTAR KARAKTER
    private JScrollPane createCharacterList() {

        JPanel listPanel = new JPanel();
        listPanel.setLayout(
            new BoxLayout(listPanel, BoxLayout.Y_AXIS)
        );

        listPanel.setBackground(AppTheme.BG_MAIN);

        for (Character c : characterList) {

            listPanel.add(createCharacterCard(c));
            listPanel.add(Box.createVerticalStrut(10));
        }

        JScrollPane scrollPane = new JScrollPane(listPanel);

        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(AppTheme.BG_MAIN);

        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        return scrollPane;
    }

    // KARTU KARAKTER
    private JPanel createCharacterCard(Character c) {

        JPanel card = new JPanel(new BorderLayout(0, 12));

        card.setBackground(AppTheme.colorFor(c.getType()));
        card.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(AppTheme.CARD_BORDER_COLOR),
                BorderFactory.createEmptyBorder(20, 24, 20, 24)
            )
        );

        JLabel name = new JLabel(c.getName());
        name.setFont(AppTheme.FONT_CARD_TITLE);
        name.setForeground(AppTheme.PRIMARY);

        JLabel role = new JLabel("Role: " + c.getType());
        role.setFont(AppTheme.FONT_BODY);
        role.setForeground(AppTheme.TEXT_DARK);

        JLabel details = new JLabel(
            "Level: " + c.getLevel()
            + " | HP: " + c.getHitPoints()
            + " | Attack: " + c.getAttack()
            + " | Mana: " + c.getMana()
        );

        details.setFont(AppTheme.FONT_BODY);

        if (c.getLevel() >= GOLD_LEVEL_LIMIT) {
            details.setForeground(AppTheme.GOLD);
            details.setFont(AppTheme.FONT_GOLD);
        } else {
            details.setForeground(AppTheme.TEXT_DARK);
        }

        JPanel information = new JPanel();
        information.setOpaque(false);
        information.setLayout(
            new BoxLayout(information, BoxLayout.Y_AXIS)
        );

        information.add(name);
        information.add(Box.createVerticalStrut(12));
        information.add(role);
        information.add(Box.createVerticalStrut(12));
        information.add(details);

        card.add(information, BorderLayout.CENTER);

        card.setMaximumSize(
            new Dimension(Integer.MAX_VALUE, 160)
        );

        return card;
    }

    // ROLE LEGEND
    private JPanel createRoleLegend() {

        JPanel legend = new JPanel();
        legend.setLayout(new BoxLayout(legend, BoxLayout.Y_AXIS));

        legend.setBackground(AppTheme.BG_HEADER);
        legend.setBorder(
            BorderFactory.createEmptyBorder(20, 16, 20, 16)
        );

        legend.setPreferredSize(new Dimension(200, 0));

        JLabel title = new JLabel("ROLE LEGEND");
        title.setFont(AppTheme.FONT_LEGEND);
        title.setForeground(AppTheme.PRIMARY);

        legend.add(title);
        legend.add(Box.createVerticalStrut(20));

        addLegendItem(legend, "WARRIOR", CharacterType.WARRIOR);
        addLegendItem(legend, "MAGE", CharacterType.MAGE);
        addLegendItem(legend, "ARCHER", CharacterType.ARCHER);
        addLegendItem(legend, "ASSASSIN", CharacterType.ASSASSIN);

        return legend;
    }

    private void addLegendItem(
        JPanel panel, String text, CharacterType type
    ) {

        JLabel item = new JLabel(text);

        item.setFont(AppTheme.FONT_BODY);
        item.setForeground(AppTheme.TEXT_DARK);
        item.setOpaque(true);
        item.setBackground(AppTheme.colorFor(type));

        item.setBorder(
            BorderFactory.createEmptyBorder(12, 12, 12, 12)
        );

        item.setMaximumSize(
            new Dimension(Integer.MAX_VALUE, 48)
        );

        item.setAlignmentX(LEFT_ALIGNMENT);

        panel.add(item);
        panel.add(Box.createVerticalStrut(10));
    }

    // FOOTER
    private JPanel createFooter() {

        JPanel footer = new JPanel(new BorderLayout());

        footer.setBackground(AppTheme.BG_FOOTER);
        footer.setBorder(
            BorderFactory.createEmptyBorder(10, 24, 10, 24)
        );

        JLabel status = new JLabel("● Ready");
        status.setFont(AppTheme.FONT_BODY);
        status.setForeground(AppTheme.TEXT_MUTED);

        JLabel version = new JLabel("Character Manager v0.5");
        version.setFont(AppTheme.FONT_MONO);
        version.setForeground(AppTheme.TEXT_MUTED);

        footer.add(status, BorderLayout.WEST);
        footer.add(version, BorderLayout.EAST);

        return footer;
    }
}
