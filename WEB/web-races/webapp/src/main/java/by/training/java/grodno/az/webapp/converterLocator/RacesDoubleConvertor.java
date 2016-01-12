package by.training.java.grodno.az.webapp.converterLocator;

import java.util.Locale;

import org.apache.wicket.util.convert.converter.DoubleConverter;

public class RacesDoubleConvertor extends DoubleConverter{

	 @Override
	    public Double convertToObject(String value, Locale locale) {
	            value = value.replace('.', ',');
	        return super.convertToObject(value, locale);
	    }
	
}
