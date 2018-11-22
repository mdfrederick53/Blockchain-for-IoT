/*
*  SmartDevices.java
*
*  A SmartDevice is a device that has limited access to smartAppliances.  The
*  master computer will be able to decide which device will have access to which
*  SmartAppliances.
*/

import java.security.*;
import java.util.*;

public class SmartDevice extends Smart
{
   public ArrayList<PublicKey> accessPublic = new ArrayList<PublicKey>();
   private ArrayList<PrivateKey> accessPrivate = new ArrayList<PrivateKey>();

   public SmartDevice(String name, PrivateKey owner)
   {
      super.generateKeyPair();
      this.name = name;
      this.owner = owner;
   }


}
