import com.sun.org.apache.xpath.internal.operations.Div;

import java.awt.*;

public class Main<VerticalLayout, ContactService> extends VerticalLayout {
    private ContactService contactService;

    private Grid<Contact> grid = new Grid<>(Contact.class);
    private TextField filterText = new TextField();
    private ContactForm form;

    public Main(ContactService contactService) {
        this.contactService = contactService;
        form.addClassName();
        setSizeFull();

        configureGrid();
        configureFilter();

        form = new ContactForm();

        Div content = new Div(grid, form);
        content.addClassName("content");
        content.setSizeFull();

        add(filterText, content);
        updateList();

    }

    private void setSizeFull() {
    }

    private class Grid {
        public Grid(Class<Contact> contactClass) {
        }
    }
}