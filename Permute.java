package SymCipher;

import java.util.HashMap;

public class Permute implements SymCipher {

    private final byte[] key;
    private final HashMap<Byte, Byte> permutation = new HashMap<>();
    private final HashMap<Byte, Byte> reversePermutation = new HashMap<>();

    public Permute(byte[] key) {
        this.key = key;
        this.generatePermutation();
    }

    public Permute() {
        this.key = new byte[256];
        for (int i = 0; i < this.key.length; i++) {
            this.key[i] = (byte) i;
        }

        for (int i = 0; i < this.key.length; i++) {
            int j = (int) (Math.random() * this.key.length);
            byte temp = this.key[i];
            this.key[i] = this.key[j];
            this.key[j] = temp;
        }

        this.generatePermutation();
    }

    private void generatePermutation() {
        for (int i = 0; i < this.key.length; i++) {
            this.permutation.put((byte) i, this.key[i]);
            this.reversePermutation.put(this.key[i], (byte) i);
        }
    }

    @Override
    public byte[] getKey() {
        return key;
    }

    @Override
    public byte[] encode(String S) {
        if (S.length() % 256 != 0 || S.length() == 0) {
            return null;
        }

        byte[] data = S.getBytes();

        byte[] encrypted = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            encrypted[i] = this.permutation.get(data[i]);
        }
        return encrypted;
    }

    @Override
    public String decode(byte[] data) {
        if (data.length % 256 != 0 || data.length == 0) {
            return null;
        }

        byte[] decrypted = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            decrypted[i] = this.reversePermutation.get(data[i]);
        }

        return new String(decrypted);
    }

}