package by.academy.rms.dao.exceptions;

public enum DaoErrorCode {

    RMS_DAO_000( "Cannot get %s by id = %s" ),
    RMS_DAO_001( "Cannot get list of <%s>" ),
    RMS_DAO_002( "Cannot create object %s" ),
    RMS_DAO_003( "Cannot update object %s" ),
    RMS_DAO_004( "Cannot delete object %s" ),
    RMS_DAO_005( "Cannot create criteria for type %s" ),
    RMS_DAO_006( "Cannot create hql: %s" );

    private final String value;

    private DaoErrorCode( String s ) {

        value = s;
    }

    public boolean equalsValue( String value2 ) {

        return ( value2 != null ) && value.equals( value2 );
    }

    public String toString() {

        return value;
    }
}