package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import entidades.Produto;

public class TesteReflection {
	
	public static void main(String[] args) {
		Class classeProduto = Produto.class;
		Field[] atributos = classeProduto.getDeclaredFields();
		for (Field atributo : atributos) {
			System.out.println(atributo.getName());
		}
		Method[] metodos = classeProduto.getDeclaredMethods();
		for (Method metodo : metodos) {
			String info = metodo.getReturnType().getName() + " "
					+ metodo.getName();
			info += "( ";
			for (int i = 0; i < metodo.getParameterTypes().length; i++) {
				info += " " + metodo.getParameterTypes()[i].getName();
				info += " arg"
						+ i
						+ (i < metodo.getParameterTypes().length - 1 ? " , "
								: "");
			}
			info += " ) ";
			System.out.println(info);
		}
	}
}
