import java.security.KeyPair;
import java.security.spec.AlgorithmParameterSpec;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.PrivateKey;


public class Network
{
    public PrivateKey privateKey;
    public PublicKey publicKey;

    public Network() {
        this.generateKeyPair();
    }

    public void generateKeyPair() {
        try {
            final KeyPairGenerator instance = KeyPairGenerator.getInstance("ECDSA", "BC");
            instance.initialize(new ECGenParameterSpec("prime192v1"), SecureRandom.getInstance("SHA1PRNG"));
            final KeyPair generateKeyPair = instance.generateKeyPair();
            this.privateKey = generateKeyPair.getPrivate();
            this.publicKey = generateKeyPair.getPublic();
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
