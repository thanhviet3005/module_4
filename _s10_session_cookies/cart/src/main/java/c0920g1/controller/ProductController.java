package c0920g1.controller;

import c0920g1.model.Item;
import c0920g1.model.Product;
import c0920g1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
@SessionAttributes("carts")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("carts")
    public List<Item> item(){
        return new ArrayList<>();
    }

    @GetMapping("")
    public ModelAndView getPageProduct(){
        List<Product> productList = productService.findAll();
        return new ModelAndView("/product/ListProduct", "productList", productList);
    }

    @GetMapping("/create")
    public ModelAndView getPageCreateProduct(){
        Product product = new Product();
        String code = Math.round(Math.random()*1000) + "";
        product.setProductCode(code);
        ModelAndView modelAnddView = new ModelAndView("/product/CreateProduct"
                , "product", product);
        code = null;
        return modelAnddView;
    }

    @PostMapping("/create")
    public String saveProduct(@ModelAttribute Product product
            , RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("statusmsg", "Create product success");
        return "redirect:/product";
    }

    @GetMapping("/{id}/detail")
    public ModelAndView getPageDetail(@PathVariable int id){
        Product product = productService.findById(id);
        Item item = new Item();
        item.setProduct(product);
        ModelAndView modelAndView = new ModelAndView("/product/DetailProduct"
                , "item", item);
        return modelAndView;
    }

    @PostMapping("/buy")
    public ModelAndView saveProductToCart(@ModelAttribute(name = "carts") List<Item> carts
            , @RequestParam(value = "quantity") int quantity
            , @RequestParam(value = "productId") int productId
            , RedirectAttributes redirectAttributes ){
        double totalPrice = 0;
        Product product = productService.findById(productId);
        Item item = new Item();
        item.setProduct(product);
        item.setQuantity(quantity);
        if(carts.size()==0){
            carts.add(item);
        }else{
            int index = -1;
            for (Item itemTemp :carts) {
                if(itemTemp.getProduct().getProductId() == product.getProductId()){
                    index = carts.indexOf(itemTemp);
                    carts.remove(itemTemp);
                    carts.add(index, item);
                    break;
                }
            }
            if (index==-1){
                carts.add(item);
            }
        }
        for (Item itemToPrice :carts) {
            totalPrice += itemToPrice.getQuantity() * itemToPrice.getProduct().getProductPrice();
        }
        ModelAndView modelAndView = new ModelAndView("/product/CartProduct");
        modelAndView.addObject("carts", carts);
        modelAndView.addObject("totalPrice", totalPrice);
        return modelAndView;
    }

    @GetMapping("/{id}/remove")
    public String removeProductInCart(@SessionAttribute(name = "carts") List<Item> carts
            , @PathVariable int id){
        int testId = id;
        for (Item item : carts) {
            if(item.getProduct().getProductId() == id) {
                carts.remove(item);
                break;
            }
        }
        return "/product/CartProduct";
    }

    @GetMapping("/removeAll")
    public String removeAllInCart(@SessionAttribute(name = "carts") List<Item> carts){
        carts.clear();
        return "/product/CartProduct";
    }



//____+____+____+____+____+____+____
}

