package org.example.features.details;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.example.steps.serenity.UserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class DetailsPageTestCases {
    String nickname = "Nicky";
    String summary = "Positive Review";
    String review = "Very good.\nHighly recommended.";
    int rating = 1;
    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @Steps
    public UserSteps user;

    @Test
    public void testEmptySize() {
        user.is_the_details_page();
        user.consent();
        user.selects_color(0);
        user.inputs_quantity(1);
        user.adds_to_cart();
        user.sees_size_error();
    }

    @Test
    public void testEmptyColor() {
        user.is_the_details_page();
        user.consent();
        user.selects_size(0);
        user.inputs_quantity(1);
        user.adds_to_cart();
        user.sees_color_error();
    }

    @Test
    public void testSmallQuantity() {
        user.is_the_details_page();
        user.consent();
        user.selects_size(0);
        user.selects_color(0);
        user.inputs_quantity(0);
        user.adds_to_cart();
        user.sees_low_quantity_error();
    }

    @Test
    public void testLargeQuantity() {
        user.is_the_details_page();
        user.consent();
        user.selects_size(0);
        user.selects_color(0);
        user.inputs_quantity(10001);
        user.adds_to_cart();
        user.sees_high_quantity_error();
    }

    @Test
    public void testCorrectAddToCartData() {
        user.is_the_details_page();
        user.consent();
        user.selects_size(0);
        user.selects_color(0);
        user.inputs_quantity(1);
        user.adds_to_cart();
        user.sees_add_to_cart_success_message();
    }

    @Test
    public void testEmptyRating() {
        user.is_the_details_page();
        user.consent();
        user.goes_to_reviews();
        user.sets_nickname(nickname);
        user.sets_summary(summary);
        user.sets_review(review);
        user.submits_review();
        user.sees_rating_error();
    }

    @Test
    public void testEmptyNickname() {
        user.is_the_details_page();
        user.consent();
        user.goes_to_reviews();
        user.assigns_rating(rating);
        user.sets_summary(summary);
        user.sets_review(review);
        user.submits_review();
        user.sees_nickname_error();
    }

    @Test
    public void testEmptySummary() {
        user.is_the_details_page();
        user.consent();
        user.goes_to_reviews();
        user.assigns_rating(rating);
        user.sets_nickname(nickname);
        user.sets_review(review);
        user.submits_review();
        user.sees_summary_error();
    }

    @Test
    public void testEmptyReview() {
        user.is_the_details_page();
        user.consent();
        user.goes_to_reviews();
        user.assigns_rating(rating);
        user.sets_nickname(nickname);
        user.sets_summary(summary);
        user.submits_review();
        user.sees_review_error();
    }

    @Test
    public void testCorrectReview() {
        user.is_the_details_page();
        user.consent();
        user.goes_to_reviews();
        user.assigns_rating(rating);
        user.sets_nickname(nickname);
        user.sets_summary(summary);
        user.sets_review(review);
        user.submits_review();
        user.sees_review_success_message();
    }
}
