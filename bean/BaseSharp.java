import java.io.Serializable;
import java.math.BigDecimal;

public class BaseSharp implements Serializable {
    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal height;

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }


    public Object readResolve(){
        return this;
    }

}
