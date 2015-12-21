package by.training.java.grodno.az.webapp.app;

import javax.inject.Inject;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;

import by.training.java.grodno.az.data.model.User;
import by.training.java.grodno.az.service.UserService;

public class CustomSession extends AuthenticatedWebSession {

	private static final long serialVersionUID = 1L;

	@Inject
	private UserService userService;

	private Integer currentUserId;

	private String fullName;

	private Roles roles;

	public CustomSession(Request request) {
		super(request);
		Injector.get().inject(this);
	}

	public static CustomSession get() {
		return (CustomSession) Session.get();
	}

	@Override
	protected boolean authenticate(String login, String password) {
		if (userService == null) {
			throw new IllegalArgumentException("user service is null");
		}
		User user = userService.getByLogPas(login, password);

		if (user != null) {
			currentUserId = user.getId();
			roles=new Roles();
			roles.add(user.getRole());
			fullName = String.format("%s %s", user.getFirstName(), user.getLastName());
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void signOut() {
		super.signOut();
		currentUserId = null;
		fullName = null;
		roles = null;
	}

	@Override
	public Roles getRoles() {
		if (currentUserId == null) {
			return null;
		}

		return roles;
	}

	public int getCurrentuserid() {
		return currentUserId;
	}

	public String getFullName() {
		return fullName;
	}

}
