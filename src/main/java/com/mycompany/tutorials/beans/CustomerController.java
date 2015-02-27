package com.mycompany.tutorials.beans;

import com.mycompany.tutorials.entities.Customer;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "customerController")
@ViewScoped
public class CustomerController extends AbstractController<Customer> {

    @Inject
    private MicroMarketController zipController;
    @Inject
    private DiscountCodeController discountCodeController;
    @Inject
    private PurchaseOrderController purchaseOrderListController;

    public CustomerController() {
        super(Customer.class);
    }

    public void prepareZip(ActionEvent event) {
        if (this.getSelected() != null) {
            zipController.setSelected(this.getSelected().getZip());
        }
    }

    public void prepareDiscountCode(ActionEvent event) {
        if (this.getSelected() != null) {
            discountCodeController.setSelected(this.getSelected().getDiscountCode());
        }
    }

    public String navigatePurchaseOrderList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PurchaseOrder_items", this.getSelected().getPurchaseOrderList());
        }
        return "/purchaseOrder/index";
    }

}
