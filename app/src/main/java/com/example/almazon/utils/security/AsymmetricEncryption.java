package com.example.almazon.utils.security;

import android.util.Base64;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;

/*Al no existir el DatatypeConverter, en esta clase da error. Sin embargo, he leido que android ya trae una
libreria con la que se puede hacer la misma operación, llamada Base64. Es la misma que creo que intento
usar Mikel en la encriptación en un primer momento (pero en la app escritorio), ya que tiene metodos comentados.
Si no funciona, he leido que hay tambien una libreria Apache, pero no es una opción muy recomendable.
He comentado los metodos mas abajo.
 */

public class AsymmetricEncryption {

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
            /*El metodo comentado es el que tenemos nosotros en la app de escritorio. Abajo he dejado
            lo que creo que puede servir*/

            //byte[] keyBytes = DatatypeConverter.parseHexBinary(this.getPublicKeyAsString());
            byte[] keyBytes = Base64.decode(this.getPublicKeyAsString(), Base64.DEFAULT);


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
     * @param array
     * @return the string in HexString format
     */
    private static String toHexString(byte[] array) {
        //return DatatypeConverter.printHexBinary(array);
        return Base64.encodeToString(array, Base64.DEFAULT);
    }

    /**
     * Converts a String into a ByteArray.
     *
     * @param s The String to convert into ByteArray
     * @return a ByteArray.
     */
    private static byte[] toByteArray(String s) {
        //return DatatypeConverter.parseHexBinary(s);
        return Base64.decode(s, Base64.DEFAULT);

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

