package by.training.java.grodno.az.webapp.page.ratelinepage;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import by.training.java.grodno.az.data.model.Jockey;
import by.training.java.grodno.az.data.model.RateLine;
import by.training.java.grodno.az.service.JockeyService;
import by.training.java.grodno.az.service.RateLineService;
import by.training.java.grodno.az.webapp.page.abstractpage.AbstractPage;
import by.training.java.grodno.az.webapp.page.admin.coefficientpage.CoefficientEditPage;
import by.training.java.grodno.az.webapp.page.admin.coefficientpage.CoefficientsPage;

@AuthorizeInstantiation(value = { "admin" })
public class RateLinePage extends AbstractPage {

	private static final long serialVersionUID = 1L;

	@Inject
	private RateLineService rateLineService;

	@Override
	protected void onInitialize() {
		super.onInitialize();
		List<RateLine> rateLines = rateLineService.getAll();

		add(new ListView<RateLine>("rate-line-list", rateLines) {
			@Override
			protected void populateItem(ListItem<RateLine> item) {

				final RateLine rateLine = item.getModelObject();
				item.add(new Label("id", rateLine.getId()));
				item.add(new Label("title", rateLine.getTitle()));
				item.add(new Label("description", rateLine.getDescription()));

				item.add(new Link("rate-line-edit-link") {
					@Override
					public void onClick() {
						setResponsePage(new RateLineEditPage(rateLine));
					}
				});

				item.add(new Link("rate-line-delete-link") {

					@Override
					public void onClick() {
						rateLineService.delete(rateLine);
						setResponsePage(RateLinePage.class);
					}
				});

			}
		});

		add(new Link("rate-line-create-link") {
			@Override
			public void onClick() {
				if (rateLines.size() < CoefficientEditPage.MAXQUANTITY) {
					setResponsePage(new RateLineEditPage());
				} else {
					AbstractPage responsePage=new RateLinePage();
					warn(getString("all.tableRecords.limit"));
					setResponsePage(responsePage);
				}
			}
		});
	}

}
