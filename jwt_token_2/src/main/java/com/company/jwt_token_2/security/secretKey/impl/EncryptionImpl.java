package com.company.jwt_token_2.security.secretKey.impl;

import com.company.jwt_token_2.security.secretKey.Encryption;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;

@Service
public class EncryptionImpl implements Encryption {
    @Override
    public String encrypt(String password) {

        try {
            SecureRandom secureRandom = new SecureRandom();
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            Signature signature = Signature.getInstance("SHA256WithDSA");

            signature.initSign(keyPair.getPrivate(), secureRandom);

            byte[] data = password.getBytes("UTF-8");
            signature.update(data);

            byte[] digitalSignature = signature.sign();

            Signature signature2 = Signature.getInstance("SHA256WithDSA");
            signature2.initVerify(keyPair.getPublic());

            signature2.update(data);

            return digitalSignature.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }catch (SignatureException e){
            throw new RuntimeException(e);
        }catch (UnsupportedEncodingException e){
            throw new RuntimeException(e);
        }


    }


}
