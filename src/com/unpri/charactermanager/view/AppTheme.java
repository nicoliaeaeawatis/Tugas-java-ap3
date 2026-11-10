
package com.unpri.charactermanager.view;

import java.awt.Color;
import java.awt.Font;

import com.unpri.charactermanager.model.CharacterType;

public final class AppTheme {

    // WARNA BACKGROUND
    public static final Color BG_MAIN =
        Color.decode("#155dee");

    public static final Color BG_HEADER =
        Color.WHITE;

    public static final Color BG_FOOTER =
        Color.decode("#E5EAF3");

    // WARNA TEKS
    public static final Color TEXT_MAIN =
        Color.decode("#172B4D");

    public static final Color TEXT_DARK =
        Color.decode("#172B4D");

    public static final Color TEXT_MUTED =
        Color.decode("#718096");

    public static final Color PRIMARY =
        Color.decode("#3867D6");

    public static final Color GOLD =
        Color.decode("#D99A00");

    public static final Color CARD_BORDER_COLOR =
        Color.decode("#D5DDEA");

    // WARNA ROLE
    public static final Color WARRIOR =
        Color.decode("#FFE0DC");

    public static final Color MAGE =
        Color.decode("#E0DCFF");

    public static final Color ARCHER =
        Color.decode("#DDF5E2");

    public static final Color ASSASSIN =
        Color.decode("#E1E6EF");

    // FONT - UKURAN LEBIH KECIL
    public static final Font FONT_HEADER =
        new Font("SansSerif", Font.BOLD, 23);

    public static final Font FONT_TITLE =
        new Font("SansSerif", Font.BOLD, 14);

    public static final Font FONT_CARD_TITLE =
        new Font("SansSerif", Font.BOLD, 16);

    public static final Font FONT_BODY =
        new Font("SansSerif", Font.PLAIN, 12);

    public static final Font FONT_GOLD =
        new Font("SansSerif", Font.BOLD, 13);

    public static final Font FONT_LEGEND =
        new Font("SansSerif", Font.BOLD, 15);

    public static final Font FONT_MONO =
        new Font("Monospaced", Font.PLAIN, 10);

    private AppTheme() {
    }

    // WARNA SESUAI ROLE
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
                return Color.LIGHT_GRAY;
        }
    }

    // KETERANGAN ROLE
    public static String describe(CharacterType type) {

        switch (type) {

            case WARRIOR:
                return "Warrior: jarak dekat, HP tinggi";

            case MAGE:
                return "Mage: serangan sihir";

            case ARCHER:
                return "Archer: serangan jarak jauh";

            case ASSASSIN:
                return "Assassin: serangan cepat";

            default:
                return "Role belum terdaftar";
        }
    }
}
