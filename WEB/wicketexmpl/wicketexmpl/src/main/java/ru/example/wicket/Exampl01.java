package ru.example.wicket;

import java.util.ArrayList;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;

public class Exampl01 extends BasePage {

	private int counter = 0;
	private Label linkLabel;
	private ArrayList<String> messages; // список строк
	private TextField inputText;
	private String inText = "";
	private String outText = "";

	/**
	 * Get the value of inText
	 *
	 * @return the value of inText
	 */
	public String getInText() {
		return inText;
	}

	/**
	 * Set the value of inText
	 *
	 * @param inText
	 *            new value of inText
	 */
	public void setInText(String inText) {
		this.inText = inText;
	}

	public Exampl01() {
		// если список еще не существует, то создаем его
		if (messages == null)
			messages = new ArrayList();
		add(new Label("message", "Пример 1"));
		add(new AjaxFallbackLink("link") {
			@Override
			public void onClick(AjaxRequestTarget target) {
				counter++;
				if (target != null) {
					target.add(linkLabel);
				}
			}
		});
		linkLabel = new Label("linkLabel", new PropertyModel(this, "counter"));
		linkLabel.setOutputMarkupId(true);
		add(linkLabel);
		Form echoForm = new Form("echoForm");
		inputText = new TextField("inputText", new PropertyModel(this, "inText"));
		echoForm.add(inputText);
		echoForm.add(new Button("sendButton") {
			@Override
			public void onSubmit() {
				// добавляем строку в список
				messages.add(getInText());
				setInText("");
			}
		});
		add(echoForm);
		
		// Добавляем список (строки в таблицу)
		add(new ListView("messages", messages) {
			
			@Override
			// этот метод выполняется для каждого элемента списка
			protected void populateItem(ListItem item) {
				// получаем объект списка
				String text = (String) item.getModelObject();
				// Добавляем текст в столбец таблицы
				item.add(new Label("post", text));
				// Добавляем ссылку
				item.add(new Link("deleteLink", item.getModel()) {
					@Override
					// переопределяем метод для обработки перехода по ссылке
					public void onClick() {
						// получаем строку (объект) с которой связана ссылка
						String selected = (String) getModelObject();
						// определяем индекс объекта в списке
						int pos = messages.indexOf(selected);
						// удаляем из списка объект (строку) если он там
						// присутствует
						if (pos >= 0)
							messages.remove(pos);
					}
				});
			}
		});
	}
}
