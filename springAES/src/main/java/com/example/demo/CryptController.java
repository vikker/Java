package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CryptController {

    Crypter crypt = new Crypter();

    private static final String template = "Hello, %s! " +
            "Request 1 get default value 'Example for Concord' or value from parameter encrypt. " +
            "Example: http://localhost:8080/encrypt?encrypt=text_for_coding. " +
            "Request 2 get default value " +
            "'ea4b6fcaae17d255a7f30276bb4cfe418c7d6f23e7782c8344c0e79f6e3b887bc3cc723707c6e4a1962173db33764f4a' " +
            "or value from parameter decrypt. " +
            "Example: http://localhost:8080/decrypt?decrypt=ea4b6fcaae17d255a7f30276bb4cfe418c7d6f23e7782c8344c0e79f6e3b887bc3cc723707c6e4a1962173db33764f4a. ";

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public Greeting greeting(@RequestParam(value = "name", required = false, defaultValue = "Concord") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/encrypt")
    public Crypter encrypt(@RequestParam(value = "encrypt", defaultValue = "Example for Concord") String encrypt) {

        crypt.setOrigin(encrypt);
        crypt.setResult(crypt.encrypt(encrypt));

        return crypt;
    }

    @RequestMapping("/decrypt")
    public Crypter decrypt(@RequestParam(value = "decrypt",
            defaultValue = "") String decrypt) {

        if (decrypt == null || decrypt.equals("")) {

            decrypt = "ea4b6fcaae17d255a7f30276bb4cfe418c7d6f23e7782c8344c0e79f6e3b887bc3cc723707c6e4a1962173db33764f4a";
        }

        crypt.setOrigin(crypt.decrypt(decrypt));
        crypt.setResult(decrypt);

        return crypt;
    }

    /*@RequestMapping(value = "/decrypt1/{codedString}")
    public Crypter decrypt1(@PathVariable String codedString) {

        codedString = crypt.getResult();
        if (codedString == null || codedString.equals("")) {

            codedString = "ea4b6fcaae17d255a7f30276bb4cfe418c7d6f23e7782c8344c0e79f6e3b887bc3cc723707c6e4a1962173db33764f4a";
        }

        crypt.setOrigin(crypt.decrypt(codedString));
        crypt.setResult(codedString);

        return crypt;
    }*/

}
