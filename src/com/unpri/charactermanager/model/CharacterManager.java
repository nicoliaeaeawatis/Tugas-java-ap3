package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {

    private final ArrayList<Character> characters = new ArrayList<>();

    /**
     * Menambahkan karakter jika namanya belum terdaftar.
     *
     * @param character karakter yang akan ditambahkan
     * @return true jika berhasil ditambahkan, false jika duplikat
     */
    public boolean addCharacter(Character character) {
        if (character == null) {
            return false;
        }

        if (findByName(character.getName()) != null) {
            System.out.println("Karakter " + character.getName()
                    + " ditolak karena nama sudah ada.");
            return false;
        }

        characters.add(character);
        System.out.println("Karakter " + character.getName()
                + " berhasil ditambahkan.");
        return true;
    }

    /**
     * Mencari karakter berdasarkan nama tanpa membedakan huruf besar/kecil.
     *
     * @param name nama karakter yang dicari
     * @return karakter yang ditemukan, atau null jika tidak ada
     */
    public Character findByName(String name) {
        if (name == null) {
            return null;
        }

        for (Character character : characters) {
            if (character.getName() != null
                    && character.getName().equalsIgnoreCase(name)) {
                return character;
            }
        }

        return null;
    }

    /**
     * Menghapus karakter berdasarkan nama.
     *
     * @param name nama karakter yang akan dihapus
     * @return true jika berhasil dihapus, false jika tidak ditemukan
     */
    public boolean removeCharacter(String name) {
        Character character = findByName(name);

        if (character == null) {
            return false;
        }

        characters.remove(character);
        return true;
    }

    /**
     * Mengembalikan jumlah karakter yang tersimpan.
     *
     * @return jumlah karakter
     */
    public int getTotalCharacters() {
        return characters.size();
    }

    /**
     * Mengembalikan salinan daftar karakter, bukan daftar internal.
     *
     * @return salinan daftar karakter
     */
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    /**
     * Menghitung rata-rata level semua karakter.
     *
     * @return rata-rata level, atau 0.0 jika daftar kosong
     */
    public double getAverageLevel() {
        if (characters.isEmpty()) {
            return 0.0;
        }

        int totalLevel = 0;

        for (Character character : characters) {
            totalLevel += character.getLevel();
        }

        return (double) totalLevel / characters.size();
    }

    /**
     * Mencari semua karakter berdasarkan tipe.
     *
     * @param type tipe karakter yang dicari
     * @return daftar baru berisi karakter dengan tipe yang sesuai
     */
    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();

        if (type == null) {
            return result;
        }

        for (Character character : characters) {
            if (character.getType() == type) {
                result.add(character);
            }
        }

        return result;
    }

    /**
     * Mencari karakter dengan nilai attack tertinggi.
     *
     * @return karakter terkuat berdasarkan attack, atau null jika kosong
     */
    public Character findStrongest() {
        if (characters.isEmpty()) {
            return null;
        }

        Character strongest = characters.get(0);

        for (Character character : characters) {
            if (character.getAttack() > strongest.getAttack()) {
                strongest = character;
            }
        }

        return strongest;
    }
}