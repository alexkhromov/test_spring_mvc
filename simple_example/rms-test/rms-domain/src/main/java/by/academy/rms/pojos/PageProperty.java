package by.academy.rms.pojos;

import java.io.Serializable;
import java.util.Set;

public class PageProperty implements Serializable {

    private  Long id;

    private Property property;
    private Page page;
    private Set< PagePropertyValue > pagePropertyValues;

    public PageProperty() {

    }

    public Long getId() {

	return id;
    }

    public void setId( Long id ) {

	this.id = id;
    }

    public Property getProperty() {

	return property;
    }

    public void setProperty( Property property ) {

	this.property = property;
    }

    public Page getPage() {

	return page;
    }

    public void setPage( Page page ) {

	this.page = page;
    }

    public Set< PagePropertyValue > getPagePropertyValues() {

	return pagePropertyValues;
    }

    public void setPagePropertyValues( Set< PagePropertyValue > pagePropertyValues ) {

	this.pagePropertyValues = pagePropertyValues;
    }

    @Override
    public boolean equals( Object o ) {

	if ( this == o )
	    return true;

	if ( o == null || getClass() != o.getClass() )
	    return false;

	PageProperty that = ( PageProperty ) o;

	if ( !id.equals( that.id ) )
	    return false;

	return true;
    }

    @Override
    public int hashCode() {

	return id.hashCode();
    }

    @Override
    public String toString() {

	return "PageProperty {" +" id = " + id +" }";
    }
}
