package pl.sstobiecki.jms;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Order implements Serializable {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("text", text)
                .toString();
    }
}
