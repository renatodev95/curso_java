package generics;

import java.util.Arrays;
import java.util.List;

public class ListaUtilTeste {

	public static void main(String[] args) {

		List<String> langs = Arrays.asList("JS", "PHP", "Java", "C++");
		List<Integer> nums = Arrays.asList(10, 20, 30, 40, 50, 60);

		// neste primeiro caso sempre é necessário fazer o casting
		String lastLang1 = (String) ListaUtil.getUltimo1(langs);
		System.out.println(lastLang1);

		Integer lastNum1 = (Integer) ListaUtil.getUltimo1(nums);
		System.out.println(lastNum1);

		// sem necessidade de casting, pois já definimos o método com generics
		String lastLang2 = ListaUtil.getUltimo2(langs);
		System.out.println(lastLang2);

		Integer lastNum2 = ListaUtil.getUltimo2(nums);
		System.out.println(lastNum2);

	}
}
