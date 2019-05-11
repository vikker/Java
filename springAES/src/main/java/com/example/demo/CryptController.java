package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CryptgController {

    Crypter crypt = new Crypter();

    @RequestMapping("/encrypt")
    public Crypter encrypt(@RequestParam(value="encrypt", defaultValue="Example for Concord") String encrypt) {

        crypt.setOrigin(encrypt);
        crypt.setResult(crypt.encrypt(encrypt));

        return crypt;
    }

    @RequestMapping("/decrypt")
    public Crypter decrypt(@RequestParam(value="decrypt", defaultValue="") String decrypt) {

        if (decrypt == null || decrypt.equals("")) {
            decrypt = crypt.getResult();
        }

       crypt.setOrigin(crypt.decrypt(decrypt));

        return crypt;
    }
}
