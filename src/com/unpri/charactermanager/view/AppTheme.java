
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterType;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class AppTheme {

    // Warna utama aplikasi
    public static final Color PRIMARY = new Color(55, 100, 220);
    public static final Color BACKGROUND = new Color(240, 244, 250);
    public static final Color CARD = Color.WHITE;
    public static final Color TEXT = new Color(35, 45, 65);
    public static final Color GOLD = new Color(218, 165, 32);

    // Warna berdasarkan role
    public static final Color WARRIOR = new Color(255, 225, 220);
    public static final Color MAGE = new Color(225, 220, 255);
    public static final Color ARCHER = new Color(220, 245, 225);
    public static final Color ASSASSIN = new Color(225, 230, 240);

    // Font aplikasi
    public static final Font TITLE_FONT =
            new Font("SansSerif", Font.BOLD, 28);

    public static final Font NAME_FONT =
            new Font("SansSerif", Font.BOLD, 19);

    public static final Font NORMAL_FONT =
            new Font("SansSerif", Font.PLAIN, 15);

    public static final Font GOLD_FONT =
            new Font("SansSerif", Font.BOLD, 17);

    // Border kartu
    public static final Border CARD_BORDER =
            BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(
                            new Color(210, 220, 235), 1),
                    BorderFactory.createEmptyBorder(15, 18, 15, 18)
            );

    // Mengambil warna berdasarkan role
    public static Color colorFor(CharacterType type) {

        switch (type) {
            case WARRIOR:
                return WARRIOR;

            case MAGE:
                return MAGE;

            case ARCHER:
                return ARCHER;

            case ASSASSIN:
                return ASSASSIN;

            default:
                return CARD;
        }
    }

    private AppTheme() {
        // Mencegah pembuatan objek AppTheme
    }
}
