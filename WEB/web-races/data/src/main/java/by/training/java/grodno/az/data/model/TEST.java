package by.training.java.grodno.az.data.model;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TEST<T> {

	public static void main(String[] args) {

		TEST<Player> test = new TEST<>();
		Player p = new Player();
		p.setBalance(200.0);
//		test.getMapAtributes(p);

//	}
//
//	private Map<String, Object> getMapAtributes(T entity) {
//		Map<String, Object> result = new HashMap<>();
//		Method[] fields = entity.getClass().getMethods();
//
//		for (Field f : fields) {
//			f.setAccessible(true);
//			try {
//				System.out.println(f.get(entity));
//			} catch (IllegalArgumentException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//		System.out.println(result);
//		System.out.println(fields.length);
//		return result;
//	}

	// private Object getField(T entity,String fieldName){
	// Object result=null;
	//
	 }

}
