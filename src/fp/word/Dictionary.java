package fp.word;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dictionary implements Collection<Word> {

	//Content
	private List<Word> words;
	
	//Constructor
	public Dictionary()
	{
		this.words = new LinkedList<Word>();
	}
	
	public Dictionary(Collection<? extends Word> list)
	{
		this.words = new LinkedList<Word>(list);
	}

	public Dictionary(Stream<Word> stream)
	{
		this.words = stream.collect(Collectors.toList());
	}

	public List<Word> getWords() {
		return List.copyOf(words);
	}

	public void setWords(List<Word> words) {
		this.words = words;
	} 
	
	public Boolean AddWord(Word word)
	{return this.add(word);}
	

	@Override
	public int hashCode() {
		return Objects.hash(words);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dictionary other = (Dictionary) obj;
		return Objects.equals(words, other.words);
	}
	

		@Override
	public String toString() {
		return "Dictionary" +  words ;
	}

		//Methods to implement
		public boolean existe(Word a) // Same as contains
		{
			Boolean res = false;
			for(Word word : this.words)
			{
				if(a.equals(word))
				{
					res = true;
					break;
				}
			}
			return res;
		}
		public Integer sumaVotos()
		{
			Integer res = 0;
			for (Word word : this.words)
			{
				res += word.getVotes().upMinusDown();
			}
			return res;
		}
		
		public Dictionary filtrarPorVotosMayor(int a)
		{
			Dictionary res = new Dictionary();
			
			for(Word i : words) 
			{
				if(i.getVotes().upMinusDown() > a)
				{res.add(i);}
			}
			
			return res;
		}
		
		public Map<String, Dictionary> agruparPorTags()
		{
			Map<String,Dictionary> res = new HashMap<String,Dictionary>();
			for(Word word : this.words)
			{
				for(String tag: word.getTags())
				{
					if(!res.containsKey(tag))
					{res.put(tag, new Dictionary());}
					res.get(tag).add(word);
				}
			}
			return res;
		}
		public Map<String, Integer> sumaVotosPorTag()
		{
		Map<String,Integer> res = new HashMap<String,Integer>();
			for(Word word : this.words)
			{
				for(String tag: word.getTags())
				{
					if(!res.containsKey(tag))
					{res.put(tag, 0);}
					res.put(tag, res.get(tag) + word.getVotes().upMinusDown());;
				}
			}
		return res;
		}
		
		
		
		
		//Entrega 3 bloque I
		public boolean existeStream(Word word)
		{
			
			return this.words.stream().anyMatch(x -> x.equals(word));
		}	
		public Integer sumaStream()
		{
			return this.words.stream().collect(Collectors.summingInt(x -> x.getVotes().upMinusDown()));
		}
		public Dictionary filtrarPorVotosMayorAStream(int a)
		{
			return new Dictionary(this.words.stream().filter(x -> x.getVotes().upMinusDown() >= a));
		}
		public Word maximoVotosAntesDe(LocalDate date)
		{
			return this.words.stream().filter(x-> x.getDate().isBefore(date)).max(Comparator.naturalOrder()).orElseGet(null);
		}
		
		public Dictionary filtradoPorVotosYOrdenado(int a)
		{
			return new Dictionary(this.words.stream().filter(x -> x.getVotes().upMinusDown() > a ).sorted(Comparator.naturalOrder()));
		}
		
		//Entrega 3 Bloque II
		public Map<String, List<Word>> agruparPorAutor()
		{
			return this.words.stream().collect(Collectors.groupingBy(Word::getAuthor));
		}
		
		public List<Word> listaInmodificable()
		{
			return this.words.stream().collect(Collectors.collectingAndThen( Collectors.toList(), Collections::unmodifiableList));
		}
		
		public Map<String, Integer> mejorNotaPorAutor()
		{
			return this.words.stream().collect(Collectors.toMap(Word::getAuthor
					, x->x.getVotes().upMinusDown(),
					BinaryOperator.maxBy(Comparator.naturalOrder())));
		}
		
		public SortedMap<LocalDate, List<Word>> topNPalabrasCadaDia(int n)
		{
			return this.words.stream().collect(Collectors.groupingBy(Word::getDate,
					TreeMap::new,
					Collectors.collectingAndThen(Collectors.toList(),
					x->x.stream().sorted().limit(n).toList())));
		
		}
		
		public String usuarioConMásPalabras()
		{
			Map<String, Long> strm = this.words.stream().collect(Collectors.groupingBy
					(Word::getAuthor, Collectors.counting()));
			
			return strm.entrySet().stream()
					.max(
					(entry1, entry2) -> entry1.getValue() > entry2.getValue() 
					? 1 : -1)
					.get().getKey();
		}
		
		
		
		
		
	//Collection methods
	@Override
	public int size() {
		return words.size();
	}

	@Override
	public boolean isEmpty() {
		return words.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return words.contains(o);
	}

	@Override
	public Iterator<Word> iterator() {
		return words.iterator();
	}

	@Override
	public Object[] toArray() {
		return words.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return words.toArray(a);
	}

	@Override
	public boolean add(Word e) {
		return words.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return words.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return words.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends Word> c) {
		return words.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return words.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return words.retainAll(c);
	}

	@Override
	public void clear() {
		words.clear();
		
	}
	
	
	
	
	
}
