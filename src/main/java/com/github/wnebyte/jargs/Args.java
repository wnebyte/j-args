package com.github.wnebyte.jargs;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import com.github.wnebyte.jarguments.Argument;
import static com.github.wnebyte.jarguments.ArgumentSupport.getByName;
import static com.github.wnebyte.jarguments.ArgumentSupport.getByIndex;

/**
 * This class represents an associative structure mapping instances of {@link Argument} to their
 * initialized values.
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
     * @param values an array of initialized values.
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

    public static ArgsParser parser(ArgsParserConfiguration conf) {
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

    private final Map<Argument, Object> map;

    /*
    ###########################
    #       CONSTRUCTORS      #
    ###########################
    */

    /**
     * Constructs a new instance using the specified <code>Map</code>.
     * @param map a Map.
     */
    private Args(Map<Argument, Object> map) {
        this.map = map;
    }

    private Args() {
        throw new UnsupportedOperationException(
                "This constructor should not be used."
        );
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose <code>Set</code> of names <code>contains</code>
     * the specified <code>name</code>, as an instance of type <code>boolean</code>.
     * @param name the name of the Argument.
     * @return the initialized Argument.
     */
    public boolean getAsBoolean(final String name) {
        try {
            Argument argument = getByName(map.keySet(), name);
            return (boolean) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>boolean</code>.
     * @param index the index of the Argument.
     * @return the initialized Argument.
     */
    public boolean getAsBoolean(final int index) {
        try {
            Argument argument = getByIndex(map.keySet(), index);
            return (boolean) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose <code>Set</code> of names <code>contains</code>
     * the specified <code>name</code>, as
     * an instance of type <code>byte</code>.
     * @param name the name of the Argument.
     * @return the initialized Argument.
     */
    public byte getAsByte(final String name) {
        try {
            Argument argument = getByName(map.keySet(), name);
            return (byte) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>byte</code>.
     * @param index the index of the Argument.
     * @return the initialized Argument.
     */
    public byte getAsByte(final int index) {
        try {
            Argument argument = getByIndex(map.keySet(), index);
            return (byte) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose <code>Set</code> of names <code>contains</code>
     * the specified <code>name</code>, as
     * an instance of type <code>char</code>.
     * @param name the name of the Argument.
     * @return the initialized Argument.
     */
    public char getAsChar(final String name) {
        try {
            Argument argument = getByName(map.keySet(), name);
            return (char) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>char</code>.
     * @param index the index of the Argument.
     * @return the initialized Argument.
     */
    public char getAsChar(final int index) {
        try {
            Argument argument = getByIndex(map.keySet(), index);
            return (char) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose <code>Set</code> of names <code>contains</code>
     * the specified <code>name</code>, as
     * an instance of type <code>double</code>.
     * @param name the name of the Argument.
     * @return the initialized Argument.
     */
    public double getAsDouble(final String name) {
        try {
            Argument argument = getByName(map.keySet(), name);
            return (double) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>double</code>.
     * @param index the index of the Argument.
     * @return the initialized Argument.
     */
    public double getAsDouble(final int index) {
        try {
            Argument argument = getByIndex(map.keySet(), index);
            return (double) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose <code>Set</code> of names <code>contains</code>
     * the specified <code>name</code>, as
     * an instance of type <code>float</code>.
     * @param name the name of the Argument.
     * @return the initialized Argument.
     */
    public float getAsFloat(final String name) {
        try {
            Argument argument = getByName(map.keySet(), name);
            return (float) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>float</code>.
     * @param index the index of the Argument.
     * @return the initialized Argument.
     */
    public float getAsFloat(final int index) {
        try {
            Argument argument = getByIndex(map.keySet(), index);
            return (float) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose <code>Set</code> of names <code>contains</code>
     * the specified <code>name</code>, as
     * an instance of type <code>int</code>.
     * @param name the name of the Argument.
     * @return the initialized Argument.
     */
    public int getAsInt(final String name) {
        try {
            Argument argument = getByName(map.keySet(), name);
            return (int) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>int</code>.
     * @param index the index of the Argument.
     * @return the initialized Argument.
     */
    public int getAsInt(final int index) {
        try {
            Argument argument = getByIndex(map.keySet(), index);
            return (int) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose <code>Set</code> of names <code>contains</code>
     * the specified <code>name</code>, as
     * an instance of type <code>long</code>.
     * @param name the name of the Argument.
     * @return the initialized Argument.
     */
    public long getAsLong(final String name) {
        try {
            Argument argument = getByName(map.keySet(), name);
            return (long) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>long</code>.
     * @param index the index of the Argument.
     * @return the initialized Argument.
     */
    public long getAsLong(final int index) {
        try {
            Argument argument = getByIndex(map.keySet(), index);
            return (long) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose <code>Set</code> of names <code>contains</code>
     * the specified <code>name</code>, as
     * an instance of type <code>short</code>.
     * @param name the name of the Argument.
     * @return the initialized Argument.
     */
    public short getAsShort(final String name) {
        try {
            Argument argument = getByName(map.keySet(), name);
            return (short) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>short</code>.
     * @param index the index of the Argument.
     * @return the initialized Argument.
     */
    public short getAsShort(final int index) {
        try {
            Argument argument = getByIndex(map.keySet(), index);
            return (short) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose <code>Set</code> of names <code>contains</code>
     * the specified <code>name</code>, as
     * an instance of type <code>String</code>.
     * @param name the name of the Argument.
     * @return the initialized Argument.
     */
    public String getAsString(final String name) {
        try {
            Argument argument = getByName(map.keySet(), name);
            return (String) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>String</code>.
     * @param index the index of the Argument.
     * @return the initialized Argument.
     */
    public String getAsString(final int index) {
        try {
            Argument argument = getByIndex(map.keySet(), index);
            return (String) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose <code>Set</code> of names <code>contains</code>
     * the specified <code>name</code>, as
     * an instance of type <code>Object</code>.
     * @param name the name of the Argument.
     * @return the initialized Argument.
     */
    public Object getAsObject(final String name) {
        try {
            Argument argument = getByName(map.keySet(), name);
            return map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>Object</code>.
     * @param index the index of the Argument.
     * @return the initialized Argument.
     */
    public Object getAsObject(final int index) {
        try {
            Argument argument = getByIndex(map.keySet(), index);
            return map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose <code>Set</code> of names <code>contains</code>
     * the specified <code>name</code>, as
     * an instance of the specified type <code>T</code>.
     * @param name the name of the Argument.
     * @param type the type of the return value.
     * @param <T> the type.
     * @return the initialized Argument.
     */
    @SuppressWarnings("unchecked")
    public <T> T get(final String name, final Class<T> type) {
        try {
            Argument argument = getByName(map.keySet(), name);
            return (T) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>T</code>.
     * @param index the index of the Argument.
     * @param type the type of the return value.
     * @param <T> the type.
     * @return the initialized Argument.
     */
    @SuppressWarnings("unchecked")
    public <T> T get(final int index, final Class<T> type) {
        try {
            Argument argument = getByIndex(map.keySet(), index);
            return (T) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose <code>Set</code> of names <code>contains</code>
     * the specified <code>name</code>, as
     * an instance of type <code>boolean[]</code>.
     * @param name the name of the Argument.
     * @return the initialized Argument.
     */
    public boolean[] getAsBooleanArray(final String name) {
        try {
            Argument argument = getByName(map.keySet(), name);
            return (boolean[]) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>boolean[]</code>.
     * @param index the index of the Argument.
     * @return the initialized Argument.
     */
    public boolean[] getAsBooleanArray(final int index) {
        try {
            Argument argument = getByIndex(map.keySet(), index);
            return (boolean[]) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose <code>Set</code> of names <code>contains</code>
     * the specified <code>name</code>, as
     * an instance of type <code>byte[]</code>.
     * @param name the name of the Argument.
     * @return the initialized Argument.
     */
    public byte[] getAsByteArray(final String name) {
        try {
            Argument argument = getByName(map.keySet(), name);
            return (byte[]) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>byte[]</code>.
     * @param index the index of the Argument.
     * @return the initialized Argument.
     */
    public byte[] getAsByteArray(final int index) {
        try {
            Argument argument = getByIndex(map.keySet(), index);
            return (byte[]) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose <code>Set</code> of names <code>contains</code>
     * the specified <code>name</code>, as
     * an instance of type <code>char[]</code>.
     * @param name the name of the Argument.
     * @return the initialized Argument.
     */
    public char[] getAsCharArray(final String name) {
        try {
            Argument argument = getByName(map.keySet(), name);
            return (char[]) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>char[]</code>.
     * @param index the index of the Argument.
     * @return the initialized Argument.
     */
    public char[] getAsCharArray(final int index) {
        try {
            Argument argument = getByIndex(map.keySet(), index);
            return (char[]) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose <code>Set</code> of names <code>contains</code>
     * the specified <code>name</code>, as
     * an instance of type <code>double[]</code>.
     * @param name the name of the Argument.
     * @return the initialized Argument.
     */
    public double[] getAsDoubleArray(final String name) {
        try {
            Argument argument = getByName(map.keySet(), name);
            return (double[]) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>double[]</code>.
     * @param index the index of the Argument.
     * @return the initialized Argument.
     */
    public double[] getAsDoubleArray(final int index) {
        try {
            Argument argument = getByIndex(map.keySet(), index);
            return (double[]) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose <code>Set</code> of names <code>contains</code>
     * the specified <code>name</code>, as
     * an instance of type <code>float[]</code>.
     * @param name the name of the Argument.
     * @return the initialized Argument.
     */
    public float[] getAsFloatArray(final String name) {
        try {
            Argument argument = getByName(map.keySet(), name);
            return (float[]) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>float[]</code>.
     * @param index the index of the Argument.
     * @return the initialized Argument.
     */
    public float[] getAsFloatArray(final int index) {
        try {
            Argument argument = getByIndex(map.keySet(), index);
            return (float[]) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose <code>Set</code> of names <code>contains</code>
     * the specified <code>name</code>, as
     * an instance of type <code>int[]</code>.
     * @param name the name of the Argument.
     * @return the initialized Argument.
     */
    public int[] getAsIntArray(final String name) {
        try {
            Argument argument = getByName(map.keySet(), name);
            return (int[]) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>int[]</code>.
     * @param index the index of the Argument.
     * @return the initialized Argument.
     */
    public int[] getAsIntArray(final int index) {
        try {
            Argument argument = getByIndex(map.keySet(), index);
            return (int[]) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose <code>Set</code> of names <code>contains</code>
     * the specified <code>name</code>, as
     * an instance of type <code>long[]</code>.
     * @param name the name of the Argument.
     * @return the initialized Argument.
     */
    public long[] getAsLongArray(final String name) {
        try {
            Argument argument = getByName(map.keySet(), name);
            return (long[]) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>long[]</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
     */
    public long[] getAsLongArray(final int index) {
        try {
            Argument argument = getByIndex(map.keySet(), index);
            return (long[]) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose <code>Set</code> of names <code>contains</code>
     * the specified <code>name</code>, as
     * an instance of type <code>short[]</code>.
     * @param name the name of the Argument.
     * @return the initialized Argument.
     */
    public short[] getAsShortArray(final String name) {
        try {
            Argument argument = getByName(map.keySet(), name);
            return (short[]) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>short[]</code>.
     * @param index the index of the Argument.
     * @return the initialized Argument.
     */
    public short[] getAsShortArray(final int index) {
        try {
            Argument argument = getByIndex(map.keySet(), index);
            return (short[]) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose <code>Set</code> of names <code>contains</code>
     * the specified <code>name</code>, as
     * an instance of type <code>String[]</code>.
     * @param name the name of the Argument.
     * @return the initialized Argument.
     */
    public String[] getAsStringArray(final String name) {
        try {
            Argument argument = getByName(map.keySet(), name);
            return (String[]) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>String[]</code>.
     * @param index the index of the Argument.
     * @return the initialized Argument.
     */
    public String[] getAsStringArray(final int index) {
        try {
            Argument argument = getByIndex(map.keySet(), index);
            return (String[]) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose <code>Set</code> of names <code>contains</code>
     * the specified <code>name</code>, as
     * an instance of type <code>Object[]</code>.
     * @param name the name of the Argument.
     * @return the initialized Argument.
     */
    public Object[] getAsObjectArray(final String name) {
        try {
            Argument argument = getByName(map.keySet(), name);
            return (Object[]) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>Object[]</code>.
     * @param index the index of the Argument.
     * @return the initialized Argument.
     */
    public Object[] getAsObjectArray(final int index) {
        try {
            Argument argument = getByIndex(map.keySet(), index);
            return (Object[]) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose <code>Set</code> of names <code>contains</code>
     * the specified <code>name</code>, as
     * an instance of type <code>T[]</code>.
     * @param name the name of the Argument.
     * @param componentType the component type of the array to be returned.
     * @param <T> the type.
     * @return the initialized Argument.
     */
    @SuppressWarnings("unchecked")
    public <T> T[] getAsArray(final String name, final Class<T> componentType) {
        try {
            Argument argument = getByName(map.keySet(), name);
            return (T[]) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the (initialized) <code>Argument</code> whose index is equal to the specified <code>index</code>, as
     * an instance of type <code>T[]</code>.
     * @param index the index of the Argument.
     * @param componentType the component type of the Object to be returned.
     * @param <T> the type.
     * @return the initialized Argument.
     */
    @SuppressWarnings("unchecked")
    public <T> T[] getAsArray(final int index, final Class<T> componentType) {
        try {
            Argument argument = getByIndex(map.keySet(), index);
            return (T[]) map.get(argument);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }
}