package com.mycompany.tutorials.beans;

import com.mycompany.tutorials.entities.ProductCode;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "productCodeController")
@ViewScoped
public class ProductCodeController extends AbstractController<ProductCode> {

    @Inject
    private ProductController productListController;

    public ProductCodeController() {
        super(ProductCode.class);
    }

    public String navigateProductList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Product_items", this.getSelected().getProductList());
        }
        return "/product/index";
    }

}
