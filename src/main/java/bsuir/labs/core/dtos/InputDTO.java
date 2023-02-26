package bsuir.labs.core.dtos;

import java.util.Objects;

public class InputDTO {

    private Double divisible;
    private Double divisor;

    public InputDTO() {
    }

    public InputDTO(Double divisible, Double divisor) {
        this.divisible = divisible;
        this.divisor = divisor;
    }

    public Double getDivisible() {
        return divisible;
    }

    public void setDivisible(Double divisible) {
        this.divisible = divisible;
    }

    public Double getDivisor() {
        return divisor;
    }

    public void setDivisor(Double divisor) {
        this.divisor = divisor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputDTO inputDTO = (InputDTO) o;
        return Objects.equals(divisible, inputDTO.divisible) && Objects.equals(divisor, inputDTO.divisor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(divisible, divisor);
    }

    @Override
    public String toString() {
        return "{" +
                "divisible=" + divisible +
                ", divisor=" + divisor +
                '}';
    }
}
