package fp.word;


import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;

public class Word implements Comparable<Word>{
	

	private String word, definition, author;
	private List<String> tags;
	private Votes votes;
	private LocalDate date;
	
	
	//Variables Derivadas
	public Float getPositiveProportion()
	{return votes.getPositiveProportion();}
	
	public PosNeg getCalification()
	{	return votes.getCalification();
	}
	
	public Boolean getPositiveOverNegative()
	{return votes.getPositiveOverNegative();}
	
	
	
	//Getters y setters
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		Checkers.check("There should be a word", word != "");
		this.word = word;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public Votes getVotes() {
		
		
		return votes;
	}

	public void setVotes(Votes votes) {
		Checkers.check("Votes cannot be negative", votes.getUp()> 0 && votes.getDown()> 0 );
		
		this.votes = votes;
	}
	

	
	//Constructores
	public Word(String word, String definition, String author, List<String> tags, Votes votes, LocalDate date) {
		
		Checkers.check("Votes cannot be negative", votes.getUp()> 0 && votes.getDown()> 0 );
		Checkers.check("There should be a word", word != "");
		
		this.word = word;
		this.definition = definition;
		this.author = author;
		this.tags = tags;
		this.votes = votes;
		this.date = date;
	}

	public Word(String word, String definition) {
		Checkers.check("There should be a word", word != "");	
		
		this.word = word;
		this.definition = definition;
		this.author = null;
		this.tags = null;
		this.votes = null;
		this.date = null;
	}

	
	//To String
	@Override
	public String toString() {
		return word + ": " + definition + ", by " + author + ". Up/Down:" + votes.getUp() + "/" + votes.getDown();
		}


	

	@Override
	public int hashCode() {
		return Objects.hash(author, date, definition, tags, votes, word);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return Objects.equals(author, other.author) && Objects.equals(date, other.date)
				&& Objects.equals(definition, other.definition) && Objects.equals(tags, other.tags)
				&& Objects.equals(votes, other.votes) && Objects.equals(word, other.word);
	}



	@Override
	public int compareTo(Word o) {
		return this.getPositiveProportion().compareTo(o.getPositiveProportion());
	}
	
}
