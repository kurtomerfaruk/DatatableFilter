package com.mycompany.tutorials.beans;

import com.mycompany.tutorials.entities.MicroMarket;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "microMarketController")
@ViewScoped
public class MicroMarketController extends AbstractController<MicroMarket> {

    @Inject
    private CustomerController customerListController;

    public MicroMarketController() {
        super(MicroMarket.class);
    }

    public String navigateCustomerList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Customer_items", this.getSelected().getCustomerList());
        }
        return "/customer/index";
    }

}
