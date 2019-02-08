package uk.wingdash.server;

public enum HTMLCode {
    OK("OK"), REACHED("REACHED"), FAILED("FAILED"), SUCCESS("SUCCESS");

    private final String text;

    /**
     * @param text
     */
    HTMLCode(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
