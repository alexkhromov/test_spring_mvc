package by.academy.rms.pojos;

import java.io.Serializable;

public class PagePropertyValue implements Serializable {

    private String value;

    private LanguageCode languageCode;
    private PageProperty pageProperty;

    public PagePropertyValue() {

    }

    public String getValue() {

	return value;
    }

    public void setValue( String value ) {

	this.value = value;
    }

    public LanguageCode getLanguageCode() {

	return languageCode;
    }

    public void setLanguageCode( LanguageCode languageCode ) {

	this.languageCode = languageCode;
    }

    public PageProperty getPageProperty() {

	return pageProperty;
    }

    public void setPageProperty( PageProperty pageProperty ) {

	this.pageProperty = pageProperty;
    }

    @Override
    public boolean equals( Object o ) {

	if ( this == o )
	    return true;

	if ( o == null || getClass() != o.getClass() )
	    return false;

	PagePropertyValue that = ( PagePropertyValue ) o;

	if ( !value.equals( that.value ) )
	    return false;

	return true;
    }

    @Override
    public int hashCode() {

	return value.hashCode();
    }

    @Override
    public String toString() {

	return "PagePropertyValue {" + " value = " + value + " }";
    }
}
