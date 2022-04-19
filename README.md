# CS 1501 – Data Structures and Algorithms 2 – Assignment #5

_(Assignment adapted from Dr. John Ramirez’s CS 1501 class.)_

Due: Monday May 2nd @ 11:59pm on Gradescope

_There is no late submission deadline for this assignment._

## Overview

The purpose of this programming assignment is to implement three primitive symmetric ciphers – an additive cipher, a substitution cipher, and a permutation cipher.

## SYMCIPHER, ADD128, SUBSTITUTE, AND PERMUTE

* `SymCipher`: This interface contains 3 methods: `getKey()`, `encode()` and `decode()`. See more information in the file `SymCipher.java`.
* `Add128`: This class must implement `SymCipher` and meet the following specifications:
  * It will have two constructors, one without any parameters and one that takes a `byte` array. The parameterless constructor will create a random 128-byte additive key and store it in an array of bytes. The other constructor will use the byte array parameter as its key.
  * To implement the `encode()` method, convert the `String` parameter to an array of bytes and simply add the corresponding byte of the key to each index in the array of bytes. If the message is shorter than the key, simply ignore the remaining bytes in the key. If the message is longer than the key, cycle through the key as many times as necessary. The encrypted array of bytes should be returned as a result of this method call.
  * To decrypt an array of bytes, simply subtract the corresponding byte of the key from each index of the array of bytes. If the message is shorter than the key, simply ignore the remaining bytes in the key. If the message is longer than the key, cycle through the key as many times as necessary. Convert the resulting byte array back to a String and return it.
  * Note that, due to wrapping and the fact that bytes are signed in Java, some or even many of your bytes will appear as negative numbers. This is normal.
* `Substitute`: This class must implement `SymCipher` and meet the following specifications:
  * It will have two constructors, one without any parameters and one that takes a `byte` array. The parameterless constructor will create a random 256-byte array which is a random permutation of the 256 possible byte values and will serve as a map from bytes to their substitution values. For example, if index 65 of the key array has the value 92, it means that byte value 65 will map into (i.e., gets substitued by) byte value 92. Note that you will also need an inverse mapping array for this cipher, which can be easily derived from the substitution array. Be careful with this class since byte values can be negative, but array indices cannot be negative – this issue can be resolved with some thought. The other constructor will use the byte array parameter as its key.
  * To implement the `encode()` method, convert the `String` parameter to an array of bytes, then iterate through all of the bytes, substituting the appropriate bytes from the key. Again, be careful with negative byte values.
  * To decode, simply reverse the substitution (using your decode byte array) and convert the resulting bytes back to a `String`.
* `Permute`: This class must implement `SymCipher` and meet the following specifications:
  * It will have two constructors, one without any parameters and one that takes a `byte` array. The parameterless constructor will create a random 256-byte array which is a random permutation of the 256 possible byte values and will serve as a map from locations in the plain text array to their destination location in the cipher text array. For example, if index 65 of the key array has the value 92, it means that the byte at location 65 in the plain text array will move into location 92 in the cipher text array. Note that you will also need an inverse mapping array for this cipher, which can be easily derived from the substitution array. Be careful with this class since byte values can be negative, but array indices cannot be negative – this issue can be resolved with some thought. The other constructor will use the byte array parameter as its key.
  * To implement the `encode()` method, convert the `String` parameter to an array of bytes, then iterate through all of the bytes, using the appropriate bytes from the key to determine the destination location in the cipher text array. Again, be careful with negative byte values. If the plain text array is smaller than 256 bytes or if its size is not a multiple of 256, the `encode()` method should return `null`.
  * To decode, simply reverse the permutation (using your decode byte array) and convert the resulting bytes back to a `String`. If the cipher text array is smaller than 256 bytes or if its size is not a multiple of 256, the `decode()` method should return `null`.

## SUBMISSION REQUIREMENTS
You must submit to Gradescope at least the following files:
1. `Substitute.java`, `Add128.java`, and `Permute.java`

The idea from your submission is that your TA (and the autograder if applicable) can compile and run your programs from the command line WITHOUT ANY additional files or changes, so be sure to test it thoroughly before submitting it. If the TA/autograder cannot compile or run your submitted code it will be graded as if the program does not work. 
Note: If you use an IDE such as NetBeans, Eclipse, or IntelliJ, to develop your programs, make sure they will compile and run on the command line before submitting – this may require some modifications to your program (such as removing some package information).

## RUBRICS

Item|Points
----|------|
`Add128` Class| 30
`Substitute` Class| 30
`Permute` Class| 30
Tests that use all ciphers| 10
