import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        Character hero1 = new Character("Arthur", CharacterType.WARRIOR);
        Character hero2 = new Character(
                "Merlin", CharacterType.MAGE, 2, 120, 60
        );
        Character hero3 = new Character("Robin", CharacterType.ARCHER);

        System.out.println("=== CHARACTER MANAGER ===");
        System.out.println(hero1);
        System.out.println(hero2);
        System.out.println(hero3);

        System.out.println("\n=== DEMO LEVEL UP ===");
        System.out.println("Level Arthur sebelum: " + hero1.getLevel());

        hero1.setLevel(2);

        System.out.println("Level Arthur sesudah: " + hero1.getLevel());
        System.out.println("HP Arthur: " + hero1.getHitPoints());
        System.out.println("Attack Arthur: " + hero1.getAttack());

        System.out.println("\n=== MINI-CHALLENGE ===");

        Character necro = new Character(
                "Necro", CharacterType.ASSASSIN, 3, 0, 25
        );

        necro.setMana(50);

        System.out.println(necro);
        System.out.println("Necro masih hidup? " + necro.isAlive());

        System.out.println("\n=== DEMO VALIDASI MANA ===");

        try {
            necro.setMana(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Validasi berhasil: " + e.getMessage());
        }
    }
}