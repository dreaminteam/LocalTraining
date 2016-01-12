package by.training.java.grodno.az.webapp.page.admin.hourseracingpage;

import java.util.Date;

import javax.inject.Inject;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.extensions.yui.calendar.DateTimeField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.StringValidator;

import by.training.java.grodno.az.data.model.HourseRacing;
import by.training.java.grodno.az.service.HourseRacingService;
import by.training.java.grodno.az.webapp.page.abstractpage.AbstractPage;

@AuthorizeInstantiation(value = { "admin" })
public class HourseRacingEditPage extends AbstractPage {
	private static final long serialVersionUID = 1L;

	@Inject
	private HourseRacingService hourseRacingService;

	private HourseRacing hourseRacing;

	public HourseRacingEditPage() {
		super();
		this.hourseRacing = new HourseRacing();
	}

	public HourseRacingEditPage(HourseRacing hourseRacing) {
		super();
		this.hourseRacing = hourseRacing;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		Form<HourseRacing> form = new Form<>("hourse-racing-edit-form", new CompoundPropertyModel<>(hourseRacing));
		add(form);

		TextField<String> titleTextField = new TextField<String>("title");
		titleTextField.setRequired(true);
		titleTextField.add(StringValidator.maximumLength(45));
		form.add(titleTextField);

		Model<Date> dateModel = new Model<Date>();

		DateTimeField dateTimeField = new DateTimeField("dateTimeField", dateModel);
		form.add(dateTimeField);

		form.add(new SubmitLink("hourse-racing-submit-button") {
			@Override
			public void onSubmit() {

				hourseRacing.setDate(dateModel.getObject());
				hourseRacingService.insertOrUpdate(hourseRacing);
				HourseRacingEditPage editPage = new HourseRacingEditPage();
				editPage.info(getString("all.data.saved"));
				setResponsePage(editPage);

			};
		});
		add(new Link<Void>("hourse-racing-page-link") {
			@Override
			public void onClick() {
				setResponsePage(HourseRacingPage.class);
			}
		});
	}

}