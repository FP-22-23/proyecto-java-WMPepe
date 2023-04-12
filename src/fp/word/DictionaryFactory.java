package fp.word;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.utiles.Checkers;

public class DictionaryFactory {

	
	public static Dictionary readWords(String path)
	{
		Dictionary res  = null;
		try
		{
			Stream<Word> words= 
				Files.lines(Paths.get(path)).
				skip(1).
				map(DictionaryFactory::parseWord);
			
		 res = new Dictionary(words.collect(Collectors.toList()));
		}
		catch(IOException e)
		{System.out.println("No se encontró el fichero");
		e.printStackTrace();}
		
		return res;
	}
	public static Word parseWord(String lineaCSV)
	{
		
		String[] fields = lineaCSV.split(",");
		if(fields.length != 7)
		{System.out.println(lineaCSV);}
		Checkers.check("La línea debe contener  campos", fields.length == 7);
		
		String definition = fields[0].trim();
		String word = fields[1].trim();
		String author = fields[2].trim();
		List<String> tags = Arrays.asList(fields[3].replace("[", "").replace("]", "").split(";"));
		Votes votes = new Votes(Integer.parseInt(fields[4].trim()), Integer.parseInt(fields[5].trim()));
		LocalDate date  = LocalDate.parse(fields[6], DateTimeFormatter.ofPattern("MMMM dd; uuuu", Locale.ENGLISH));;
		
		return new Word(word, definition, author, tags, votes, date);
	}
}


