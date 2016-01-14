package by.training.java.grodno.az.webapp.page.admin.hourseracingpage;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import by.training.java.grodno.az.data.model.HourseRacing;
import by.training.java.grodno.az.service.HourseRacingService;
import by.training.java.grodno.az.webapp.page.abstractpage.AbstractPage;
import by.training.java.grodno.az.webapp.page.admin.coefficientpage.CoefficientEditPage;
import by.training.java.grodno.az.webapp.page.admin.coefficientpage.SelectCoefficient;
import by.training.java.grodno.az.webapp.page.admin.racinglinepage.RacingLineEditParticipantPage;
import by.training.java.grodno.az.webapp.page.admin.racinglinepage.RacingLineResultEditPage;
import by.training.java.grodno.az.webapp.page.resultpage.ResultPage;

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
				item.add(new Label("id", hourseRacing.getId()));
				item.add(new Label("title", hourseRacing.getTitle()));
				item.add(new Label("date", hourseRacing.getDate()));

				item.add(new AdminLink("hourse-racing-edit-link") {
					@Override
					public void onClick() {
						setResponsePage(new HourseRacingEditPage(hourseRacing));
					}
				});

				item.add(new AdminLink("hourse-racing-delete-link") {

					@Override
					public void onClick() {
						racingService.delete(hourseRacing);
						setResponsePage(HourseRacingPage.class);
					}
				});

				item.add(new AdminLink("racing-line-edit-link") {

					@Override
					public void onClick() {
						setResponsePage(new RacingLineEditParticipantPage(hourseRacing));
					}
				});

				item.add(new AdminLink("racing-result-edit-link") {

					@Override
					public void onClick() {
						setResponsePage(new RacingLineResultEditPage(hourseRacing));
					}
				});

				item.add(new AdminLink("coefficients-edit-link") {

					@Override
					public void onClick() {
						setResponsePage(new CoefficientEditPage(hourseRacing));
					}
				});

				item.add(new Link("select-coefficients-link") {

					@Override
					public void onClick() {
						if (hourseRacing.getDate().after(new Date())) {
							setResponsePage(new SelectCoefficient(hourseRacing));
						} else {
							setResponsePage(new ResultPage(hourseRacing));
						}
					}
				});

			}
		});

		add(new AdminLink("hourse-racing-create-link") {
			@Override
			public void onClick() {
				setResponsePage(new HourseRacingEditPage());
			}
		});
	}

	@AuthorizeAction(roles = { "admin" }, action = Action.RENDER)
	private class AdminLink extends Link<Void> {
		private static final long serialVersionUID = 1L;

		public AdminLink(String id) {
			super(id);
		}

		@Override
		public void onClick() {
		}

	}

}
