package loopback.android.remoting;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;



public class BeanUtil {

	public static void setProperties(Object object,
			Map<String, ? extends Object> properties,
			boolean includeSuperClasses) {
		if (object == null || properties == null) {
			return;
		}

		Class objectClass = object.getClass();
		System.out.println("Ola Mundo Doido");
		
		Set<?> chaves = properties.keySet();
		for (Object chave : chaves) {
			String key = "" + chave;
			Object value = properties.get(chave);
			if (key == null)
				continue;
			if (key.length() == 0)
				continue;

			String setterName = "set" + Character.toUpperCase(key.charAt(0)) + key.substring(1);
			Method setter = null;

			
			if (value != null) {
				// String entrando aqui !!!!!
				try {
					if (includeSuperClasses) {
						setter = objectClass.getMethod(setterName, value.getClass());
					} else {
						setter = objectClass.getDeclaredMethod(setterName,value.getClass());
					}
				} catch (Exception ex) {
				}
			}
			

			
			if (setter == null) {
				Method[] methods = includeSuperClasses ? objectClass.getMethods() : objectClass.getDeclaredMethods();
				for (Method method : methods) {
					if (method.getName().equals(setterName)) {
						Class<?>[] parameterTypes = method.getParameterTypes();
						if (parameterTypes.length == 1
								&& isAssignableFrom(parameterTypes[0], value)) {
							setter = method;
							break;
						}
					}
				}
			}
			

			// Invoke
			
			if (setter != null) {
				if (setter.getAnnotation(Transient.class) != null)
					continue;

				try {
					setter.invoke(object, value);
				} catch (Exception e) {
					// Log.getLogger().severe("BeanUtil: " + setterName + "()
					// failed " + e.getMessage());
				}
			}
			
		}
	}

	public static Map<String, Object> getProperties(Object object,
			boolean includeSuperClasses, boolean deepCopy) {
		return null;
	}

	
	private static boolean isAssignableFrom(Class<?> parameterType, Object value) {
		if (parameterType.isPrimitive()) {
			if (value == null) {
				return false;
			}
			Class<?> valueClass = value.getClass();

			if (parameterType == Boolean.TYPE) {
				return valueClass == Boolean.class;
			} else if (parameterType == Byte.TYPE) {
				return valueClass == Byte.class;
			} else if (parameterType == Character.TYPE) {
				return valueClass == Character.class;
			} else if (parameterType == Short.TYPE) {
				return valueClass == Short.class || valueClass == Byte.class;
			} else if (parameterType == Integer.TYPE) {
				return valueClass == Integer.class
						|| valueClass == Character.class
						|| valueClass == Short.class
						|| valueClass == Byte.class;
			} else if (parameterType == Long.TYPE) {
				return valueClass == Long.class || valueClass == Integer.class
						|| valueClass == Character.class
						|| valueClass == Short.class
						|| valueClass == Byte.class;
			} else if (parameterType == Float.TYPE) {
				return valueClass == Float.class || valueClass == Long.class
						|| valueClass == Integer.class
						|| valueClass == Character.class
						|| valueClass == Short.class
						|| valueClass == Byte.class;
			} else if (parameterType == Double.TYPE) {
				return valueClass == Double.class || valueClass == Float.class
						|| valueClass == Long.class
						|| valueClass == Integer.class
						|| valueClass == Character.class
						|| valueClass == Short.class
						|| valueClass == Byte.class;
			} else {
				return false;
			}
		} else {
			return value == null
					|| parameterType.isAssignableFrom(value.getClass());
		}
	}
	
}
