package hello;

import com.github.appreciated.card.ClickableCard;
import com.github.appreciated.card.content.IconItem;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.UIDetachedException;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import java.util.Optional;

public class JobCard extends VerticalLayout {
    private UI ui;
    private ClickableCard card;
    private Image img;
    private JobPosting jobPosting;

    public JobCard(String imagePath, JobPosting jobPosting) {

        img = new Image(imagePath, "image");
        img.setWidth("50px");
        img.setHeight("50px");
        this.jobPosting = jobPosting;

        card = new ClickableCard(
                event -> showJobDetails(jobPosting), new IconItem(img, jobPosting.getName(), jobPosting.getDescription())
        );
        card.setWidth("80%");
        add(card);
    }

    public void showJobDetails(JobPosting jobPosting) {
        Dialog dialog = new Dialog();
        Button applyBtn = new Button("Apply");
        applyBtn.addClickListener(event -> {
            dialog.close();
            applyBtn.getUI().ifPresent(ui -> ui.navigate(JobApplyView.NAME));
        });
        dialog.add(new H2(jobPosting.getName() + " @ " + jobPosting.getCompany()),
                new Paragraph(jobPosting.getDescription()),
                applyBtn
        );
        dialog.open();
    }

}