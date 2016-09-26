package com.hotelbooking.equalexperts.pages;

import com.hotelbooking.equalexperts.model.HotelBooking;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("http://hotel-test.equalexperts.io/")
public class HotelBookingPage extends PageObject {

    @FindBy(id="firstname")
    private WebElementFacade firstname;

    @FindBy(id="lastname")
    private WebElementFacade surname;

    @FindBy(id="totalprice")
    private WebElementFacade price;

    @FindBy(id="depositpaid")
    private WebElementFacade deposit;

    @FindBy(id="checkin")
    private WebElementFacade checkin;

    @FindBy(id="checkout")
    private WebElementFacade checkout;

    @FindBy(css="input[value=' Save '")
    private WebElementFacade save;

    public void enterBookingDetails(HotelBooking booking){
        firstname.typeAndTab(booking.getFirstname());
        surname.typeAndTab(booking.getSurname());
        price.typeAndTab(booking.getPrice());
        deposit.sendKeys(booking.getDeposit());
        checkin.typeAndTab(booking.getCheckin());
        checkout.typeAndTab(booking.getCheckout());
    }

    public void addTheBooking(HotelBooking booking) {
        save.click();
        waitForAllTextToAppear(booking.getFirstname(), booking.getSurname(), booking.getPrice());
    }

    public List<HotelBooking> getbookings() {
        List<HotelBooking> listOfBookings = new ArrayList<HotelBooking>();
        WebElement bookings = getDriver().findElement(By.id("bookings"));
        List<WebElement> list = bookings.findElements(By.className("row"));

        for(int i=2;i<=list.size();i++){
            String firstname = findBy("//body/div/div[2]/div["+i+"]/div[1]").getText();
            String surname = findBy("//body/div/div[2]/div["+i+"]/div[2]").getText();
            String price = findBy("//body/div/div[2]/div["+i+"]/div[3]").getText();
            String deposit = findBy("//body/div/div[2]/div["+i+"]/div[4]").getText();
            String checkin = findBy("//body/div/div[2]/div["+i+"]/div[5]").getText();
            String checkout = findBy("//body/div/div[2]/div["+i+"]/div[6]").getText();
            HotelBooking booking = new HotelBooking(firstname, surname, price, deposit,checkin,checkout);
            listOfBookings.add(booking);
        }

        return listOfBookings;
    }

    public void deleteThatBooking(HotelBooking booking) {
        int index = 0;
        List<HotelBooking> bookings = getbookings();
        for(int i =0;i<bookings.size();i++){
            if(bookings.get(i).equals(booking)){
                 index = i+2;
                 break;
            }
        }
        findBy("//body/div/div[2]/div["+index+"]/div[7]").click();
    }
}