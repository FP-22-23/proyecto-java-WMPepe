package fp.test;

import java.time.LocalDate;
import java.util.LinkedList;

import fp.word.Dictionary;
import fp.word.DictionaryFactory;
import fp.word.Votes;
import fp.word.Word;

public class WordTest {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Word word = new Word("Reloj", "Elemento que da la hora", "Manolo",new LinkedList<String>(), new Votes(50,6), LocalDate.now());
		Word word2 = new Word("Panadero", "Persona que hace pan", "Gerardo",new LinkedList<String>(), new Votes(5,66), LocalDate.now());
		
		System.out.println(word.getWord());
		System.out.println(word.getCalification());
		System.out.println(word.getDate());
		System.out.println(word.getPositiveOverNegative());
		
		System.out.println(word);
		
		System.out.println(word.compareTo(word2));
		System.out.println(word.equals(word2));
		
		Dictionary a = DictionaryFactory.readWords("C:/Users/PokeH/git/UrbanDirctionary/data/urban_dictionary_UP.csv");
		System.out.println(a);
		
		
	}

}
