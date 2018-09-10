/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/**
 *
 * @author nash Created on Aug 7, 2018, 11:29:06 AM
 */
public class FileEncrypterDecrypter {

    private final SecretKey secretKey;
    private final Cipher cipher;

    FileEncrypterDecrypter(SecretKey secretKey, String transformation) throws NoSuchAlgorithmException, NoSuchPaddingException {
        this.secretKey = secretKey;
        this.cipher = Cipher.getInstance(transformation);
    }

    public void encrypt(String content, String fileName) throws InvalidKeyException, FileNotFoundException, IOException {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] iv = cipher.getIV();
        FileOutputStream fileOut = new FileOutputStream(fileName);
        CipherOutputStream cipherOut = new CipherOutputStream(fileOut, cipher);
        fileOut.write(iv);
        cipherOut.write(content.getBytes());
        cipherOut.close();
        fileOut.close();
    }

    public String decrypt(String fileName) throws FileNotFoundException, IOException, InvalidKeyException, InvalidAlgorithmParameterException {
        String content;
        FileInputStream fileIn = new FileInputStream(fileName);
        byte[] fileIv = new byte[16];
        fileIn.read(fileIv);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(fileIv));

        CipherInputStream cipherIn = new CipherInputStream(fileIn, cipher);
        InputStreamReader inputReader = new InputStreamReader(cipherIn);
        BufferedReader reader = new BufferedReader(inputReader);

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        content = sb.toString();

        reader.close();
        inputReader.close();
        cipherIn.close();

        return content;
    }

    public static void main(String[] args) {
        try {
            String originalContent = "Hola mundo";
            SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();

            FileEncrypterDecrypter fileEncrypterDecrypter = new FileEncrypterDecrypter(secretKey, "AES/CBC/PKCS5Padding");
            fileEncrypterDecrypter.encrypt(originalContent, "baz.enc");

            String decryptedContent = fileEncrypterDecrypter.decrypt("baz.enc");
            System.out.println(decryptedContent);

            new File("baz.enc").delete(); // cleanup
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("Error en algoritmo " + ex);
        } catch (InvalidKeyException ex) {
            System.err.println("Error llave invalida " + ex);
        } catch (IOException ex) {
            System.err.println("Error en io " + ex);
        } catch (NoSuchPaddingException ex) {
            System.err.println("Error padding " + ex);
        } catch (InvalidAlgorithmParameterException ex) {
            System.err.println("Error algoritmo invalido" + ex);
        }
    }
}
