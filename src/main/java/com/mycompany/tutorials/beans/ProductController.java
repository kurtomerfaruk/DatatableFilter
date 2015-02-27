package com.mycompany.tutorials.beans;

import com.mycompany.tutorials.entities.Product;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "productController")
@ViewScoped
public class ProductController extends AbstractController<Product> {

    @Inject
    private ProductCodeController productCodeController;
    @Inject
    private ManufacturerController manufacturerIdController;
    @Inject
    private PurchaseOrderController purchaseOrderListController;

    public ProductController() {
        super(Product.class);
    }

    public void prepareProductCode(ActionEvent event) {
        if (this.getSelected() != null) {
            productCodeController.setSelected(this.getSelected().getProductCode());
        }
    }

    public void prepareManufacturerId(ActionEvent event) {
        if (this.getSelected() != null) {
            manufacturerIdController.setSelected(this.getSelected().getManufacturerId());
        }
    }

    public String navigatePurchaseOrderList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PurchaseOrder_items", this.getSelected().getPurchaseOrderList());
        }
        return "/purchaseOrder/index";
    }

}
