package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DefaultUrl("https://magento.softwaretestingboard.com/proteus-fitness-jackshirt.html")
public class ProductDetailsPage extends PageObject {
    @FindBy(css = ".swatch-option.text")
    private List<WebElementFacade> sizeSelects;

    @FindBy(css = ".swatch-option.color")
    private List<WebElementFacade> colorSelects;

    @FindBy(css = "div.control input.input-text.qty")
    private WebElementFacade quantityInput;

    @FindBy(css = "button[title='Add to Cart']")
    private WebElementFacade addToCartButton;

    @FindBy(css = "#tab-label-reviews-title")
    private WebElementFacade reviewPageButton;

    public void consent() {
        find("button.fc-cta-consent p.fc-button-label").click();
    }
    public void select_size(int idx) {
        sizeSelects.get(idx).click();
    }

    public void check_size_error() {
        assertThat("This is a required field.", is(find("div#super_attribute\\[143\\]-error").getText()));
    }

    public void check_color_error() {
        assertThat(
                "This is a required field.",
                is(find("div#super_attribute\\[93\\]-error").getText())
        );
    }

    public void check_lower_quantity_error() {
        assertThat(
                "Please enter a quantity greater than 0.",
                is(find("#qty-error").getText())
        );
    }

    public void check_higher_quality_error() {
        assertThat(
                "The maximum you may purchase is 10000.",
                is(find("#qty-error").getText())
        );
    }

    public void check_add_to_cart_success_message() {
        assertThat(
                "You added Proteus Fitness Jackshirt to your shopping cart.",
                is(find(".message-success.success.message").getText())
        );
    }

    public void select_color(int idx) {
        colorSelects.get(idx).click();
    }

    public void input_quantity(int quantity) {
        quantityInput.type(String.valueOf(quantity));
    }

    public void add_to_cart() {
        addToCartButton.click();
    }

    public void go_to_reviews() {
        reviewPageButton.click();
    }

    public void assign_rating(int rating) {
        find("#Rating_" + rating + "_label").click();
    }

    public void set_nickname(String nickname) {
        find("#nickname_field").type(nickname);
    }

    public void set_summary(String summary) {
        find("#summary_field").type(summary);
    }

    public void set_review(String review) {
        find("#review_field").type(review);
    }

    public void submit_review() {
        find("div.primary.actions-primary button.action.submit.primary").click();
    }

    public void check_rating_error() {
        assertThat(
                "Please select one of each of the ratings above.",
                is(find("#ratings\\[4\\]-error").getText())
        );
    }

    public void check_nickname_error() {
        assertThat(
                "This is a required field.",
                is(find("#nickname_field-error").getText())
        );
    }

    public void check_summary_error() {
        assertThat(
                "This is a required field.",
                is(find("#summary_field-error").getText())
        );
    }

    public void check_review_error() {
        assertThat(
                "This is a required field.",
                is(find("#review_field-error").getText())
        );
    }

    public void check_review_success_message() {
        assertThat(
                "You submitted your review for moderation.",
                is(find(".message-success.success.message").getText())
        );
    }
}
