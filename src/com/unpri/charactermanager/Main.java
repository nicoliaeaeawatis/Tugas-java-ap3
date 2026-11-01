package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            // Membuat Character Manager
            CharacterManager manager =
                    new CharacterManager();

            // Menambahkan karakter awal
            manager.addCharacter(
                    new Character(
                            "Arthas",
                            CharacterType.WARRIOR
                    )
            );

            manager.addCharacter(
                    new Character(
                            "Merlin",
                            CharacterType.MAGE
                    )
            );

            manager.addCharacter(
                    new Character(
                            "Shadow",
                            CharacterType.ASSASSIN
                    )
            );

            manager.addCharacter(
                    new Character(
                            "Legolas",
                            CharacterType.ARCHER
                    )
            );

            // Membuka tampilan utama
            MainWindow window =
                    new MainWindow(manager);

            window.setVisible(true);

        });
    }
}
