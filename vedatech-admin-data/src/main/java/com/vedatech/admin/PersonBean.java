package com.vedatech.admin;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.Objects;


//@Getter
//@Setter
//@MappedSuperclass
public class PersonBean {

    private String firstName;
  	private String lastName;
  	private Date birthDate;
  	private Boolean married;
  	private Integer numberOfKids;
  	private String favouriteQuote;
  	private String email;

    public PersonBean() {
    }

    public PersonBean(final String firstName, final String lastName, final Date birthDate, final Boolean married, final Integer numberOfKids, final String favouriteQuote, final String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.married = married;
        this.numberOfKids = numberOfKids;
        this.favouriteQuote = favouriteQuote;
        this.email = email;
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Boolean getMarried() {
		return married;
	}

	public void setMarried(Boolean married) {
		this.married = married;
	}

	public Integer getNumberOfKids() {
		return numberOfKids;
	}

	public void setNumberOfKids(Integer numberOfKids) {
		this.numberOfKids = numberOfKids;
	}

	public String getFavouriteQuote() {
		return favouriteQuote;
	}

	public void setFavouriteQuote(String favouriteQuote) {
		this.favouriteQuote = favouriteQuote;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
 	public boolean equals(Object obj) {
         		if( this == obj ) {
             			return true;
             		}
         		if( obj == null ) {
             			return false;
             		}
         		if( !(obj instanceof PersonBean) ) {
             			return false;
             		}
         		PersonBean other = (PersonBean) obj;
         		if( birthDate == null ) {
             			if( other.birthDate != null ) {
                 				return false;
                 			}
             		} else if( !birthDate.equals(other.birthDate) ) {
             			return false;
             		}
         		if( email == null ) {
             			if( other.email != null ) {
                				return false;
                			}
             		} else if( !email.equals(other.email) ) {
             			return false;
             		}
         		if( favouriteQuote == null ) {
             			if( other.favouriteQuote != null ) {
                 				return false;
                 			}
             		} else if( !favouriteQuote.equals(other.favouriteQuote) ) {
             			return false;
             		}
         		if( firstName == null ) {
             			if( other.firstName != null ) {
                 				return false;
                 			}
            		} else if( !firstName.equals(other.firstName) ) {
             			return false;
             		}
         		if( lastName == null ) {
             			if( other.lastName != null ) {
                 				return false;
                 			}
             		} else if( !lastName.equals(other.lastName) ) {
             			return false;
             		}
         		if( married == null ) {
             			if( other.married != null ) {
                 				return false;
                 			}
             		} else if( !married.equals(other.married) ) {
             			return false;
             		}
         		if( numberOfKids == null ) {
             			if( other.numberOfKids != null ) {
                 				return false;
                 			}
            		} else if( !numberOfKids.equals(other.numberOfKids) ) {
             			return false;
             		}
         		return true;
         	}

    @Override
 	public int hashCode() {
       final int prime = 31;
         		int result = 1;
         		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
         		result = prime * result + ((email == null) ? 0 : email.hashCode());
         		result = prime * result + ((favouriteQuote == null) ? 0 : favouriteQuote.hashCode());
         		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
         		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
         		result = prime * result + ((married == null) ? 0 : married.hashCode());
         		result = prime * result + ((numberOfKids == null) ? 0 : numberOfKids.hashCode());
         		return result;
         	}


    @Override
 	public String toString() {
         		return String
         			.format(
                 				"PersonBean [firstName=%s, lastName=%s, birthDate=%s, married=%s, numberOfKids=%s, favouriteQuote=%s, email=%s]",
                 				firstName, lastName, birthDate, married, numberOfKids, favouriteQuote, email);
         	}
}
