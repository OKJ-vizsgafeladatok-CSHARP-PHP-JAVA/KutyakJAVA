import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

	public static List<KutyaNev> beolvasKutyaNevet() {
		List<KutyaNev> lista = new ArrayList<KutyaNev>();
		try {
			List<String> sorok = Files.readAllLines(Paths.get("KutyaNevek.csv"));
			for (String sor : sorok.subList(1, sorok.size())) {
				String[] split = sor.split(";");
				KutyaNev o = new KutyaNev(Integer.parseInt(split[0]), split[1]);
				lista.add(o);
			}
		} catch (Exception e) {
			System.out.println("Hiba a fájl beolvasásánál: kutyanevek.csv" + e);
		}
		return lista;
	}

	public static List<KutyaFajtak> beolvasKutyaFajtat() {
		List<KutyaFajtak> lista = new ArrayList<KutyaFajtak>();
		try {
			// int szamlalo=0;
			List<String> sorok = Files.readAllLines(Paths.get("KutyaFajták.csv"));
			for (String sor : sorok.subList(1, sorok.size())) {
				String[] split = sor.split(";");
				// szamlalo++;
				// System.out.println(split.length+" "+szamlalo);
				if (split.length == 3) {
					KutyaFajtak o = new KutyaFajtak(Integer.parseInt(split[0]), split[1], split[2]);
					lista.add(o);
				} else {
					KutyaFajtak o = new KutyaFajtak(Integer.parseInt(split[0]), split[1], "");
					lista.add(o);
				}

			}
		} catch (Exception e) {
			System.out.println("Hiba a fájl beolvasásánál: kutyafajtak.csv" + e);
		}
		return lista;
	}

	public static List<Kutyak> beolvasKutyakat() {
		List<Kutyak> lista = new ArrayList<Kutyak>();
		try {
			List<String> sorok = Files.readAllLines(Paths.get("Kutyák.csv"));
			for (String sor : sorok.subList(1, sorok.size())) {
				String[] split = sor.split(";");
				Kutyak k = new Kutyak(Integer.parseInt(split[0]), Integer.parseInt(split[1]),
						Integer.parseInt(split[2]), Integer.parseInt(split[3]),
						LocalDate.parse(split[4], DateTimeFormatter.ofPattern("yyyy.MM.dd")));

				lista.add(k);
			}
		} catch (Exception e) {
			System.out.println("Hiba a fájl beolvasásánál: kutyak.csv" + e);
		}
		return lista;
	}

	public static TreeMap<LocalDate, Integer> rendez(Map<LocalDate, Integer> lista) {
		TreeMap<LocalDate, Integer> rendezett = new TreeMap<LocalDate, Integer>(new Comparator<LocalDate>() {
			public int compare(LocalDate o2, LocalDate o1) {
				int compare = lista.get(o1).compareTo(lista.get(o2));
				if (compare == 0) {
					return 1;
				} else {
					return compare;
				}
			}
		});
		rendezett.putAll(lista);
		return rendezett;
	}

	public static TreeMap<Integer, Integer> rendezII(Map<Integer, Integer> lista) {
		TreeMap<Integer, Integer> rendezett = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
			public int compare(Integer o2, Integer o1) {
				int compare = lista.get(o1).compareTo(lista.get(o2));
				if (compare == 0) {
					return 1;
				} else {
					return compare;
				}
			}
		});
		rendezett.putAll(lista);
		return rendezett;
	}

	public static TreeMap<String, Integer> rendezSI(Map<String, Integer> lista) {
		TreeMap<String, Integer> rendezett = new TreeMap<String, Integer>(new Comparator<String>() {
			public int compare(String o2, String o1) {
				int compare = lista.get(o1).compareTo(lista.get(o2));
				if (compare == 0) {
					return 1;
				} else {
					return compare;
				}
			}
		});
		rendezett.putAll(lista);
		return rendezett;
	}

	
	public static <K,V extends Comparable<? super V>> TreeMap<K,V>rendezALL(Map<K,V>lista){
		TreeMap<K,V> rendezett=new TreeMap<>(new Comparator<K>() {
			public int compare(K o1,K o2) {
				int compare=lista.get(o2).compareTo(lista.get(o1));
				if(compare==0) {
					return 1;
				}else {
					return compare;
				}
			}
		});
		rendezett.putAll(lista);
		return rendezett;
	}

	public static void main(String[] args) throws IOException {
		List<KutyaNev> a = beolvasKutyaNevet();
		System.out.println("3. feladat: Kutyanevek száma: " + a.size());
		// 4. feladat:
		List<KutyaFajtak> b = beolvasKutyaFajtat();
		// b.forEach(System.out::println);
		// 5. feladat:
		List<Kutyak> c = beolvasKutyakat();

		// 6. feladat:
		int sumEletkor = 0;
		for (Kutyak k : c) {
			sumEletkor += k.getEletkor();
		}
		double atlag = sumEletkor / (double) c.size();
		System.out.println("6. feladat: Kutyák átlagéletkora: " + new DecimalFormat("0.00").format(atlag));

		// 7. feladat
		int maxeletkor = Integer.MIN_VALUE;
		Kutyak max = null;
		for (Kutyak k : c) {
			if (k.getEletkor() > maxeletkor) {
				maxeletkor = k.getEletkor();
				max = k;
			}
		}
		String nev = "";
		for (KutyaNev k : a) {
			if (max.getcNevID() == k.getNevId()) {
				nev = k.getKutyaNev();
			}
		}
		String fajta = "";
		for (KutyaFajtak k : b) {
			if (max.getcFajtaId() == k.getFajtaId()) {
				fajta = k.getFajtaNev();
			}
		}
		System.out.println("7. feladat: Legidősebb kutya neve és fajtája: " + nev + "," + fajta + " életkora: "
				+ max.getEletkor());

		System.out.println("8. feladat: Január 10.-én vizsgált kutya fajták: ");
		LocalDate jan10 = LocalDate.of(2018, 01, 10);
		List<Integer> fajtalista = new ArrayList<Integer>();
		for (Kutyak k : c) {
			if (k.getuEll().equals(jan10)) {
				fajtalista.add(k.getcFajtaId());
			}
		}
		HashMap<String, Integer> stat = new HashMap<String, Integer>();
		for (Integer i : fajtalista) {
			for (KutyaFajtak f : b) {
				if (i == f.getFajtaId()) {
					stat.merge(f.getFajtaNev(), 1, Integer::sum);
				}
			}
		}
		for (Entry<String, Integer> e : stat.entrySet()) {
			System.out.println("\t" + e.getKey() + ": " + e.getValue());
		}

		// 9. feladat:
		HashMap<LocalDate, Integer> stat2 = new HashMap<LocalDate, Integer>();
		for (Kutyak k : c) {
			stat2.merge(k.getuEll(), 1, Integer::sum);
		}
		// System.out.println(stat2);
		TreeMap<LocalDate, Integer> stat3 = rendez(stat2);

		System.out.println("9. feladat: Legjobban leterhelt nap: "
				+ stat3.firstKey().format(DateTimeFormatter.ofPattern("yyyy. MM. dd.")) + ": "
				+ stat3.firstEntry().getValue() + " kutya");
		// System.out.println(stat3);
		// 10. feladat:
		String fajlba = "";

		/*
		 * HashMap<String,Integer>stat100=new HashMap<String,Integer>(); for (Kutyak k :
		 * c) { for (KutyaNev kn : a) { if(k.getcNevID()==kn.getNevId()) {
		 * stat100.merge(kn.getKutyaNev(), 1,Integer::sum); } } }
		 * 
		 * TreeMap<String, Integer> stat101=rendezSI(stat100);
		 * 
		 * for (Entry<String,Integer> e : stat101.entrySet()) {
		 * fajlba+=e.getKey()+";"+e.getValue()+"\n"; }
		 */
		HashMap<Integer, Integer> stat200 = new HashMap<Integer, Integer>();
		for (Kutyak k : c) {
			stat200.merge(k.getcNevID(), 1, Integer::sum);
		}
		// System.out.println(stat200);
		TreeMap<Integer, Integer> stat201 = rendezALL(stat200);
		// System.out.println(stat201);
		// System.out.println(fajlba);
		for (Entry<Integer, Integer> ii : stat201.entrySet()) {
			for (KutyaNev kn : a) {
				if (ii.getKey() == kn.getNevId()) {
					fajlba += kn.getKutyaNev() + ";" + ii.getValue() + "\n";
				}
			}
		}
		Files.write(Paths.get("Névstatisztika.txt"), fajlba.getBytes());

	}// endofmain
}
