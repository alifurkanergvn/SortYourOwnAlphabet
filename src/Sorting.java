import java.util.Scanner;
import java.util.regex.Pattern;

public class Sorting {
	
	public static void takeWords() {
		Scanner klavye = new Scanner(System.in);
		
		System.out.println("Lutfen siralamak istenilen kelimeleri "
				+ "arasinda boşluk olacak sekilde giriniz");
		String wordString = klavye.nextLine().toLowerCase();
		
		//Alınan isimleri boşluktan sonrasını parçalayarak array içine yerleştirme
		String [] names =wordString.split(" ");
		if (names.length<2) {
			System.out.println("En az 2 kelime girmek zorundasınız");
			takeWords();
		}else {
			klavye.close();
		
			takeAlphabetAndStart(names);
		} 
		
			
	}
	
	public static void takeAlphabetAndStart(String []names ) {

		String newAlphabet = "defgauğıvijçklümnocöprsyhbştz";
		
		//Regex ile girilen alfabenin şartları sağlamasını kontrol ediliyor
		if (Pattern.matches("(?:([abcçdefgğhiıjklmnoöprsştuüvyz])(?!.*\\1)){29}", newAlphabet)==true) {
			System.out.println("Alfabe gerekli kurallara uygundur");
			
			//startSorting den gelen boolean ı ekrana yazdırdık
			 if (startSorting(newAlphabet,names)==true) {
				System.out.println("Kelimeler iletilen alfabetik sıraya göre SIRALIDIR");
			} else {
				System.out.println("Kelimeler iletilen alfabetik sıraya göre sirali DEGILDIR");
			}
		}else {
			 System.out.println("Alfabeniz kurallara uymamaktadır");
		}
	}
	
	public static boolean startSorting(String newAlphabet,String []names) {
		
		
		for (int i = 0; i < names.length-1; i++) {
			
			//Girilen kelimeler aynıysa veya birbilerini içeriyorsa kontolü hızlandır
			if(names[i].equals(names[i+1])) {
				continue;
			}
			else if(names[i].contains(names[i+1])) {
				return false;
			}else if(names[i+1].contains(names[i])) {
				continue;
			}
			
			//Kelime uzunluğu az olan sayıda döngüye girsin
			int shorterWordLength= Math.min(names[i].length(),names[i+1].length());
			
			for (int j = 0; j <shorterWordLength ; j++) {
				 if (newAlphabet.indexOf(names[i].charAt(j)) < newAlphabet.indexOf(names[i+1].charAt(j))) {
					break;
				} else if(newAlphabet.indexOf(names[i].charAt(j)) > newAlphabet.indexOf(names[i+1].charAt(j))){
					return false;
				}
			}
			
		}
		return true;
	}
	
	
	
}
