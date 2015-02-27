package com.mycompany.tutorials.beans;

import com.mycompany.tutorials.entities.PurchaseOrder;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@Named(value = "purchaseOrderController")
@ViewScoped
public class PurchaseOrderController extends AbstractController<PurchaseOrder> {

    @Inject
    private ProductController productIdController;
    @Inject
    private CustomerController customerIdController;

    public PurchaseOrderController() {
        super(PurchaseOrder.class);
    }

    public void prepareProductId(ActionEvent event) {
        if (this.getSelected() != null) {
            productIdController.setSelected(this.getSelected().getProductId());
        }
    }

    public void prepareCustomerId(ActionEvent event) {
        if (this.getSelected() != null) {
            customerIdController.setSelected(this.getSelected().getCustomerId());
        }
    }

    public void handleDateSelect(SelectEvent event) {
        RequestContext.getCurrentInstance().execute("PF('widgetList').filter()");
    }

}
