package com.hotelbooking.equalexperts.steps.serenity;

import com.hotelbooking.equalexperts.model.HotelBooking;
import com.hotelbooking.equalexperts.pages.HotelBookingPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps extends ScenarioSteps {

    HotelBookingPage hotelBookingPage;

    HotelBooking bookingObject;

    @Step
    public void is_the_home_page() {
        hotelBookingPage.open();
    }

    @Step
    public void make_the_booking(){
        hotelBookingPage.addTheBooking(bookingObject);
    }

    @Step
    public void enters_booking_details(HotelBooking booking){
        bookingObject = booking;
        hotelBookingPage.enterBookingDetails(booking);
    }

    @Step
    public void booking_should_be_in_list() {
        assertThat(hotelBookingPage.getbookings(), hasItem(bookingObject));
    }

    @Step
    public void delete_that_booking() {
        hotelBookingPage.deleteThatBooking(bookingObject);
    }

    @Step
    public void booking_should_be_deleted_from_list() { 
        assertThat(hotelBookingPage.getbookings(), not(hasItem(bookingObject)));
    }
}