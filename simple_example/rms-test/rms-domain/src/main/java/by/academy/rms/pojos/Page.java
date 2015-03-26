package by.academy.rms.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

//@Transactional( propagation = Propagation.REQUIRED, readOnly = false )
public class Page implements Serializable {

    private Long id;
    private String name;
    private String description;
    private Date changeDate;

    private Set< PageProperty > pageProperties;

    public Page() {

    }

    public Long getId() {

	return id;
    }

    public void setId( Long id ) {

	this.id = id;
    }

    public String getName() {

	return name;
    }

    public void setName( String name ) {

	this.name = name;
    }

    public String getDescription() {

	return description;
    }

    public void setDescription( String description ) {

	this.description = description;
    }

    public Date getChangeDate() {

	return changeDate;
    }

    public void setChangeDate( Date changeDate ) {

	this.changeDate = changeDate;
    }

    public Set< PageProperty > getPageProperties() {

	return pageProperties;
    }

    public void setPageProperties( Set< PageProperty > pageProperties ) {

	this.pageProperties = pageProperties;
    }

    @Override
    public boolean equals( Object o ) {

	if ( this == o )
	    return true;

	if ( o == null || getClass() != o.getClass() )
	    return false;

	Page page = ( Page ) o;

	if ( !changeDate.equals( page.changeDate ) )
	    return false;

	if ( !description.equals( page.description ) )
	    return false;

	if ( !id.equals( page.id ) )
	    return false;

	if ( !name.equals( page.name ) )
	    return false;

	return true;
    }

    @Override
    public int hashCode() {

	int result = id.hashCode();

	result = 31 * result + name.hashCode();
	result = 31 * result + description.hashCode();
	result = 31 * result + changeDate.hashCode();

	return result;
    }

    @Override
    public String toString() {

	return "Page {" + " id = " + id + ", name = " + name +
	       ", description = " + description + ", changeDate = " + changeDate + " }";
    }
}
