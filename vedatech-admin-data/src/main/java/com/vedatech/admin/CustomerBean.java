package com.vedatech.admin;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;


//@Setter
//@Getter
//@Entity
//
// @Table(name = "customer_bean")
public class CustomerBean extends PersonBean implements Customer{


    private String customerNo;
  	private long loyaltyPoints;
  	private String mailingAddress;

    public CustomerBean() {
    }

    public CustomerBean(final String firstName, final String lastName, final Date birthDate, final Boolean married, final Integer numberOfKids, final String favouriteQuote, final String email, final String customerNo, final long loyaltyPoints, final String mailingAddress) {
        super(firstName, lastName, birthDate, married, numberOfKids, favouriteQuote, email);
        this.customerNo = customerNo;
        this.loyaltyPoints = loyaltyPoints;
        this.mailingAddress = mailingAddress;
    }


    @Override
 	public boolean equals(final Object obj) {
         		if( this == obj ) {
             			return true;
             		}
         		if( !super.equals(obj) ) {
            			return false;
             		}
        if( !(obj instanceof CustomerBean) ) {
             			return false;
             		}
         		CustomerBean other = (CustomerBean) obj;
         		if( customerNo == null ) {
             			if( other.customerNo != null ) {
                 				return false;
                 			}
             		} else if( !customerNo.equals(other.customerNo) ) {
             			return false;
             		}
         		if( loyaltyPoints != other.loyaltyPoints ) {
             			return false;
             		}
         		if( mailingAddress == null ) {
             			if( other.mailingAddress != null ) {
                 				return false;
                 			}
             		} else if( !mailingAddress.equals(other.mailingAddress) ) {
             			return false;
             		}
         		return true;
         	}

    @Override
 	public int hashCode() {
         		final int prime = 31;
         		int result = super.hashCode();
        		result = prime * result + ((customerNo == null) ? 0 : customerNo.hashCode());
         		result = prime * result + (int) (loyaltyPoints ^ (loyaltyPoints >>> 32));
         		result = prime * result + ((mailingAddress == null) ? 0 : mailingAddress.hashCode());
         		return result;
         	}

    @Override
    public String toString() {
        return String
        			.format(
                 				"CustomerBean [customerNo=%s, firstName=%s, lastName=%s, birthDate=%s, mailingAddress=%s, married=%s, numberOfKids=%s, favouriteQuote=%s, email=%s, loyaltyPoints=%s]",
                 				customerNo, getFirstName(), getLastName(), getBirthDate(), mailingAddress, getMarried(),
                 				getNumberOfKids(), getFavouriteQuote(), getEmail(), loyaltyPoints);
    }

    @Override
    public String getCustomerNo() {
        System.out.println("RETURN getter CUSTOMERNO");
        return customerNo;
    }

    @Override
    public void setCustomerNo(String customerNo) {
        System.out.println("CUSTOMER NO SETTER");
            this.customerNo = customerNo;

    }

    @Override
    public long getLoyaltyPoints() {
        return 0;
    }

    @Override
    public void setLoyaltyPoints(long loyaltyPoints) {

    }

    @Override
    public String getMailingAddress() {
        return null;
    }

    @Override
    public void setMailingAddress(String mailingAddress) {

    }
}
