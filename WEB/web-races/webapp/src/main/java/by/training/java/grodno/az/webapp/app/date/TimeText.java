package by.training.java.grodno.az.webapp.app.date;

import java.util.Date;

import org.apache.wicket.datetime.DateConverter;
import org.apache.wicket.datetime.StyleDateConverter;
import org.apache.wicket.datetime.markup.html.form.DateTextField;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.extensions.yui.calendar.TimeField;
import org.apache.wicket.model.IModel;

import com.googlecode.wicket.kendo.ui.form.datetime.TimePicker;

public class TimeText extends TimeField {

	
	public TimeText(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}


	public TimeText(String id, IModel<Date> model) {
		super(id, model);
		// TODO Auto-generated constructor stub
	}

	TimePicker timePicker = new TimePicker("time") {
		
	};
//		@Override
//		protected String getAdditionalJavaScript() {
//			return "${calendar}.cfg.setProperty(\"navigator\",true,false); ${calendar}.render();";
//		}
//	};

	@Override
	public void onInitialize() {
		super.onInitialize();
		timePicker.setEnabled(true);
//		timePicker.setShowOnFieldClick(true);
//		timePicker.setAutoHide(true);
		this.add(timePicker);
		this.setRequired(true);
	};

}
