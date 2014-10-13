OPrime_Cipher
=============

Version of Caesar cipher that uses the sum of circular primes below the given key to encrypt the given message.

=============

Java program that simulates a circular primes encryption device.

Unlike a regular Caesar cipher, this version uses the key as its circular prime upper limit.

This limit is then used to calculate the sum of positive circular primes below it.

The calculated sum is then used as the shift number to encrypt the message.

=============

This a safer version of the Caesar cipher, since it offers two layers of security:

Either the key or the method can be made public without revealing the message.

=============

Based on problem 35 on projecteuler.net, and the Caesar Cipher.

https://projecteuler.net/problem=35

https://en.wikipedia.org/wiki/Caesar_cipher

https://github.com/PlainIntricacy/Circular_Primes

=============

For the decryption version, use the decrypt branch:

https://github.com/PlainIntricacy/OPrime_Cipher/tree/decrypt
