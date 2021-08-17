package generics;

import java.util.List;

public class ListaUtil {

	// Este primeiro m�todo exige sempre que fa�amos o casting de tipos
	public static Object getUltimo1(List<?> lista) {
		return lista.get(lista.size() - 1);
	}

	// Esse segundo m�todo permite que n�o precisemos nos preocupar
	// com o casting, porque no momento em que passamos uma lista de
	// strings, automaticamente o tipo retornado ser� uma String, por exemplo
	public static <T> T getUltimo2(List<T> lista) {
		return lista.get(lista.size() - 1);
	}

}
