
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            CharacterManager manager = new CharacterManager();

            // 8 karakter dengan role dan level berbeda

            manager.addCharacter(
                    new Character("Arthas",
                            CharacterType.WARRIOR, 5, 150, 60));

            manager.addCharacter(
                    new Character("Merlin",
                            CharacterType.MAGE, 3, 120, 70));

            manager.addCharacter(
                    new Character("Shadow",
                            CharacterType.ASSASSIN, 6, 100, 85));

            manager.addCharacter(
                    new Character("Legolas",
                            CharacterType.ARCHER, 4, 130, 65));

            manager.addCharacter(
                    new Character("Gatotkaca",
                            CharacterType.WARRIOR, 8, 200, 90));

            manager.addCharacter(
                    new Character("Morgana",
                            CharacterType.MAGE, 7, 140, 80));

            manager.addCharacter(
                    new Character("Robin",
                            CharacterType.ARCHER, 2, 110, 45));

            manager.addCharacter(
                    new Character("Raven",
                            CharacterType.ASSASSIN, 1, 100, 50));

            // Mengirim data karakter ke MainWindow

            MainWindow window = new MainWindow(
                    manager.getAllCharacters()
            );

            window.setVisible(true);

        });
    }
}
