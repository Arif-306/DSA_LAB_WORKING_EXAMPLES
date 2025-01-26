
package com.mycompany.swaping;



public class Swaping {
    
        int y;
        int z;
        
        
        public Swaping(int y,int z) {
            this.y = y;
            this.z = z;
        }
        public void swap() {
            y = y + z;// 1: y yz (y + z)ban gaya
            z = y - z;// 2: z yz (y + z - z) ban gaya, jo ke original y hai
            y = y - z;// 3: y yz (y + z - y)ban gaya
        }
        public void printValues() {
            System.out.println("y = " + y + ", z = " + z);
        }
    

    public static void main(String[] args) {
     Swaping obj = new Swaping(20,35);
      
      System.out.println("Before Swapping:");
      obj.printValues();
      
      obj.swap();
      
      
      System.out.println("After Swapping:");
      obj.printValues();
    }
}
