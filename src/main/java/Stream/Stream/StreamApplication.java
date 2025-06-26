package Stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class StreamApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(StreamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Long> nombre = new ArrayList<>();
		nombre.add(10L);
		nombre.add(18L);
		nombre.add(15L);
		nombre.add(24L);
		nombre.add(55L);

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
				    List<Long> listMutiplierforTwo = nombres.stream()
									.map(n -> n * 2)
									.collect(Collectors.toList());

				return listMutiplierforTwo;

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

	}
}


