package by.training.java.grodno.az.webapp.page.admin.hourseRacing;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import by.training.java.grodno.az.data.model.HourseRacing;
import by.training.java.grodno.az.service.HourseRacingService;
import by.training.java.grodno.az.webapp.page.abstractPage.AbstractPage;
import by.training.java.grodno.az.webapp.page.admin.coefficientPage.CoefficientEditPage;
import by.training.java.grodno.az.webapp.page.admin.racingLinePage.RacingLineEditPage;
import by.training.java.grodno.az.webapp.page.admin.racingLinePage.RacingLineResultEditPage;

@AuthorizeInstantiation(value = { "admin" })
public class HourseRacingPage extends AbstractPage {

	private static final long serialVersionUID = 1L;

	@Inject
	private HourseRacingService racingService;

	@Override
	protected void onInitialize() {
		super.onInitialize();
		List<HourseRacing> allHourseRacings = racingService.getAll();

		add(new ListView<HourseRacing>("hourse-racing-list", allHourseRacings) {
			@Override
			protected void populateItem(ListItem<HourseRacing> item) {
				
				final HourseRacing hourseRacing = item.getModelObject();
				item.add(new Label("id",hourseRacing.getId()));
				item.add(new Label("title",hourseRacing.getTitle()));
				item.add(new Label("date",hourseRacing.getDate()));

				item.add(new Link("hourse-racing-edit-link") {
					@Override
					public void onClick() {
						setResponsePage(new HourseRacingEditPage(hourseRacing));
					}
				});

				item.add(new Link("hourse-racing-delete-link") {

					@Override
					public void onClick() {
						racingService.delete(hourseRacing);
						setResponsePage(HourseRacingPage.class);
					}
				});
				
				item.add(new Link("racing-line-edit-link") {

					@Override
					public void onClick() {
						setResponsePage(new RacingLineEditPage(hourseRacing));
					}
				});
				
				item.add(new Link("racing-result-edit-link") {

					@Override
					public void onClick() {
						setResponsePage(new RacingLineResultEditPage(hourseRacing));
					}
				});
				
				item.add(new Link("coefficients-edit-link") {

					@Override
					public void onClick() {
						setResponsePage(new CoefficientEditPage(hourseRacing));
					}
				});

			}
		});

		add(new Link("hourse-racing-create-link") {
			@Override
			public void onClick() {
				setResponsePage(new HourseRacingEditPage());
			}
		});
	}

}
