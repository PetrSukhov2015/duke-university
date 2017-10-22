package level3.cc;

import edu.duke.FileResource;

public class CaesarBreaker {
	public static void main (String[] args){
		CaesarCipher cc = new CaesarCipher();
		
		//String encrypted="Can you imagine life WITHOUT the internet AND computers in your pocket";
		FileResource fr = new FileResource("D:\\duke\\level3\\QuizCryptographyData\\mysteryTwoKeysQuiz.txt");
		String encrypted = fr.asString();
		//String encrypted="Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx";
		
		
		for (int k1=0; k1<= 26; k1++){
				
			
			int key=k1;
			//int key2=24;
			//String message = cc.encrypt(encrypted, key);
			//System.out.println(message);
			
			String message1 = cc.encrypt(encrypted, 26-key);
			//String message2 = cc.encrypt(encrypted, 26-key2);
			//System.out.println(message1);
			//System.out.println(message2);
			//for(int k=0; k<message1.length(); k++){
			//	if (0==k%2){System.out.print(message1.charAt(k));}
			//	else{System.out.print(message2.charAt(k));	}
			//}
			
			for (int k2=0; k2<= 26; k2++){
				key=k2;
				String message2 = cc.encrypt(encrypted, 26 - key);
				
				//System.out.println(message2);
				for (int k=0; k<message2.length();k++){
					//System.out.println("num "+k1*k2);
					//System.out.println(message1);
					if (0==k%2){System.out.print(message1.charAt(k));}
					else{System.out.print(message2.charAt(k));
					}
				}
				System.out.println("----------------");
			}
		}
		
	}
}
