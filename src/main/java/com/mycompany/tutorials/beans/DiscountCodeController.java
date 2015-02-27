package com.mycompany.tutorials.beans;

import com.mycompany.tutorials.entities.DiscountCode;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "discountCodeController")
@ViewScoped
public class DiscountCodeController extends AbstractController<DiscountCode> {

    @Inject
    private CustomerController customerListController;

    public DiscountCodeController() {
        super(DiscountCode.class);
    }

    public String navigateCustomerList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Customer_items", this.getSelected().getCustomerList());
        }
        return "/customer/index";
    }

}
