package ics499.group4.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Tracking")
@Route(value = "tracking")
public class CustomerView extends VerticalLayout {
	private static final long serialVersionUID = -9218051678695853157L;
	
	public CustomerView() {
		setSizeFull();
		setPadding(false);
		setSpacing(false);
		
		//setting up header
		Header header = new Header("Delivery Tracking");
		
		// Tracking Label
		H1 tracking = new H1("Track Packages");

		// setting up tracking
		TextField trackingNumber = new TextField();
		trackingNumber.setLabel("Tracking Number");
		TextField zipCode = new TextField();
		zipCode.setLabel("ZIP code");
		Button trackButton = new Button("Track");

		// show tracking info if button is clicked
		H2 trackingInfo = new H2();
		H2 deliveryInfo = new H2();
		Button cancelButton = new Button("Cancel");
		Button rescheduleButton = new Button("Reschedule");
		
		cancelButton.setVisible(false);
		rescheduleButton.setVisible(false);
		
		trackButton.getElement().addEventListener("click",
				event -> {					
					trackingInfo.setText("Tracking Number: " + trackingNumber.getValue());
					deliveryInfo.setText("Expected Delivery mm/dd/yyyy at hh:mm");
					cancelButton.setVisible(true);
					rescheduleButton.setVisible(true);
				});

		// container for textfields
		HorizontalLayout hl = new HorizontalLayout();
		hl.setAlignItems(FlexComponent.Alignment.BASELINE);
		hl.add(trackingNumber, zipCode, trackButton);
		hl.setSizeFull();
		
		//container for buttons
		HorizontalLayout buttons = new HorizontalLayout(cancelButton, rescheduleButton);

		// Container for tracking form
		VerticalLayout trackingContent = new VerticalLayout();
		trackingContent.add(tracking, hl, trackingInfo, deliveryInfo, buttons);
		trackingContent.setSizeFull();

		add(header, trackingContent, new Footer());
		
	}
}
