package velo.q.structure;

// TODO: Auto-generated Javadoc

/**
 * The Class DataPoint.
 */
public class DataPoint {

    /**
     * The name.
     */
    String name;

    /**
     * The query params.
     */
    String[] queryParams;

    /**
     * Fetch.
     *
     * @param p the p
     * @return the object
     */
    public Object fetch(Object[] p) {
        return null;
    }

    /**
     * Plot.
     *
     * @param o the o
     */
    public void plot(Object o) {

    }

    /**
     * Stringify.
     *
     * @param o the o
     * @return the string
     */
    public String stringify(Object o) {
        return (String) o;
    }

    /**
     * Instantiates a new data point.
     *
     * @param name        the name
     * @param queryParams the query params
     */
    public DataPoint(String name, String[] queryParams) {
        super();
        this.name = name;
        this.queryParams = queryParams;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the query params.
     *
     * @return the query params
     */
    public String[] getQueryParams() {
        return queryParams;
    }

    /**
     * Sets the query params.
     *
     * @param queryParams the new query params
     */
    public void setQueryParams(String[] queryParams) {
        this.queryParams = queryParams;
    }

}
