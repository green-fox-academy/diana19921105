package com.greenfox.basicwebshop.controller;

import com.greenfox.basicwebshop.model.Currency;
import com.greenfox.basicwebshop.model.Filter;
import com.greenfox.basicwebshop.model.ShopItem;
import com.greenfox.basicwebshop.model.Type;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Controller
public class WebshopController {

    private List<ShopItem> items;
    private List<Filter> filters;

    public WebshopController() {
        items = new ArrayList<>();
        filters = new ArrayList<>();
        items.add(new ShopItem("Nike", "Running shoe", (double) 1000L, 0, Currency.CZK, Type.CLOTHES_AND_SHOES));
        items.add(new ShopItem("Running shoes", "Nike shoe in different colors", (double) 1000L, 10, Currency.CZK, Type.CLOTHES_AND_SHOES));
        items.add(new ShopItem("Printer", "Some HP printer that makes its job", (double) 3000L, 10, Currency.CZK, Type.ELECTRONICS));
        items.add(new ShopItem("Coca cola", "Delicious cola", (double) 10L, 100, Currency.CZK, Type.BEVERAGES_AND_SNACKS));
        items.add(new ShopItem("Wokin", "Chicken with fried rice and WOKIN sauce", (double) 119L, 1, Currency.CZK, Type.BEVERAGES_AND_SNACKS));
        items.add(new ShopItem("T-shirt", "Blue with a corgi", (double) 300L, 1, Currency.CZK, Type.CLOTHES_AND_SHOES));

        filters.add(new Filter("Brand"));
        filters.add(new Filter("Product Color"));
        filters.add(new Filter("Most wanted"));
    }

    @GetMapping("/webshop")
    public String landingPage(Model model) {
        model.addAttribute("items", items);
        return "index";
    }
//
//    @GetMapping("/only-available")
//    public String onlyAvailable(Model model) {
//        model.addAttribute("items", items.stream()
//                .filter(i -> i.getQuantity() > 0)
//                .collect(Collectors.toList()));
//        return "index";
//    }
//
//    @GetMapping("/cheapest-first")
//    public String cheapestFirst(Model model) {
//        model.addAttribute("items", items.stream()
//                .sorted(Comparator.comparing(ShopItem::getPrice))
//                .collect(Collectors.toList()));
//        return "index";
//    }
//
//    @GetMapping("/contains-nike")
//    public String containsNike(Model model) {
//        model.addAttribute("items", items.stream()
//                .filter(item -> item.getName().toLowerCase().contains("nike") || item.getDescription().toLowerCase().contains("nike"))
//                .collect(Collectors.toList()));
//
//        return "index";
//    }
//
//    @GetMapping("/average-stock")
//    public String averageStock(Model model) {
//        OptionalDouble optionalDouble = getAverage();
//        String average = "Average Stock: ";
//        if (optionalDouble.isPresent()) {
//            model.addAttribute("average", average + String.format("%.1f", optionalDouble.getAsDouble()));
//        }
//        return "average";
//    }

//    @GetMapping("/most-expensive")
//    public String getMostExpensive(Model model) {
//        Optional<String> mostExpensiveName = getMostExpensive();
//        String string = "The most expensive item is: ";
//        mostExpensiveName.ifPresent(s -> model.addAttribute("mostExpensiveName", string + s));
//        return "average";
//    }

    @PostMapping("/search")
    public String search(@RequestParam String search, Model model) {
        List<ShopItem> collect = searchItem(search);
        model.addAttribute("items", collect);

        return "index";
    }

    @GetMapping("/shop-items")
    public String getShopItems(@RequestParam Type type, Model model) {
        List<ShopItem> filteredList = getFilterByType(type);
        model.addAttribute("items", filteredList);
        return "index";
    }

    @GetMapping("/more-filters")
    public String moreFilters(Model model) {
        model.addAttribute("filters", filters);
        return "filters";
    }

    @GetMapping("/price-in-eur")
    public String getPriceInEur(Model model) {
        List<ShopItem> list = changePrice(Currency.EUR);
        model.addAttribute("items", list);

        return "index";
    }

    @GetMapping("/price-in-original")
    public String priceInOriginal(Model model) {
        model.addAttribute("items", items);
        return "index";
    }

    @PostMapping("/filter-by-price")
    public String filterByPrice(@RequestParam Double price,
                                @RequestParam(required = false) String exactly,
                                @RequestParam(required = false) String above,
                                @RequestParam(required = false) String below,
                                Model model) {
        if (exactly != null) {
            model.addAttribute("items", getFilterByPrice(i -> i.getPrice().equals(price)));
        } else if (above != null) {
            model.addAttribute("items", getFilterByPrice(i -> i.getPrice() > price));
        } else if (below != null){
            model.addAttribute("items", getFilterByPrice(i -> i.getPrice() < price));
        } else {
            throw new IllegalArgumentException("Bad parameter!");
        }
        return "index";
    }


    private OptionalDouble getAverage() {
        return items.stream()
                .mapToDouble(ShopItem::getQuantity)
                .average();
    }

    private Optional<String> getMostExpensive() {
        return items.stream()
                .max(Comparator.comparing(ShopItem::getPrice))
                .map(ShopItem::getName);
    }

    private List<ShopItem> searchItem(String str) {
        return items.stream()
                .filter(i -> i.getQuantity() > 0)
                .filter(i -> i.getName().toLowerCase().contains(str.toLowerCase()) || i.getDescription().toLowerCase().contains(str.toLowerCase()))
                .collect(Collectors.toList());
    }

    private List<ShopItem> getFilterByType(Type type) {
        return items.stream()
                .filter(i -> i.getType().equals(type))
                .collect(Collectors.toList());
    }

    private List<ShopItem> changePrice(Currency currency) {
        List<ShopItem> changedCurrency = items.stream()
                .map(i -> new ShopItem(i.getName(), i.getDescription(), i.getPrice() * currency.getRate(), i.getQuantity(), currency, i.getType()))
                .collect(Collectors.toList());

        return changedCurrency;
    }

    private List<ShopItem> getFilterByPrice(Predicate<ShopItem> filter) {
        return items.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }
}
