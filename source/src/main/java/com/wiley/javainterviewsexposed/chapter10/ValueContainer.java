package com.wiley.javainterviewsexposed.chapter10;

public class ValueContainer {
    private final String value;

    public ValueContainer(final String value) {
        this.value = value;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.printf("Finalizing for [%s]%n", toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValueContainer that = (ValueContainer) o;

        if (!value.equals(that.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return "ValueContainer{" +
                "value='" + value + '\'' +
                '}';
    }
}
