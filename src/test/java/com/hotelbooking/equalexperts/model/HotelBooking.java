package com.hotelbooking.equalexperts.model;

/**
 * Created by cheet_000 on 17-Sep-16.
 */
public class HotelBooking {
    private String firstname;

    public String getSurname() {
        return surname;
    }

    public String getPrice() {
        return price;
    }

    public String getDeposit() {
        return deposit;
    }

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    private String surname;
    private String price;
    private String deposit;
    private String checkin;
    private String checkout;

    public HotelBooking(String firstname, String surname, String price, String deposit, String checkin, String checkout) {
        this.firstname = firstname;
        this.surname=surname;
        this.price=price;
        this.deposit=deposit;
        this.checkin=checkin;
        this.checkout=checkout;
    }

    public String getFirstname() {
        return firstname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotelBooking that = (HotelBooking) o;

        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (deposit != null ? !deposit.equals(that.deposit) : that.deposit != null) return false;
        if (checkin != null ? !checkin.equals(that.checkin) : that.checkin != null) return false;
        return checkout != null ? checkout.equals(that.checkout) : that.checkout == null;

    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (deposit != null ? deposit.hashCode() : 0);
        result = 31 * result + (checkin != null ? checkin.hashCode() : 0);
        result = 31 * result + (checkout != null ? checkout.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HotelBooking{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", price='" + price + '\'' +
                ", deposit='" + deposit + '\'' +
                ", checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
