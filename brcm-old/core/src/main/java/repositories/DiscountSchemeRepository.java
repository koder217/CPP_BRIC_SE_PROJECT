package repositories;

import entities.Discountscheme;

import java.util.List;

public interface DiscountSchemeRepository {
    Discountscheme AddDiscount(Discountscheme discountscheme);
    void DeleteDiscount(int id);
    List<Discountscheme> getAllDiscounts();
    void UpdateDiscount(Discountscheme discountscheme);
}
