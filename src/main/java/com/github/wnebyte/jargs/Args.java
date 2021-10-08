package com.github.wnebyte.jargs;

import com.github.wnebyte.args.Argument;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.github.wnebyte.args.ArgumentUtil.*;

/**
 * This class represents a map of initialized instances of type {@link Argument}.
 */
public class Args {

    private final Map<Argument, Object> map;

    /**
     * Constructs a new instance using the specified <code>map</code>.
     * @param map should contain the mappings of argument and initialized argument.
     */
    public Args(final Map<Argument, Object> map){
        this.map = map;
    }

    /**
     * Returns the initialized argument whose name is equal to the specified <code>name</code>, as
     * an instance of type <code>boolean</code>.
     * @param name the name of the argument.
     * @return the initialized argument as an instance of type <code>boolean</code>.
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
     * Returns the initialized argument whose name is equal to the specified <code>name</code>, as
     * an instance of <code>byte</code>.
     * @param name the name of the argument.
     * @return the initialized argument as an instance of <code>byte</code>.
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
     * Returns the initialized argument whose name is equal to the specified <code>name</code>, as
     * an instance of <code>char</code>.
     * @param name the name of the argument.
     * @return the initialized argument as an instance of <code>char</code>.
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
     * Returns the initialized argument whose name is equal to the specified <code>name</code>, as
     * an instance of <code>double</code>.
     * @param name the name of the argument.
     * @return the initialized argument as an instance of <code>double</code>.
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
     * Returns the initialized argument whose name is equal to the specified <code>name</code>, as
     * an instance of <code>float</code>.
     * @param name the name of the argument.
     * @return the initialized argument as an instance of <code>float</code>.
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
     * Returns the initialized argument whose name is equal to the specified <code>name</code>, as
     * an instance of <code>int</code>.
     * @param name the name of the argument.
     * @return the initialized argument as an instance of <code>int</code>.
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
     * Returns the initialized argument whose name is equal to the specified <code>name</code>, as
     * an instance of <code>long</code>.
     * @param name the name of the argument.
     * @return the initialized argument as an instance of <code>long</code>.
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
     * Returns the initialized argument whose name is equal to the specified <code>name</code>, as
     * an instance of <code>short</code>.
     * @param name the name of the argument.
     * @return the initialized argument as an instance of <code>short</code>.
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
     * Returns the initialized argument whose name is equal to the specified <code>name</code>, as
     * an instance of <code>String</code>.
     * @param name the name of the argument.
     * @return the initialized argument as an instance of <code>String</code>.
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
     * Returns the initialized argument whose name is equal to the specified <code>name</code>, as
     * an instance of <code>Object</code>.
     * @param name the name of the argument.
     * @return the initialized argument as an instance of <code>Object</code>.
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
     * Returns the initialized argument whose name is equal to the specified <code>name</code>, as
     * an instance of <code>T</code>.
     * @param name the name of the argument.
     * @param type the class of the argument's type.
     * @param <T>  the type of the argument.
     * @return the initialized argument as an instance of <code>T</code>.
     */
    @SuppressWarnings("unchecked")
    public <T> T getAsObject(final String name, final Class<T> type) {
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
     * Returns the initialized argument whose name is equal to the specified <code>name</code>, as
     * an instance of <code>T[]</code>.
     * @param name the name of the argument.
     * @param componentType the element type.
     * @param <T>  the array type.
     * @return the initialized argument as an instance of <code>T[]</code>.
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
     * Returns the initialized argument whose name is equal to the specified <code>name</code>, as
     * an instance of <code>boolean[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument as an instance of <code>boolean[]</code>.
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
     * Returns the initialized argument whose name is equal to the specified <code>name</code>, as
     * an instance of <code>byte[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument as an instance of <code>byte[]</code>.
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
     * Returns the initialized argument whose name is equal to the specified <code>name</code>, as
     * an instance of <code>char[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument as an instance of <code>char[]</code>.
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
     * Returns the initialized argument whose name is equal to the specified <code>name</code>, as
     * an instance of <code>double[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument as an instance of <code>double[]</code>.
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
     * Returns the initialized argument whose name is equal to the specified <code>name</code>, as
     * an instance of <code>float[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument as an instance of <code>float[]</code>.
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
     * Returns the initialized argument whose name is equal to the specified <code>name</code>, as
     * an instance of <code>int[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument as an instance of <code>int[]</code>.
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
     * Returns the initialized argument whose name is equal to the specified <code>name</code>, as
     * an instance of <code>long[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument as an instance of <code>long[]</code>.
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
     * Returns the initialized argument whose name is equal to the specified <code>name</code>, as
     * an instance of <code>short[]</code>.
     * @param name the name of the argument.
     * @return the initialized argument as an instance of <code>short[]</code>.
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
     * Constructs a new instance using the specified <code>arguments</code> and <code>objects</code>.
     * @param arguments the arguments.
     * @param objects the initialized arguments.
     * @return a new instance.
     */
    public static Args newInstance(final List<Argument> arguments, final Object[] objects) {
        if ((arguments == null) || (objects == null)) {
            throw new IllegalArgumentException(
                    "Arguments and/or Object may to be null."
            );
        }
        Map<Argument, Object> map = new HashMap<>(objects.length);
        for (int i = 0; i < objects.length; i++) {
            map.put(getByIndex(arguments, i), objects[i]);
        }
        return new Args(map);
    }
}