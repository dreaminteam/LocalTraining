package by.training.java.grodno.az.webapp.page.admin.racingLinePage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.model.Model;

import com.googlecode.wicket.kendo.ui.markup.html.link.BookmarkablePageLink;

import by.training.java.grodno.az.data.entities.RacingLineView;
import by.training.java.grodno.az.data.model.HourseRacing;
import by.training.java.grodno.az.data.model.RacingLine;
import by.training.java.grodno.az.service.RacingLineService;
import by.training.java.grodno.az.webapp.page.abstractPage.AbstractPage;
import by.training.java.grodno.az.webapp.page.admin.hourseRacing.HourseRacingPage;

@AuthorizeInstantiation(value = { "admin" })
public class RacingLineResultEditPage extends AbstractPage {
	private static final long serialVersionUID = 1L;

	@Inject
	private RacingLineService racingLineService;

	private HourseRacing hourseRacing;

	public RacingLineResultEditPage(HourseRacing hourseRacing) {
		super();
		this.hourseRacing = hourseRacing;
	}

	@SuppressWarnings("serial")
	@Override
	protected void onInitialize() {
		super.onInitialize();

		Map<String, Object> atributes = new HashMap<>();
		atributes.put("hourseRacingId", hourseRacing.getId());
		List<RacingLine> racings = racingLineService.getAll(atributes, "id", true);
		int listSize = racings.size();
		List<RacingLineView> racingLineViewList = new ArrayList<>(listSize);

		for (RacingLine rl : racings) {
			racingLineViewList.add(racingLineService.getView(rl));
		}
		List<Integer> positionListChoise = initNumberList(listSize);

		List<DropDownChoice<Integer>> dropDownFieldsdList = new ArrayList<>();
		List<Model<Integer>> modelsList = new ArrayList<>();
		List<Label> resultLabelsList = new ArrayList<>();

		for (int i = 0; i < RacingLineEditPage.maxParticipants; i++) {
			modelsList.add(new Model<Integer>());
			resultLabelsList.add(new Label("result-label-" + i, getParticipantView(racingLineViewList, i)));
			dropDownFieldsdList
					.add(new DropDownChoice<>("drop-result-field-" + i, modelsList.get(i), positionListChoise));
		}

		Form<Void> form = new Form<>("racing-line-result-edit-form");
		add(form);

		Label titleRacing = new Label("hourse-racing-title", hourseRacing.toString());
		form.add(titleRacing);

		for (DropDownChoice<Integer> ddc : dropDownFieldsdList) {
			ddc.setRequired(true);
			form.add(ddc);
		}

		for (Label label : resultLabelsList) {
			form.add(label);
		}

		for (int i = RacingLineEditPage.maxParticipants - 1; i >= listSize; i--) {
			dropDownFieldsdList.get(i).setVisible(false);
			resultLabelsList.get(i).setVisible(false);
		}

		form.add(new SubmitLink("racing-line-result-submit-button") {
			@Override
			public void onSubmit() {
				Set<Integer> checkSet = new HashSet<>();
				for (int i = 0; i < listSize; i++) {
					checkSet.add(modelsList.get(i).getObject().intValue());
				}
				System.out.println(checkSet.toString());
				if (checkSet.size() != listSize) {
					RacingLineResultEditPage editPage = new RacingLineResultEditPage(hourseRacing);
					editPage.warn(getString("page.inputResultRacing.warn"));
					setResponsePage(editPage);
				} else {

					RacingLine rLine;
					for (int i = 0; i < listSize; i++) {
						rLine = racings.get(i);
						rLine.setResult(modelsList.get(i).getObject());
						racingLineService.update(rLine);
					}

					RacingLineEditPage editPage = new RacingLineEditPage(hourseRacing);
					editPage.info(getString("all.data.saved"));
					setResponsePage(editPage);

				}
				;
			};
		});

		add(new BookmarkablePageLink<Void>("hourse-racing-page-link", HourseRacingPage.class));
	}

	private String getParticipantView(List<RacingLineView> source, int index) {
		if (index < source.size()) {
			return String.format("", source.get(index).getParticipantView().toString());
		}
		return "";
	}

	private List<Integer> initNumberList(int size) {
		List<Integer> resultList = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			resultList.add(i + 1);
		}
		return resultList;
	}
}
