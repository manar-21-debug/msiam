package ma.bkam.msiam.common.utils;


import ma.bkam.msiam.common.exceptions.InvalidInputsException;

import java.util.List;
import java.util.Set;

/**
 * The type Utilities.
 *  @author Alae Eddine Manar
 */
public class Utilities {

    private Utilities() {}


    /**
     * Is null or empty boolean.
     *
     * @param input the input
     * @return the boolean
     */
    public static boolean isNullOrEmpty(String input) {
        return !(input != null && !input.trim().isEmpty());
    }


    /**
     * Is null or empty boolean.
     *
     * @param list the list
     * @return the boolean
     */
    public static boolean isNullOrEmpty(List<?> list) {
        return !(list != null && !list.isEmpty());
    }


    /**
     * Is null or empty boolean.
     *
     * @param list the list
     * @return the boolean
     */
    public static boolean isNullOrEmpty(Set<?> list) {
        return !(list != null && !list.isEmpty());
    }


    /**
     * Is overflow boolean.
     *
     * @param input     the input
     * @param maxLength the max length
     * @return the boolean
     */
    public static boolean isOverflow(String input, int maxLength) {
        return !(!isNullOrEmpty(input) && input.length() <= maxLength);
    }

    public static boolean isValidLong(Long number) {
        return number != null && number >= 0L;
    }


    /**
     * Raise error invalid inputs exception.
     *
     * @param message the message
     * @return the invalid inputs exception
     */
    public static InvalidInputsException raiseError(String message) {
        return new InvalidInputsException(message);
    }

    public static boolean isValidDouble(Double price) {
        return price != null && price >= 0.0;
    }


    public static String removeDuplicatedHttps(String host){
        return host.substring(8,host.length());
    }

}

