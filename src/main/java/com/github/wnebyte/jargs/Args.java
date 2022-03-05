package com.github.wnebyte.jargs;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import com.github.wnebyte.jarguments.Argument;
import static com.github.wnebyte.jarguments.ArgumentSupport.getByName;
import static com.github.wnebyte.jarguments.ArgumentSupport.getByIndex;

/**
 * This class represents a map of initialized Arguments.
 */
public class Args {

    /*
    ###########################
    #      STATIC METHODS     #
    ###########################
    */

    /**
     * Constructs a new instance using the specified <code>Collection</code> and <code>values</code>.
     * @param arguments a Collection of arguments.
     * @param values the initialized argument values.
     * @return a new instance.
     */
    static Args newInstance(Collection<Argument> arguments, Object[] values) {
        if (arguments == null || values == null) {
            return null;
        }
        Map<Argument, Object> map = new HashMap<>(values.length);
        for (int i = 0; i < values.length; i++) {
            Argument key = getByIndex(arguments, i);
            Object value = values[i];
            map.put(key, value);
        }
        return new Args(map);
    }

    public static ArgsParser parser(Configuration conf) {
        return new ArgsParser(conf);
    }

    public static ArgsParser parser() {
        return new ArgsParser();
    }

    /*
    ###########################
    #          FIELDS         #
    ###########################
    */

    private final Map<Argument, Object> values;

    /*
    ###########################
    #       CONSTRUCTORS      #
    ###########################
    */

    /**
     * Constructs a new instance using the specified <code>Map</code>.
     * @param values a map.
     */
    private Args(Map<Argument, Object> values){
        this.values = values;
    }

    private Args() {
        throw new UnsupportedOperationException(
                "This constructor should not be used."
        );
    }

    /**
     * Returns the (initialized) argument whose <code>Set</code> of names <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>boolean</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
     */
    public boolean getAsBoolean(final String name) {
        try {
            Argument argument = getByName(values.keySet(), name);
            return (boolean) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>boolean</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
     */
    public boolean getAsBoolean(final int index) {
        try {
            Argument argument = getByIndex(values.keySet(), index);
            return (boolean) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose <code>Set</code> of names <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>byte</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
     */
    public byte getAsByte(final String name) {
        try {
            Argument argument = getByName(values.keySet(), name);
            return (byte) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>byte</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
     */
    public byte getAsByte(final int index) {
        try {
            Argument argument = getByIndex(values.keySet(), index);
            return (byte) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose <code>Set</code> of names <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>char</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
     */
    public char getAsChar(final String name) {
        try {
            Argument argument = getByName(values.keySet(), name);
            return (char) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>char</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
     */
    public char getAsChar(final int index) {
        try {
            Argument argument = getByIndex(values.keySet(), index);
            return (char) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose <code>Set</code> of names <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>double</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
     */
    public double getAsDouble(final String name) {
        try {
            Argument argument = getByName(values.keySet(), name);
            return (double) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>double</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
     */
    public double getAsDouble(final int index) {
        try {
            Argument argument = getByIndex(values.keySet(), index);
            return (double) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose <code>Set</code> of names <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>float</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
     */
    public float getAsFloat(final String name) {
        try {
            Argument argument = getByName(values.keySet(), name);
            return (float) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>float</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
     */
    public float getAsFloat(final int index) {
        try {
            Argument argument = getByIndex(values.keySet(), index);
            return (float) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose <code>Set</code> of names <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>int</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
     */
    public int getAsInt(final String name) {
        try {
            Argument argument = getByName(values.keySet(), name);
            return (int) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>int</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
     */
    public int getAsInt(final int index) {
        try {
            Argument argument = getByIndex(values.keySet(), index);
            return (int) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose <code>Set</code> of names <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>long</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
     */
    public long getAsLong(final String name) {
        try {
            Argument argument = getByName(values.keySet(), name);
            return (long) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>long</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
     */
    public long getAsLong(final int index) {
        try {
            Argument argument = getByIndex(values.keySet(), index);
            return (long) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose <code>Set</code> of names <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>short</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
     */
    public short getAsShort(final String name) {
        try {
            Argument argument = getByName(values.keySet(), name);
            return (short) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>short</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
     */
    public short getAsShort(final int index) {
        try {
            Argument argument = getByIndex(values.keySet(), index);
            return (short) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose <code>Set</code> of names <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>String</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
     */
    public String getAsString(final String name) {
        try {
            Argument argument = getByName(values.keySet(), name);
            return (String) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>String</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
     */
    public String getAsString(final int index) {
        try {
            Argument argument = getByIndex(values.keySet(), index);
            return (String) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose <code>Set</code> of names <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>Object</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
     */
    public Object getAsObject(final String name) {
        try {
            Argument argument = getByName(values.keySet(), name);
            return values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>Object</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
     */
    public Object getAsObject(final int index) {
        try {
            Argument argument = getByIndex(values.keySet(), index);
            return values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose <code>Set</code> of names <code>contains</code> the specified <code>name</code>, as
     * an instance of the specified type <code>T</code>.
     * @param name the name of the argument.
     * @param type the type of the return value.
     * @param <T> the type.
     * @return the initialized argument.
     */
    @SuppressWarnings("unchecked")
    public <T> T get(final String name, final Class<T> type) {
        try {
            Argument argument = getByName(values.keySet(), name);
            return (T) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }

        /*
        try {
            Argument argument = getByName(map.keySet(), name);
            return type.cast(map.get(argument));
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
         */
    }

    /**
     * Returns the (initialized) argument whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>T</code>.
     * @param index the index of the argument.
     * @param type the type of the return value.
     * @param <T> the type.
     * @return the initialized argument.
     */
    @SuppressWarnings("unchecked")
    public <T> T get(final int index, final Class<T> type) {
        try {
            Argument argument = getByIndex(values.keySet(), index);
            return (T) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
        /*
        try {
            Argument argument = getByIndex(values.keySet(), index);
            return type.cast(values.get(argument));
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
         */
    }

    /**
     * Returns the (initialized) argument whose <code>Set</code> of names <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>T[]</code>.
     * @param name the name of the argument.
     * @param componentType the component type of the array to be returned.
     * @param <T> the type.
     * @return the initialized argument.
     */
    @SuppressWarnings("unchecked")
    public <T> T[] getAsArray(final String name, final Class<T> componentType) {
        try {
            Argument argument = getByName(values.keySet(), name);
            return (T[]) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>T[]</code>.
     * @param index the index of the argument.
     * @param componentType the component type of the Object to be returned.
     * @param <T> the type.
     * @return the initialized argument.
     */
    @SuppressWarnings("unchecked")
    public <T> T[] getAsArray(final int index, final Class<T> componentType) {
        try {
            Argument argument = getByIndex(values.keySet(), index);
            return (T[]) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose <code>Set</code> of names <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>boolean[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
     */
    public boolean[] getAsBooleanArray(final String name) {
        try {
            Argument argument = getByName(values.keySet(), name);
            return (boolean[]) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>boolean[]</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
     */
    public boolean[] getAsBooleanArray(final int index) {
        try {
            Argument argument = getByIndex(values.keySet(), index);
            return (boolean[]) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose <code>Set</code> of names <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>byte[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
     */
    public byte[] getAsByteArray(final String name) {
        try {
            Argument argument = getByName(values.keySet(), name);
            return (byte[]) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>byte[]</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
     */
    public byte[] getAsByteArray(final int index) {
        try {
            Argument argument = getByIndex(values.keySet(), index);
            return (byte[]) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose <code>Set</code> of names <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>char[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
     */
    public char[] getAsCharArray(final String name) {
        try {
            Argument argument = getByName(values.keySet(), name);
            return (char[]) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>char[]</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
     */
    public char[] getAsCharArray(final int index) {
        try {
            Argument argument = getByIndex(values.keySet(), index);
            return (char[]) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose <code>Set</code> of names <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>double[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
     */
    public double[] getAsDoubleArray(final String name) {
        try {
            Argument argument = getByName(values.keySet(), name);
            return (double[]) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>double[]</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
     */
    public double[] getAsDoubleArray(final int index) {
        try {
            Argument argument = getByIndex(values.keySet(), index);
            return (double[]) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose <code>Set</code> of names <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>float[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
     */
    public float[] getAsFloatArray(final String name) {
        try {
            Argument argument = getByName(values.keySet(), name);
            return (float[]) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>float[]</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
     */
    public float[] getAsFloatArray(final int index) {
        try {
            Argument argument = getByIndex(values.keySet(), index);
            return (float[]) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose <code>Set</code> of names <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>int[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
     */
    public int[] getAsIntArray(final String name) {
        try {
            Argument argument = getByName(values.keySet(), name);
            return (int[]) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>int[]</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
     */
    public int[] getAsIntArray(final int index) {
        try {
            Argument argument = getByIndex(values.keySet(), index);
            return (int[]) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose <code>Set</code> of names <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>long[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
     */
    public long[] getAsLongArray(final String name) {
        try {
            Argument argument = getByName(values.keySet(), name);
            return (long[]) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>long[]</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
     */
    public long[] getAsLongArray(final int index) {
        try {
            Argument argument = getByIndex(values.keySet(), index);
            return (long[]) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose <code>Set</code> of names <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>short[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
     */
    public short[] getAsShortArray(final String name) {
        try {
            Argument argument = getByName(values.keySet(), name);
            return (short[]) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) argument whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>short[]</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
     */
    public short[] getAsShortArray(final int index) {
        try {
            Argument argument = getByIndex(values.keySet(), index);
            return (short[]) values.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }
}