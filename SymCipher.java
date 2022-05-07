package SymCipher;

/**  Interface for symmetric ciphers to be used with Assignment 5.
 * This must be implemented by your Add128, Substitute, and Permute classes.
 * Adapted from Dr. John Ramirez's CS 1501 Assignment 4
 */
public interface SymCipher
{
	// Return an array of bytes that represent the key for the cipher
	public byte [] getKey();

	// Encode the string using the key and return the result as an array of
	// bytes.  Note that you will need to convert the String to an array of bytes
	// prior to encrypting it.  Also note that String S could have an arbitrary
	// length, so your cipher may have to "wrap" when encrypting or return
	// null if the size is not correct.
	public byte [] encode(String S);

	// Decrypt the array of bytes and generate and return the corresponding String.
	// Also note that the bytes array could have an arbitrary
	// length, so your cipher may have to "wrap" when decrypting or return
	// null if the size is not correct.
	public String decode(byte [] bytes);
}
