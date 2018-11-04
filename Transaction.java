import java.security.*;
import java.util.ArrayList;

public class Transaction
{

   public String transactionId; //this is also the hash of the transaction
   public PublicKey user; // users address/public key.
   public PublicKey device; // Recipients address/public key.
   public float value;
   public byte[] signature; //this is to prevent anybody else from spending
                            //funds in our Wallet

   public ArrayList<TransactionInput> inputs
                                 = new ArrayList<TransactionInput>();
   public ArrayList<TransactionOutput> outputs
                                 = new ArrayList<TransactionOutput>();

   private static int sequence = 0; // a rough count of how many transactions
                                    // have been generated

   //Constructor
   public Transaction(PublicKey from, PublicKey to, float value,
                        ArrayList<TransactionInput> inputs)
   {
      this.user = from;
      this.device = to;
      this.value = value;
      this.inputs = inputs;
   }

   //This calculates the transaction hash (which will be used as its Id)
   private String calculateHash()
   {
      sequence++; //increase the sequence to avoid 2 identical transactions
                  //having the same hash
      return StringUtil.applySha(
                           StringUtil.getStringFromKey(user) +
                           StringUtil.getStringFromKey(device) +
                           Float.toString(value) + sequence);

   }

   //Signs all the data we dont wish to be tampered with.
   public void generateSignature(PrivateKey privateKey)
   {
	     String data = StringUtil.getStringFromKey(user) +
            StringUtil.getStringFromKey(device) + Float.toString(value);
	     signature = StringUtil.applyECDSASig(privateKey,data);
   }

   //Verifies the data we signed hasnt been tampered with
   /*public boolean verifiySignature()
   {
	     String data = StringUtil.getStringFromKey(user) +
               StringUtil.getStringFromKey(device) + Float.toString(value);
	     return StringUtil.verifyECDSASig(user, device, signature);
   }*/
}
