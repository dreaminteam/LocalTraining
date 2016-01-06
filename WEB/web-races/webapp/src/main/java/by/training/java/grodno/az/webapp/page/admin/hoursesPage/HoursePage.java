package by.training.java.grodno.az.webapp.page.admin.hoursesPage;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import by.training.java.grodno.az.data.model.Hourse;
import by.training.java.grodno.az.data.model.Jockey;
import by.training.java.grodno.az.service.HourseService;
import by.training.java.grodno.az.service.JockeyService;
import by.training.java.grodno.az.webapp.page.abstractPage.AbstractPage;

@AuthorizeInstantiation(value = { "admin" })
public class HoursePage extends AbstractPage {

	private static final long serialVersionUID = 1L;

	@Inject
	private HourseService hourseService;

	@Override
	protected void onInitialize() {
		super.onInitialize();
		List<Hourse> allUsers = hourseService.getAll();

		add(new ListView<Hourse>("hourses-list", allUsers) {
			@Override
			protected void populateItem(ListItem<Hourse> item) {
				
				final Hourse hourse = item.getModelObject();
				item.add(new Label("id",hourse.getId()));
				item.add(new Label("name",hourse.getName()));

				item.add(new Link("hourse-edit-link") {
					@Override
					public void onClick() {
						setResponsePage(new HourseEditPage(hourse));
					}
				});

				item.add(new Link("hourse-delete-link") {

					@Override
					public void onClick() {
						hourseService.delete(hourse);
						setResponsePage(HoursePage.class);
					}
				});
				
			}
		});

		add(new Link("hourse-create-link") {
			@Override
			public void onClick() {
				setResponsePage(new HourseEditPage());
			}
		});
	}

}
