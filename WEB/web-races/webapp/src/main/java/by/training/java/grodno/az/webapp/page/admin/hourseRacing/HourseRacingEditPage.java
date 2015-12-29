package by.training.java.grodno.az.webapp.page.admin.hourseRacing;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.extensions.yui.calendar.DateTimeField;
import org.apache.wicket.extensions.yui.calendar.TimeField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.StringValidator;

import com.googlecode.wicket.kendo.ui.form.datetime.DateTimePicker;

import by.training.java.grodno.az.data.model.HourseRacing;
import by.training.java.grodno.az.service.HourseRacingService;
import by.training.java.grodno.az.webapp.app.date.DateText;
import by.training.java.grodno.az.webapp.app.date.TimeText;
import by.training.java.grodno.az.webapp.page.abstractPage.AbstractPage;

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

	// public HourseRacingEditPage(HourseRacing hourseRacing) {
	// super();
	// this.hourseRacing = hourseRacing;
	// }

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
		 DateTimeField date=new DateTimeField("date1",dateModel);
		 form.add(date);

		DateText dateField = new DateText("date", dateModel);
		dateField.setRequired(true);
		form.add(dateField);


		// final DateTimePicker datetimepicker = new
		// DateTimePicker("datetimepicker", dateModel, "dd MMM yyyy", "HH:mm");
		// form.add(datetimepicker);

		// TimePicker //
		Calendar calendar = Calendar.getInstance();
		calendar.set(2013, 05, 27, 02, 00);

		final DateTimePicker datetimepicker = new DateTimePicker("datetimepicker", Model.of(calendar.getTime()));
		form.add(datetimepicker);

		//
		// DateTextField dateTextField = new DateTextField("date",
		// new StyleDateConverter("S-", true));
		// form.add(dateTextField);
		// DatePicker datePicker = new DatePicker() {
		// @Override
		// protected String getAdditionalJavaScript() {
		// return "${calendar}.cfg.setProperty(\"navigator\",true,false);
		// ${calendar}.render();";
		// }
		// };
		// datePicker.setShowOnFieldClick(true);
		// datePicker.setAutoHide(true);
		// dateTextField.add(datePicker);
		//
		// dateTextField.setRequired(true);

		form.add(new SubmitLink("hourse-racing-submit-button") {
			@Override
			public void onSubmit() {

				hourseRacing.setDate(dateModel.getObject());
				hourseRacingService.insertOrUpdate(hourseRacing);
				HourseRacingEditPage editPage = new HourseRacingEditPage();
				System.out.println(new Date());
				System.out.println(dateModel.getObject().toString());
				editPage.info("hourse racing saved");
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
