package by.training.java.grodno.az.webapp.app.date;

import java.util.Date;

import org.apache.wicket.datetime.DateConverter;
import org.apache.wicket.datetime.StyleDateConverter;
import org.apache.wicket.datetime.markup.html.form.DateTextField;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.extensions.yui.calendar.TimeField;
import org.apache.wicket.model.IModel;
import org.joda.time.DateTimeFieldType;

public class DateText extends DateTextField {

	
	
	public DateText(String id){
		super(id,new StyleDateConverter("S-", true));
	}
	
	public DateText(String id,IModel<Date> model){
		super(id,model,new StyleDateConverter("S-", true));
	}
	
	public DateText(String id, DateConverter converter) {
		super(id, converter);
	}

	DatePicker datePicker = new DatePicker() {
		@Override
		protected String getAdditionalJavaScript() {
			return "${calendar}.cfg.setProperty(\"navigator\",true,false); ${calendar}.render();";
		}
	};

	@Override
	public void onInitialize() {
		super.onInitialize();
		datePicker.setShowOnFieldClick(true);
		datePicker.setAutoHide(true);
		this.add(datePicker);
		this.setRequired(true);
	};

}
