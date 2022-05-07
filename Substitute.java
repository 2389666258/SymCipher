package SymCipher;

import java.util.HashMap;

public class Substitute implements SymCipher {

    private final byte[] key;
    private final HashMap<Byte, Byte> substitution = new HashMap<>();
    private final HashMap<Byte, Byte> reverseSubstitution = new HashMap<>();

    public Substitute(byte[] key) {
        this.key = key;
        this.generateSubstitution();
    }

    public Substitute() {
        this.key = new byte[256];
        for (int i = 0; i < this.key.length; i++) {
            this.key[i] = (byte) i;
        }

        // randomize the key
        for (int i = 0; i < this.key.length; i++) {
            int j = (int) (Math.random() * this.key.length);
            byte temp = this.key[i];
            this.key[i] = this.key[j];
            this.key[j] = temp;
        }

        this.generateSubstitution();
    }

    private void generateSubstitution() {
        for (int i = 0; i < this.key.length; i++) {
            this.substitution.put((byte) i, this.key[i]);
            this.reverseSubstitution.put(this.key[i], (byte) i);
        }
    }

    @Override
    public byte[] getKey() {
        return key;
    }

    @Override
    public byte[] encode(String S) {
        // convert the String to an array of bytes
        byte[] data = S.getBytes();

        byte[] encrypted = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            encrypted[i] = this.substitution.get(data[i]);
        }
        return encrypted;
    }

    @Override
    public String decode(byte[] data) {
        byte[] decrypted = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            decrypted[i] = this.reverseSubstitution.get(data[i]);
        }

        // convert the byte array to a String
        return new String(decrypted);
    }

}
