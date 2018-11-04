import java.util.ArrayList;
import java.security.Security;
import java.util.Base64;

public class BlockChain
{
   public static ArrayList<Block> blockchain = new ArrayList<Block>();
   public static int difficulty = 5;

   public static void main(String[] args)
   {

      //Create the new wallets
		PersonalSystem PS1 = new PersonalSystem();
		PersonalSystem PS2 = new PersonalSystem();
		//Test public and private keys
		System.out.println("Private and public keys:");
		System.out.println(StringUtil.getStringFromKey(PS1.privateKey));
		System.out.println(StringUtil.getStringFromKey(PS1.publicKey));
		//Create a test transaction from PS1 to PS2
		Transaction transaction = new Transaction(PS1.publicKey, PS2.publicKey, 5, null);
		transaction.generateSignature(PS1.privateKey);
		//Verify the signature works and verify it from the public key
		System.out.println("Is signature verified");
		//System.out.println(transaction.verifiySignature());

   }

   public static Boolean isChainValid() {
	Block currentBlock;
	Block previousBlock;

	//loop through blockchain to check hashes:
	for(int i=1; i < blockchain.size(); i++) {
		currentBlock = blockchain.get(i);
		previousBlock = blockchain.get(i-1);
		//compare registered hash and calculated hash:
		if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
			System.out.println("Current Hashes not equal");
			return false;
		}
		//compare previous hash and registered previous hash
		if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
			System.out.println("Previous Hashes not equal");
			return false;
		}
	}
	return true;
}


}
