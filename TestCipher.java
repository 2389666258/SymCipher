package SymCipher;

import java.util.Arrays;

public class TestCipher {
    public static void main(String[] args) {

        String plaintext;
        byte[] plaintextBytes;
        byte[] key;
        byte[] ciphertextBytes;
        String ciphertext;


            /* ----- Test Add128 ----- */

        Add128 a = new Add128();

        plaintext = "Hello World! 2,3;8^9";              // String
        plaintextBytes = plaintext.getBytes();  // byte[]
        key = a.getKey();                       // byte[]
        ciphertextBytes = a.encode(plaintext);  // byte[]
        ciphertext = a.decode(ciphertextBytes); // String

        System.out.println("\n\n------------- Test Add128 -------------\n");
        System.out.println("Plaintext:         " + plaintext);
        System.out.println("Plaintext Bytes:   " + Arrays.toString(plaintextBytes));
        System.out.println("Key:               " + Arrays.toString(key));
        System.out.println("Ciphertext Bytes:  " + Arrays.toString(ciphertextBytes));
        System.out.println("Ciphertext:        " + ciphertext);


            /* ----- Test Substitute ----- */

        Substitute b = new Substitute();

        plaintextBytes = plaintext.getBytes();  // byte[]
        key = b.getKey();                       // byte[]
        ciphertextBytes = b.encode(plaintext);  // byte[]
        ciphertext = b.decode(ciphertextBytes); // String

        System.out.println("\n\n------------- Test Substitute -------------\n");
        System.out.println("Plaintext:         " + plaintext);
        System.out.println("Plaintext Bytes:   " + Arrays.toString(plaintextBytes));
        System.out.println("Key:               " + Arrays.toString(key));
        System.out.println("Ciphertext Bytes:  " + Arrays.toString(ciphertextBytes));
        System.out.println("Ciphertext:        " + ciphertext);


            /* ----- Test Permute ----- */

        plaintext = "sakdhkashfkhasjkfhaskhfashfjkhaskfhaskjhdkjashdhkasjdkhksajhdkajshdkjhaskjdhaskjhdsakdhkashfkhasjkfhaskhfashfjkhaskfhaskjhdkjashdhkasjdkhksajhdkajshdkjhaskjdhaskjhdkasjdhkasakdhkashfkhasjkfhaskhfashfjkhaskfhaskjhdkjashdhkasjdkhksajhdkajshdkjhaskjdhaskjhdka";

        Permute c = new Permute();

        plaintextBytes = plaintext.getBytes();  // byte[]
        key = c.getKey();                       // byte[]
        ciphertextBytes = c.encode(plaintext);  // byte[]
        ciphertext = c.decode(ciphertextBytes); // String

        System.out.println("\n\n------------- Test Permute -------------\n");
        System.out.println("Plaintext:         " + plaintext);
        System.out.println("Plaintext Bytes:   " + Arrays.toString(plaintextBytes));
        System.out.println("Key:               " + Arrays.toString(key));
        System.out.println("Ciphertext Bytes:  " + Arrays.toString(ciphertextBytes));
        System.out.println("Ciphertext:        " + ciphertext);

    }
}
