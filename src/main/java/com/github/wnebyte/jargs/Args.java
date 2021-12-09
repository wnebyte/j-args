package com.github.wnebyte.jargs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.github.wnebyte.jargs.util.Objects;
import com.github.wnebyte.jarguments.Argument;
import static com.github.wnebyte.jarguments.ArgumentSupport.*;

/**
 * This class represents a map of initialized instances of type {@link Argument}.
 */
public class Args {

    /* ---------------- Fields ---------------- */

    private final Map<Argument, Object> map;

    /* ---------------- Constructors ---------------- */

    /**
     * Constructs a new instance using the specified <code>map</code>.
     * @param map should contain the mappings of argument and initialized argument.
     */
    private Args(final Map<Argument, Object> map){
        this.map = map;
    }

    private Args() {
        throw new UnsupportedOperationException(
                "This constructor is not supported."
        );
    }

    /* ---------------- Static Functions ---------------- */

    /**
     * Constructs a new instance using the specified <code>arguments</code> and <code>objects</code>.
     * @param arguments the arguments.
     * @param objects the initialized arguments.
     * @return a new instance.
     */
    static Args newInstance(final List<Argument> arguments, final Object[] objects) {
        if (Objects.isNull(arguments, objects)) {
            return null;
        }
        Map<Argument, Object> map = new HashMap<>(objects.length);
        for (int i = 0; i < objects.length; i++) {
            Argument key = getByIndex(arguments, i);
            Object value = objects[i];
            map.put(key, value);
        }
        return new Args(map);
    }

    /**
     * Constructs and returns  a new instance of <code>ArgsParser</code> using the specified <code>arguments</code>.
     * @param arguments
     * @return
     */
    public static ArgsParser parser(List<Argument> arguments) {
        return new ArgsParser(arguments);
    }

    public static ArgsParser parser() {
        return new ArgsParser();
    }

    /**
     * Returns the initialized argument whose name property <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>boolean</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
     */
    public boolean getAsBoolean(final String name) {
        try {
            Argument arg = getByName(map.keySet(), name);
            return (boolean) map.get(arg);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the initialized argument whose index property <code>equals</code> the specified <code>index</code>, as
     * an instance of type <code>boolean</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
     */
    public boolean getAsBoolean(final int index) {
        try {
            Argument arg = getByIndex(map.keySet(), index);
            return (boolean) map.get(arg);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    e.getMessage()
            );
        }
    }

    /**
     * Returns the initialized argument whose name property <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>byte</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose index property <code>equals</code> the specified <code>index</code>, as
     * an instance of type <code>byte</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose name property <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>char</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose index property <code>equals</code> the specified <code>index</code>, as
     * an instance of type <code>char</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose name property <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>double</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose index property <code>equals</code> the specified <code>index</code>, as
     * an instance of type <code>double</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose name property <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>float</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose index property <code>equals</code> the specified <code>index</code>, as
     * an instance of type <code>float</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose name property <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>int</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose index property <code>equals</code> the specified <code>index</code>, as
     * an instance of type <code>int</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose name property <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>long</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose index property <code>equals</code> the specified <code>index</code>, as
     * an instance of type <code>long</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose name property <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>short</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose index property <code>equals</code> the specified <code>index</code>, as
     * an instance of type <code>short</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose name property <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>String</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose index property <code>equals</code> the specified <code>index</code>, as
     * an instance of type <code>String</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose name property <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>Object</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose index property <code>equals</code> the specified <code>index</code>, as
     * an instance of type <code>Object</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
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
     * Returns the (initialized) argument whose set of names <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>T</code>.
     * @param name the name of the argument.
     * @param type the type of the Object to be returned.
     * @param <T> the type.
     * @return the initialized argument.
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
     * Returns the initialized argument whose index property <code>equals</code> the specified <code>index</code>, as
     * an instance of type <code>T</code>.
     * @param index the index of the argument.
     * @param type the type of the Object to be returned.
     * @param <T> the type.
     * @return the initialized argument.
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
     * Returns the initialized argument whose name property <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>T[]</code>.
     * @param name the name of the argument.
     * @param componentType the component type of the Object to be returned.
     * @param <T> the type.
     * @return the initialized argument.
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
     * Returns the initialized argument whose index property <code>equals</code> the specified <code>index</code>, as
     * an instance of type <code>T[]</code>.
     * @param index the index of the argument.
     * @param componentType the component type of the Object to be returned.
     * @param <T> the type.
     * @return the initialized argument.
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

    /**
     * Returns the initialized argument whose name property <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>boolean[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose index property <code>equals</code> the specified <code>index</code>, as
     * an instance of type <code>boolean[]</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose name property <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>byte[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose index property <code>equals</code> the specified <code>index</code>, as
     * an instance of type <code>byte[]</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose name property <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>char[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose index property <code>equals</code> the specified <code>index</code>, as
     * an instance of type <code>char[]</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose name property <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>double[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose index property <code>equals</code> the specified <code>index</code>, as
     * an instance of type <code>double[]</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose name property <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>float[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose index property <code>equals</code> the specified <code>index</code>, as
     * an instance of type <code>float[]</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose name property <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>int[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose index property <code>equals</code> the specified <code>index</code>, as
     * an instance of type <code>int[]</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose name property <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>long[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose index property <code>equals</code> the specified <code>index</code>, as
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
     * Returns the initialized argument whose name property <code>contains</code> the specified <code>name</code>, as
     * an instance of type <code>short[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument.
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
     * Returns the initialized argument whose index property <code>equals</code> the specified <code>index</code>, as
     * an instance of type <code>short[]</code>.
     * @param index the index of the argument.
     * @return the initialized argument.
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
}