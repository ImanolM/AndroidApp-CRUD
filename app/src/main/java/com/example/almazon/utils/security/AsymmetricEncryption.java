/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.almazon.utils.security;

import com.example.almazon.utils.security.KeyGenerator;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Mikel
 */
public class AsymmetricEncryption {
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    private String publicKey;

    public AsymmetricEncryption(String publicKeyAsString) {
        this.publicKey = publicKeyAsString;
    }

    /**
     * Encrypts a String using the public key.
     *
     * @param text
     * @return The text encrypted.
     */
    public String encryptString(String text) {
        try {
            byte[] cipherText
                    = KeyGenerator.do_RSAEncryption(
                    text,
                    this.getPublicKey());
            //String stringBytes = Base64.getEncoder().encodeToString(cipherText);
            String stringBytes = toHexString(cipherText);
            return stringBytes;
        } catch (Exception ex) {
            Logger.getLogger(AsymmetricEncryption.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Gets the public key used to encrypt.
     *
     * @return the PublicKey.
     */
    private PublicKey getPublicKey() {
        try {
            byte[] keyBytes = toByteArray(this.getPublicKeyAsString());

            X509EncodedKeySpec spec
                    = new X509EncodedKeySpec(keyBytes);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            return kf.generatePublic(spec);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(AsymmetricEncryption.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AsymmetricEncryption.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Converts a ByteArray into a HexString String
     *
     * @param bytes
     * @return the string in HexString format
     */
    public String toHexString(byte[] bytes) {
       return Hex.encodeHexString(bytes);
    }

    /**
     * Converts a String into a ByteArray.
     *
     * @param s The String to convert into ByteArray
     * @return a ByteArray.
     */
    public static byte[] toByteArray(String s) {
        try {
           return Hex.decodeHex(s.toCharArray());
        } catch (DecoderException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Setter of publicKey
     *
     * @param publicKey
     */
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    /**
     * Returns the public key as string.
     *
     * @return The public key.
     */
    private String getPublicKeyAsString() {
        return this.publicKey;
    }

    /**
     * Encodes a string using URLEncoder.
     *
     * @param textToEncode The text to encode
     * @return A string containing the encoded text.
     */

}
