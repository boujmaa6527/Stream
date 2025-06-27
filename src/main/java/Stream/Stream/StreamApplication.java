package Stream.Stream;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootApplication
public class StreamApplication implements CommandLineRunner {


	private static final Logger LOGGER = LoggerFactory.getLogger(StreamApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StreamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Personne p1 = new Personne("rachid", 42);
		Personne p2 = new Personne("boKazbor", 54);
		Personne p3 = new Personne("Bonarnar", 34);
		Personne p4 = new Personne("Bodarbala", 36);
		Personne p5 = new Personne("attar", 54);
		List<Long> nombre = new ArrayList<>();
		nombre.add(55L);
		nombre.add(10L);
		nombre.add(18L);
		nombre.add(15L);
		nombre.add(24L);
		nombre.add(55L);

		List<String> chaineList = new ArrayList<>();
		chaineList.add("pomme");
		chaineList.add("banane");
		chaineList.add("fraise");
		chaineList.add("poire");
		String str = "Il pleut souvent En Normandie et en Normandie les vaches sont grasses.";

		List<Personne> listPersonne = new ArrayList<>();
		listPersonne.add(p1);
		listPersonne.add(p2);
		listPersonne.add(p3);
		listPersonne.add(p4);
		listPersonne.add(p5);


		System.out.println("Liste de nombre :" + nombre);
		List<Long> result = Ex1_1.filtreNombrepair(nombre);
		System.out.println("Nombre pairs :" + result);
		List<Long> result1 = Ex1_1.filtreNombreWithStream(nombre);
		System.out.println("Nombre pairs avec stream :" + result1);
		List<Long> result2 = Ex1_2.countNombreSupTen(nombre);
		System.out.println("Nombre supérieur a 10 :" + result2);
		List<Long> result3 = Ex1_2.countNombreSupTenWithStream(nombre);
		System.out.println("Nombre supérieur a 10 avec stream :" + result3);
		List<Long> result4 = Ex1_3.numberMutiplierFor2(nombre);
		System.out.println("Nombre Mutiliper par 2 :" + result4);
		List<Long> result5 = Ex1_3.numberMutiplierFor2Stream(nombre);
		System.out.println("Nombre Mutiliper par 2 avec Stream:" + result5);
		Ex1_4.maxAndMinOfList(nombre);
		Ex1_4.maxAndMinOfListWithStream(nombre);
		Set<Long> result6 = Ex2_5.deleteDoublonOfList(nombre);
		System.out.println("List sans doublon:" + result6);
		Set<Long> result7 = Ex2_5.deleteDoublonOfListWithSteam(nombre);
		System.out.println("List sans doublon avec Stream:" + result6);
		Long result8 = Ex2_6.sumOfList(nombre);
		System.out.println("Somme d'une liste :" + result8);
		Long result9 = Ex2_6.sumOfListwithStream(nombre);
		System.out.println("Somme d'une liste avec Stream :" + result9);
		List<Integer> result10 = Ex2_7.convertirChaineEnNombre(chaineList);
		System.out.println("Liste de chaine :" + chaineList);
		System.out.println("Convertir une chaine de liste en longueur :" + result10);
		List<Integer> result11 = Ex2_7.convertirChaineEnNombreWithStream(chaineList);
		System.out.println("Convertir une chaine de liste en longueur avec Stream :" + result11);
		System.out.println(str);
		Ex2_8.compterOccurenceMotPhrase(str);
		Ex2_8.countOccurenceMotPhraseWithStream(str);
		Ex3_9.trierListChaineOrdreAlPha(chaineList);
		List<String> list = Ex3_9.trierListChaineOrdreAlPhaWithSteam(chaineList);
		System.out.println("liste trier avec stream "+ list);
		List<Personne> listPersonneAge = Ex3_10.trierListePersonneAge(listPersonne);
		System.out.println("Trier Personne selon age: ");
		for(Personne p : listPersonneAge){
			System.out.println("Nom: "+ p.getNom()+" Age: " +p.getAge());
		}
		List<String> stringList = Ex3_11.listTrierParOrdreCroissant(chaineList);
		System.out.println("Liste trie par ordre croissant: " +stringList);
		List<String> stringList1 = Ex3_11.listTrierParOrdreCroissantWithStream(chaineList);
		System.out.println("Liste trie par ordre croissant avec Stream: " +stringList1);
		System.out.println("Trouver les 3 plus grande valeur distinct");
		Ex3_12.findThreeMaxDistinc(nombre);
		System.out.println("Trouver les 3 plus grande valeur distinct avec STREAM STREAM STREAM");
		Ex3_12.findTreeMaxDistincWithStream(nombre);



	}

	//filtrer les nombres pairs d'une liste
	public class Ex1_1{

		// Sans Stream
		public static List<Long> filtreNombrepair(List<Long> nombres){
			List<Long> nombrePair = new ArrayList<>();
			for (Long n : nombres){
				if(n % 2 ==0){
					nombrePair.add(n);
				}
			}
			return nombrePair;
		}
		public static List<Long> filtreNombreWithStream(List<Long> nombres){
			return nombres.stream()
					.filter(n -> n % 2 ==0)
					.collect(Collectors.toList());

		}
	}
	//Compter le nombre d'element supérieur a 10 dans une liste
	public class Ex1_2 {

		public static List<Long> countNombreSupTen(List<Long> nombres){
			List<Long> nombreSupTen = new ArrayList<>();
			for (Long n : nombres){
				if(n > 10){
					nombreSupTen.add(n);
				}
			}
			return nombreSupTen;
		}
		public static List<Long> countNombreSupTenWithStream(List<Long> nombres){
			return  nombres.stream()
					.filter(n -> n > 10)
					.collect(Collectors.toList());


		}
	}
	//Multipliez chaque element d'une liste par deux et stocker le resultat dans une nouvelle liste
	public class Ex1_3 {

		public static List<Long> numberMutiplierFor2(List<Long> nombres) {
			List<Long> nombreMultiPar2 = new ArrayList<>();
			for (Long n : nombres) {
				n = n * 2;
				nombreMultiPar2.add(n);

			}
			return nombreMultiPar2;
		}
			public static List<Long> numberMutiplierFor2Stream(List <Long> nombres) {
				return nombres.stream()
									.map(n -> n * 2)
									.collect(Collectors.toList());

			}
		}
	//Trouver le maximum et le minimum
	public class Ex1_4{

		public static void  maxAndMinOfList(List<Long> nombres) {
			 Long max = 0L;
			for (Long n : nombres){
				if(n > max) {
					max = n;
				}
			}
			Long min = max;
			for (Long n : nombres){
				if(n < min) {
					min = n;
				}
			}
			System.out.println("Le max est :" + max);
			System.out.println("Le min est :" + min);
        }
		public static void maxAndMinOfListWithStream(List<Long> nombres){
			Optional<Long> max = nombres.stream().max(Comparator.naturalOrder());
			max.ifPresent(v -> System.out.println("max avec Stream: " + v));

			Optional<Long> min = nombres.stream().min(Comparator.naturalOrder());
			min.ifPresent(v -> System.out.println("min avec Stream: " + v));


		}

	}
	// Supprimer mes doublons dans une liste
	public class Ex2_5 {

		public static Set<Long> deleteDoublonOfList(List<Long> nombres){

			Set<Long> sansDoublons = new LinkedHashSet<>(nombres);
				return sansDoublons;
			}
		public static Set<Long> deleteDoublonOfListWithSteam(List<Long> nombres){

			return nombres.stream()
					.distinct()
					.collect(Collectors.toSet());
		}


	}
	//Calculer la somme de tous les élements d'une liste
	public class Ex2_6 {

		public static Long sumOfList(List<Long> nombres){

				Long sum = 0L;
				for (Long n : nombres){
					sum += n;
				}
				return sum;
		}
		public static Long sumOfListwithStream(List<Long> nombre) {

			return nombre.stream().mapToLong(i -> i).sum();
		}
	}
	//Convertir une liste de chaines de caractère en liste de leur longueur respective
	public class Ex2_7 {

		public static List<Integer> convertirChaineEnNombre(List<String> stringList){

			List<Integer> chaineList = new ArrayList<>();
			for(String s : stringList){
				chaineList.add(s.length());
			}
			return chaineList;
		}
		public static List<Integer> convertirChaineEnNombreWithStream(List<String> stringList){

			return stringList.stream()
					.map(String::length)
					.collect(Collectors.toList());
		}
	}
	//Comparer les occurences de chaque mot dans une phrase
	public class Ex2_8 {

		public static void compterOccurenceMotPhrase(String str) {

			String[] mots = str.toLowerCase().split("\\s+");
			Map<String, Integer> occurence = new HashMap<>();

			for(String mot : mots) {
				occurence.put(mot, occurence.getOrDefault(mot,0) + 1);

			}
			for(Map.Entry<String, Integer> entry : occurence.entrySet()){
				System.out.println(entry.getKey() + ":" + entry.getValue());
			}

		}
		public static void countOccurenceMotPhraseWithStream(String str){

			Arrays.stream(str.toLowerCase().split("\\s+"))
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
					.forEach((mot, count) -> System.out.println("With Stream : "+ mot + " : "+ count));
		}

	}
	//Trier une liste de chaine pa odredre alphabetique
	public class Ex3_9{

		public static void trierListChaineOrdreAlPha(List<String> stringList){

			Collections.sort(stringList);
			System.out.println("Liste trié par ordre alphabétique: ");
				for (String str : stringList){
					System.out.println(str);
				}

		}
		public static List<String> trierListChaineOrdreAlPhaWithSteam(List<String> stringList){

			 return  stringList.stream()
					.sorted()
					.toList();

		}





	}

	//trier uen liste d'objet (par exemple : liste de personne par age)
	public class Personne{


		@Id
		private String nom;
		private int age;

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}


		public Personne(String nom, int age) {
			this.nom = nom;
			this.age = age;
		}

	}

	public class Ex3_10{

		public static List<Personne> trierListePersonneAge(List<Personne> personneList){

			Collections.sort(personneList, new Comparator<Personne>() {
				@Override
				public int compare(Personne p1, Personne p2) {
					return p1.getAge() - p2.getAge();
				}
			});
			return personneList;
		}


	}
	public class Ex3_11 {

		public static List<String> listTrierParOrdreCroissant(List<String> stringList)  {

			Set<String> ensembleMots = new HashSet<>(stringList);

			List<String> motsUnique = new ArrayList<>(ensembleMots);
			motsUnique.sort(Comparator.comparing(String::length));
			return  motsUnique;

		}
		public static List<String> listTrierParOrdreCroissantWithStream(List<String> stringList){
			return stringList.stream()
					.distinct()
					.sorted(Comparator.comparing(String::length))
					.collect(Collectors.toList());

		}


	}
	public class Ex3_12 {

		public static void findThreeMaxDistinc(List<Long> longList){

			int count = 0;
			Set<Long> distinct = new TreeSet<>(Collections.reverseOrder());

			for(Long val : longList){
				distinct.add(val);
			}

			for(Long val : distinct){
				System.out.println(val);
				count++;
				if(count == 3) break;
			}
		}
		public static void findTreeMaxDistincWithStream(List<Long> longList){

			TreeSet<Long> trieDesc = new TreeSet<>(Collections.reverseOrder());
			trieDesc.addAll(longList);

			List<Long> top3 =   trieDesc.stream()
										.limit(3)
										.toList();
			System.out.println(top3);
		}

	}

}


