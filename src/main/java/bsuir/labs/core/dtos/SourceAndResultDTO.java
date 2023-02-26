package bsuir.labs.core.dtos;

import java.util.Objects;

public class SourceAndResultDTO {
    private Double divisible;
    private Double divisor;
    private Long total;
    private Long remains;

    public SourceAndResultDTO() {
    }

    public SourceAndResultDTO(Double divisible, Double divisor, Long total, Long remains) {
        this.divisible = divisible;
        this.divisor = divisor;
        this.total = total;
        this.remains = remains;
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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getRemains() {
        return remains;
    }

    public void setRemains(Long remains) {
        this.remains = remains;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SourceAndResultDTO that = (SourceAndResultDTO) o;
        return Objects.equals(divisible, that.divisible)
                && Objects.equals(divisor, that.divisor)
                && Objects.equals(total, that.total)
                && Objects.equals(remains, that.remains);
    }

    @Override
    public int hashCode() {
        return Objects.hash(divisible, divisor, total, remains);
    }

    @Override
    public String toString() {
        return "{" +
                "divisible=" + divisible +
                ", divisor=" + divisor +
                ", total=" + total +
                ", remains=" + remains +
                '}';
    }
}
