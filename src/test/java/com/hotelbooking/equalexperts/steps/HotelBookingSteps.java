package com.hotelbooking.equalexperts.steps;

import com.hotelbooking.equalexperts.model.HotelBooking;
import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.*;

import com.hotelbooking.equalexperts.steps.serenity.EndUserSteps;

public class HotelBookingSteps {

    @Steps
    EndUserSteps user;

    @Given("I am on the hotel booking page")
    public void the_user_on_the_hotel_booking_page() {
        user.is_the_home_page();
    }

    @When("^I enter the following details$")
    public void the_user_enters_the_following_details(List<HotelBooking> data) throws Throwable {
        HotelBooking booking = data.get(0);
        user.enters_booking_details(booking);
    }

    @When("^would like to make the hotel booking$")
    public void the_user_would_like_to_make_the_booking() throws Throwable {
      user.make_the_booking();
    }

    @Then("^the booking should be added to the list$")
    public void the_booking_should_be_added_to_the_list() throws Throwable {
        user.booking_should_be_in_list();
    }

    @When("^I delete that booking$")
    public void the_user_delete_that_booking() throws Throwable {
    user.delete_that_booking();
    }

    @Then("^the booking should be deleted from the list$")
    public void the_booking_should_be_deleted_from_the_list() throws Throwable {
        user.booking_should_be_deleted_from_list();
    }
}