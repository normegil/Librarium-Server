package be.normegil.librarium.util.parser.adapter.jaxb;

import be.normegil.librarium.util.DateHelper;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateTimeJAXBAdapter extends XmlAdapter<String, LocalDateTime> {

	private DateHelper dateHelper = new DateHelper();

	@Override
	public LocalDateTime unmarshal(final String date) throws Exception {
		if (date == null || date.isEmpty()) {
			return null;
		} else {
			return dateHelper.parseLocalDateTime(date);
		}
	}

	@Override
	public String marshal(final LocalDateTime date) throws Exception {
		if (date != null) {
			return dateHelper.format(date);
		} else {
			return null;
		}
	}
}