package SymCipher;

public class Add128 implements SymCipher {

    private final byte[] key;

    public Add128() {
        // random key
        key = new byte[128];
        for (int i = 0; i < key.length; i++) {
            key[i] = (byte) (Math.random() * 256);
        }
    }

    public Add128(byte[] key) {
        this.key = key;
    }

    @Override
    public byte[] getKey() {
        return key;
    }

    @Override
    public byte[] encode(String S) {
        // convert the String to an array of bytes
        byte[] plaintext = S.getBytes();

        byte[] ciphertext = new byte[plaintext.length];
        for (int i = 0; i < plaintext.length; i++) {
            ciphertext[i] = (byte) (plaintext[i] + key[i % key.length]);
        }
        return ciphertext;
    }

    @Override
    public String decode(byte[] ciphertext) {
        byte[] plaintext = new byte[ciphertext.length];
        for (int i = 0; i < ciphertext.length; i++) {
            plaintext[i] = (byte) (ciphertext[i] - key[i % key.length]);
        }

        // convert the byte array to a String
        return new String(plaintext);
    }

}
