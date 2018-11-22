/*
*  Smart.java
*
*  This class is used for SmartAppliances and SmartDevices. SmartDevices are
*  devices that have the ability to control SmartAppliances but do not have as
*  much power as a PersonalSystem.
*
*/

import java.security.*;
//import java.util.security.spec.*;

abstract class Smart
{
   public PrivateKey privateKey;
   public PublicKey publicKey;
   String name;
   PublicKey owner;

   public void generateKeyPair()
   {
      final KeyPair generateKeyPair = instance.generateKeyPair();
      this.privateKey = generateKeyPair.getPrivate();
      this.publicKey = generateKeyPair.getPublic();
   }
}
