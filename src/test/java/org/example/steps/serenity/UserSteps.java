package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.ProductDetailsPage;

public class UserSteps {
    ProductDetailsPage detailsPage;

    @Step
    public void consent() {
        detailsPage.consent();
    }
    @Step
    public void is_the_details_page() {
        detailsPage.open();
    }

    @Step
    public void selects_size(int idx) {
        detailsPage.select_size(idx);
    }
    @Step
    public void selects_color(int idx) {
        detailsPage.select_color(idx);
    }
    @Step
    public void inputs_quantity(int quantity) {
        detailsPage.input_quantity(quantity);
    }
    @Step
    public void adds_to_cart() {
        detailsPage.add_to_cart();
    }

    @Step
    public void sees_size_error() {
        detailsPage.check_size_error();
    }

    @Step
    public void sees_color_error() {
        detailsPage.check_color_error();
    }

    @Step
    public void sees_low_quantity_error() {
        detailsPage.check_lower_quantity_error();
    }

    @Step
    public void sees_high_quantity_error() {
        detailsPage.check_higher_quality_error();
    }

    @Step
    public void sees_add_to_cart_success_message() {
        detailsPage.check_add_to_cart_success_message();
    }

    @Step
    public void goes_to_reviews() {
        detailsPage.go_to_reviews();
    }

    @Step
    public void assigns_rating(int rating) {
        detailsPage.assign_rating(rating);
    }

    @Step
    public void sets_nickname(String nickname) {
        detailsPage.set_nickname(nickname);
    }

    @Step
    public void sets_summary(String summary) {
        detailsPage.set_summary(summary);
    }

    @Step
    public void sets_review(String review) {
        detailsPage.set_review(review);
    }

    @Step
    public void submits_review() {
        detailsPage.submit_review();
    }

    @Step
    public void sees_rating_error() {
        detailsPage.check_rating_error();
    }

    public void sees_nickname_error() {
        detailsPage.check_nickname_error();
    }

    @Step
    public void sees_summary_error() {
        detailsPage.check_summary_error();
    }

    @Step
    public void sees_review_error() {
        detailsPage.check_review_error();
    }

    @Step
    public void sees_review_success_message() {
        detailsPage.check_review_success_message();
    }
}
