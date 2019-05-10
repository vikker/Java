package com.example.demo;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Crypter {

    private String origin;
    private String result;

    public Crypter() {

    }

    public Crypter(String origin, String result) {

        if (origin == null ||origin.equals("")) {
            if (result != null || !result.equals("")) {

                this.origin = decrypt(result);

            } else {

                this.origin = "This is an text.";
                this.result = encrypt(origin);

            }
        } else {

            this.result = encrypt(origin);

        }
    }

    String key = "";

    BufferedReader bufferedReader;
    {
        try {
            bufferedReader = new BufferedReader(new FileReader("src/main/resources/key.txt"));
            key = bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String salt = KeyGenerators.string().generateKey();

    TextEncryptor encryptor = Encryptors.text(key, salt);



    String encrypt(String textToEncrypt) {

        return encryptor.encrypt(textToEncrypt);
    }

    String decrypt(String textToDecrypt) {

        return  encryptor.decrypt(textToDecrypt);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

}
