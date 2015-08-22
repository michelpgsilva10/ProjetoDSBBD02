package validacao;

import java.lang.reflect.Field;

public class ValidacaoUtil {

	public static Exception valida(Object obj) {
		StringBuffer msg = new StringBuffer();
		Field atributos[] = obj.getClass().getDeclaredFields();
		
		for (Field f : atributos) {
			f.setAccessible(true);
			Validacao val = f.getAnnotation(Validacao.class);
			if (val != null && val.requerido()) {
				try {
					if (f.get(obj) == null) 
						msg.append(f.getName() + " : é obrigatório.\n");
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return msg.length()>0?new Exception(msg.toString()):null;
	}
	
}
