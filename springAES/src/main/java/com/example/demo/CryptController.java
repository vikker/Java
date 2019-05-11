package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CryptController {

    Crypter crypt = new Crypter();

    private static final String template = "Hello, %s!" +
        "Query 1 get default value 'Example for Concord' or value from parameter encrypt." +
        "Example: http://localhost:8080/encrypt?encrypt=text_for_coding. " +
        "Query 2 has not a default value, it gets the coding string from a common object Crypter" +
        "or value from parameter decrypt. " +
        "Example: http://localhost:8080/decrypt?decrypt=17a90551c50d406a2dc55fd7b33b5396ed21cbf403685a53a5e2f0568437fe2c. " +
        "When we use Query 2 before Query 1 we get an error because the coded string is not exist.";

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="Concord") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

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
