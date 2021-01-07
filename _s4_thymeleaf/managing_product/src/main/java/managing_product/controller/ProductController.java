package managing_product.controller;

import managing_product.model.Product;
import managing_product.repository.ProductRepositoryImpl;
import managing_product.repository.Repository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    Repository<Product> repository = new ProductRepositoryImpl();

    @GetMapping("/")
    public String getPageList(Model model){
        List<Product> productList = repository.getAll();
        model.addAttribute("productList", productList);
        return "/list";
    }

    @GetMapping("/product/{id}/detail")
    public String getPageView(@PathVariable int id, Model model){
        Product product = repository.findById(id);
        model.addAttribute("product", product);
        return "/detail";
    }

    @GetMapping("/product/{id}/remove")
    public String getPageRemove(@PathVariable int id, Model model){
        Product product = repository.findById(id);
        model.addAttribute("product", product);
        return "/remove";
    }

    @GetMapping("/product/create")
    public String getCreatePage( Model model){
//        return new ModelAndView("/create", "product1", new Product());
        Product product = new Product();
        model.addAttribute("product", product);
        return "/create";
    }

    @PostMapping("/create")
    public String saveProduct(Product product, RedirectAttributes redirectAttributes, Model model){
        repository.saveToList(product);
        redirectAttributes.addFlashAttribute("success", "Add successful");
        return "redirect:/";
    }

    @PostMapping("/product/remove")
    public String removeProduct(Product product, RedirectAttributes redirectAttributes){
        repository.removeById(product.getIdProduct());
        redirectAttributes.addFlashAttribute("success", "Removed successful");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/edit")
    public String getUpdatePage(@PathVariable int id, Model model){
        Product product = repository.findById(id);
        model.addAttribute("product", product);
        return "/edit";
    }

    @PostMapping("/edit")
    public String updateProduct(Product product, RedirectAttributes redirectAttributes){
        repository.updateToList(product);
        redirectAttributes.addFlashAttribute("success","Update "+product.getNameProduct()+" success");
        return "redirect:/";
    }




//__+__+__+__+__+__+__+__+__+__+__
//__+__+__+__+__+__+__+__+__+__+__
}
