package by.academy.rms.pojos;

import java.io.Serializable;
import java.util.Set;

public class Property implements Serializable {

    private Long id;
    private String name;
    private String defaultValue;

    private LanguageCode languageCode;
    private Set< PageProperty > pageProperties;

    public Property() {

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

    public String getDefaultValue() {

	return defaultValue;
    }

    public void setDefaultValue( String defaultValue ) {

	this.defaultValue = defaultValue;
    }

    public LanguageCode getLanguageCode() {

	return languageCode;
    }

    public void setLanguageCode( LanguageCode languageCode ) {

	this.languageCode = languageCode;
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

	Property property = ( Property ) o;

	if ( !defaultValue.equals( property.defaultValue ) )
	    return false;

	if ( !id.equals(property.id ) )
	    return false;

	if ( !name.equals( property.name ) )
	    return false;

	return true;
    }

    @Override
    public int hashCode() {

	int result = id.hashCode();

	result = 31 * result + name.hashCode();
	result = 31 * result + defaultValue.hashCode();

	return result;
    }

    @Override
    public String toString() {

	return "Property {" + " id = " + id +
	       ", name = " + name + ", defaultValue = " + defaultValue + " }";
    }
}
