package com.mycompany.tutorials.beans;

import com.mycompany.tutorials.entities.Manufacturer;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "manufacturerController")
@ViewScoped
public class ManufacturerController extends AbstractController<Manufacturer> {

    @Inject
    private ProductController productListController;

    public ManufacturerController() {
        super(Manufacturer.class);
    }

    public String navigateProductList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Product_items", this.getSelected().getProductList());
        }
        return "/product/index";
    }

}
