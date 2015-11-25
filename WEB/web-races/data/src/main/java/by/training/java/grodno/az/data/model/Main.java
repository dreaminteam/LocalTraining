package by.training.java.grodno.az.data.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public  class Main extends GenericDao<UserTest> {
    public static void main(String[] args) {
        Main test = new Main();
        UserTest p = new UserTest();
        p.setId(2);
        p.setLogin("login");
        p.setPassword("password");
        p.setFirstName("firstName");
        p.setLastName("lastName");
        p.setCreateDate(new Date());
        test.getMapAtributes(p);
    }
}


class GenericDao<T> {

    private Class<T> classOfObjectClass;

    public GenericDao() {
        classOfObjectClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    private Class<T> getGenericType() {
        return classOfObjectClass;
    }

    protected Map<String, Object> getMapAtributes(T entity) {
        Map<String, Object> result = new HashMap<>();
        Method[] methods = entity.getClass().getMethods();
        String str;
        for (Method m : methods) {
            if (m.getName().indexOf("get") == 0 && m.getName() != "getClass") {
                str = m.getName();
                try {
                    try {
						result.put(getFieldName(str), entity.getClass().getMethod(str, null).invoke(entity, null));
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                } catch (NoSuchMethodException | SecurityException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(result);
        return result;
    }

    private String getFieldName(String str) {
        StringBuilder sb = new StringBuilder(str.substring(3));
        char c = sb.charAt(0);
        sb.setCharAt(0, Character.toLowerCase(c));
        return sb.toString();
    }

}

class UserTest extends AbstractEntity {

	private int id;
	private String login;
	private String password;
	private String firstName;
	private String lastName;
	private Date createDate;
	private Date endDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", createDate=" + createDate + ", endDate=" + endDate + "]";
	}

}
