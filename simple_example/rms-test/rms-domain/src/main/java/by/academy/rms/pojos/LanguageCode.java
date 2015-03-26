package by.academy.rms.pojos;

import java.io.Serializable;
import java.util.Set;

public class LanguageCode implements Serializable {

    private Long id;
    private String language;
    private String countryCode;
    private String langCode;

    private Set< PagePropertyValue > pagePropertyValues;
    private Set< Property > properties;

    public LanguageCode() {

    }

    public Long getId() {

	return id;
    }

    public void setId( Long id ) {

	this.id = id;
    }

    public String getLangCode() {

	return langCode;
    }

    public void setLangCode( String langCode ) {

	this.langCode = langCode;
    }

    public String getCountryCode() {

	return countryCode;
    }

    public void setCountryCode( String countryCode ) {

	this.countryCode = countryCode;
    }

    public String getLanguage() {

	return language;
    }

    public void setLanguage( String language ) {

	this.language = language;
    }

    public Set< PagePropertyValue > getPagePropertyValues() {

	return pagePropertyValues;
    }

    public void setPagePropertyValues( Set< PagePropertyValue > pagePropertyValues ) {

	this.pagePropertyValues = pagePropertyValues;
    }

    public Set< Property > getProperties() {

	return properties;
    }

    public void setProperties( Set< Property > properties ) {

	this.properties = properties;
    }

    @Override
    public boolean equals( Object o ) {

	if ( this == o )
	    return true;

	if ( o == null || getClass() != o.getClass() )
	    return false;

	LanguageCode that = ( LanguageCode ) o;

	if ( !countryCode.equals( that.countryCode ) )
	    return false;

	if ( !id.equals( that.id ) )
	    return false;

	if ( !langCode.equals( that.langCode ) )
	    return false;

	if ( !language.equals( that.language ) )
	    return false;

	return true;
    }

    @Override
    public int hashCode() {

	int result = id.hashCode();

	result = 31 * result + language.hashCode();
	result = 31 * result + countryCode.hashCode();
	result = 31 * result + langCode.hashCode();

	return result;
    }

    @Override
    public String toString() {

	return "LanguageCode {" + " id = " + id +
	       ", language = " + language +
	       ", countryCode = " + countryCode +
	       ", langCode = " + langCode + " }";
    }
}
